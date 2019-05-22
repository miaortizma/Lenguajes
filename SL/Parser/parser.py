from path import Path
from .sets import first
from .grammar import parseGrammar, isNT
from codeReader import fullCodeReader, SyntaxException
from Lexer.lexer import nextToken, getTokens

localPath = Path(__file__).parent

grammar_path = localPath / 'grammar.md'
sl_sample = localPath / 'sl_sample.txt'

derivation = []
tokens = []
positions = []


def opt(grammar, reader, verbose=False):
    global derivation, tokens, positions
    tk = token(reader)
    opt_pos = reader.pos()
    if(positions[0][0] == opt_pos[0]):
        if(tk._type != 'tk_semicolon'):
            raise SyntaxException
    predictDerivation(grammar, reader, verbose=verbose)


def sino(grammar, reader, verbose=False):
    global derivation, tokens
    sino_pos = reader.pos()
    tk = token(reader)
    if(reader.pos()[0] == sino_pos[0] and tk._type == 'si'):
        rule = ['SINOSI']
    else:
        rule = ['SENTENCIAS']
    derivation = rule + derivation[1:]


def token(reader):
    global tokens, positions
    if(len(tokens) == 0):
        tokens.append(nextToken(reader))
        positions.append(reader.pos())
    return tokens[0]


def predictDerivation(grammar, reader, verbose=False):
    global derivation, tokens
    tk = token(reader)
    symbol = derivation[0]
    if(verbose):
            print('--------')
            print('derivacion: ', end='')
            print(*derivation, sep=', ')
    candidates = []
    for i, rules in enumerate(grammar.rules[symbol]):
        rule = grammar.rules[symbol][i]
        predicts = grammar.predicts[symbol][i]
        """
        if(verbose):
            print('token: ' + str(tk))
            print(*rule, sep=', ', end=' ')
            print(predicts)
        """
        if('<' + tk._type + '>' in predicts):
            candidates.append(i)
    if(len(candidates) > 1):
        for i in candidates:
            print(grammar.rules[symbol][i])
            print(grammar.predicts[symbol][i])
        raise ValueError('Grammar is not LL(1)')
    elif(len(candidates) == 0):
        raise SyntaxException

    rule = candidates[0]
    rule = grammar.rules[symbol][rule]
    if(verbose):
        print('Using rule: ', rule)
    if(rule[0] == 'eps'):
        derivation = derivation[1:]
    else:
        derivation = rule + derivation[1:]


def derivate(grammar, reader, verbose=False):
    """
    only : only errors with these tokens are taken into account,
     used to check if main function exists
    """
    global derivation, tokens, positions
    while(len(derivation)):
        symbol = derivation[0]
        """
        if read token now it will screw up with knowing
        if last token and this one is on same line or not
        """
        if(isNT(symbol)):
            dct = {'SINO2': sino,
                   'OPT': opt }
            f = dct.get(symbol, predictDerivation)
            f(grammar, reader, verbose=verbose)
        elif(token(reader)._type == symbol[1:-1]):
            if(verbose):
                print('--------')
                print('derivacion: ', end='')
                print(*derivation, sep=' ')
                print('token: ' + str(tokens[0]))
            derivation = derivation[1:]
            tokens = tokens[1:]
            positions = positions[1:]
        else:
            raise SyntaxException
    return tokens


def tokenToSymbol(token):
    return tokensToSymbols.get(token, token)


def handleSyntaxException(grammar, reader):
    tk = tokens[0]
    pos = reader.pos()
    firsts = first(grammar, derivation)
    firsts = [tokenToSymbol(te[1:-1]) for te in firsts]
    s = '<{}, {}>'.format(pos[0], pos[1])
    s += ' Error sintactico: se encontro: "{}";'.format(
        tokenToSymbol(tk._type))
    s += ' Se esperaba: ' + ','.join(['"{}"'.format(te) for te in firsts])
    print(s)


def parse(grammar, reader, verbose=False):
    global derivation, tokens, positions
    derivation = ['PROGRAMA']
    tokens = []
    positions = [(1, 1)]
    try:
        tokens = derivate(grammar, reader, verbose=verbose)
    except SyntaxException as e:
        handleSyntaxException(grammar, reader)
    else:
        print('El analisis sintactico ha finalizado exitosamente')


def load_data():
    global tokensToSymbols
    tokens, tokens_regexp = getTokens()
    tokensToSymbols = dict(
        [(tokens[token], token) for token in tokens])  # invert dict
    tokensToSymbols['tk_numerico'] = 'tk_numerico'
    tokensToSymbols['tk_cadena'] = 'tk_cadena'
    tokensToSymbols['tk_logico'] = 'tk_logico'


def mainExists(reader, verbose=False):
    global tokens, positions
    tokens = []
    positions = [(1, 1)]
    while(token(reader)._type != 'inicio'):
        if(token(reader)._type == '$'):
            return False
        # print(tokens)
        tokens = tokens[1:]
        positions = positions[1:]
    while(token(reader)._type != 'fin'):
        _type = token(reader)._type
        if(_type == '$' or _type == 'subrutina'):
            return False
        # print(tokens)
        tokens = tokens[1:]
        positions = positions[1:]
    return True


def main(sl_path, verbose=False):
    reader = fullCodeReader(sl_path)
    grammar = parseGrammar(grammar_path)
    load_data()
    if(not mainExists(reader, verbose=verbose)):
        print('Error sintactico: falta funcion_principal')
    else:
        reader = fullCodeReader(sl_path)
        parse(grammar, reader, verbose=verbose)


if __name__ == '__main__':
    main(sl_sample)
