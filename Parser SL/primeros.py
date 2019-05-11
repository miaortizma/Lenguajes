import re

grammar_path = 'grammar.txt'
terminal_reg = r'(?:\<.+\>)'
non_terminal_reg = r'(?:[A-Z]+[0-9]*)'

class Grammar:

	def __init__(self, rules):
		self.rules = {}
		self.firsts = {}
		self.seconds = {}
		self.predicts = {}
		self.root = None
		for rule in rules:
			self.addRule(rule)

	def addRule(self, rule):
		print(rule)
		symbol, rule = rule
		if(symbol in self.rules):
			self.rules[symbol].append(rule)
		else:
			self.rules[symbol] = [rule]

	def __str__(self):
		return str(self.rules)

def parseRule(rule):
	a, b = rule.split(':', 1)
	a = a.strip()
	b = b.strip().split(' ')
	if( 'eps' in b ):
		if( len(b) > 1 ):
			raise ValueError
		else:
			return a, b
	for symbol in b:
		if(not re.fullmatch('|'.join([terminal_reg, non_terminal_reg]), symbol)):
			raise ValueError
	return a, b

def parseGrammar(grammar_path):
	"""
	formato: identificador no terminal
	A : <alpha> <Beta> 
	"""
	with open(grammar_path) as file:
		rules = [ parseRule(line) for line in file]
	grammar = Grammar(rules)
	return grammar

def first(grammar, non_terminal, rule):
	if(non_terminal in grammar.firsts):
		return grammar.first[non_terminal]
	ret = set()
	if(rule == non_terminal):
		print(grammar.rules)
		for rule in grammar.rules[non_terminal]:
			ret |= first(grammar, non_terminal, rule)
		grammar.firsts[non_terminal] = ret
		return ret
	if('eps' == rule[0]):
		ret |= set(['eps'])
	elif(re.fullmatch(non_terminal_reg, rule[0])):
		if(rule[0] != non_terminal):
			sol = first(grammar, rule[0], rule[0])
			ret |= sol - set(['eps'])
			if 'eps' in sol:
				if(len(rule) == 1):
					ret |= set(['eps'])
				else:
					ret |= first(grammar, non_terminal, rule[1:])
	else:
		return set([rule[0]])
	return ret




grammar = parseGrammar(grammar_path)
print(first(grammar, 'A', 'A'))
print('termine')