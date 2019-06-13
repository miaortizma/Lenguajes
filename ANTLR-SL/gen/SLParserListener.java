// Generated from /data/Lenguajes/ANTLR-SL/grammar/SLParser.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SLParser}.
 */
public interface SLParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SLParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(SLParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(SLParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLParser#programaprc}.
	 * @param ctx the parse tree
	 */
	void enterProgramaprc(SLParser.ProgramaprcContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#programaprc}.
	 * @param ctx the parse tree
	 */
	void exitProgramaprc(SLParser.ProgramaprcContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLParser#declaraciones}.
	 * @param ctx the parse tree
	 */
	void enterDeclaraciones(SLParser.DeclaracionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#declaraciones}.
	 * @param ctx the parse tree
	 */
	void exitDeclaraciones(SLParser.DeclaracionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLParser#consts}.
	 * @param ctx the parse tree
	 */
	void enterConsts(SLParser.ConstsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#consts}.
	 * @param ctx the parse tree
	 */
	void exitConsts(SLParser.ConstsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLParser#const_}.
	 * @param ctx the parse tree
	 */
	void enterConst_(SLParser.Const_Context ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#const_}.
	 * @param ctx the parse tree
	 */
	void exitConst_(SLParser.Const_Context ctx);
	/**
	 * Enter a parse tree produced by {@link SLParser#tipos}.
	 * @param ctx the parse tree
	 */
	void enterTipos(SLParser.TiposContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#tipos}.
	 * @param ctx the parse tree
	 */
	void exitTipos(SLParser.TiposContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(SLParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(SLParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLParser#vars}.
	 * @param ctx the parse tree
	 */
	void enterVars(SLParser.VarsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#vars}.
	 * @param ctx the parse tree
	 */
	void exitVars(SLParser.VarsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(SLParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(SLParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLParser#explicitvar}.
	 * @param ctx the parse tree
	 */
	void enterExplicitvar(SLParser.ExplicitvarContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#explicitvar}.
	 * @param ctx the parse tree
	 */
	void exitExplicitvar(SLParser.ExplicitvarContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLParser#opt}.
	 * @param ctx the parse tree
	 */
	void enterOpt(SLParser.OptContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#opt}.
	 * @param ctx the parse tree
	 */
	void exitOpt(SLParser.OptContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLParser#listaid}.
	 * @param ctx the parse tree
	 */
	void enterListaid(SLParser.ListaidContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#listaid}.
	 * @param ctx the parse tree
	 */
	void exitListaid(SLParser.ListaidContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(SLParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(SLParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLParser#tipobasico}.
	 * @param ctx the parse tree
	 */
	void enterTipobasico(SLParser.TipobasicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#tipobasico}.
	 * @param ctx the parse tree
	 */
	void exitTipobasico(SLParser.TipobasicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLParser#tipobasico2}.
	 * @param ctx the parse tree
	 */
	void enterTipobasico2(SLParser.Tipobasico2Context ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#tipobasico2}.
	 * @param ctx the parse tree
	 */
	void exitTipobasico2(SLParser.Tipobasico2Context ctx);
	/**
	 * Enter a parse tree produced by {@link SLParser#tipobasico3}.
	 * @param ctx the parse tree
	 */
	void enterTipobasico3(SLParser.Tipobasico3Context ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#tipobasico3}.
	 * @param ctx the parse tree
	 */
	void exitTipobasico3(SLParser.Tipobasico3Context ctx);
	/**
	 * Enter a parse tree produced by {@link SLParser#tensor}.
	 * @param ctx the parse tree
	 */
	void enterTensor(SLParser.TensorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#tensor}.
	 * @param ctx the parse tree
	 */
	void exitTensor(SLParser.TensorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLParser#registro}.
	 * @param ctx the parse tree
	 */
	void enterRegistro(SLParser.RegistroContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#registro}.
	 * @param ctx the parse tree
	 */
	void exitRegistro(SLParser.RegistroContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLParser#subrutinas}.
	 * @param ctx the parse tree
	 */
	void enterSubrutinas(SLParser.SubrutinasContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#subrutinas}.
	 * @param ctx the parse tree
	 */
	void exitSubrutinas(SLParser.SubrutinasContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLParser#subrutina}.
	 * @param ctx the parse tree
	 */
	void enterSubrutina(SLParser.SubrutinaContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#subrutina}.
	 * @param ctx the parse tree
	 */
	void exitSubrutina(SLParser.SubrutinaContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLParser#procedimiento}.
	 * @param ctx the parse tree
	 */
	void enterProcedimiento(SLParser.ProcedimientoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#procedimiento}.
	 * @param ctx the parse tree
	 */
	void exitProcedimiento(SLParser.ProcedimientoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLParser#funcion}.
	 * @param ctx the parse tree
	 */
	void enterFuncion(SLParser.FuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#funcion}.
	 * @param ctx the parse tree
	 */
	void exitFuncion(SLParser.FuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(SLParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(SLParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(SLParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(SLParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLParser#sentencias}.
	 * @param ctx the parse tree
	 */
	void enterSentencias(SLParser.SentenciasContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#sentencias}.
	 * @param ctx the parse tree
	 */
	void exitSentencias(SLParser.SentenciasContext ctx);
}