package driver;

import antlr4.BBaseVisitor;
import antlr4.BParser;

public class ErrorVisitor extends BBaseVisitor {

    @Override public Object visitSource(BParser.SourceContext ctx) { return visitChildren(ctx); }

    @Override public Object visitBlock(BParser.BlockContext ctx) { return visitChildren(ctx); }

    @Override public Object visitStatement(BParser.StatementContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitAssignment(BParser.AssignmentContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitConstantAssignment(BParser.ConstantAssignmentContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitIfStatement(BParser.IfStatementContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitIfStat(BParser.IfStatContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitElseIfStat(BParser.ElseIfStatContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitElseStat(BParser.ElseStatContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitFunctionDecl(BParser.FunctionDeclContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitMissingLBraceFuncDecl(BParser.MissingLBraceFuncDeclContext ctx) {
        B.addErrors("Function declaration has no opening brace ({) at line " + ctx.getStart().getLine());

        return visitChildren(ctx);
    }
    
    @Override public Object visitMissingRBraceFuncDecl(BParser.MissingRBraceFuncDeclContext ctx) {
        B.addErrors("Function declaration has no closing brace (}) at line " + ctx.getStart().getLine());

        return visitChildren(ctx);
    }
    
    @Override public Object visitForStatement(BParser.ForStatementContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitMissingLBraceForLoop(BParser.MissingLBraceForLoopContext ctx) {
        B.addErrors("Pork loop does not have an opening brace ({) at line " + ctx.getStart().getLine());

        return visitChildren(ctx);
    }
    
    @Override public Object visitMissingRBraceForLoop(BParser.MissingRBraceForLoopContext ctx) {
        B.addErrors("Pork loop does not have a closing brace (}) at line " + ctx.getStart().getLine());

        return visitChildren(ctx);
    }
    
    @Override public Object visitWhileStatement(BParser.WhileStatementContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitMissingLBraceWhileLoop(BParser.MissingLBraceWhileLoopContext ctx) {
        B.addErrors("Wine loop does not have an opening brace ({) at line " + ctx.getStart().getLine());

        return visitChildren(ctx);
    }
    
    @Override public Object visitMissingRBraceWhileLoop(BParser.MissingRBraceWhileLoopContext ctx) {
        B.addErrors("Wine loop does not have a closing brace (}) at line " + ctx.getStart().getLine());

        return visitChildren(ctx);
    }
    
    @Override public Object visitDoWhileStatement(BParser.DoWhileStatementContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitMissingLBraceDoWhileLoop(BParser.MissingLBraceDoWhileLoopContext ctx) {
        B.addErrors("Doughnut-Wine loop does not have an opening brace ({) at line " + ctx.getStart().getLine());

        return visitChildren(ctx);
    }
    
    @Override public Object visitMissingRBraceDoWhileLoop(BParser.MissingRBraceDoWhileLoopContext ctx) {
        B.addErrors("Doughnut-Wine loop does not have a closing brace (}) at line " + ctx.getStart().getLine());

        return visitChildren(ctx);
    }
    
    @Override public Object visitIdentifierFunctionCall(BParser.IdentifierFunctionCallContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitPrintlnFunctionCall(BParser.PrintlnFunctionCallContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitPrintFunctionCall(BParser.PrintFunctionCallContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitMissingLParenPrintStatement(BParser.MissingLParenPrintStatementContext ctx) {
        B.addErrors("Missing ')' token at function call at line " + ctx.getStart().getLine());

        return visitChildren(ctx);
    }
    
    @Override public Object visitMissingRParenStatement(BParser.MissingRParenStatementContext ctx) {
        B.addErrors("Error in visitMissingRParenStatement");
        return visitChildren(ctx);
    }
    
    @Override public Object visitIdList(BParser.IdListContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitExprList(BParser.ExprListContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitBoolExpression(BParser.BoolExpressionContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitNumberExpression(BParser.NumberExpressionContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitIdentifierExpression(BParser.IdentifierExpressionContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitMissingLParenExpression(BParser.MissingLParenExpressionContext ctx) {
        B.addErrors("Excess ')' or missing '(' in line " + ctx.getStart().getLine());

        return visitChildren(ctx);
    }
    
    @Override public Object visitNotExpression(BParser.NotExpressionContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitOrExpression(BParser.OrExpressionContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitUnaryMinusExpression(BParser.UnaryMinusExpressionContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitPowerExpression(BParser.PowerExpressionContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitEqExpression(BParser.EqExpressionContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitAndExpression(BParser.AndExpressionContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitInExpression(BParser.InExpressionContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitStringExpression(BParser.StringExpressionContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitExpressionExpression(BParser.ExpressionExpressionContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitCompExpression(BParser.CompExpressionContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitNullExpression(BParser.NullExpressionContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitMissingRParenExpression(BParser.MissingRParenExpressionContext ctx) {
        B.addErrors("Excess '(' or missing ')' in line " + ctx.getStart().getLine());

        return visitChildren(ctx);
    }
    
    @Override public Object visitExcessOperationExpression(BParser.ExcessOperationExpressionContext ctx) {
        B.addErrors("Excess operation (+, -, *, /, %) found in line " + ctx.getStart().getLine());

        return visitChildren(ctx);
    }
    
    @Override public Object visitADDExpression(BParser.ADDExpressionContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitFunctionCallExpression(BParser.FunctionCallExpressionContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitMultExpression(BParser.MultExpressionContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitListExpression(BParser.ListExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Object visitInputExpression(BParser.InputExpressionContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitIndexes(BParser.IndexesContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitList(BParser.ListContext ctx) { return visitChildren(ctx); }
}
