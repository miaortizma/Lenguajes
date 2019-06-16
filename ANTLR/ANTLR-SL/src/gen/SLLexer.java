// Generated from /data/Lenguajes/ANTLR-SL/grammar/SLLexer.g4 by ANTLR 4.7.2
package gen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WHITESPACE=1, COMMENT=2, BLOCK_COMMENT=3, NEW_LINE=4, PROGRAMA=5, CONST=6, 
		TIPOS=7, VAR=8, NUMERICO=9, CADENA=10, LOGICO=11, SUBRUTINA=12, INICIO=13, 
		REF=14, FIN=15, IF=16, THEN=17, ELSE=18, ENDIF=19, RETORNA=20, LOGICO_LITERAL=21, 
		REGISTRO=22, TENSOR=23, SENTENCIAS=24, ID=25, NUMERICO_LITERAL=26, CADENA_LITERAL=27, 
		PLUS=28, MINUS=29, ASTERISK=30, DIVISION=31, POWER=32, MOD=33, SEMI=34, 
		DOUBLE_POINT=35, BOOL_OP=36, ASSIGN=37, POINT=38, COMMA=39, LEFT_PAR=40, 
		RIGHT_PAR=41, LEFT_BRACE=42, RIGHT_BRACE=43, LEFT_BRACKET=44, RIGHT_BRACET=45, 
		ANY=46;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WHITESPACE", "COMMENT", "BLOCK_COMMENT", "NEW_LINE", "PROGRAMA", "CONST", 
			"TIPOS", "VAR", "NUMERICO", "CADENA", "LOGICO", "SUBRUTINA", "INICIO", 
			"REF", "FIN", "IF", "THEN", "ELSE", "ENDIF", "RETORNA", "LOGICO_LITERAL", 
			"REGISTRO", "TENSOR", "SENTENCIAS", "DIGIT", "LETTER", "ID", "NUMERICO_LITERAL", 
			"SEQ_ESCAPE", "CADENA_LITERAL", "PLUS", "MINUS", "ASTERISK", "DIVISION", 
			"POWER", "MOD", "SEMI", "DOUBLE_POINT", "BOOL_OP", "ASSIGN", "POINT", 
			"COMMA", "LEFT_PAR", "RIGHT_PAR", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_BRACKET", 
			"RIGHT_BRACET", "ANY"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'programa'", "'const'", "'tipos'", "'var'", 
			"'numerico'", "'cadena'", "'logico'", "'subrutina'", "'inicio'", "'ref'", 
			"'fin'", "'if'", "'then'", "'else'", "'endif'", "'retorna'", null, "'registro'", 
			"'tensor'", "'sentencias'", null, null, null, "'+'", "'-'", "'*'", "'/'", 
			"'^'", "'%'", "';'", "':'", null, "'='", "'.'", "','", "'('", "')'", 
			"'{'", "'}'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WHITESPACE", "COMMENT", "BLOCK_COMMENT", "NEW_LINE", "PROGRAMA", 
			"CONST", "TIPOS", "VAR", "NUMERICO", "CADENA", "LOGICO", "SUBRUTINA", 
			"INICIO", "REF", "FIN", "IF", "THEN", "ELSE", "ENDIF", "RETORNA", "LOGICO_LITERAL", 
			"REGISTRO", "TENSOR", "SENTENCIAS", "ID", "NUMERICO_LITERAL", "CADENA_LITERAL", 
			"PLUS", "MINUS", "ASTERISK", "DIVISION", "POWER", "MOD", "SEMI", "DOUBLE_POINT", 
			"BOOL_OP", "ASSIGN", "POINT", "COMMA", "LEFT_PAR", "RIGHT_PAR", "LEFT_BRACE", 
			"RIGHT_BRACE", "LEFT_BRACKET", "RIGHT_BRACET", "ANY"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public SLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SLLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\60\u0179\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\7\3n\n\3\f\3\16\3q\13\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4"+
		"y\n\4\f\4\16\4|\13\4\3\4\3\4\3\4\3\4\3\4\3\5\5\5\u0084\n\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\5\26\u00f9\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\5\34\u011c"+
		"\n\34\3\34\3\34\3\34\7\34\u0121\n\34\f\34\16\34\u0124\13\34\3\35\6\35"+
		"\u0127\n\35\r\35\16\35\u0128\3\35\3\35\6\35\u012d\n\35\r\35\16\35\u012e"+
		"\5\35\u0131\n\35\3\36\3\36\3\36\3\37\3\37\3\37\7\37\u0139\n\37\f\37\16"+
		"\37\u013c\13\37\3\37\3\37\3\37\3\37\7\37\u0142\n\37\f\37\16\37\u0145\13"+
		"\37\3\37\5\37\u0148\n\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3"+
		"\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\5(\u0164\n(\3)\3)\3*\3*\3+\3+\3,"+
		"\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3z\2\63\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\2\65\2\67\339\34;\2=\35?\36A\37"+
		"C E!G\"I#K$M%O&Q\'S(U)W*Y+[,]-_.a/c\60\3\2\r\4\2\13\f\"\"\4\2\f\f\17\17"+
		"\3\2\62;\6\2C\\c|\u00d3\u00d3\u00f3\u00f3\3\2aa\3\2\60\60\3\2^^\3\2))"+
		"\6\2\f\f\16\17))^^\3\2$$\6\2\f\f\16\17$$^^\2\u018c\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2"+
		"\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2"+
		"S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3"+
		"\2\2\2\2a\3\2\2\2\2c\3\2\2\2\3e\3\2\2\2\5i\3\2\2\2\7t\3\2\2\2\t\u0083"+
		"\3\2\2\2\13\u0087\3\2\2\2\r\u0090\3\2\2\2\17\u0096\3\2\2\2\21\u009c\3"+
		"\2\2\2\23\u00a0\3\2\2\2\25\u00a9\3\2\2\2\27\u00b0\3\2\2\2\31\u00b7\3\2"+
		"\2\2\33\u00c1\3\2\2\2\35\u00c8\3\2\2\2\37\u00cc\3\2\2\2!\u00d0\3\2\2\2"+
		"#\u00d3\3\2\2\2%\u00d8\3\2\2\2\'\u00dd\3\2\2\2)\u00e3\3\2\2\2+\u00f8\3"+
		"\2\2\2-\u00fa\3\2\2\2/\u0103\3\2\2\2\61\u010a\3\2\2\2\63\u0115\3\2\2\2"+
		"\65\u0117\3\2\2\2\67\u011b\3\2\2\29\u0126\3\2\2\2;\u0132\3\2\2\2=\u0147"+
		"\3\2\2\2?\u0149\3\2\2\2A\u014b\3\2\2\2C\u014d\3\2\2\2E\u014f\3\2\2\2G"+
		"\u0151\3\2\2\2I\u0153\3\2\2\2K\u0155\3\2\2\2M\u0157\3\2\2\2O\u0163\3\2"+
		"\2\2Q\u0165\3\2\2\2S\u0167\3\2\2\2U\u0169\3\2\2\2W\u016b\3\2\2\2Y\u016d"+
		"\3\2\2\2[\u016f\3\2\2\2]\u0171\3\2\2\2_\u0173\3\2\2\2a\u0175\3\2\2\2c"+
		"\u0177\3\2\2\2ef\t\2\2\2fg\3\2\2\2gh\b\2\2\2h\4\3\2\2\2ij\7\61\2\2jk\7"+
		"\61\2\2ko\3\2\2\2ln\n\3\2\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2pr"+
		"\3\2\2\2qo\3\2\2\2rs\b\3\2\2s\6\3\2\2\2tu\7\61\2\2uv\7,\2\2vz\3\2\2\2"+
		"wy\13\2\2\2xw\3\2\2\2y|\3\2\2\2z{\3\2\2\2zx\3\2\2\2{}\3\2\2\2|z\3\2\2"+
		"\2}~\7,\2\2~\177\7\61\2\2\177\u0080\3\2\2\2\u0080\u0081\b\4\2\2\u0081"+
		"\b\3\2\2\2\u0082\u0084\7\17\2\2\u0083\u0082\3\2\2\2\u0083\u0084\3\2\2"+
		"\2\u0084\u0085\3\2\2\2\u0085\u0086\7\f\2\2\u0086\n\3\2\2\2\u0087\u0088"+
		"\7r\2\2\u0088\u0089\7t\2\2\u0089\u008a\7q\2\2\u008a\u008b\7i\2\2\u008b"+
		"\u008c\7t\2\2\u008c\u008d\7c\2\2\u008d\u008e\7o\2\2\u008e\u008f\7c\2\2"+
		"\u008f\f\3\2\2\2\u0090\u0091\7e\2\2\u0091\u0092\7q\2\2\u0092\u0093\7p"+
		"\2\2\u0093\u0094\7u\2\2\u0094\u0095\7v\2\2\u0095\16\3\2\2\2\u0096\u0097"+
		"\7v\2\2\u0097\u0098\7k\2\2\u0098\u0099\7r\2\2\u0099\u009a\7q\2\2\u009a"+
		"\u009b\7u\2\2\u009b\20\3\2\2\2\u009c\u009d\7x\2\2\u009d\u009e\7c\2\2\u009e"+
		"\u009f\7t\2\2\u009f\22\3\2\2\2\u00a0\u00a1\7p\2\2\u00a1\u00a2\7w\2\2\u00a2"+
		"\u00a3\7o\2\2\u00a3\u00a4\7g\2\2\u00a4\u00a5\7t\2\2\u00a5\u00a6\7k\2\2"+
		"\u00a6\u00a7\7e\2\2\u00a7\u00a8\7q\2\2\u00a8\24\3\2\2\2\u00a9\u00aa\7"+
		"e\2\2\u00aa\u00ab\7c\2\2\u00ab\u00ac\7f\2\2\u00ac\u00ad\7g\2\2\u00ad\u00ae"+
		"\7p\2\2\u00ae\u00af\7c\2\2\u00af\26\3\2\2\2\u00b0\u00b1\7n\2\2\u00b1\u00b2"+
		"\7q\2\2\u00b2\u00b3\7i\2\2\u00b3\u00b4\7k\2\2\u00b4\u00b5\7e\2\2\u00b5"+
		"\u00b6\7q\2\2\u00b6\30\3\2\2\2\u00b7\u00b8\7u\2\2\u00b8\u00b9\7w\2\2\u00b9"+
		"\u00ba\7d\2\2\u00ba\u00bb\7t\2\2\u00bb\u00bc\7w\2\2\u00bc\u00bd\7v\2\2"+
		"\u00bd\u00be\7k\2\2\u00be\u00bf\7p\2\2\u00bf\u00c0\7c\2\2\u00c0\32\3\2"+
		"\2\2\u00c1\u00c2\7k\2\2\u00c2\u00c3\7p\2\2\u00c3\u00c4\7k\2\2\u00c4\u00c5"+
		"\7e\2\2\u00c5\u00c6\7k\2\2\u00c6\u00c7\7q\2\2\u00c7\34\3\2\2\2\u00c8\u00c9"+
		"\7t\2\2\u00c9\u00ca\7g\2\2\u00ca\u00cb\7h\2\2\u00cb\36\3\2\2\2\u00cc\u00cd"+
		"\7h\2\2\u00cd\u00ce\7k\2\2\u00ce\u00cf\7p\2\2\u00cf \3\2\2\2\u00d0\u00d1"+
		"\7k\2\2\u00d1\u00d2\7h\2\2\u00d2\"\3\2\2\2\u00d3\u00d4\7v\2\2\u00d4\u00d5"+
		"\7j\2\2\u00d5\u00d6\7g\2\2\u00d6\u00d7\7p\2\2\u00d7$\3\2\2\2\u00d8\u00d9"+
		"\7g\2\2\u00d9\u00da\7n\2\2\u00da\u00db\7u\2\2\u00db\u00dc\7g\2\2\u00dc"+
		"&\3\2\2\2\u00dd\u00de\7g\2\2\u00de\u00df\7p\2\2\u00df\u00e0\7f\2\2\u00e0"+
		"\u00e1\7k\2\2\u00e1\u00e2\7h\2\2\u00e2(\3\2\2\2\u00e3\u00e4\7t\2\2\u00e4"+
		"\u00e5\7g\2\2\u00e5\u00e6\7v\2\2\u00e6\u00e7\7q\2\2\u00e7\u00e8\7t\2\2"+
		"\u00e8\u00e9\7p\2\2\u00e9\u00ea\7c\2\2\u00ea*\3\2\2\2\u00eb\u00ec\7U\2"+
		"\2\u00ec\u00f9\7K\2\2\u00ed\u00ee\7P\2\2\u00ee\u00f9\7Q\2\2\u00ef\u00f0"+
		"\7V\2\2\u00f0\u00f1\7T\2\2\u00f1\u00f2\7W\2\2\u00f2\u00f9\7G\2\2\u00f3"+
		"\u00f4\7H\2\2\u00f4\u00f5\7C\2\2\u00f5\u00f6\7N\2\2\u00f6\u00f7\7U\2\2"+
		"\u00f7\u00f9\7G\2\2\u00f8\u00eb\3\2\2\2\u00f8\u00ed\3\2\2\2\u00f8\u00ef"+
		"\3\2\2\2\u00f8\u00f3\3\2\2\2\u00f9,\3\2\2\2\u00fa\u00fb\7t\2\2\u00fb\u00fc"+
		"\7g\2\2\u00fc\u00fd\7i\2\2\u00fd\u00fe\7k\2\2\u00fe\u00ff\7u\2\2\u00ff"+
		"\u0100\7v\2\2\u0100\u0101\7t\2\2\u0101\u0102\7q\2\2\u0102.\3\2\2\2\u0103"+
		"\u0104\7v\2\2\u0104\u0105\7g\2\2\u0105\u0106\7p\2\2\u0106\u0107\7u\2\2"+
		"\u0107\u0108\7q\2\2\u0108\u0109\7t\2\2\u0109\60\3\2\2\2\u010a\u010b\7"+
		"u\2\2\u010b\u010c\7g\2\2\u010c\u010d\7p\2\2\u010d\u010e\7v\2\2\u010e\u010f"+
		"\7g\2\2\u010f\u0110\7p\2\2\u0110\u0111\7e\2\2\u0111\u0112\7k\2\2\u0112"+
		"\u0113\7c\2\2\u0113\u0114\7u\2\2\u0114\62\3\2\2\2\u0115\u0116\t\4\2\2"+
		"\u0116\64\3\2\2\2\u0117\u0118\t\5\2\2\u0118\66\3\2\2\2\u0119\u011c\5\65"+
		"\33\2\u011a\u011c\t\6\2\2\u011b\u0119\3\2\2\2\u011b\u011a\3\2\2\2\u011c"+
		"\u0122\3\2\2\2\u011d\u0121\5\65\33\2\u011e\u0121\5\63\32\2\u011f\u0121"+
		"\t\6\2\2\u0120\u011d\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u011f\3\2\2\2\u0121"+
		"\u0124\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u01238\3\2\2\2"+
		"\u0124\u0122\3\2\2\2\u0125\u0127\5\63\32\2\u0126\u0125\3\2\2\2\u0127\u0128"+
		"\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u0130\3\2\2\2\u012a"+
		"\u012c\t\7\2\2\u012b\u012d\5\63\32\2\u012c\u012b\3\2\2\2\u012d\u012e\3"+
		"\2\2\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0131\3\2\2\2\u0130"+
		"\u012a\3\2\2\2\u0130\u0131\3\2\2\2\u0131:\3\2\2\2\u0132\u0133\t\b\2\2"+
		"\u0133\u0134\t\7\2\2\u0134<\3\2\2\2\u0135\u013a\t\t\2\2\u0136\u0139\5"+
		";\36\2\u0137\u0139\n\n\2\2\u0138\u0136\3\2\2\2\u0138\u0137\3\2\2\2\u0139"+
		"\u013c\3\2\2\2\u013a\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013d\3\2"+
		"\2\2\u013c\u013a\3\2\2\2\u013d\u0148\t\t\2\2\u013e\u0143\t\13\2\2\u013f"+
		"\u0142\5;\36\2\u0140\u0142\n\f\2\2\u0141\u013f\3\2\2\2\u0141\u0140\3\2"+
		"\2\2\u0142\u0145\3\2\2\2\u0143\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144"+
		"\u0146\3\2\2\2\u0145\u0143\3\2\2\2\u0146\u0148\t\13\2\2\u0147\u0135\3"+
		"\2\2\2\u0147\u013e\3\2\2\2\u0148>\3\2\2\2\u0149\u014a\7-\2\2\u014a@\3"+
		"\2\2\2\u014b\u014c\7/\2\2\u014cB\3\2\2\2\u014d\u014e\7,\2\2\u014eD\3\2"+
		"\2\2\u014f\u0150\7\61\2\2\u0150F\3\2\2\2\u0151\u0152\7`\2\2\u0152H\3\2"+
		"\2\2\u0153\u0154\7\'\2\2\u0154J\3\2\2\2\u0155\u0156\7=\2\2\u0156L\3\2"+
		"\2\2\u0157\u0158\7<\2\2\u0158N\3\2\2\2\u0159\u0164\7>\2\2\u015a\u015b"+
		"\7>\2\2\u015b\u0164\7?\2\2\u015c\u015d\7@\2\2\u015d\u0164\7?\2\2\u015e"+
		"\u0164\7@\2\2\u015f\u0160\7?\2\2\u0160\u0164\7?\2\2\u0161\u0162\7>\2\2"+
		"\u0162\u0164\7@\2\2\u0163\u0159\3\2\2\2\u0163\u015a\3\2\2\2\u0163\u015c"+
		"\3\2\2\2\u0163\u015e\3\2\2\2\u0163\u015f\3\2\2\2\u0163\u0161\3\2\2\2\u0164"+
		"P\3\2\2\2\u0165\u0166\7?\2\2\u0166R\3\2\2\2\u0167\u0168\7\60\2\2\u0168"+
		"T\3\2\2\2\u0169\u016a\7.\2\2\u016aV\3\2\2\2\u016b\u016c\7*\2\2\u016cX"+
		"\3\2\2\2\u016d\u016e\7+\2\2\u016eZ\3\2\2\2\u016f\u0170\7}\2\2\u0170\\"+
		"\3\2\2\2\u0171\u0172\7\177\2\2\u0172^\3\2\2\2\u0173\u0174\7]\2\2\u0174"+
		"`\3\2\2\2\u0175\u0176\7_\2\2\u0176b\3\2\2\2\u0177\u0178\13\2\2\2\u0178"+
		"d\3\2\2\2\23\2oz\u0083\u00f8\u011b\u0120\u0122\u0128\u012e\u0130\u0138"+
		"\u013a\u0141\u0143\u0147\u0163\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}