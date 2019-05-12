from path import Path
from .grammar import *
from codeReader import *
from Lexer.lexer import *

localPath = Path(__file__).parent

grammar_path = localPath / 'grammar.txt'
sl_sample = localPath / 'sl_sample.txt'


def derivate(grammar, reader, derivation, tokens):
    iters = 0
    while(len(derivation)):
        symbol = derivation[0]
        if(len(tokens) == 0):
            tokens.append(nextToken(reader))
        tk = tokens[0]
        """
        print('--------')
        print(derivation)
        print(symbol, tk)
        """
        if(isNT(symbol)):
            candidates = []
            for i, rules in enumerate(grammar.rules[symbol]):
                if('<' + tk._type + '>' in grammar.predicts[symbol][i]):
                    candidates.append(i)
            if(len(candidates) > 1):
                print('Grammar is not LL(1)')
                raise ValueError
            elif(len(candidates) == 0):
                print('No valid prediction found')
                raise SyntaxException
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
            print('Unmatched Grammar')
            raise SyntaxException
        iters += 1
    return tokens


def parse(grammar, reader):
    derivation = ['PROGRAMAPRC']
    tokens = []
    try:
        tokens = derivate(grammar, reader, derivation, tokens)
        derivation = ['SUBRUTINAS']
    except SyntaxException as e:
        print('Error sintáctico: falta función principal')
    else:
        print(e)

    tokens = derivate(grammar, reader, derivation, tokens)


if __name__ == '__main__':
    grammar = parseGrammar(grammar_path)
    reader = fullCodeReader(sl_sample)
    parse(grammar, reader)
    print('El análisis sintáctico ha finalizado exitosamente')
