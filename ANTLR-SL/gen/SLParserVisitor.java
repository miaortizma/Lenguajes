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
	 * Visit a parse tree produced by {@link SLParser#commands}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommands(SLParser.CommandsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(SLParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional(SLParser.ConditionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLParser#booleanExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpr(SLParser.BooleanExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(SLParser.ExprContext ctx);
}