import re
terminal_reg = r'(?:\<.+\>)'
non_terminal_reg = r'(?:[A-Z]+[0-9]*)'
maximum_depth = 600

def isNT(symbol):
    return re.fullmatch(non_terminal_reg, symbol)

def firsts(grammar, non_terminal):
    global maximum_depth
    """
    Problemas si hay recursividad por la izquierda
    """
    maximum_depth -= 1
    if(maximum_depth <= 0):
        return {'eps'}

    if(non_terminal in grammar.firsts):
        maximum_depth += 1
        return grammar.firsts[non_terminal]
    ret = set()
    for rule in grammar.rules[non_terminal]:
            if(rule[0] != non_terminal):  # left recursive
                ret |= first(grammar, rule)
            elif(grammar.nullable[non_terminal]):  # simple recursion
                ret |= first(grammar, rule[1:])
    grammar.firsts[non_terminal] = ret
    maximum_depth += 1
    return ret


def first(grammar, alpha):
    global maximum_depth
    maximum_depth -= 1
    if(len(alpha) == 0 or maximum_depth <= 0):
        return {'eps'}
    ret = set()
    terminal = alpha[0] == 'eps' or re.fullmatch(terminal_reg, alpha[0])
    if(terminal):  # terminal or epsilon
        maximum_depth += 1
        return set([alpha[0]])
    else:  # non-terminal
        sol = firsts(grammar, alpha[0])
        ret |= sol - {'eps'}
        if 'eps' in sol:
            if(len(alpha) == 1):
                ret.add('eps')
            else:
                ret |= first(grammar, alpha[1:])
        maximum_depth += 1
        return ret


def follows(grammar, non_terminal):
    grammar.explored.add(non_terminal)
    if(non_terminal is grammar.initial):
        grammar.follows[non_terminal].add('<$>')
    for rule in grammar.rules[non_terminal]:
        for i in range(len(rule)):
            symbol = rule[i]
            if(isNT(symbol)):
                if(symbol not in grammar.explored):
                    follows(grammar, symbol)
                sol = first(grammar, rule[i + 1:])  # may be epsilon
                grammar.follows[symbol] |= sol - {'eps'}
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

def predicts(grammar, non_terminal, alpha):
    sol = first(grammar, alpha)
    if('eps' in sol):
        return (sol - {'eps'}) | grammar.follows[non_terminal]
    else:
        return sol