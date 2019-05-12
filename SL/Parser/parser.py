from path import Path
from .sets import first
from .grammar import parseGrammar, isNT
from codeReader import fullCodeReader, SyntaxException, LexicException
from Lexer.lexer import nextToken

localPath = Path(__file__).parent

grammar_path = localPath / 'grammar.md'
sl_sample = localPath / 'sl_sample.txt'


def derivate(grammar, reader, derivation, tokens, verbose=False):
    while(len(derivation)):
        symbol = derivation[0]
        if(len(tokens) == 0):
            try:
                tokens.append(nextToken(reader))
            except LexicException as e:
                print(e)
                break
        tk = tokens[0]
        if(verbose):
            print('--------')
            print('derivación: ', end='')
            print(*derivation, sep=' ')
            print('token: ' + str(tk))
        if(isNT(symbol)):
            candidates = []
            for i, rules in enumerate(grammar.rules[symbol]):
                rule = grammar.rules[symbol][i]
                predicts = grammar.predicts[symbol][i]
                if('<' + tk._type + '>' in predicts):
                    candidates.append(i)
            if(len(candidates) > 1):
                raise ValueError('Grammar is not LL(1)')
            elif(len(candidates) == 0):
                printSyntaxException(grammar, reader, tk, derivation)
                raise SyntaxException
            rule = candidates[0]
            rule = grammar.rules[symbol][rule]
            if(verbose):
                print('Using rule', rule)
            if(rule[0] == 'eps'):
                derivation = derivation[1:]
            else:
                derivation = rule + derivation[1:]
        elif(tk._type == symbol[1:-1]):
            derivation = derivation[1:]
            tokens = tokens[1:]
        else:
            printSyntaxException(grammar, reader, tk, derivation)
            raise SyntaxException
    return tokens


def printSyntaxException(grammar, reader, tk, derivation):
    pos = reader.pos()
    firsts = first(grammar, derivation)
    s = '<{}, {}>'.format(pos[0], pos[1])
    s += ' Error sintáctico: se encontro: "{}";'.format(tk._type)
    s += ' Se esperaba: ' + ','.join(['"{}"'.format(te) for te in firsts])
    print(s)


def parse(grammar, reader, verbose=False):
    derivation = ['PROGRAMAPRC']
    tokens = []
    try:
        tokens = derivate(grammar, reader, derivation, tokens, verbose=verbose)
    except SyntaxException as e:
        print('Error sintáctico: falta función principal *correcta*')
    except Exception as e:
        print(e)
    else:
        print('Función principal exitosa')
        derivation = ['SUBRUTINAS']
        try:
            tokens = derivate(
                grammar, reader, derivation, tokens, verbose=verbose)
        except SyntaxException as e:
            print('Error sintáctico:', e)
        except Exception as e:
            print(e)
        else:
            print('El análisis sintáctico ha finalizado exitosamente')


def main(reader, verbose=False):
    grammar = parseGrammar(grammar_path)
    parse(grammar, reader, verbose=verbose)


if __name__ == '__main__':
    reader = fullCodeReader(sl_sample)
    main(reader)
