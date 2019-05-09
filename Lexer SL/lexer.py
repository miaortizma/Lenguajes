import re
from codeReader import fullCodeReader, Token

reserved_file = 'reserved.txt'
tokens_file = 'tokens.txt'
regex_file = 'regex.txt'
sl_file = './data/sl_sample.txt'
output_file = 'out.txt'


def init():
    global reserved, tokens, tokens_regexp, regex, code    
    with open(reserved_file) as file:
        #rstrip removes trailing whitespace
        reserved = set([ x.rstrip() for x in file.readlines()])
    
    with open(tokens_file) as file:
        tokens_regexp = dict([ [x.strip() for x in line.split(' : ') ] for line in file])
        tokens_regexp = '|'.join([r'(?:{})'.format(reg) for reg in tokens_regexp])
        tokens = dict([ (x[1:], tokens_regexp[x]) if x[0] == '\\' else (x, tokens_regexp[x]) for x in tokens_regexp])        
    
    with open(regex_file, encoding='utf-8') as file:
        regex = dict([ [x.strip() for x in line.split(':', 1)] for line in file])

    with open(sl_file) as file:    
        code = file.readlines()

class LexicException(Exception):
    """Raised when a lexic error happens"""
    pass    


def readUntilFullMatch(reader, s, reg, eof = False):
    while(not reader.done() and not re.fullmatch(reg, s)):
        c = next(reader)
        s = s + c   
    if(not re.fullmatch(reg, s) and not eof):
        raise LexicException
    else:
        return s
        
def readWhileFullMatch(reader, s, reg): 
    while(not reader.done() and re.fullmatch(reg, s)):
        s = s + next(reader)
    if(not reader.done()):
        s = s[:-1]
        reader.reset()
    return s
        
def identificador(reader, s, pos):
    reg = regex['id']
    s = readWhileFullMatch(reader, s, reg)
    if s in reserved:
        if(s in ['NO', 'SI', 'TRUE', 'FALSE']):
            appendToken(Token('tk_logico', pos[0], pos[1], s))
        else:
            appendToken(Token(s, pos[0], pos[1]))
    else:
        appendToken(Token('id', pos[0], pos[1], s))

def tokenMatch(reader, s, pos):
    if(not re.match(reg, s)):
        raise LexicException
    s = readWhileFullMatch(reader, s, reg)
    appendToken(Token(tokens[s], pos[0], pos[1]))
    

def appendToken(token):
    with open(output_file, 'a') as file:
        file.write(str(token) + '\n')
        
def cadena(reader, s, pos):
    #"(?:[^\\]|(?:\\.))*"
    reg = regex['cadena']
    s = readUntilFullMatch(reader, s, reg)
    appendToken(Token('tk_cadena', pos[0], pos[1], s))

def numerico(reader, s, pos):
    #[+-]?[0-9]+(?:\.[0-9]+)?
    reg = regex['numerico']
    s = readWhileFullMatch(reader, s, reg)
    if(re.match(r'[\.][0-9]', reader.peek(2))):
        s += reader.read(2)
        s = readWhileFullMatch(reader, s, reg)
    if(re.match(r'[eE][\+-][0-9]', reader.peek(3))):
        s += reader.read(3)
        s = readWhileFullMatch(reader, s, reg)
    appendToken(Token('tk_num', pos[0], pos[1], s))
      
def resetMatch(reader, c, pos):
    reader.reset()
    tokenMatch(reader, c, pos)

def slash(reader, c, pos):
    #handle comments
    p = next(reader)
    dct = {'*': lambda : readUntilFullMatch(reader, '/*', regex['block_comment']),
           '/': lambda : readWhileFullMatch(reader, '//', regex['comment'])}
    f = dct.get(p, lambda : resetMatch(reader, c, pos))
    f()

def sign(reader, c, pos):
    p = next(reader)
    dct = {True: lambda : numerico(reader, c + p, pos),
           False: lambda : resetMatch(reader, c, pos)}
    f = dct[bool(re.match(r'[0-9]', p))]
    f()

def default(reader, c, pos):
    if(re.match(r'[0-9]', c)):
        numerico(reader, c, pos)
    #identificador
    elif(re.match(r'[a-zA-ZñÑ_]', c)):
        #write identifier
        identificador(reader, c, pos)
    #catchALl tokenMatch tokens
    else:
        tokenMatch(reader, c, pos)

def main(code):
    #erases output
    with open(output_file, 'w') as file:
        file.write('')
    reader = fullCodeReader(code)
    while(not reader.done()):
        pos = reader.pos()
        c = next(reader)
        try:
            #espacios en blanco
            if(re.match(r'\s', c)):
                continue
            dct = {'/' : slash,
                   '+' : sign,
                   '-' : sign,
                   '"' : cadena,
                   "'" : cadena,
                    }
            f = dct.get(c, default)
            f(reader, c, pos)
        except LexicException:
            with open(output_file, 'a') as file:
                file.write('Error Léxico(linea:{},posición:{})'.format(pos[0], pos[1]))
            break
            
init()
main(code)
print('termine')
