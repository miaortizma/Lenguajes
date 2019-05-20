import re
from path import Path
from codeReader import *

localPath = Path(__file__).parent
reserved_file = localPath / 'data/reserved.txt'
tokens_file = localPath / 'data/tokens.txt'
regex_file = localPath / 'data/regex.txt'
sl_file = localPath / 'data/sl_sample.txt'
output_file = localPath / 'data/out.txt'

def load_data():
    global reserved, tokens, tokens_regexp, regex, code
    with open(reserved_file) as file:
        reserved = set([x.rstrip() for x in file.readlines()])
    tokens, tokens_regexp = getTokens()
    with open(regex_file, encoding='utf-8') as file:
        regex = dict([[x.strip() for x in line.split(':', 1)]
                      for line in file])


def getTokens():
    with open(tokens_file) as file:
        tokens_regexp = dict(
            [[x.strip() for x in line.split(' : ')] for line in file])
        tokens = dict([(x[1:], tokens_regexp[x]) if x[0] == '\\' else (
            x, tokens_regexp[x]) for x in tokens_regexp])
        tokens_regexp = '|'.join([r'(?:{})'.format(reg)
                                  for reg in tokens_regexp])
    return tokens, tokens_regexp


def appendToken(token):
    with open(output_file, 'a') as file:
        file.write(str(token) + '\n')


def resetMatch(reader, c, pos):
    reader.reset()
    return tokenMatch(reader, c, pos)


def identificador(reader, s, pos):
    reg = regex['id']
    s = readWhileFullMatch(reader, s, reg)
    if s in reserved:
        if(s in ['NO', 'SI', 'TRUE', 'FALSE']):
            return Token('tk_logico', pos[0], pos[1], s)
        else:
            return Token(s, pos[0], pos[1])
    else:
        return Token('id', pos[0], pos[1], s)


def tokenMatch(reader, s, pos):
    if(not re.match(tokens_regexp, s)):
        raise LexicException
    s = readWhileFullMatch(reader, s, tokens_regexp)
    return Token(tokens[s], pos[0], pos[1])


def cadena(reader, s, pos):
    reg = regex['cadena']  # "(?:[^\\]|(?:\\.))*"
    s = readUntilFullMatch(reader, s, reg)
    return Token('tk_cadena', pos[0], pos[1], s)


def numerico(reader, s, pos):
    reg = regex['numerico']  # [+-]?[0-9]+(?:\.[0-9]+)?
    s = readWhileFullMatch(reader, s, reg)
    if(re.match(r'[\.][0-9]', reader.peek(2))):
        s += reader.read(2)
        s = readWhileFullMatch(reader, s, reg)
    if(re.match(r'[eE][\+-][0-9]', reader.peek(3))):
        s += reader.read(3)
        s = readWhileFullMatch(reader, s, reg)
    return Token('tk_numerico', pos[0], pos[1], s)


def slash(reader, c, pos):
    p = next(reader)
    dct = {
        '*': lambda: readUntilFullMatch(reader, '/*', regex['block_comment']),
        '/': lambda: readWhileFullMatch(reader, '//', regex['comment'])}
    f = dct.get(p, lambda: resetMatch(reader, c, pos))
    return f()


def sign(reader, c, pos):
    p = next(reader)
    dct = {True: lambda: numerico(reader, c + p, pos),
           False: lambda: resetMatch(reader, c, pos)}
    f = dct[bool(re.match(r'[0-9]', p))]
    return f()


def default(reader, c, pos):
    if(re.match(r'[0-9]', c)):
        return numerico(reader, c, pos)
    elif(re.match(r'[a-zA-ZñÑ_]', c)):
        return identificador(reader, c, pos)
    else:
        return tokenMatch(reader, c, pos)


def nextToken(reader):
    pos = reader.pos()
    if(reader.done()):
        return Token('$', pos[0], pos[1])
    while(not reader.done()):
        c = next(reader)
        try:
            if(re.match(r'\s', c)):  # espacios en blanco
                continue
            dct = {'/': slash,
                   '+': sign,
                   '-': sign,
                   '"': cadena,
                   "'": cadena}
            f = dct.get(c, default)
            token = f(reader, c, pos)
            if(isinstance(token, Token)):
                return token
        except LexicException:
            with open(output_file, 'a') as file:
                file.write(
                    'Error Léxico(linea:{},posición:{})'
                    .format(pos[0], pos[1]))
            raise ValueError


def main(reader, verbose=False):
    load_data()
    with open(output_file, 'w') as file:
        file.write('')  # erases output
    while(not reader.done()):
        token = nextToken(reader)
        appendToken(token)
    if(verbose):
        print('termine')


if __name__ == '__main__':
    reader = fullCodeReader(sl_file)
    main(reader)
