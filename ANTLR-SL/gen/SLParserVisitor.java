// Generated from /data/Lenguajes/ANTLR-SL/grammar/SLParser.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SLParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SLParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(SLParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLParser#programaprc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramaprc(SLParser.ProgramaprcContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLParser#declaraciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaraciones(SLParser.DeclaracionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLParser#consts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConsts(SLParser.ConstsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLParser#const_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConst_(SLParser.Const_Context ctx);
	/**
	 * Visit a parse tree produced by {@link SLParser#tipos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipos(SLParser.TiposContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(SLParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLParser#vars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVars(SLParser.VarsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(SLParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLParser#explicitvar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitvar(SLParser.ExplicitvarContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLParser#opt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpt(SLParser.OptContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLParser#nombre}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNombre(SLParser.NombreContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLParser#listaid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaid(SLParser.ListaidContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLParser#listaid2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaid2(SLParser.Listaid2Context ctx);
	/**
	 * Visit a parse tree produced by {@link SLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(SLParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLParser#tipobasico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipobasico(SLParser.TipobasicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLParser#tipobasico2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipobasico2(SLParser.Tipobasico2Context ctx);
	/**
	 * Visit a parse tree produced by {@link SLParser#tipobasico3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipobasico3(SLParser.Tipobasico3Context ctx);
	/**
	 * Visit a parse tree produced by {@link SLParser#tensor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTensor(SLParser.TensorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLParser#registro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegistro(SLParser.RegistroContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLParser#subrutinas}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubrutinas(SLParser.SubrutinasContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLParser#sentencias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentencias(SLParser.SentenciasContext ctx);
}