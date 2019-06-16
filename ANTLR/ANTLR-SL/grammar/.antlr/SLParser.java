// Generated from /home/fabiotovar/Proyectos/Lenguajes/ANTLR-SL/grammar/SLParser.g4 by ANTLR 4.7.1
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
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

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
	public static final int
		RULE_programa = 0, RULE_programaprc = 1, RULE_declaraciones = 2, RULE_consts = 3, 
		RULE_const_ = 4, RULE_tipos = 5, RULE_tipo = 6, RULE_vars = 7, RULE_var = 8, 
		RULE_explicitvar = 9, RULE_opt = 10, RULE_listaid = 11, RULE_literal = 12, 
		RULE_tipobasico = 13, RULE_tipobasico2 = 14, RULE_tipobasico3 = 15, RULE_tensor = 16, 
		RULE_registro = 17, RULE_subrutinas = 18, RULE_subrutina = 19, RULE_procedimiento = 20, 
		RULE_funcion = 21, RULE_parametros = 22, RULE_parametro = 23, RULE_sentencias = 24;
	public static final String[] ruleNames = {
		"programa", "programaprc", "declaraciones", "consts", "const_", "tipos", 
		"tipo", "vars", "var", "explicitvar", "opt", "listaid", "literal", "tipobasico", 
		"tipobasico2", "tipobasico3", "tensor", "registro", "subrutinas", "subrutina", 
		"procedimiento", "funcion", "parametros", "parametro", "sentencias"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, "'programa'", "'const'", "'tipos'", "'var'", 
		"'numerico'", "'cadena'", "'logico'", "'subrutina'", "'inicio'", "'ref'", 
		"'fin'", "'if'", "'then'", "'else'", "'endif'", "'retorna'", null, "'registro'", 
		"'tensor'", "'sentencias'", null, null, null, "'+'", "'-'", "'*'", "'/'", 
		"'^'", "'%'", "';'", "':'", null, "'='", "'.'", "','", "'('", "')'", "'{'", 
		"'}'", "'['", "']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WHITESPACE", "COMMENT", "BLOCK_COMMENT", "NEW_LINE", "PROGRAMA", 
		"CONST", "TIPOS", "VAR", "NUMERICO", "CADENA", "LOGICO", "SUBRUTINA", 
		"INICIO", "REF", "FIN", "IF", "THEN", "ELSE", "ENDIF", "RETORNA", "LOGICO_LITERAL", 
		"REGISTRO", "TENSOR", "SENTENCIAS", "ID", "NUMERICO_LITERAL", "CADENA_LITERAL", 
		"PLUS", "MINUS", "ASTERISK", "DIVISION", "POWER", "MOD", "SEMI", "DOUBLE_POINT", 
		"BOOL_OP", "ASSIGN", "POINT", "COMMA", "LEFT_PAR", "RIGHT_PAR", "LEFT_BRACE", 
		"RIGHT_BRACE", "LEFT_BRACKET", "RIGHT_BRACET", "ANY"
	};
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
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			programaprc();
			setState(51);
			subrutinas();
			setState(52);
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
	}

	public final ProgramaprcContext programaprc() throws RecognitionException {
		ProgramaprcContext _localctx = new ProgramaprcContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_programaprc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PROGRAMA) {
				{
				setState(54);
				match(PROGRAMA);
				setState(55);
				match(ID);
				}
			}

			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONST) | (1L << TIPOS) | (1L << VAR))) != 0)) {
				{
				setState(58);
				declaraciones();
				}
			}

			setState(61);
			match(INICIO);
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SENTENCIAS) {
				{
				setState(62);
				sentencias();
				}
			}

			setState(65);
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
		public List<TerminalNode> CONST() { return getTokens(SLParser.CONST); }
		public TerminalNode CONST(int i) {
			return getToken(SLParser.CONST, i);
		}
		public List<ConstsContext> consts() {
			return getRuleContexts(ConstsContext.class);
		}
		public ConstsContext consts(int i) {
			return getRuleContext(ConstsContext.class,i);
		}
		public List<TerminalNode> TIPOS() { return getTokens(SLParser.TIPOS); }
		public TerminalNode TIPOS(int i) {
			return getToken(SLParser.TIPOS, i);
		}
		public List<TiposContext> tipos() {
			return getRuleContexts(TiposContext.class);
		}
		public TiposContext tipos(int i) {
			return getRuleContext(TiposContext.class,i);
		}
		public List<TerminalNode> VAR() { return getTokens(SLParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(SLParser.VAR, i);
		}
		public List<VarsContext> vars() {
			return getRuleContexts(VarsContext.class);
		}
		public VarsContext vars(int i) {
			return getRuleContext(VarsContext.class,i);
		}
		public DeclaracionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaraciones; }
	}

	public final DeclaracionesContext declaraciones() throws RecognitionException {
		DeclaracionesContext _localctx = new DeclaracionesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaraciones);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(73);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CONST:
					{
					{
					setState(67);
					match(CONST);
					setState(68);
					consts();
					}
					}
					break;
				case TIPOS:
					{
					{
					setState(69);
					match(TIPOS);
					setState(70);
					tipos();
					}
					}
					break;
				case VAR:
					{
					{
					setState(71);
					match(VAR);
					setState(72);
					vars();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(75); 
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
	}

	public final ConstsContext consts() throws RecognitionException {
		ConstsContext _localctx = new ConstsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_consts);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(77);
				const_();
				}
				}
				setState(80); 
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
	}

	public final Const_Context const_() throws RecognitionException {
		Const_Context _localctx = new Const_Context(_ctx, getState());
		enterRule(_localctx, 8, RULE_const_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(ID);
			setState(83);
			match(ASSIGN);
			setState(84);
			literal();
			setState(85);
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
	}

	public final TiposContext tipos() throws RecognitionException {
		TiposContext _localctx = new TiposContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tipos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(87);
				tipo();
				}
				}
				setState(90); 
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
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_tipo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(ID);
			setState(93);
			match(DOUBLE_POINT);
			setState(94);
			tipobasico();
			setState(95);
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
	}

	public final VarsContext vars() throws RecognitionException {
		VarsContext _localctx = new VarsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_vars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(97);
				var();
				}
				}
				setState(100); 
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
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			listaid();
			setState(103);
			match(DOUBLE_POINT);
			setState(104);
			explicitvar();
			setState(105);
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
	}

	public final ExplicitvarContext explicitvar() throws RecognitionException {
		ExplicitvarContext _localctx = new ExplicitvarContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_explicitvar);
		try {
			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
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
				setState(108);
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
	}

	public final OptContext opt() throws RecognitionException {
		OptContext _localctx = new OptContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_opt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(111);
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
	}

	public final ListaidContext listaid() throws RecognitionException {
		ListaidContext _localctx = new ListaidContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_listaid);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(ID);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(115);
				match(COMMA);
				setState(116);
				match(ID);
				}
				}
				setState(121);
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
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
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
	}

	public final TipobasicoContext tipobasico() throws RecognitionException {
		TipobasicoContext _localctx = new TipobasicoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_tipobasico);
		try {
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMERICO:
			case CADENA:
			case LOGICO:
			case REGISTRO:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				tipobasico2();
				}
				break;
			case TENSOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
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
	}

	public final Tipobasico2Context tipobasico2() throws RecognitionException {
		Tipobasico2Context _localctx = new Tipobasico2Context(_ctx, getState());
		enterRule(_localctx, 28, RULE_tipobasico2);
		try {
			setState(130);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMERICO:
			case CADENA:
			case LOGICO:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				tipobasico3();
				}
				break;
			case REGISTRO:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
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
	}

	public final Tipobasico3Context tipobasico3() throws RecognitionException {
		Tipobasico3Context _localctx = new Tipobasico3Context(_ctx, getState());
		enterRule(_localctx, 30, RULE_tipobasico3);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
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
	}

	public final TensorContext tensor() throws RecognitionException {
		TensorContext _localctx = new TensorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_tensor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
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
	}

	public final RegistroContext registro() throws RecognitionException {
		RegistroContext _localctx = new RegistroContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_registro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
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
	}

	public final SubrutinasContext subrutinas() throws RecognitionException {
		SubrutinasContext _localctx = new SubrutinasContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_subrutinas);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SUBRUTINA) {
				{
				{
				setState(138);
				subrutina();
				}
				}
				setState(143);
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
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public SubrutinaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subrutina; }
	}

	public final SubrutinaContext subrutina() throws RecognitionException {
		SubrutinaContext _localctx = new SubrutinaContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_subrutina);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(144);
			match(SUBRUTINA);
			setState(145);
			((SubrutinaContext)_localctx).nombre_subrutina = match(ID);
			setState(146);
			match(LEFT_PAR);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==REF || _la==ID) {
				{
				setState(147);
				parametros();
				}
			}

			setState(150);
			match(RIGHT_PAR);
			}
			setState(154);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
			case TIPOS:
			case VAR:
				{
				setState(152);
				procedimiento();
				}
				break;
			case RETORNA:
				{
				setState(153);
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
		public DeclaracionesContext declaraciones() {
			return getRuleContext(DeclaracionesContext.class,0);
		}
		public TerminalNode INICIO() { return getToken(SLParser.INICIO, 0); }
		public TerminalNode FIN() { return getToken(SLParser.FIN, 0); }
		public SentenciasContext sentencias() {
			return getRuleContext(SentenciasContext.class,0);
		}
		public ProcedimientoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedimiento; }
	}

	public final ProcedimientoContext procedimiento() throws RecognitionException {
		ProcedimientoContext _localctx = new ProcedimientoContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_procedimiento);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			declaraciones();
			setState(157);
			match(INICIO);
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SENTENCIAS) {
				{
				setState(158);
				sentencias();
				}
			}

			setState(161);
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
		public TerminalNode INICIO() { return getToken(SLParser.INICIO, 0); }
		public TerminalNode LEFT_PAR() { return getToken(SLParser.LEFT_PAR, 0); }
		public List<TerminalNode> ID() { return getTokens(SLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SLParser.ID, i);
		}
		public TerminalNode RIGHT_PAR() { return getToken(SLParser.RIGHT_PAR, 0); }
		public TerminalNode FIN() { return getToken(SLParser.FIN, 0); }
		public TipobasicoContext tipobasico() {
			return getRuleContext(TipobasicoContext.class,0);
		}
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
	}

	public final FuncionContext funcion() throws RecognitionException {
		FuncionContext _localctx = new FuncionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_funcion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(RETORNA);
			setState(166);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(164);
				match(ID);
				}
				break;
			case NUMERICO:
			case CADENA:
			case LOGICO:
			case REGISTRO:
			case TENSOR:
				{
				setState(165);
				tipobasico();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONST) | (1L << TIPOS) | (1L << VAR))) != 0)) {
				{
				setState(168);
				declaraciones();
				}
			}

			setState(171);
			match(INICIO);
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SENTENCIAS) {
				{
				setState(172);
				sentencias();
				}
			}

			setState(175);
			match(RETORNA);
			setState(176);
			match(LEFT_PAR);
			setState(177);
			match(ID);
			setState(178);
			match(RIGHT_PAR);
			setState(179);
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

	public static class ParametrosContext extends ParserRuleContext {
		public ParametroContext parametro() {
			return getRuleContext(ParametroContext.class,0);
		}
		public List<TerminalNode> SEMI() { return getTokens(SLParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(SLParser.SEMI, i);
		}
		public List<ParametrosContext> parametros() {
			return getRuleContexts(ParametrosContext.class);
		}
		public ParametrosContext parametros(int i) {
			return getRuleContext(ParametrosContext.class,i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_parametros);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			parametro();
			setState(186);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(182);
					match(SEMI);
					setState(183);
					parametros();
					}
					} 
				}
				setState(188);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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

	public static class ParametroContext extends ParserRuleContext {
		public ListaidContext listaid() {
			return getRuleContext(ListaidContext.class,0);
		}
		public TerminalNode DOUBLE_POINT() { return getToken(SLParser.DOUBLE_POINT, 0); }
		public TerminalNode ID() { return getToken(SLParser.ID, 0); }
		public TipobasicoContext tipobasico() {
			return getRuleContext(TipobasicoContext.class,0);
		}
		public TerminalNode REF() { return getToken(SLParser.REF, 0); }
		public ParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametro; }
	}

	public final ParametroContext parametro() throws RecognitionException {
		ParametroContext _localctx = new ParametroContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_parametro);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==REF) {
				{
				setState(189);
				match(REF);
				}
			}

			setState(192);
			listaid();
			setState(193);
			match(DOUBLE_POINT);
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(194);
				match(ID);
				}
				break;
			case NUMERICO:
			case CADENA:
			case LOGICO:
			case REGISTRO:
			case TENSOR:
				{
				setState(195);
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
		public TerminalNode SENTENCIAS() { return getToken(SLParser.SENTENCIAS, 0); }
		public SentenciasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencias; }
	}

	public final SentenciasContext sentencias() throws RecognitionException {
		SentenciasContext _localctx = new SentenciasContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_sentencias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(SENTENCIAS);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\60\u00cb\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\2\3\2\3\3\3\3\5\3;\n\3\3\3\5\3>\n\3\3\3\3\3\5\3B"+
		"\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\6\4L\n\4\r\4\16\4M\3\5\6\5Q\n\5\r"+
		"\5\16\5R\3\6\3\6\3\6\3\6\3\6\3\7\6\7[\n\7\r\7\16\7\\\3\b\3\b\3\b\3\b\3"+
		"\b\3\t\6\te\n\t\r\t\16\tf\3\n\3\n\3\n\3\n\3\n\3\13\3\13\5\13p\n\13\3\f"+
		"\5\fs\n\f\3\r\3\r\3\r\7\rx\n\r\f\r\16\r{\13\r\3\16\3\16\3\17\3\17\5\17"+
		"\u0081\n\17\3\20\3\20\5\20\u0085\n\20\3\21\3\21\3\22\3\22\3\23\3\23\3"+
		"\24\7\24\u008e\n\24\f\24\16\24\u0091\13\24\3\25\3\25\3\25\3\25\5\25\u0097"+
		"\n\25\3\25\3\25\3\25\3\25\5\25\u009d\n\25\3\26\3\26\3\26\5\26\u00a2\n"+
		"\26\3\26\3\26\3\27\3\27\3\27\5\27\u00a9\n\27\3\27\5\27\u00ac\n\27\3\27"+
		"\3\27\5\27\u00b0\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\7\30"+
		"\u00bb\n\30\f\30\16\30\u00be\13\30\3\31\5\31\u00c1\n\31\3\31\3\31\3\31"+
		"\3\31\5\31\u00c7\n\31\3\32\3\32\3\32\2\2\33\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\2\4\4\2\27\27\34\35\3\2\13\r\2\u00c9\2\64"+
		"\3\2\2\2\4:\3\2\2\2\6K\3\2\2\2\bP\3\2\2\2\nT\3\2\2\2\fZ\3\2\2\2\16^\3"+
		"\2\2\2\20d\3\2\2\2\22h\3\2\2\2\24o\3\2\2\2\26r\3\2\2\2\30t\3\2\2\2\32"+
		"|\3\2\2\2\34\u0080\3\2\2\2\36\u0084\3\2\2\2 \u0086\3\2\2\2\"\u0088\3\2"+
		"\2\2$\u008a\3\2\2\2&\u008f\3\2\2\2(\u0092\3\2\2\2*\u009e\3\2\2\2,\u00a5"+
		"\3\2\2\2.\u00b7\3\2\2\2\60\u00c0\3\2\2\2\62\u00c8\3\2\2\2\64\65\5\4\3"+
		"\2\65\66\5&\24\2\66\67\7\2\2\3\67\3\3\2\2\289\7\7\2\29;\7\33\2\2:8\3\2"+
		"\2\2:;\3\2\2\2;=\3\2\2\2<>\5\6\4\2=<\3\2\2\2=>\3\2\2\2>?\3\2\2\2?A\7\17"+
		"\2\2@B\5\62\32\2A@\3\2\2\2AB\3\2\2\2BC\3\2\2\2CD\7\21\2\2D\5\3\2\2\2E"+
		"F\7\b\2\2FL\5\b\5\2GH\7\t\2\2HL\5\f\7\2IJ\7\n\2\2JL\5\20\t\2KE\3\2\2\2"+
		"KG\3\2\2\2KI\3\2\2\2LM\3\2\2\2MK\3\2\2\2MN\3\2\2\2N\7\3\2\2\2OQ\5\n\6"+
		"\2PO\3\2\2\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\t\3\2\2\2TU\7\33\2\2UV\7\'"+
		"\2\2VW\5\32\16\2WX\5\26\f\2X\13\3\2\2\2Y[\5\16\b\2ZY\3\2\2\2[\\\3\2\2"+
		"\2\\Z\3\2\2\2\\]\3\2\2\2]\r\3\2\2\2^_\7\33\2\2_`\7%\2\2`a\5\34\17\2ab"+
		"\5\26\f\2b\17\3\2\2\2ce\5\22\n\2dc\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2\2"+
		"\2g\21\3\2\2\2hi\5\30\r\2ij\7%\2\2jk\5\24\13\2kl\5\26\f\2l\23\3\2\2\2"+
		"mp\7\33\2\2np\5\34\17\2om\3\2\2\2on\3\2\2\2p\25\3\2\2\2qs\7$\2\2rq\3\2"+
		"\2\2rs\3\2\2\2s\27\3\2\2\2ty\7\33\2\2uv\7)\2\2vx\7\33\2\2wu\3\2\2\2x{"+
		"\3\2\2\2yw\3\2\2\2yz\3\2\2\2z\31\3\2\2\2{y\3\2\2\2|}\t\2\2\2}\33\3\2\2"+
		"\2~\u0081\5\36\20\2\177\u0081\5\"\22\2\u0080~\3\2\2\2\u0080\177\3\2\2"+
		"\2\u0081\35\3\2\2\2\u0082\u0085\5 \21\2\u0083\u0085\5$\23\2\u0084\u0082"+
		"\3\2\2\2\u0084\u0083\3\2\2\2\u0085\37\3\2\2\2\u0086\u0087\t\3\2\2\u0087"+
		"!\3\2\2\2\u0088\u0089\7\31\2\2\u0089#\3\2\2\2\u008a\u008b\7\30\2\2\u008b"+
		"%\3\2\2\2\u008c\u008e\5(\25\2\u008d\u008c\3\2\2\2\u008e\u0091\3\2\2\2"+
		"\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\'\3\2\2\2\u0091\u008f\3"+
		"\2\2\2\u0092\u0093\7\16\2\2\u0093\u0094\7\33\2\2\u0094\u0096\7*\2\2\u0095"+
		"\u0097\5.\30\2\u0096\u0095\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\3\2"+
		"\2\2\u0098\u0099\7+\2\2\u0099\u009c\3\2\2\2\u009a\u009d\5*\26\2\u009b"+
		"\u009d\5,\27\2\u009c\u009a\3\2\2\2\u009c\u009b\3\2\2\2\u009d)\3\2\2\2"+
		"\u009e\u009f\5\6\4\2\u009f\u00a1\7\17\2\2\u00a0\u00a2\5\62\32\2\u00a1"+
		"\u00a0\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\7\21"+
		"\2\2\u00a4+\3\2\2\2\u00a5\u00a8\7\26\2\2\u00a6\u00a9\7\33\2\2\u00a7\u00a9"+
		"\5\34\17\2\u00a8\u00a6\3\2\2\2\u00a8\u00a7\3\2\2\2\u00a9\u00ab\3\2\2\2"+
		"\u00aa\u00ac\5\6\4\2\u00ab\u00aa\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad"+
		"\3\2\2\2\u00ad\u00af\7\17\2\2\u00ae\u00b0\5\62\32\2\u00af\u00ae\3\2\2"+
		"\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\7\26\2\2\u00b2"+
		"\u00b3\7*\2\2\u00b3\u00b4\7\33\2\2\u00b4\u00b5\7+\2\2\u00b5\u00b6\7\21"+
		"\2\2\u00b6-\3\2\2\2\u00b7\u00bc\5\60\31\2\u00b8\u00b9\7$\2\2\u00b9\u00bb"+
		"\5.\30\2\u00ba\u00b8\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc"+
		"\u00bd\3\2\2\2\u00bd/\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c1\7\20\2\2"+
		"\u00c0\u00bf\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3"+
		"\5\30\r\2\u00c3\u00c6\7%\2\2\u00c4\u00c7\7\33\2\2\u00c5\u00c7\5\34\17"+
		"\2\u00c6\u00c4\3\2\2\2\u00c6\u00c5\3\2\2\2\u00c7\61\3\2\2\2\u00c8\u00c9"+
		"\7\32\2\2\u00c9\63\3\2\2\2\31:=AKMR\\fory\u0080\u0084\u008f\u0096\u009c"+
		"\u00a1\u00a8\u00ab\u00af\u00bc\u00c0\u00c6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}