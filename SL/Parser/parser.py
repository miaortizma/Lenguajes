from path import Path
from .grammar import *
from codeReader import *
from Lexer.lexer import *

localPath = Path(__file__).parent

grammar_path = localPath / 'grammar.txt'
sl_sample = localPath / 'sl_sample.txt'


def derivate(grammar, reader, derivation, tokens, verbose=False):
    iters = 0
    while(len(derivation)):
        symbol = derivation[0]
        if(len(tokens) == 0):
            tokens.append(nextToken(reader))
        tk = tokens[0]
        if(verbose):
            print('--------')
            print(derivation)
            print(symbol, tk)
            print(tk._type)
        if(isNT(symbol)):
            candidates = []
            for i, rules in enumerate(grammar.rules[symbol]):
                if(verbose):
                    print('Rule:')
                    print(grammar.rules[symbol][i])
                    print(grammar.predicts[symbol][i])
                if('<' + tk._type + '>' in grammar.predicts[symbol][i]):
                    candidates.append(i)
            if(len(candidates) > 1):
                raise ValueError('Grammar is not LL(1)')
            elif(len(candidates) == 0):
                raise SyntaxException('No valid prediction found')
            rule = candidates[0]
            rule = grammar.rules[symbol][rule]
            if(rule[0] == 'eps'):
                derivation = derivation[1:]
            else:
                derivation = rule + derivation[1:]
        elif(tk._type == symbol[1:-1]):
            derivation = derivation[1:]
            tokens = tokens[1:]
        else:
            raise SyntaxException('Unmatched Grammar')
        iters += 1
    return tokens


def parse(grammar, reader):
    derivation = ['PROGRAMAPRC']
    tokens = []
    try:
        tokens = derivate(grammar, reader, derivation, tokens)
        derivation = ['SUBRUTINAS']
    except SyntaxException as e:
        print(e)
        print('Error sintáctico: falta función principal')
    except Exception as e:
        print(e)
    else:
        print('Función principal exitosa')
    try:
        tokens = derivate(grammar, reader, derivation, tokens, verbose=True)
    except SyntaxException as e:
        print('Error sintáctico:', e)
    except Exception as e:
        print(e)
    else:
        print('El análisis sintáctico ha finalizado exitosamente')


if __name__ == '__main__':
    grammar = parseGrammar(grammar_path)
    reader = fullCodeReader(sl_sample)
    parse(grammar, reader)
