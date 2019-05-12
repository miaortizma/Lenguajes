import re
from path import Path
from collections import defaultdict
from .sets import *

grammar_path = Path(__file__).parent / 'grammar.txt'
terminal_reg = r'(?:\<.+\>)'
non_terminal_reg = r'(?:[A-Z]+[0-9]*)'


class Grammar:

    def __init__(self, rules, initial):
        self.initial = initial
        self.rules = defaultdict(list)
        self.ins = defaultdict(list)
        self.predicts = defaultdict(list)
        self.follows = defaultdict(set)
        self.nullable = defaultdict(bool)
        self.non_terminals = set()
        self.firsts = {}
        self.explored = set()
        for rule in rules:
            self.addRule(rule)
        self.non_terminals = list(sorted(self.non_terminals))
        self.calculateSets()

    def calculateSets(self):
        for nt in self.non_terminals:
            firsts(self, nt)
        for nt in self.non_terminals:
            if(nt not in self.explored):
                follows(self, self.initial)
        while(followsResolve(self)):
            pass
        for nt in self.non_terminals:
            for rule in self.rules[nt]:
                rule_predicts = predicts(self, nt, rule)
                self.predicts[nt].append(rule_predicts)

    def addRule(self, rule):
        non_terminal, rule = rule
        if(rule[0] == 'eps'):
            self.nullable[non_terminal] |= True
        self.non_terminals.add(non_terminal)
        self.rules[non_terminal].append(rule)

    def __str__(self):
        s = ''
        s += str(self.initial) + '\n'
        for nt in self.non_terminals:
            for i in range(len(self.rules[nt])):
                rule = self.rules[nt][i]
                predicts = self.predicts[nt][i]
                s += str(nt) + '\t' + str(rule) + '\t' + str(predicts) + '\n'
        s += 'Firsts:\n'
        for nt in self.non_terminals:
            s += str(nt) + '\t' + str(sorted(self.firsts[nt])) + '\n'
        s += 'Follows:\n'
        for nt in self.non_terminals:
            s += str(nt) + '\t' + str(sorted(self.follows[nt])) + '\n'
        return s


def parseRule(rule):
    a, b = rule
    a = a.strip()
    b = b.strip().split()
    if('eps' in b):
        if(len(b) > 1):
            raise ValueError
        else:
            return a, b
    for symbol in b:
        reg = '|'.join([terminal_reg, non_terminal_reg])
        if(not re.fullmatch(reg, symbol)):
            print(symbol + ' Doesn\'t match non_terminal or terminal regex' )
            raise ValueError
    return a, b


def splitRule(rule):
    a, b = rule.split(':', 1)
    nt = a.strip()
    rules = b.strip().split('|')
    arr = [(nt, rule.strip()) for rule in rules]
    return arr


def parseGrammar(grammar_path):
    """
    formato: identificador no terminal
    A : <alpha> <Beta>
    """
    with open(grammar_path) as file:
        initial = file.readline().strip()
        rules = sum([splitRule(line) for line in file], [])
        rules = [parseRule(rule) for rule in rules]
    grammar = Grammar(rules, initial)
    return grammar


grammar = parseGrammar(grammar_path)
print(grammar)

print(predicts(grammar, 'S', ['A', 'B', 'C']))
print('El análisis sintáctico ha finalizado exitosamente')
