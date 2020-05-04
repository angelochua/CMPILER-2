package antlr4;// Generated from C:/Users/user/Desktop/CMPILER v2/Java Implementation/grammar\B.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BParser}.
 */
public interface BListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BParser#source}.
	 * @param ctx the parse tree
	 */
	void enterSource(BParser.SourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#source}.
	 * @param ctx the parse tree
	 */
	void exitSource(BParser.SourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(BParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(BParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(BParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(BParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(BParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(BParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#constantAssignment}.
	 * @param ctx the parse tree
	 */
	void enterConstantAssignment(BParser.ConstantAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#constantAssignment}.
	 * @param ctx the parse tree
	 */
	void exitConstantAssignment(BParser.ConstantAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(BParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(BParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(BParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(BParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#elseIfStat}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStat(BParser.ElseIfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#elseIfStat}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStat(BParser.ElseIfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#elseStat}.
	 * @param ctx the parse tree
	 */
	void enterElseStat(BParser.ElseStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#elseStat}.
	 * @param ctx the parse tree
	 */
	void exitElseStat(BParser.ElseStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(BParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(BParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#missingLBraceFuncDecl}.
	 * @param ctx the parse tree
	 */
	void enterMissingLBraceFuncDecl(BParser.MissingLBraceFuncDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#missingLBraceFuncDecl}.
	 * @param ctx the parse tree
	 */
	void exitMissingLBraceFuncDecl(BParser.MissingLBraceFuncDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#missingRBraceFuncDecl}.
	 * @param ctx the parse tree
	 */
	void enterMissingRBraceFuncDecl(BParser.MissingRBraceFuncDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#missingRBraceFuncDecl}.
	 * @param ctx the parse tree
	 */
	void exitMissingRBraceFuncDecl(BParser.MissingRBraceFuncDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(BParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(BParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#missingLBraceForLoop}.
	 * @param ctx the parse tree
	 */
	void enterMissingLBraceForLoop(BParser.MissingLBraceForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#missingLBraceForLoop}.
	 * @param ctx the parse tree
	 */
	void exitMissingLBraceForLoop(BParser.MissingLBraceForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#missingRBraceForLoop}.
	 * @param ctx the parse tree
	 */
	void enterMissingRBraceForLoop(BParser.MissingRBraceForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#missingRBraceForLoop}.
	 * @param ctx the parse tree
	 */
	void exitMissingRBraceForLoop(BParser.MissingRBraceForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(BParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(BParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#missingLBraceWhileLoop}.
	 * @param ctx the parse tree
	 */
	void enterMissingLBraceWhileLoop(BParser.MissingLBraceWhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#missingLBraceWhileLoop}.
	 * @param ctx the parse tree
	 */
	void exitMissingLBraceWhileLoop(BParser.MissingLBraceWhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#missingRBraceWhileLoop}.
	 * @param ctx the parse tree
	 */
	void enterMissingRBraceWhileLoop(BParser.MissingRBraceWhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#missingRBraceWhileLoop}.
	 * @param ctx the parse tree
	 */
	void exitMissingRBraceWhileLoop(BParser.MissingRBraceWhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#doWhileStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStatement(BParser.DoWhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#doWhileStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStatement(BParser.DoWhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#missingLBraceDoWhileLoop}.
	 * @param ctx the parse tree
	 */
	void enterMissingLBraceDoWhileLoop(BParser.MissingLBraceDoWhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#missingLBraceDoWhileLoop}.
	 * @param ctx the parse tree
	 */
	void exitMissingLBraceDoWhileLoop(BParser.MissingLBraceDoWhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#missingRBraceDoWhileLoop}.
	 * @param ctx the parse tree
	 */
	void enterMissingRBraceDoWhileLoop(BParser.MissingRBraceDoWhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#missingRBraceDoWhileLoop}.
	 * @param ctx the parse tree
	 */
	void exitMissingRBraceDoWhileLoop(BParser.MissingRBraceDoWhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#tryCatchNullStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryCatchNullStatement(BParser.TryCatchNullStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#tryCatchNullStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryCatchNullStatement(BParser.TryCatchNullStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#tryCatchIndexOutOfBoundsStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryCatchIndexOutOfBoundsStatement(BParser.TryCatchIndexOutOfBoundsStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#tryCatchIndexOutOfBoundsStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryCatchIndexOutOfBoundsStatement(BParser.TryCatchIndexOutOfBoundsStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#tryCatchDivideByZeroStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryCatchDivideByZeroStatement(BParser.TryCatchDivideByZeroStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#tryCatchDivideByZeroStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryCatchDivideByZeroStatement(BParser.TryCatchDivideByZeroStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierFunctionCall}
	 * labeled alternative in {@link BParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierFunctionCall(BParser.IdentifierFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierFunctionCall}
	 * labeled alternative in {@link BParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierFunctionCall(BParser.IdentifierFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printlnFunctionCall}
	 * labeled alternative in {@link BParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterPrintlnFunctionCall(BParser.PrintlnFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printlnFunctionCall}
	 * labeled alternative in {@link BParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitPrintlnFunctionCall(BParser.PrintlnFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printFunctionCall}
	 * labeled alternative in {@link BParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterPrintFunctionCall(BParser.PrintFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printFunctionCall}
	 * labeled alternative in {@link BParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitPrintFunctionCall(BParser.PrintFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code missingLParenPrintStatement}
	 * labeled alternative in {@link BParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterMissingLParenPrintStatement(BParser.MissingLParenPrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code missingLParenPrintStatement}
	 * labeled alternative in {@link BParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitMissingLParenPrintStatement(BParser.MissingLParenPrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code missingRParenStatement}
	 * labeled alternative in {@link BParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterMissingRParenStatement(BParser.MissingRParenStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code missingRParenStatement}
	 * labeled alternative in {@link BParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitMissingRParenStatement(BParser.MissingRParenStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#idList}.
	 * @param ctx the parse tree
	 */
	void enterIdList(BParser.IdListContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#idList}.
	 * @param ctx the parse tree
	 */
	void exitIdList(BParser.IdListContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(BParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(BParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpression(BParser.BoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpression(BParser.BoolExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpression(BParser.NumberExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpression(BParser.NumberExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(BParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(BParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code missingLParenExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMissingLParenExpression(BParser.MissingLParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code missingLParenExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMissingLParenExpression(BParser.MissingLParenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(BParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(BParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(BParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(BParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryMinusExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinusExpression(BParser.UnaryMinusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMinusExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinusExpression(BParser.UnaryMinusExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powerExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPowerExpression(BParser.PowerExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powerExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPowerExpression(BParser.PowerExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqExpression(BParser.EqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqExpression(BParser.EqExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(BParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(BParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInExpression(BParser.InExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInExpression(BParser.InExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpression(BParser.StringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpression(BParser.StringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionExpression(BParser.ExpressionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionExpression(BParser.ExpressionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCompExpression(BParser.CompExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCompExpression(BParser.CompExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNullExpression(BParser.NullExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNullExpression(BParser.NullExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code missingRParenExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMissingRParenExpression(BParser.MissingRParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code missingRParenExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMissingRParenExpression(BParser.MissingRParenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code excessOperationExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExcessOperationExpression(BParser.ExcessOperationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code excessOperationExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExcessOperationExpression(BParser.ExcessOperationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ADDExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterADDExpression(BParser.ADDExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ADDExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitADDExpression(BParser.ADDExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpression(BParser.FunctionCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpression(BParser.FunctionCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultExpression(BParser.MultExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultExpression(BParser.MultExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterListExpression(BParser.ListExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitListExpression(BParser.ListExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ternaryExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpression(BParser.TernaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ternaryExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpression(BParser.TernaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inputExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInputExpression(BParser.InputExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inputExpression}
	 * labeled alternative in {@link BParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInputExpression(BParser.InputExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#indexes}.
	 * @param ctx the parse tree
	 */
	void enterIndexes(BParser.IndexesContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#indexes}.
	 * @param ctx the parse tree
	 */
	void exitIndexes(BParser.IndexesContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(BParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(BParser.ListContext ctx);
}