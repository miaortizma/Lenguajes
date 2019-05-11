import re

grammar_path = 'grammar.txt'
terminal_reg = r'(?:\<.+\>)'
non_terminal_reg = r'(?:[A-Z]+[0-9]*)'


class Grammar:

    def __init__(self, rules, initial):
        self.initial = initial
        self.rules = {}
        self.firsts = {}
        self.seconds = {}
        self.predicts = {}
        for rule in rules:
            self.addRule(rule)  # recursion will calculate all firsts of reachable elements
        first(self, self.initial)

    def addRule(self, rule):
        symbol, rule = rule
        if(symbol in self.rules):
            self.rules[symbol].append(rule)
        else:
            self.rules[symbol] = [rule]

    def __str__(self):
        s = ''
        s += str(self.initial) + '\n'
        for symbol in self.rules:
            for rule in self.rules[symbol]:
                s += str(symbol) + '\t' + str(rule) + '\n'
        s += 'Firsts:\n'
        for symbol in self.rules:
            s += str(symbol) + '\t' + str(sorted(self.firsts[symbol])) + '\n'
        return s


def parseRule(rule):
    a, b = rule.split(':', 1)
    a = a.strip()
    b = b.strip().split(' ')
    if('eps' in b):
        if(len(b) > 1):
            raise ValueError
        else:
            return a, b
    for symbol in b:
        reg = '|'.join([terminal_reg, non_terminal_reg])
        if(not re.fullmatch(reg, symbol)):
            raise ValueError
    return a, b


def parseGrammar(grammar_path):
    """
    formato: identificador no terminal
    A : <alpha> <Beta>
    """
    with open(grammar_path) as file:
        initial = file.readline().strip()
        rules = [parseRule(line) for line in file]
    grammar = Grammar(rules, initial)
    return grammar


def first(grammar, non_terminal, rule=None):
    if(non_terminal in grammar.firsts):
        return grammar.firsts[non_terminal]
    ret = set()
    if(rule is None):
        for rule in grammar.rules[non_terminal]:
            ret |= first(grammar, non_terminal, rule)
        grammar.firsts[non_terminal] = ret
        return ret
    if('eps' == rule[0]):
        return set(['eps'])
    elif(re.fullmatch(terminal_reg, rule[0])):
        return set([rule[0]])
    else:
        if(rule[0] != non_terminal):
            sol = first(grammar, rule[0])
            ret |= sol - set(['eps'])
            if 'eps' in sol:
                if(len(rule) == 1):
                    ret.add('eps')
                else:
                    ret |= first(grammar, non_terminal, rule[1:])
        return ret


def follows(grammar, non_terminal):
    ret = set()
    if(non_terminal is grammar.initial):
        ret.add('$')
#   


def predicts(grammar, non_terminal, rule=None):
    pass


grammar = parseGrammar(grammar_path)
# print(first(grammar, 'A'))
# print(first(grammar, 'B'))
# print(first(grammar, 'C'))
print(grammar)
print('El análisis sintáctico ha finalizado exitosamente')
