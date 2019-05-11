import re
from path import Path
from collections import defaultdict


grammar_path = Path(__file__).parent / 'grammar.txt'
terminal_reg = r'(?:\<.+\>)'
non_terminal_reg = r'(?:[A-Z]+[0-9]*)'


class Grammar:

    def __init__(self, rules, initial):
        self.initial = initial
        self.rules = defaultdict(list)
        self.ins = defaultdict(list)
        self.follows = defaultdict(set)
        self.non_terminals = set()
        self.firsts = {}
        self.predicts = {}
        self.explored = set()
        for rule in rules:
            self.addRule(rule)
        self.non_terminals = list(sorted(self.non_terminals))
        firsts(self, self.initial)  # recursion will calculate all
        follows(self, self.initial)
        while(followsResolve(self)):
            pass

    def addRule(self, rule):
        non_terminal, rule = rule
        self.non_terminals.add(non_terminal)
        for symbol in rule:
            if(isNT(symbol) and symbol != non_terminal):
                pos = len(self.rules[non_terminal])
                self.ins[symbol].append((non_terminal, pos))
        self.rules[non_terminal].append(rule)

    def __str__(self):
        s = ''
        s += str(self.initial) + '\n'
        for nt in self.non_terminals:
            for rule in self.rules[nt]:
                s += str(nt) + '\t' + str(rule) + '\n'
        s += 'Firsts:\n'
        for nt in self.non_terminals:
            s += str(nt) + '\t' + str(sorted(self.firsts[nt])) + '\n'
        s += 'Follows:\n'
        for nt in self.non_terminals:
            s += str(nt) + '\t' + str(sorted(self.follows[nt])) + '\n'
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


def isNT(symbol):
    return re.fullmatch(non_terminal_reg, symbol)


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


def firsts(grammar, non_terminal):
    if(non_terminal in grammar.firsts):
        return grammar.firsts[non_terminal]
    ret = set()
    for rule in grammar.rules[non_terminal]:
            if(rule[0] != non_terminal):  # left recursive
                ret |= first(grammar, rule)
    grammar.firsts[non_terminal] = ret
    return ret


def first(grammar, alpha):
    if(len(alpha) == 0):
        return set(['eps'])
    ret = set()
    terminal = alpha[0] == 'eps' or re.fullmatch(terminal_reg, alpha[0])
    if(terminal):  # terminal or epsilon
        return set([alpha[0]])
    else:  # non-terminal
        sol = firsts(grammar, alpha[0])
        ret |= sol - set(['eps'])
        if 'eps' in sol:
            if(len(alpha) == 1):
                ret.add('eps')
            else:
                ret |= first(grammar, alpha[1:])
        return ret


def follows(grammar, non_terminal):
    grammar.explored.add(non_terminal)
    if(non_terminal is grammar.initial):
        grammar.follows[non_terminal].add('$')
    for rule in grammar.rules[non_terminal]:
        for i in range(len(rule)):
            symbol = rule[i]
            if(isNT(symbol)):
                if(symbol not in grammar.explored):
                    follows(grammar, symbol)
                sol = first(grammar, rule[i + 1:])  # may be epsilon
                grammar.follows[symbol] |= sol - set(['eps'])
                if('eps' in sol):
                    grammar.follows[symbol].add(non_terminal)


def followsResolve(grammar):
    added = False
    for non_terminal in grammar.non_terminals:
        copy = grammar.follows[non_terminal].copy()
        for elem in grammar.follows[non_terminal]:
            if(isNT(elem)):
                to_add = grammar.follows[elem]
                added = True
                copy |= to_add
                copy -= set([non_terminal])  # non recursive
                copy -= set([elem])
        grammar.follows[non_terminal] = copy
    return added


def predicts(grammar, non_terminal, rule=None):
    
    pass


grammar = parseGrammar(grammar_path)
# print(first(grammar, 'A'))
# print(first(grammar, 'B'))
# print(first(grammar, 'C'))
print(grammar)
print('El análisis sintáctico ha finalizado exitosamente')
