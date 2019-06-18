// Generated from /data/Lenguajes/ANTLR-SL/grammar/SLParser.g4 by ANTLR 4.7.2
package gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WHITESPACE=1, COMMENT=2, BLOCK_COMMENT=3, NEW_LINE=4, PROGRAMA=5, CONST=6, 
		TIPOS=7, VAR=8, NUMERICO=9, CADENA=10, LOGICO=11, SUBRUTINA=12, INICIO=13, 
		REF=14, FIN=15, IF=16, THEN=17, ELSE=18, ENDIF=19, RETORNA=20, LOGICO_LITERAL=21, 
		REGISTRO=22, TENSOR=23, SENTENCIA=24, ID=25, NUMERICO_LITERAL=26, CADENA_LITERAL=27, 
		PLUS=28, MINUS=29, ASTERISK=30, DIVISION=31, POWER=32, MOD=33, SEMI=34, 
		DOUBLE_POINT=35, BOOL_OP=36, ASSIGN=37, POINT=38, COMMA=39, LEFT_PAR=40, 
		RIGHT_PAR=41, LEFT_BRACE=42, RIGHT_BRACE=43, LEFT_BRACKET=44, RIGHT_BRACET=45, 
		ANY=46;
	public static final int
		RULE_programa = 0, RULE_programaprc = 1, RULE_declaraciones = 2, RULE_declaracion = 3, 
		RULE_consts = 4, RULE_const_ = 5, RULE_tipos = 6, RULE_tipo = 7, RULE_vars = 8, 
		RULE_var = 9, RULE_explicitvar = 10, RULE_opt = 11, RULE_listaid = 12, 
		RULE_literal = 13, RULE_tipobasico = 14, RULE_tipobasico2 = 15, RULE_tipobasico3 = 16, 
		RULE_tensor = 17, RULE_registro = 18, RULE_subrutinas = 19, RULE_subrutina = 20, 
		RULE_procedimiento = 21, RULE_funcion = 22, RULE_tiporet = 23, RULE_ret = 24, 
		RULE_expr = 25, RULE_parametrosformales = 26, RULE_parametroformal = 27, 
		RULE_sentencias = 28, RULE_sentencia = 29, RULE_llamadosub = 30, RULE_parametros = 31;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "programaprc", "declaraciones", "declaracion", "consts", 
			"const_", "tipos", "tipo", "vars", "var", "explicitvar", "opt", "listaid", 
			"literal", "tipobasico", "tipobasico2", "tipobasico3", "tensor", "registro", 
			"subrutinas", "subrutina", "procedimiento", "funcion", "tiporet", "ret", 
			"expr", "parametrosformales", "parametroformal", "sentencias", "sentencia", 
			"llamadosub", "parametros"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'programa'", "'const'", "'tipos'", "'var'", 
			"'numerico'", "'cadena'", "'logico'", "'subrutina'", "'inicio'", "'ref'", 
			"'fin'", "'if'", "'then'", "'else'", "'endif'", "'retorna'", null, "'registro'", 
			"'tensor'", "'sentencia'", null, null, null, "'+'", "'-'", "'*'", "'/'", 
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
			"REGISTRO", "TENSOR", "SENTENCIA", "ID", "NUMERICO_LITERAL", "CADENA_LITERAL", 
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

	@Override
	public String getGrammarFileName() { return "SLParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramaContext extends ParserRuleContext {
		public ProgramaprcContext programaprc() {
			return getRuleContext(ProgramaprcContext.class,0);
		}
		public SubrutinasContext subrutinas() {
			return getRuleContext(SubrutinasContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SLParser.EOF, 0); }
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			programaprc();
			setState(65);
			subrutinas();
			setState(66);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramaprcContext extends ParserRuleContext {
		public TerminalNode INICIO() { return getToken(SLParser.INICIO, 0); }
		public TerminalNode FIN() { return getToken(SLParser.FIN, 0); }
		public TerminalNode PROGRAMA() { return getToken(SLParser.PROGRAMA, 0); }
		public TerminalNode ID() { return getToken(SLParser.ID, 0); }
		public DeclaracionesContext declaraciones() {
			return getRuleContext(DeclaracionesContext.class,0);
		}
		public SentenciasContext sentencias() {
			return getRuleContext(SentenciasContext.class,0);
		}
		public ProgramaprcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programaprc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterProgramaprc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitProgramaprc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitProgramaprc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaprcContext programaprc() throws RecognitionException {
		ProgramaprcContext _localctx = new ProgramaprcContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_programaprc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PROGRAMA) {
				{
				setState(68);
				match(PROGRAMA);
				setState(69);
				match(ID);
				}
			}

			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONST) | (1L << TIPOS) | (1L << VAR))) != 0)) {
				{
				setState(72);
				declaraciones();
				}
			}

			setState(75);
			match(INICIO);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SENTENCIA || _la==ID) {
				{
				setState(76);
				sentencias();
				}
			}

			setState(79);
			match(FIN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracionesContext extends ParserRuleContext {
		public List<DeclaracionContext> declaracion() {
			return getRuleContexts(DeclaracionContext.class);
		}
		public DeclaracionContext declaracion(int i) {
			return getRuleContext(DeclaracionContext.class,i);
		}
		public DeclaracionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaraciones; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterDeclaraciones(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitDeclaraciones(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitDeclaraciones(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionesContext declaraciones() throws RecognitionException {
		DeclaracionesContext _localctx = new DeclaracionesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaraciones);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(81);
				declaracion();
				}
				}
				setState(84); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONST) | (1L << TIPOS) | (1L << VAR))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracionContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(SLParser.CONST, 0); }
		public ConstsContext consts() {
			return getRuleContext(ConstsContext.class,0);
		}
		public TerminalNode TIPOS() { return getToken(SLParser.TIPOS, 0); }
		public TiposContext tipos() {
			return getRuleContext(TiposContext.class,0);
		}
		public TerminalNode VAR() { return getToken(SLParser.VAR, 0); }
		public VarsContext vars() {
			return getRuleContext(VarsContext.class,0);
		}
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterDeclaracion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitDeclaracion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitDeclaracion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaracion);
		try {
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(86);
				match(CONST);
				setState(87);
				consts();
				}
				}
				break;
			case TIPOS:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(88);
				match(TIPOS);
				setState(89);
				tipos();
				}
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(90);
				match(VAR);
				setState(91);
				vars();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstsContext extends ParserRuleContext {
		public List<Const_Context> const_() {
			return getRuleContexts(Const_Context.class);
		}
		public Const_Context const_(int i) {
			return getRuleContext(Const_Context.class,i);
		}
		public ConstsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_consts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterConsts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitConsts(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitConsts(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstsContext consts() throws RecognitionException {
		ConstsContext _localctx = new ConstsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_consts);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(94);
				const_();
				}
				}
				setState(97); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Const_Context extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SLParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(SLParser.ASSIGN, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public OptContext opt() {
			return getRuleContext(OptContext.class,0);
		}
		public Const_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterConst_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitConst_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitConst_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Const_Context const_() throws RecognitionException {
		Const_Context _localctx = new Const_Context(_ctx, getState());
		enterRule(_localctx, 10, RULE_const_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(ID);
			setState(100);
			match(ASSIGN);
			setState(101);
			literal();
			setState(102);
			opt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TiposContext extends ParserRuleContext {
		public List<TipoContext> tipo() {
			return getRuleContexts(TipoContext.class);
		}
		public TipoContext tipo(int i) {
			return getRuleContext(TipoContext.class,i);
		}
		public TiposContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterTipos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitTipos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitTipos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TiposContext tipos() throws RecognitionException {
		TiposContext _localctx = new TiposContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_tipos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(104);
				tipo();
				}
				}
				setState(107); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SLParser.ID, 0); }
		public TerminalNode DOUBLE_POINT() { return getToken(SLParser.DOUBLE_POINT, 0); }
		public TipobasicoContext tipobasico() {
			return getRuleContext(TipobasicoContext.class,0);
		}
		public OptContext opt() {
			return getRuleContext(OptContext.class,0);
		}
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitTipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_tipo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(ID);
			setState(110);
			match(DOUBLE_POINT);
			setState(111);
			tipobasico();
			setState(112);
			opt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarsContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public VarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterVars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitVars(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitVars(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarsContext vars() throws RecognitionException {
		VarsContext _localctx = new VarsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_vars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(114);
				var();
				}
				}
				setState(117); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public ListaidContext listaid() {
			return getRuleContext(ListaidContext.class,0);
		}
		public TerminalNode DOUBLE_POINT() { return getToken(SLParser.DOUBLE_POINT, 0); }
		public ExplicitvarContext explicitvar() {
			return getRuleContext(ExplicitvarContext.class,0);
		}
		public OptContext opt() {
			return getRuleContext(OptContext.class,0);
		}
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			listaid();
			setState(120);
			match(DOUBLE_POINT);
			setState(121);
			explicitvar();
			setState(122);
			opt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExplicitvarContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SLParser.ID, 0); }
		public TipobasicoContext tipobasico() {
			return getRuleContext(TipobasicoContext.class,0);
		}
		public ExplicitvarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitvar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterExplicitvar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitExplicitvar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitExplicitvar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExplicitvarContext explicitvar() throws RecognitionException {
		ExplicitvarContext _localctx = new ExplicitvarContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_explicitvar);
		try {
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				match(ID);
				}
				break;
			case NUMERICO:
			case CADENA:
			case LOGICO:
			case REGISTRO:
			case TENSOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				tipobasico();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(SLParser.SEMI, 0); }
		public OptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterOpt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitOpt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitOpt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptContext opt() throws RecognitionException {
		OptContext _localctx = new OptContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_opt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(128);
				match(SEMI);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaidContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SLParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SLParser.COMMA, i);
		}
		public ListaidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterListaid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitListaid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitListaid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListaidContext listaid() throws RecognitionException {
		ListaidContext _localctx = new ListaidContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_listaid);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(ID);
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(132);
				match(COMMA);
				setState(133);
				match(ID);
				}
				}
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode NUMERICO_LITERAL() { return getToken(SLParser.NUMERICO_LITERAL, 0); }
		public TerminalNode CADENA_LITERAL() { return getToken(SLParser.CADENA_LITERAL, 0); }
		public TerminalNode LOGICO_LITERAL() { return getToken(SLParser.LOGICO_LITERAL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOGICO_LITERAL) | (1L << NUMERICO_LITERAL) | (1L << CADENA_LITERAL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipobasicoContext extends ParserRuleContext {
		public Tipobasico2Context tipobasico2() {
			return getRuleContext(Tipobasico2Context.class,0);
		}
		public TensorContext tensor() {
			return getRuleContext(TensorContext.class,0);
		}
		public TipobasicoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipobasico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterTipobasico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitTipobasico(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitTipobasico(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipobasicoContext tipobasico() throws RecognitionException {
		TipobasicoContext _localctx = new TipobasicoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_tipobasico);
		try {
			setState(143);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMERICO:
			case CADENA:
			case LOGICO:
			case REGISTRO:
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				tipobasico2();
				}
				break;
			case TENSOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				tensor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Tipobasico2Context extends ParserRuleContext {
		public Tipobasico3Context tipobasico3() {
			return getRuleContext(Tipobasico3Context.class,0);
		}
		public RegistroContext registro() {
			return getRuleContext(RegistroContext.class,0);
		}
		public Tipobasico2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipobasico2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterTipobasico2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitTipobasico2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitTipobasico2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipobasico2Context tipobasico2() throws RecognitionException {
		Tipobasico2Context _localctx = new Tipobasico2Context(_ctx, getState());
		enterRule(_localctx, 30, RULE_tipobasico2);
		try {
			setState(147);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMERICO:
			case CADENA:
			case LOGICO:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				tipobasico3();
				}
				break;
			case REGISTRO:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				registro();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Tipobasico3Context extends ParserRuleContext {
		public TerminalNode NUMERICO() { return getToken(SLParser.NUMERICO, 0); }
		public TerminalNode CADENA() { return getToken(SLParser.CADENA, 0); }
		public TerminalNode LOGICO() { return getToken(SLParser.LOGICO, 0); }
		public Tipobasico3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipobasico3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterTipobasico3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitTipobasico3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitTipobasico3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipobasico3Context tipobasico3() throws RecognitionException {
		Tipobasico3Context _localctx = new Tipobasico3Context(_ctx, getState());
		enterRule(_localctx, 32, RULE_tipobasico3);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMERICO) | (1L << CADENA) | (1L << LOGICO))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TensorContext extends ParserRuleContext {
		public TerminalNode TENSOR() { return getToken(SLParser.TENSOR, 0); }
		public TensorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tensor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterTensor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitTensor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitTensor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TensorContext tensor() throws RecognitionException {
		TensorContext _localctx = new TensorContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_tensor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(TENSOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RegistroContext extends ParserRuleContext {
		public TerminalNode REGISTRO() { return getToken(SLParser.REGISTRO, 0); }
		public RegistroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_registro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterRegistro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitRegistro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitRegistro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegistroContext registro() throws RecognitionException {
		RegistroContext _localctx = new RegistroContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_registro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(REGISTRO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubrutinasContext extends ParserRuleContext {
		public List<SubrutinaContext> subrutina() {
			return getRuleContexts(SubrutinaContext.class);
		}
		public SubrutinaContext subrutina(int i) {
			return getRuleContext(SubrutinaContext.class,i);
		}
		public SubrutinasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subrutinas; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterSubrutinas(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitSubrutinas(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitSubrutinas(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubrutinasContext subrutinas() throws RecognitionException {
		SubrutinasContext _localctx = new SubrutinasContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_subrutinas);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SUBRUTINA) {
				{
				{
				setState(155);
				subrutina();
				}
				}
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubrutinaContext extends ParserRuleContext {
		public Token nombre_subrutina;
		public TerminalNode SUBRUTINA() { return getToken(SLParser.SUBRUTINA, 0); }
		public TerminalNode LEFT_PAR() { return getToken(SLParser.LEFT_PAR, 0); }
		public TerminalNode RIGHT_PAR() { return getToken(SLParser.RIGHT_PAR, 0); }
		public ProcedimientoContext procedimiento() {
			return getRuleContext(ProcedimientoContext.class,0);
		}
		public FuncionContext funcion() {
			return getRuleContext(FuncionContext.class,0);
		}
		public TerminalNode ID() { return getToken(SLParser.ID, 0); }
		public ParametrosformalesContext parametrosformales() {
			return getRuleContext(ParametrosformalesContext.class,0);
		}
		public SubrutinaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subrutina; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterSubrutina(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitSubrutina(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitSubrutina(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubrutinaContext subrutina() throws RecognitionException {
		SubrutinaContext _localctx = new SubrutinaContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_subrutina);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(161);
			match(SUBRUTINA);
			setState(162);
			((SubrutinaContext)_localctx).nombre_subrutina = match(ID);
			setState(163);
			match(LEFT_PAR);
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==REF || _la==ID) {
				{
				setState(164);
				parametrosformales();
				}
			}

			setState(167);
			match(RIGHT_PAR);
			}
			setState(171);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
			case TIPOS:
			case VAR:
			case INICIO:
				{
				setState(169);
				procedimiento();
				}
				break;
			case RETORNA:
				{
				setState(170);
				funcion();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProcedimientoContext extends ParserRuleContext {
		public TerminalNode INICIO() { return getToken(SLParser.INICIO, 0); }
		public TerminalNode FIN() { return getToken(SLParser.FIN, 0); }
		public DeclaracionesContext declaraciones() {
			return getRuleContext(DeclaracionesContext.class,0);
		}
		public SentenciasContext sentencias() {
			return getRuleContext(SentenciasContext.class,0);
		}
		public ProcedimientoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedimiento; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterProcedimiento(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitProcedimiento(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitProcedimiento(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedimientoContext procedimiento() throws RecognitionException {
		ProcedimientoContext _localctx = new ProcedimientoContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_procedimiento);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONST) | (1L << TIPOS) | (1L << VAR))) != 0)) {
				{
				setState(173);
				declaraciones();
				}
			}

			setState(176);
			match(INICIO);
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SENTENCIA || _la==ID) {
				{
				setState(177);
				sentencias();
				}
			}

			setState(180);
			match(FIN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncionContext extends ParserRuleContext {
		public List<TerminalNode> RETORNA() { return getTokens(SLParser.RETORNA); }
		public TerminalNode RETORNA(int i) {
			return getToken(SLParser.RETORNA, i);
		}
		public TiporetContext tiporet() {
			return getRuleContext(TiporetContext.class,0);
		}
		public TerminalNode INICIO() { return getToken(SLParser.INICIO, 0); }
		public TerminalNode LEFT_PAR() { return getToken(SLParser.LEFT_PAR, 0); }
		public RetContext ret() {
			return getRuleContext(RetContext.class,0);
		}
		public TerminalNode RIGHT_PAR() { return getToken(SLParser.RIGHT_PAR, 0); }
		public TerminalNode FIN() { return getToken(SLParser.FIN, 0); }
		public DeclaracionesContext declaraciones() {
			return getRuleContext(DeclaracionesContext.class,0);
		}
		public SentenciasContext sentencias() {
			return getRuleContext(SentenciasContext.class,0);
		}
		public FuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterFuncion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitFuncion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitFuncion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncionContext funcion() throws RecognitionException {
		FuncionContext _localctx = new FuncionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_funcion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(RETORNA);
			setState(183);
			tiporet();
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONST) | (1L << TIPOS) | (1L << VAR))) != 0)) {
				{
				setState(184);
				declaraciones();
				}
			}

			setState(187);
			match(INICIO);
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SENTENCIA || _la==ID) {
				{
				setState(188);
				sentencias();
				}
			}

			setState(191);
			match(RETORNA);
			setState(192);
			match(LEFT_PAR);
			setState(193);
			ret();
			setState(194);
			match(RIGHT_PAR);
			setState(195);
			match(FIN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TiporetContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SLParser.ID, 0); }
		public TipobasicoContext tipobasico() {
			return getRuleContext(TipobasicoContext.class,0);
		}
		public TiporetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tiporet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterTiporet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitTiporet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitTiporet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TiporetContext tiporet() throws RecognitionException {
		TiporetContext _localctx = new TiporetContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_tiporet);
		try {
			setState(199);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				match(ID);
				}
				break;
			case NUMERICO:
			case CADENA:
			case LOGICO:
			case REGISTRO:
			case TENSOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				tipobasico();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RetContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SLParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ret; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterRet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitRet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitRet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetContext ret() throws RecognitionException {
		RetContext _localctx = new RetContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_ret);
		try {
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(201);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
				expr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<TerminalNode> NUMERICO_LITERAL() { return getTokens(SLParser.NUMERICO_LITERAL); }
		public TerminalNode NUMERICO_LITERAL(int i) {
			return getToken(SLParser.NUMERICO_LITERAL, i);
		}
		public TerminalNode PLUS() { return getToken(SLParser.PLUS, 0); }
		public TerminalNode ID() { return getToken(SLParser.ID, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_expr);
		try {
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				match(NUMERICO_LITERAL);
				setState(206);
				match(PLUS);
				setState(207);
				match(NUMERICO_LITERAL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(208);
				match(NUMERICO_LITERAL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(209);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametrosformalesContext extends ParserRuleContext {
		public List<ParametroformalContext> parametroformal() {
			return getRuleContexts(ParametroformalContext.class);
		}
		public ParametroformalContext parametroformal(int i) {
			return getRuleContext(ParametroformalContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(SLParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(SLParser.SEMI, i);
		}
		public ParametrosformalesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametrosformales; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterParametrosformales(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitParametrosformales(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitParametrosformales(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametrosformalesContext parametrosformales() throws RecognitionException {
		ParametrosformalesContext _localctx = new ParametrosformalesContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_parametrosformales);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			parametroformal();
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMI) {
				{
				{
				setState(213);
				match(SEMI);
				setState(214);
				parametroformal();
				}
				}
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametroformalContext extends ParserRuleContext {
		public ListaidContext listaid() {
			return getRuleContext(ListaidContext.class,0);
		}
		public TerminalNode DOUBLE_POINT() { return getToken(SLParser.DOUBLE_POINT, 0); }
		public TerminalNode ID() { return getToken(SLParser.ID, 0); }
		public TipobasicoContext tipobasico() {
			return getRuleContext(TipobasicoContext.class,0);
		}
		public TerminalNode REF() { return getToken(SLParser.REF, 0); }
		public ParametroformalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametroformal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterParametroformal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitParametroformal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitParametroformal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametroformalContext parametroformal() throws RecognitionException {
		ParametroformalContext _localctx = new ParametroformalContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_parametroformal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==REF) {
				{
				setState(220);
				match(REF);
				}
			}

			setState(223);
			listaid();
			setState(224);
			match(DOUBLE_POINT);
			setState(227);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(225);
				match(ID);
				}
				break;
			case NUMERICO:
			case CADENA:
			case LOGICO:
			case REGISTRO:
			case TENSOR:
				{
				setState(226);
				tipobasico();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciasContext extends ParserRuleContext {
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public SentenciasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterSentencias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitSentencias(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitSentencias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciasContext sentencias() throws RecognitionException {
		SentenciasContext _localctx = new SentenciasContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_sentencias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(229);
				sentencia();
				}
				}
				setState(232); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SENTENCIA || _la==ID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaContext extends ParserRuleContext {
		public TerminalNode SENTENCIA() { return getToken(SLParser.SENTENCIA, 0); }
		public LlamadosubContext llamadosub() {
			return getRuleContext(LlamadosubContext.class,0);
		}
		public SentenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterSentencia(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitSentencia(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitSentencia(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_sentencia);
		try {
			setState(236);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SENTENCIA:
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				match(SENTENCIA);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(235);
				llamadosub();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LlamadosubContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SLParser.ID, 0); }
		public TerminalNode LEFT_PAR() { return getToken(SLParser.LEFT_PAR, 0); }
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public TerminalNode RIGHT_PAR() { return getToken(SLParser.RIGHT_PAR, 0); }
		public LlamadosubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_llamadosub; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterLlamadosub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitLlamadosub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitLlamadosub(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LlamadosubContext llamadosub() throws RecognitionException {
		LlamadosubContext _localctx = new LlamadosubContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_llamadosub);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(ID);
			setState(239);
			match(LEFT_PAR);
			setState(240);
			parametros();
			setState(241);
			match(RIGHT_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametrosContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SLParser.COMMA, i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterParametros(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitParametros(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitParametros(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			expr();
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(244);
				match(COMMA);
				setState(245);
				expr();
				}
				}
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\60\u00fe\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\2\3\2\3\3\3\3\5\3I\n\3\3\3\5\3L\n\3\3\3\3\3\5\3P\n\3\3\3"+
		"\3\3\3\4\6\4U\n\4\r\4\16\4V\3\5\3\5\3\5\3\5\3\5\3\5\5\5_\n\5\3\6\6\6b"+
		"\n\6\r\6\16\6c\3\7\3\7\3\7\3\7\3\7\3\b\6\bl\n\b\r\b\16\bm\3\t\3\t\3\t"+
		"\3\t\3\t\3\n\6\nv\n\n\r\n\16\nw\3\13\3\13\3\13\3\13\3\13\3\f\3\f\5\f\u0081"+
		"\n\f\3\r\5\r\u0084\n\r\3\16\3\16\3\16\7\16\u0089\n\16\f\16\16\16\u008c"+
		"\13\16\3\17\3\17\3\20\3\20\5\20\u0092\n\20\3\21\3\21\5\21\u0096\n\21\3"+
		"\22\3\22\3\23\3\23\3\24\3\24\3\25\7\25\u009f\n\25\f\25\16\25\u00a2\13"+
		"\25\3\26\3\26\3\26\3\26\5\26\u00a8\n\26\3\26\3\26\3\26\3\26\5\26\u00ae"+
		"\n\26\3\27\5\27\u00b1\n\27\3\27\3\27\5\27\u00b5\n\27\3\27\3\27\3\30\3"+
		"\30\3\30\5\30\u00bc\n\30\3\30\3\30\5\30\u00c0\n\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\31\3\31\5\31\u00ca\n\31\3\32\3\32\5\32\u00ce\n\32\3\33\3"+
		"\33\3\33\3\33\3\33\5\33\u00d5\n\33\3\34\3\34\3\34\7\34\u00da\n\34\f\34"+
		"\16\34\u00dd\13\34\3\35\5\35\u00e0\n\35\3\35\3\35\3\35\3\35\5\35\u00e6"+
		"\n\35\3\36\6\36\u00e9\n\36\r\36\16\36\u00ea\3\37\3\37\5\37\u00ef\n\37"+
		"\3 \3 \3 \3 \3 \3!\3!\3!\7!\u00f9\n!\f!\16!\u00fc\13!\3!\2\2\"\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@\2\4\4\2\27\27"+
		"\34\35\3\2\13\r\2\u00fc\2B\3\2\2\2\4H\3\2\2\2\6T\3\2\2\2\b^\3\2\2\2\n"+
		"a\3\2\2\2\fe\3\2\2\2\16k\3\2\2\2\20o\3\2\2\2\22u\3\2\2\2\24y\3\2\2\2\26"+
		"\u0080\3\2\2\2\30\u0083\3\2\2\2\32\u0085\3\2\2\2\34\u008d\3\2\2\2\36\u0091"+
		"\3\2\2\2 \u0095\3\2\2\2\"\u0097\3\2\2\2$\u0099\3\2\2\2&\u009b\3\2\2\2"+
		"(\u00a0\3\2\2\2*\u00a3\3\2\2\2,\u00b0\3\2\2\2.\u00b8\3\2\2\2\60\u00c9"+
		"\3\2\2\2\62\u00cd\3\2\2\2\64\u00d4\3\2\2\2\66\u00d6\3\2\2\28\u00df\3\2"+
		"\2\2:\u00e8\3\2\2\2<\u00ee\3\2\2\2>\u00f0\3\2\2\2@\u00f5\3\2\2\2BC\5\4"+
		"\3\2CD\5(\25\2DE\7\2\2\3E\3\3\2\2\2FG\7\7\2\2GI\7\33\2\2HF\3\2\2\2HI\3"+
		"\2\2\2IK\3\2\2\2JL\5\6\4\2KJ\3\2\2\2KL\3\2\2\2LM\3\2\2\2MO\7\17\2\2NP"+
		"\5:\36\2ON\3\2\2\2OP\3\2\2\2PQ\3\2\2\2QR\7\21\2\2R\5\3\2\2\2SU\5\b\5\2"+
		"TS\3\2\2\2UV\3\2\2\2VT\3\2\2\2VW\3\2\2\2W\7\3\2\2\2XY\7\b\2\2Y_\5\n\6"+
		"\2Z[\7\t\2\2[_\5\16\b\2\\]\7\n\2\2]_\5\22\n\2^X\3\2\2\2^Z\3\2\2\2^\\\3"+
		"\2\2\2_\t\3\2\2\2`b\5\f\7\2a`\3\2\2\2bc\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\13"+
		"\3\2\2\2ef\7\33\2\2fg\7\'\2\2gh\5\34\17\2hi\5\30\r\2i\r\3\2\2\2jl\5\20"+
		"\t\2kj\3\2\2\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2n\17\3\2\2\2op\7\33\2\2pq"+
		"\7%\2\2qr\5\36\20\2rs\5\30\r\2s\21\3\2\2\2tv\5\24\13\2ut\3\2\2\2vw\3\2"+
		"\2\2wu\3\2\2\2wx\3\2\2\2x\23\3\2\2\2yz\5\32\16\2z{\7%\2\2{|\5\26\f\2|"+
		"}\5\30\r\2}\25\3\2\2\2~\u0081\7\33\2\2\177\u0081\5\36\20\2\u0080~\3\2"+
		"\2\2\u0080\177\3\2\2\2\u0081\27\3\2\2\2\u0082\u0084\7$\2\2\u0083\u0082"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084\31\3\2\2\2\u0085\u008a\7\33\2\2\u0086"+
		"\u0087\7)\2\2\u0087\u0089\7\33\2\2\u0088\u0086\3\2\2\2\u0089\u008c\3\2"+
		"\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\33\3\2\2\2\u008c\u008a"+
		"\3\2\2\2\u008d\u008e\t\2\2\2\u008e\35\3\2\2\2\u008f\u0092\5 \21\2\u0090"+
		"\u0092\5$\23\2\u0091\u008f\3\2\2\2\u0091\u0090\3\2\2\2\u0092\37\3\2\2"+
		"\2\u0093\u0096\5\"\22\2\u0094\u0096\5&\24\2\u0095\u0093\3\2\2\2\u0095"+
		"\u0094\3\2\2\2\u0096!\3\2\2\2\u0097\u0098\t\3\2\2\u0098#\3\2\2\2\u0099"+
		"\u009a\7\31\2\2\u009a%\3\2\2\2\u009b\u009c\7\30\2\2\u009c\'\3\2\2\2\u009d"+
		"\u009f\5*\26\2\u009e\u009d\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2"+
		"\2\2\u00a0\u00a1\3\2\2\2\u00a1)\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a4"+
		"\7\16\2\2\u00a4\u00a5\7\33\2\2\u00a5\u00a7\7*\2\2\u00a6\u00a8\5\66\34"+
		"\2\u00a7\u00a6\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa"+
		"\7+\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00ae\5,\27\2\u00ac\u00ae\5.\30\2\u00ad"+
		"\u00ab\3\2\2\2\u00ad\u00ac\3\2\2\2\u00ae+\3\2\2\2\u00af\u00b1\5\6\4\2"+
		"\u00b0\u00af\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b4"+
		"\7\17\2\2\u00b3\u00b5\5:\36\2\u00b4\u00b3\3\2\2\2\u00b4\u00b5\3\2\2\2"+
		"\u00b5\u00b6\3\2\2\2\u00b6\u00b7\7\21\2\2\u00b7-\3\2\2\2\u00b8\u00b9\7"+
		"\26\2\2\u00b9\u00bb\5\60\31\2\u00ba\u00bc\5\6\4\2\u00bb\u00ba\3\2\2\2"+
		"\u00bb\u00bc\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bf\7\17\2\2\u00be\u00c0"+
		"\5:\36\2\u00bf\u00be\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1"+
		"\u00c2\7\26\2\2\u00c2\u00c3\7*\2\2\u00c3\u00c4\5\62\32\2\u00c4\u00c5\7"+
		"+\2\2\u00c5\u00c6\7\21\2\2\u00c6/\3\2\2\2\u00c7\u00ca\7\33\2\2\u00c8\u00ca"+
		"\5\36\20\2\u00c9\u00c7\3\2\2\2\u00c9\u00c8\3\2\2\2\u00ca\61\3\2\2\2\u00cb"+
		"\u00ce\7\33\2\2\u00cc\u00ce\5\64\33\2\u00cd\u00cb\3\2\2\2\u00cd\u00cc"+
		"\3\2\2\2\u00ce\63\3\2\2\2\u00cf\u00d0\7\34\2\2\u00d0\u00d1\7\36\2\2\u00d1"+
		"\u00d5\7\34\2\2\u00d2\u00d5\7\34\2\2\u00d3\u00d5\7\33\2\2\u00d4\u00cf"+
		"\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\65\3\2\2\2\u00d6"+
		"\u00db\58\35\2\u00d7\u00d8\7$\2\2\u00d8\u00da\58\35\2\u00d9\u00d7\3\2"+
		"\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc"+
		"\67\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00e0\7\20\2\2\u00df\u00de\3\2\2"+
		"\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\5\32\16\2\u00e2"+
		"\u00e5\7%\2\2\u00e3\u00e6\7\33\2\2\u00e4\u00e6\5\36\20\2\u00e5\u00e3\3"+
		"\2\2\2\u00e5\u00e4\3\2\2\2\u00e69\3\2\2\2\u00e7\u00e9\5<\37\2\u00e8\u00e7"+
		"\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb"+
		";\3\2\2\2\u00ec\u00ef\7\32\2\2\u00ed\u00ef\5> \2\u00ee\u00ec\3\2\2\2\u00ee"+
		"\u00ed\3\2\2\2\u00ef=\3\2\2\2\u00f0\u00f1\7\33\2\2\u00f1\u00f2\7*\2\2"+
		"\u00f2\u00f3\5@!\2\u00f3\u00f4\7+\2\2\u00f4?\3\2\2\2\u00f5\u00fa\5\64"+
		"\33\2\u00f6\u00f7\7)\2\2\u00f7\u00f9\5\64\33\2\u00f8\u00f6\3\2\2\2\u00f9"+
		"\u00fc\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fbA\3\2\2\2"+
		"\u00fc\u00fa\3\2\2\2\37HKOV^cmw\u0080\u0083\u008a\u0091\u0095\u00a0\u00a7"+
		"\u00ad\u00b0\u00b4\u00bb\u00bf\u00c9\u00cd\u00d4\u00db\u00df\u00e5\u00ea"+
		"\u00ee\u00fa";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}