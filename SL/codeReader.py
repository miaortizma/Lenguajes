import re


class codeReader:

    def __init(self):
        pass

    def __iter(self):
        pass

    def __next__(self):
        pass

    def done(self):
        """
        Is file done?
        """
        pass

    def reset(self):
        """
        Resets last read character
        """
        pass

    def pos(self):
        """
        Get position on file
        """

    def peek(self):
        """
        Returns next token
        """
        pass


class fullCodeReader(codeReader):
    """
    Reads code as a list of lines
    """

    def __init__(self, code_path):
        with open(code_path) as file:
            self.code = file.readlines()
        self.len = sum([len(line) for line in self.code])
        self.row = self.col = self.displacement = self.iter = 0
        self.history = []
        self.c = None

    def __iter__(self):
        self.row = self.col = self.iter = self.displacement = 0
        self.history = []
        return self

    def __next__(self):
        if(self.row < len(self.code)):
            self.history.append((self.row, self.col, self.displacement))
            self.iter += 1
            self.char = self.code[self.row][self.col]
            if(self.char == '\t'):
                self.displacement += 3
            self.col += 1
            if(self.col == len(self.code[self.row])):
                self.col = self.displacement = 0
                self.row += 1
            return self.char
        else:
            raise StopIteration

    def __len__(self):
        return self.len

    def done(self):
        return self.iter == self.len

    def reset(self, n=1):
        if(n == 0):
            pass
        elif(self.history):
            self.row, self.col, self.displacement = self.history[-1]
            self.history = self.history[:-1]
            self.iter = len(self.history)
            self.reset(n - 1)
        else:
            raise ValueError

    def pos(self):
        return (self.row + 1, self.col + self.displacement + 1)

    def read(self, n=1):
        if(n <= 0):
            raise ValueError
        else:
            try:
                s = ''
                for i in range(n):
                    s = s + next(self)
                return s
            except Exception as e:
                n = len(s)
                self.reset(n)
                print(e)
                raise ValueError

    def peek(self, n=1):
        try:
            s = ''
            for i in range(n):
                s = s + next(self)
            return s
        except Exception as e:
            return ''
        finally:
            n = len(s)
            self.reset(n)


class fileCodeReader:
    """
    clase que lee de un archivo caracter por caracter
    """

    def __init__(self, filename):
        pass


def readUntilFullMatch(reader, s, reg):
    while(not reader.done() and not re.fullmatch(reg, s)):
        c = next(reader)
        s = s + c
    if(not re.fullmatch(reg, s)):
        raise LexicException
    else:
        return s


def readWhileFullMatch(reader, s, reg):
    while(not reader.done() and re.fullmatch(reg, s)):
        s = s + next(reader)
    if(not reader.done()):
        s = s[:-1]
        reader.reset()
    return s


class Token(object):

    def __init__(self, _type, row, col, lexeme=None):
        self._type = _type
        if(lexeme):
            self.lexeme = lexeme
        else:
            self.lexeme = _type
        self.row = row
        self.col = col

    def __str__(self):
        if(self.lexeme == self._type):
            return '<{}, {}, {}>'.format(self._type, self.row, self.col)
        else:
            return '<{}, {}, {}, {}>'.format(
                self._type, self.lexeme, self.row, self.col)

    def __repr__(self):
        return str(self)


class LexicException(Exception):
    """Raised when a lexic error happens"""
    pass


class SyntaxException(Exception):
    """Raised when a lexic error happens"""
    pass
