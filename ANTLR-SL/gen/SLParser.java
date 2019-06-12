// Generated from /data/Lenguajes/ANTLR-SL/grammar/SLParser.g4 by ANTLR 4.7.2
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
		PLUS=1, MINUS=2, ASTERISK=3, DIVISION=4, POWER=5, MOD=6, SEMICOLON=7, 
		DOUBLE_POINT=8, LESS=9, LESS_EQUAL=10, GREATER=11, GREATER_EQUAL=12, EQUAL=13, 
		NOT_EQUAL=14, ASSIGN=15, POINT=16, COMMA=17, LEFT_PAR=18, RIGHT_PAR=19, 
		LEFT_BRACE=20, RIGHT_BRACE=21, LEFT_BRACKET=22, RIGHT_BRACET=23, IF=24, 
		THEN=25, ELSE=26, ENDIF=27, ROP=28, CONST=29, TIPOS=30, VAR=31, ID=32, 
		NUMERICO_LITERAL=33, SEQ_ESCAPE=34, CADENA_LITERAL=35, LOGICO_LITERAL=36, 
		NUMERICO=37, CADENA=38, LOGICO=39;
	public static final int
		RULE_programa = 0, RULE_programaprc = 1, RULE_declaraciones = 2, RULE_consts = 3, 
		RULE_const_ = 4, RULE_tipos = 5, RULE_tipo = 6, RULE_vars = 7, RULE_var = 8, 
		RULE_explicitvar = 9, RULE_opt = 10, RULE_nombre = 11, RULE_listaid = 12, 
		RULE_listaid2 = 13, RULE_literal = 14, RULE_tipobasico = 15, RULE_tipobasico2 = 16, 
		RULE_tipobasico3 = 17, RULE_tensor = 18, RULE_registro = 19, RULE_subrutinas = 20, 
		RULE_sentencias = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "programaprc", "declaraciones", "consts", "const_", "tipos", 
			"tipo", "vars", "var", "explicitvar", "opt", "nombre", "listaid", "listaid2", 
			"literal", "tipobasico", "tipobasico2", "tipobasico3", "tensor", "registro", 
			"subrutinas", "sentencias"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'^'", "'%'", "';'", "':'", "'<'", 
			"'<='", "'>'", "'>='", "'=='", "'<>'", "'='", "'.'", "','", "'('", "')'", 
			"'{'", "'}'", "'['", "']'", "'if'", "'then'", "'else'", "'endif'", null, 
			"'const'", "'tipos'", "'var'", null, null, null, null, null, "'numerico'", 
			"'cadena'", "'logico'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PLUS", "MINUS", "ASTERISK", "DIVISION", "POWER", "MOD", "SEMICOLON", 
			"DOUBLE_POINT", "LESS", "LESS_EQUAL", "GREATER", "GREATER_EQUAL", "EQUAL", 
			"NOT_EQUAL", "ASSIGN", "POINT", "COMMA", "LEFT_PAR", "RIGHT_PAR", "LEFT_BRACE", 
			"RIGHT_BRACE", "LEFT_BRACKET", "RIGHT_BRACET", "IF", "THEN", "ELSE", 
			"ENDIF", "ROP", "CONST", "TIPOS", "VAR", "ID", "NUMERICO_LITERAL", "SEQ_ESCAPE", 
			"CADENA_LITERAL", "LOGICO_LITERAL", "NUMERICO", "CADENA", "LOGICO"
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
			setState(44);
			programaprc();
			setState(45);
			subrutinas();
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
		public NombreContext nombre() {
			return getRuleContext(NombreContext.class,0);
		}
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			nombre();
			setState(48);
			declaraciones();
			setState(49);
			sentencias();
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
		public TerminalNode CONST() { return getToken(SLParser.CONST, 0); }
		public Const_Context const_() {
			return getRuleContext(Const_Context.class,0);
		}
		public ConstsContext consts() {
			return getRuleContext(ConstsContext.class,0);
		}
		public DeclaracionesContext declaraciones() {
			return getRuleContext(DeclaracionesContext.class,0);
		}
		public TerminalNode TIPOS() { return getToken(SLParser.TIPOS, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TiposContext tipos() {
			return getRuleContext(TiposContext.class,0);
		}
		public TerminalNode VAR() { return getToken(SLParser.VAR, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public VarsContext vars() {
			return getRuleContext(VarsContext.class,0);
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
		try {
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				match(CONST);
				setState(53);
				const_();
				setState(54);
				consts();
				setState(55);
				declaraciones();
				}
				break;
			case TIPOS:
				enterOuterAlt(_localctx, 3);
				{
				setState(57);
				match(TIPOS);
				setState(58);
				tipo();
				setState(59);
				tipos();
				setState(60);
				declaraciones();
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(62);
				match(VAR);
				setState(63);
				var();
				setState(64);
				vars();
				setState(65);
				declaraciones();
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
		public Const_Context const_() {
			return getRuleContext(Const_Context.class,0);
		}
		public ConstsContext consts() {
			return getRuleContext(ConstsContext.class,0);
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
		enterRule(_localctx, 6, RULE_consts);
		try {
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case CONST:
			case TIPOS:
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				const_();
				setState(71);
				consts();
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
		enterRule(_localctx, 8, RULE_const_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(ID);
			setState(76);
			match(ASSIGN);
			setState(77);
			literal();
			setState(78);
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
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TiposContext tipos() {
			return getRuleContext(TiposContext.class,0);
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
		enterRule(_localctx, 10, RULE_tipos);
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case CONST:
			case TIPOS:
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				tipo();
				setState(82);
				tipos();
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
		enterRule(_localctx, 12, RULE_tipo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(ID);
			setState(87);
			match(DOUBLE_POINT);
			setState(88);
			tipobasico();
			setState(89);
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
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public VarsContext vars() {
			return getRuleContext(VarsContext.class,0);
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
		enterRule(_localctx, 14, RULE_vars);
		try {
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case CONST:
			case TIPOS:
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				var();
				setState(93);
				vars();
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

	public static class VarContext extends ParserRuleContext {
		public ListaidContext listaid() {
			return getRuleContext(ListaidContext.class,0);
		}
		public TerminalNode DOUBLE_POINT() { return getToken(SLParser.DOUBLE_POINT, 0); }
		public ExplicitvarContext explicitvar() {
			return getRuleContext(ExplicitvarContext.class,0);
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
		enterRule(_localctx, 16, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			listaid();
			setState(98);
			match(DOUBLE_POINT);
			setState(99);
			explicitvar();
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
		enterRule(_localctx, 18, RULE_explicitvar);
		try {
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				tipobasico();
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

	public static class OptContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(SLParser.SEMICOLON, 0); }
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
		enterRule(_localctx, 20, RULE_opt);
		try {
			setState(107);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case CONST:
			case TIPOS:
			case VAR:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case SEMICOLON:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				match(SEMICOLON);
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

	public static class NombreContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SLParser.ID, 0); }
		public NombreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nombre; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterNombre(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitNombre(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitNombre(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NombreContext nombre() throws RecognitionException {
		NombreContext _localctx = new NombreContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_nombre);
		try {
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case CONST:
			case TIPOS:
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(ID);
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

	public static class ListaidContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SLParser.ID, 0); }
		public Listaid2Context listaid2() {
			return getRuleContext(Listaid2Context.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(ID);
			setState(114);
			listaid2();
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

	public static class Listaid2Context extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(SLParser.COMMA, 0); }
		public TerminalNode ID() { return getToken(SLParser.ID, 0); }
		public Listaid2Context listaid2() {
			return getRuleContext(Listaid2Context.class,0);
		}
		public Listaid2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaid2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).enterListaid2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SLParserListener ) ((SLParserListener)listener).exitListaid2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SLParserVisitor ) return ((SLParserVisitor<? extends T>)visitor).visitListaid2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Listaid2Context listaid2() throws RecognitionException {
		Listaid2Context _localctx = new Listaid2Context(_ctx, getState());
		enterRule(_localctx, 26, RULE_listaid2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(COMMA);
			setState(117);
			match(ID);
			setState(118);
			listaid2();
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
		enterRule(_localctx, 28, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMERICO_LITERAL) | (1L << CADENA_LITERAL) | (1L << LOGICO_LITERAL))) != 0)) ) {
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
		enterRule(_localctx, 30, RULE_tipobasico);
		try {
			setState(124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				tipobasico2();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				tensor();
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
		enterRule(_localctx, 32, RULE_tipobasico2);
		try {
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMERICO:
			case CADENA:
			case LOGICO:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				tipobasico3();
				}
				break;
			case EOF:
			case SEMICOLON:
			case CONST:
			case TIPOS:
			case VAR:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
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
		enterRule(_localctx, 34, RULE_tipobasico3);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
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
		enterRule(_localctx, 36, RULE_tensor);
		try {
			enterOuterAlt(_localctx, 1);
			{
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
		enterRule(_localctx, 38, RULE_registro);
		try {
			enterOuterAlt(_localctx, 1);
			{
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
		enterRule(_localctx, 40, RULE_subrutinas);
		try {
			enterOuterAlt(_localctx, 1);
			{
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
		enterRule(_localctx, 42, RULE_sentencias);
		try {
			enterOuterAlt(_localctx, 1);
			{
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u008f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\5\4F\n\4\3\5\3\5\3\5\3\5\5\5L\n\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\5\7W\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\5\tb\n\t\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\5\13j\n\13\3\f\3\f\5\fn\n\f\3\r\3\r\5\rr\n\r\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\5\21\177\n\21\3\22\3\22\5"+
		"\22\u0083\n\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27"+
		"\2\2\30\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\4\4\2##%&\3\2"+
		"\')\2\u0083\2.\3\2\2\2\4\61\3\2\2\2\6E\3\2\2\2\bK\3\2\2\2\nM\3\2\2\2\f"+
		"V\3\2\2\2\16X\3\2\2\2\20a\3\2\2\2\22c\3\2\2\2\24i\3\2\2\2\26m\3\2\2\2"+
		"\30q\3\2\2\2\32s\3\2\2\2\34v\3\2\2\2\36z\3\2\2\2 ~\3\2\2\2\"\u0082\3\2"+
		"\2\2$\u0084\3\2\2\2&\u0086\3\2\2\2(\u0088\3\2\2\2*\u008a\3\2\2\2,\u008c"+
		"\3\2\2\2./\5\4\3\2/\60\5*\26\2\60\3\3\2\2\2\61\62\5\30\r\2\62\63\5\6\4"+
		"\2\63\64\5,\27\2\64\5\3\2\2\2\65F\3\2\2\2\66\67\7\37\2\2\678\5\n\6\28"+
		"9\5\b\5\29:\5\6\4\2:F\3\2\2\2;<\7 \2\2<=\5\16\b\2=>\5\f\7\2>?\5\6\4\2"+
		"?F\3\2\2\2@A\7!\2\2AB\5\22\n\2BC\5\20\t\2CD\5\6\4\2DF\3\2\2\2E\65\3\2"+
		"\2\2E\66\3\2\2\2E;\3\2\2\2E@\3\2\2\2F\7\3\2\2\2GL\3\2\2\2HI\5\n\6\2IJ"+
		"\5\b\5\2JL\3\2\2\2KG\3\2\2\2KH\3\2\2\2L\t\3\2\2\2MN\7\"\2\2NO\7\21\2\2"+
		"OP\5\36\20\2PQ\5\26\f\2Q\13\3\2\2\2RW\3\2\2\2ST\5\16\b\2TU\5\f\7\2UW\3"+
		"\2\2\2VR\3\2\2\2VS\3\2\2\2W\r\3\2\2\2XY\7\"\2\2YZ\7\n\2\2Z[\5 \21\2[\\"+
		"\5\26\f\2\\\17\3\2\2\2]b\3\2\2\2^_\5\22\n\2_`\5\20\t\2`b\3\2\2\2a]\3\2"+
		"\2\2a^\3\2\2\2b\21\3\2\2\2cd\5\32\16\2de\7\n\2\2ef\5\24\13\2f\23\3\2\2"+
		"\2gj\7\"\2\2hj\5 \21\2ig\3\2\2\2ih\3\2\2\2j\25\3\2\2\2kn\3\2\2\2ln\7\t"+
		"\2\2mk\3\2\2\2ml\3\2\2\2n\27\3\2\2\2or\3\2\2\2pr\7\"\2\2qo\3\2\2\2qp\3"+
		"\2\2\2r\31\3\2\2\2st\7\"\2\2tu\5\34\17\2u\33\3\2\2\2vw\7\23\2\2wx\7\""+
		"\2\2xy\5\34\17\2y\35\3\2\2\2z{\t\2\2\2{\37\3\2\2\2|\177\5\"\22\2}\177"+
		"\5&\24\2~|\3\2\2\2~}\3\2\2\2\177!\3\2\2\2\u0080\u0083\5$\23\2\u0081\u0083"+
		"\5(\25\2\u0082\u0080\3\2\2\2\u0082\u0081\3\2\2\2\u0083#\3\2\2\2\u0084"+
		"\u0085\t\3\2\2\u0085%\3\2\2\2\u0086\u0087\3\2\2\2\u0087\'\3\2\2\2\u0088"+
		"\u0089\3\2\2\2\u0089)\3\2\2\2\u008a\u008b\3\2\2\2\u008b+\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d-\3\2\2\2\13EKVaimq~\u0082";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}