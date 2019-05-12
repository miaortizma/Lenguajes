from path import Path
import Lexer.lexer as lexer
import Parser.parser as parser
from codeReader import fullCodeReader

localPath = Path(__file__).parent
sl_path = localPath / 'Parser/sl_sample.txt'

try:
    reader = fullCodeReader(sl_path)
    lexer.main(reader, verbose=False)
except Exception as e:
    print(e)
    print('Error lexer')
else:
    print('Exito lexer')
    try:
        reader = fullCodeReader(sl_path)
        parser.main(reader, verbose=True)
    except Exception as e:
        print(e)
        print('Error parser')
    else:
        print('Exito parser')
