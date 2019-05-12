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


def sino(grammar, reader):
    global derivation, tokens
    sino_pos = reader.pos()
    tk = token(reader)
    if(reader.pos()[0] == sino_pos[0] and tk._type == 'si'):
        rule = ['SINOSI']
    else:
        rule = ['SENTENCIAS']
    derivation = rule + derivation[1:]


def token(reader):
    global tokens
    if(len(tokens) == 0):
        tokens.append(nextToken(reader))
    return tokens[0]


def predictDerivation(grammar, reader, symbol, verbose=False):
    global derivation
    tk = token(reader)
    if(verbose):
            print('--------')
            print('derivación: ', end='')
            print(*derivation, sep=', ')
    candidates = []
    for i, rules in enumerate(grammar.rules[symbol]):
        rule = grammar.rules[symbol][i]
        predicts = grammar.predicts[symbol][i]
        if(verbose):
            print('token: ' + str(tk))
            print(*rule, sep=', ', end=' ')
            print(predicts)
        if('<' + tk._type + '>' in predicts):
            candidates.append(i)
    if(len(candidates) > 1):
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
    global derivation, tokens
    while(len(derivation)):
        symbol = derivation[0]
        if(symbol == 'SINO2'):
            sino(grammar, reader)
            continue
        tk = token(reader)
        if(isNT(symbol)):
            predictDerivation(grammar, reader, symbol, verbose=verbose)
        elif(tk._type == symbol[1:-1]):
            if(verbose):
                print('--------')
                print('derivación: ', end='')
                print(*derivation, sep=' ')
                print('token: ' + str(tk))
            derivation = derivation[1:]
            tokens = tokens[1:]
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
    s += ' Error sintáctico: se encontro: "{}";'.format(
        tokenToSymbol(tk._type))
    s += ' Se esperaba: ' + ','.join(['"{}"'.format(te) for te in firsts])
    print(s)


def parse(grammar, reader, verbose=False):
    global derivation, tokens
    derivation = ['PROGRAMAPRC']
    tokens = []
    try:
        tokens = derivate(grammar, reader, verbose=verbose)
    except SyntaxException as e:
        handleSyntaxException(grammar, reader)
        print('Error sintáctico: falta función principal *correcta*')
    else:
        print('Función principal exitosa')
        derivation = ['SUBRUTINAS']
        try:
            tokens = derivate(
                grammar, reader, verbose=verbose)
        except SyntaxException as e:
            handleSyntaxException(grammar, reader)
        else:
            print('El análisis sintáctico ha finalizado exitosamente')


def load_data():
    global tokensToSymbols
    tokens, tokens_regexp = getTokens()
    tokensToSymbols = dict(
        [(tokens[token], token) for token in tokens])  # invert dict
    tokensToSymbols['tk_numerico'] = 'numerico'
    tokensToSymbols['tk_cadena'] = 'cadena'
    tokensToSymbols['tk_logico'] = 'logico'


def main(reader, verbose=False):
    load_data()
    grammar = parseGrammar(grammar_path)
    parse(grammar, reader, verbose=verbose)


if __name__ == '__main__':
    reader = fullCodeReader(sl_sample)
    main(reader)
