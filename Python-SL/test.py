from path import Path
import Lexer.lexer as lexer
import Parser.parser as parser
from codeReader import fullCodeReader, SyntaxException, LexicException

localPath = Path(__file__).parent
sl_path = localPath / 'Parser/5.txt'
lexerOutPath = localPath / 'Lexer/data/out.txt'

try:
    reader = fullCodeReader(sl_path)
    lexer.main(reader, verbose=False)
except LexicException as e:
    print(e)
    print('Error lexer')
else:
    print('Exito lexer')
    try:
        parser.main(sl_path, verbose=True)
    except SyntaxException as e:
        print(e)
        print('Error parser')
    else:
        print('Exito parser')
