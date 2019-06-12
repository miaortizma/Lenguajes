// Generated from /data/Lenguajes/ANTLR-SL/grammar/SLParser.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SLParser}.
 */
public interface SLParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SLParser#commands}.
	 * @param ctx the parse tree
	 */
	void enterCommands(SLParser.CommandsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#commands}.
	 * @param ctx the parse tree
	 */
	void exitCommands(SLParser.CommandsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(SLParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(SLParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterConditional(SLParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitConditional(SLParser.ConditionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLParser#booleanExpr}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpr(SLParser.BooleanExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#booleanExpr}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpr(SLParser.BooleanExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(SLParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(SLParser.ExprContext ctx);
}