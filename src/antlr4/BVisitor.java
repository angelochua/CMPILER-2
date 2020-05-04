package antlr4;// Generated from C:/Users/user/Desktop/CMPILER v2/Java Implementation/grammar\B.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BParser#source}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSource(BParser.SourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(BParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(BParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(BParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#constantAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantAssignment(BParser.ConstantAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(BParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#ifStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(BParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#elseIfStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfStat(BParser.ElseIfStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#elseStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStat(BParser.ElseStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(BParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#missingLBraceFuncDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissingLBraceFuncDecl(BParser.MissingLBraceFuncDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#missingRBraceFuncDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissingRBraceFuncDecl(BParser.MissingRBraceFuncDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(BParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#missingLBraceForLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissingLBraceForLoop(BParser.MissingLBraceForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#missingRBraceForLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissingRBraceForLoop(BParser.MissingRBraceForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(BParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#missingLBraceWhileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissingLBraceWhileLoop(BParser.MissingLBraceWhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#missingRBraceWhileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissingRBraceWhileLoop(BParser.MissingRBraceWhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#doWhileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStatement(BParser.DoWhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#missingLBraceDoWhileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissingLBraceDoWhileLoop(BParser.MissingLBraceDoWhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#missingRBraceDoWhileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissingRBraceDoWhileLoop(BParser.MissingRBraceDoWhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#tryCatchNullStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryCatchNullStatement(BParser.TryCatchNullStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#tryCatchIndexOutOfBoundsStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryCatchIndexOutOfBoundsStatement(BParser.TryCatchIndexOutOfBoundsStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#tryCatchDivideByZeroStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryCatchDivideByZeroStatement(BParser.TryCatchDivideByZeroStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierFunctionCall}
	 * labeled alternative in {@link BParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierFunctionCall(BParser.IdentifierFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printlnFunctionCall}
	 * labeled alternative in {@link BParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintlnFunctionCall(BParser.PrintlnFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printFunctionCall}
	 * labeled alternative in {@link BParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintFunctionCall(BParser.PrintFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code missingLParenPrintStatement}
	 * labeled alternative in {@link BParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissingLParenPrintStatement(BParser.MissingLParenPrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code missingRParenStatement}
	 * labeled alternative in {@link BParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissingRParenStatement(BParser.MissingRParenStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#idList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdList(BParser.IdListContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(BParser.ExprListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpression(BParser.BoolExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExpression(BParser.NumberExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpression(BParser.IdentifierExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code missingLParenExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissingLParenExpression(BParser.MissingLParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(BParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(BParser.OrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryMinusExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinusExpression(BParser.UnaryMinusExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code powerExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowerExpression(BParser.PowerExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExpression(BParser.EqExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(BParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInExpression(BParser.InExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpression(BParser.StringExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionExpression(BParser.ExpressionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompExpression(BParser.CompExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullExpression(BParser.NullExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code missingRParenExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissingRParenExpression(BParser.MissingRParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code excessOperationExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExcessOperationExpression(BParser.ExcessOperationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ADDExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitADDExpression(BParser.ADDExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpression(BParser.FunctionCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpression(BParser.MultExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpression(BParser.ListExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ternaryExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryExpression(BParser.TernaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inputExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputExpression(BParser.InputExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#indexes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexes(BParser.IndexesContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(BParser.ListContext ctx);
}