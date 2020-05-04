package interpreter;

import antlr4.BBaseVisitor;
import antlr4.BLexer;
import antlr4.BParser.*;
import model.Scope;
import org.antlr.v4.runtime.ParserRuleContext;
import driver.B;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class TheVisitor extends BBaseVisitor<model.BData> {
    private static BdData returnValue = new BdData();
    private Scope scope;
    private Map<String, Function> functions;

    public TheVisitor(Scope scope, Map<String, Function> functions) {
        this.scope = scope;
        this.functions = functions;
    }

    // functionDecl
    @Override
    public model.BData visitFunctionDecl(FunctionDeclContext ctx) {
        return model.BData.VOID;
    }

    // list: '[' exprList? ']'
    @Override
    public model.BData visitList(ListContext ctx) {
        List<model.BData> list = new ArrayList<>();
        if (ctx.exprList() != null) {
            for (ExpressionContext ex : ctx.exprList().expression()) {
                list.add(this.visit(ex));
            }
        }
        return new model.BData(list);
    }


    // '-' expression                           #unaryMinusExpression
    @Override
    public model.BData visitUnaryMinusExpression(UnaryMinusExpressionContext ctx) {
        model.BData v = this.visit(ctx.expression());
        if (!v.isNumber()) {
            throw new BException(ctx);
        }
        return new model.BData(-1 * v.asDouble());
    }

    // '!' expression                           #notExpression
    @Override
    public model.BData visitNotExpression(NotExpressionContext ctx) {
        model.BData v = this.visit(ctx.expression());
        if (!v.isBoolean()) {
            throw new BException(ctx);
        }
        return new model.BData(!v.asBoolean());
    }

    // expression '^' expression                #powerExpression
    @Override
    public model.BData visitPowerExpression(PowerExpressionContext ctx) {
        model.BData lhs = this.visit(ctx.expression(0));
        model.BData rhs = this.visit(ctx.expression(1));
        if (lhs.isNumber() && rhs.isNumber()) {
            return new model.BData(Math.pow(lhs.asDouble(), rhs.asDouble()));
        }
        throw new BException(ctx);
    }

    // expression op=( '*' | '/' | '%' ) expression         #multExpression
    @Override
    public model.BData visitMultExpression(MultExpressionContext ctx) {
        switch (ctx.op.getType()) {
            case BLexer.MUL:
                return MUL(ctx);
            case BLexer.DIV:
                return DIV(ctx);
            case BLexer.MOD:
                return MOD(ctx);
            default:
                throw new RuntimeException("unknown operator type: " + ctx.op.getType());
        }
    }

    // expression op=( '+' | '-' ) expression               #ADDExpression
    @Override
    public model.BData visitADDExpression(ADDExpressionContext ctx) {
        switch (ctx.op.getType()) {
            case BLexer.ADD:
                return ADD(ctx);
            case BLexer.SUB:
                return SUB(ctx);
            default:
                throw new RuntimeException("unknown operator type: " + ctx.op.getType());
        }
    }

    // expression op=( '>=' | '<=' | '>' | '<' ) expression #compExpression
    @Override
    public model.BData visitCompExpression(CompExpressionContext ctx) {
        switch (ctx.op.getType()) {
            case BLexer.LT:
                return lt(ctx);
            case BLexer.LTEQUALS:
                return ltEq(ctx);
            case BLexer.GT:
                return gt(ctx);
            case BLexer.GTEQUALS:
                return gtEq(ctx);
            default:
                throw new RuntimeException("unknown operator type: " + ctx.op.getType());
        }
    }

    // expression op=( '==' | '!=' ) expression             #eqExpression
    @Override
    public model.BData visitEqExpression(EqExpressionContext ctx) {
        switch (ctx.op.getType()) {
            case BLexer.EQUALS:
                return eq(ctx);
            case BLexer.NEQUALS:
                return nEq(ctx);
            default:
                throw new RuntimeException("unknown operator type: " + ctx.op.getType());
        }
    }

    public model.BData MUL(MultExpressionContext ctx) {
        model.BData lhs = this.visit(ctx.expression(0));
        model.BData rhs = this.visit(ctx.expression(1));

        // number * number
        if (lhs.isNumber() && rhs.isNumber()) {
            return new model.BData(lhs.asDouble() * rhs.asDouble());
        }

        // string * number
        if (lhs.isString() && rhs.isNumber()) {
            StringBuilder str = new StringBuilder();
            int stop = rhs.asDouble().intValue();
            for (int i = 0; i < stop; i++) {
                str.append(lhs.asString());
            }
            return new model.BData(str.toString());
        }

        // list * number
        if (lhs.isList() && rhs.isNumber()) {
            List<model.BData> total = new ArrayList<>();
            int stop = rhs.asDouble().intValue();
            for (int i = 0; i < stop; i++) {
                total.addAll(lhs.asList());
            }
            return new model.BData(total);
        }

        throw new BException(ctx);
    }

    private model.BData DIV(MultExpressionContext ctx) {
        model.BData lhs = this.visit(ctx.expression(0));
        model.BData rhs = this.visit(ctx.expression(1));

        if (lhs.isNumber() && rhs.isNumber()) {
            return new model.BData(lhs.asDouble() / rhs.asDouble());
        }
        throw new BException(ctx);
    }

    private model.BData MOD(MultExpressionContext ctx) {
        model.BData lhs = this.visit(ctx.expression(0));
        model.BData rhs = this.visit(ctx.expression(1));

        if (lhs.isNumber() && rhs.isNumber()) {
            return new model.BData(lhs.asDouble() % rhs.asDouble());
        }
        throw new BException(ctx);
    }

    private model.BData ADD(ADDExpressionContext ctx) {
        model.BData lhs = this.visit(ctx.expression(0));
        model.BData rhs = this.visit(ctx.expression(1));

        // number + number
        if (lhs.isNumber() && rhs.isNumber()) {
            return new model.BData(lhs.asDouble() + rhs.asDouble());
        }

        // list + any
        if (lhs.isList()) {
            List<model.BData> list = lhs.asList();
            list.add(rhs);
            return new model.BData(list);
        }

        // string + any
        if (lhs.isString()) {
            return new model.BData(lhs.asString() + "" + rhs.toString());
        }

        // any + string
        if (rhs.isString()) {
            return new model.BData(lhs.toString() + "" + rhs.asString());
        }

        return new model.BData(lhs.toString() + rhs.toString());
    }

    private model.BData SUB(ADDExpressionContext ctx) {
        model.BData lhs = this.visit(ctx.expression(0));
        model.BData rhs = this.visit(ctx.expression(1));

        if (lhs.isNumber() && rhs.isNumber()) {
            return new model.BData(lhs.asDouble() - rhs.asDouble());
        }
        if (lhs.isList()) {
            List<model.BData> list = lhs.asList();
            list.remove(rhs);
            return new model.BData(list);
        }
        throw new BException(ctx);
    }

    private model.BData gtEq(CompExpressionContext ctx) {
        model.BData lhs = this.visit(ctx.expression(0));
        model.BData rhs = this.visit(ctx.expression(1));

        if (lhs.isNumber() && rhs.isNumber()) {
            return new model.BData(lhs.asDouble() >= rhs.asDouble());
        }
        if (lhs.isString() && rhs.isString()) {
            return new model.BData(lhs.asString().compareTo(rhs.asString()) >= 0);
        }
        throw new BException(ctx);
    }

    private model.BData ltEq(CompExpressionContext ctx) {
        model.BData lhs = this.visit(ctx.expression(0));
        model.BData rhs = this.visit(ctx.expression(1));

        if (lhs.isNumber() && rhs.isNumber()) {
            return new model.BData(lhs.asDouble() <= rhs.asDouble());
        }
        if (lhs.isString() && rhs.isString()) {
            return new model.BData(lhs.asString().compareTo(rhs.asString()) <= 0);
        }
        throw new BException(ctx);
    }

    private model.BData gt(CompExpressionContext ctx) {
        model.BData lhs = this.visit(ctx.expression(0));
        model.BData rhs = this.visit(ctx.expression(1));

        if (lhs.isNumber() && rhs.isNumber()) {
            return new model.BData(lhs.asDouble() > rhs.asDouble());
        }
        if (lhs.isString() && rhs.isString()) {
            return new model.BData(lhs.asString().compareTo(rhs.asString()) > 0);
        }
        throw new BException(ctx);
    }

    private model.BData lt(CompExpressionContext ctx) {
        model.BData lhs = this.visit(ctx.expression(0));
        model.BData rhs = this.visit(ctx.expression(1));

        if (lhs == null || rhs == null) {

            B.appendOutput("Null Pointer Exception: Trying to compare with null");

            throw new BException(ctx);
        }

        if (lhs.isNumber() && rhs.isNumber()) {
            return new model.BData(lhs.asDouble() < rhs.asDouble());
        }
        if (lhs.isString() && rhs.isString()) {
            return new model.BData(lhs.asString().compareTo(rhs.asString()) < 0);
        }
        throw new BException(ctx);
    }

    private model.BData eq(EqExpressionContext ctx) {
        model.BData lhs = this.visit(ctx.expression(0));
        model.BData rhs = this.visit(ctx.expression(1));

        return new model.BData(lhs.equals(rhs));
    }

    private model.BData nEq(EqExpressionContext ctx) {
        model.BData lhs = this.visit(ctx.expression(0));
        model.BData rhs = this.visit(ctx.expression(1));

        return new model.BData(!lhs.equals(rhs));
    }

    // expression '&&' expression               #andExpression
    @Override
    public model.BData visitAndExpression(AndExpressionContext ctx) {
        model.BData lhs = this.visit(ctx.expression(0));
        model.BData rhs = this.visit(ctx.expression(1));

        if (!lhs.isBoolean() || !rhs.isBoolean()) {
            throw new BException(ctx);
        }
        return new model.BData(lhs.asBoolean() && rhs.asBoolean());
    }

    // expression '||' expression               #orExpression
    @Override
    public model.BData visitOrExpression(OrExpressionContext ctx) {
        model.BData lhs = this.visit(ctx.expression(0));
        model.BData rhs = this.visit(ctx.expression(1));

        if (!lhs.isBoolean() || !rhs.isBoolean()) {
            throw new BException(ctx);
        }
        return new model.BData(lhs.asBoolean() || rhs.asBoolean());
    }

    // expression '?' expression ':' expression #ternaryExpression
    @Override
    public model.BData visitTernaryExpression(TernaryExpressionContext ctx) {
        model.BData condition = this.visit(ctx.expression(0));
        if (condition.asBoolean()) {
            return new model.BData(this.visit(ctx.expression(1)));
        } else {
            return new model.BData(this.visit(ctx.expression(2)));
        }
    }

    // expression In expression                 #inExpression
    @Override
    public model.BData visitInExpression(InExpressionContext ctx) {
        model.BData lhs = this.visit(ctx.expression(0));
        model.BData rhs = this.visit(ctx.expression(1));

        if (rhs.isList()) {
            for (model.BData val : rhs.asList()) {
                if (val.equals(lhs)) {
                    return new model.BData(true);
                }
            }
            return new model.BData(false);
        }
        throw new BException(ctx);
    }

    // Number                                   #numberExpression
    @Override
    public model.BData visitNumberExpression(NumberExpressionContext ctx) {
        return new model.BData(Double.valueOf(ctx.getText()));
    }

    // Bool                                     #boolExpression
    @Override
    public model.BData visitBoolExpression(BoolExpressionContext ctx) {
        return new model.BData(Boolean.valueOf(ctx.getText()));
    }

    // Null                                     #nullExpression
    @Override
    public model.BData visitNullExpression(NullExpressionContext ctx) {
        return model.BData.NULL;
    }

    private model.BData resolveIndexes(model.BData val, List<ExpressionContext> indexes) {
        for (ExpressionContext ec : indexes) {
            model.BData idx = this.visit(ec);
            if (!idx.isNumber() || (!val.isList() && !val.isString())) {
                throw new BException("Problem resolving indexes on " + val + " at " + idx, ec);
            }
            int i = idx.asDouble().intValue();
            if (val.isString()) {
                val = new model.BData(val.asString().substring(i, i + 1));
            } else {
                val = val.asList().get(i);
            }
        }
        return val;
    }

    private void setAtIndex(ParserRuleContext ctx, List<ExpressionContext> indexes, model.BData val, model.BData newVal) {
        if (!val.isList()) {
            throw new BException(ctx);
        }
        for (int i = 0; i < indexes.size() - 1; i++) {
            model.BData idx = this.visit(indexes.get(i));
            if (!idx.isNumber()) {
                throw new BException(ctx);
            }
            val = val.asList().get(idx.asDouble().intValue());
        }
        model.BData idx = this.visit(indexes.get(indexes.size() - 1));
        if (!idx.isNumber()) {
            throw new BException(ctx);
        }
        val.asList().set(idx.asDouble().intValue(), newVal);
    }

    // functionCall indexes?                    #functionCallExpression
    @Override
    public model.BData visitFunctionCallExpression(FunctionCallExpressionContext ctx) {
        model.BData val = this.visit(ctx.functionCall());
        if (ctx.indexes() != null) {
            List<ExpressionContext> exps = ctx.indexes().expression();
            val = resolveIndexes(val, exps);
        }
        return val;
    }

    // list indexes?                            #listExpression
    @Override
    public model.BData visitListExpression(ListExpressionContext ctx) {
        model.BData val = this.visit(ctx.list());
        if (ctx.indexes() != null) {
            List<ExpressionContext> exps = ctx.indexes().expression();
            val = resolveIndexes(val, exps);
        }
        return val;
    }

    // Identifier indexes?                      #identifierExpression
    @Override
    public model.BData visitIdentifierExpression(IdentifierExpressionContext ctx) {
        String id = ctx.IDENTIFIER().getText();
        model.BData val = scope.resolve(id);

        if (ctx.indexes() != null) {
            List<ExpressionContext> exps = ctx.indexes().expression();
            val = resolveIndexes(val, exps);
        }
        return val;
    }

    // String indexes?                          #stringExpression
    @Override
    public model.BData visitStringExpression(StringExpressionContext ctx) {
        String text = ctx.getText();
        text = text.substring(1, text.length() - 1).replaceAll("\\\\(.)", "$1");
        model.BData val = new model.BData(text);
        if (ctx.indexes() != null) {
            List<ExpressionContext> exps = ctx.indexes().expression();
            val = resolveIndexes(val, exps);
        }
        return val;
    }

    // '(' expression ')' indexes?              #expressionExpression
    @Override
    public model.BData visitExpressionExpression(ExpressionExpressionContext ctx) {
        model.BData val = this.visit(ctx.expression());
        if (ctx.indexes() != null) {
            List<ExpressionContext> exps = ctx.indexes().expression();
            val = resolveIndexes(val, exps);
                B.appendOutput(val + " insideinsideinside vse");
        }

//        B.appendOutput(val + "inside vse");
        return val;
    }

//    // Input '(' String? ')'                    #inputExpression
//    @Override
//    public BdData visitInputExpression(InputExpressionContext ctx) {
//        String input = B.getInput();
//        BdData kaonInput = new BdData(input);
//        System.out.println(kaonInput.toString());
//
//
////        TerminalNode inputString = ctx.STRING();
////        try {
////            if (inputString != null) {
////                String text = inputString.getText();
////                text = text.substring(1, text.length() - 1).replaceAll("\\\\(.)", "$1");
////                return new BdData(new String(Files.readAllBytes(Paths.get(text))));
////            } else {
////                BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
////                return new BdData(buffer.readLine());
////            }
////        } catch (IOException e) {
////            throw new RuntimeException(e);
////        }
//
//        return kaonInput;
//    }


    // assignment
    // : Identifier indexes? '=' expression
    // ;
    @Override
    public model.BData visitAssignment(AssignmentContext ctx) {
        if(ctx.getText().contains("pudding()")) {
            model.BData newVal = new model.BData(B.getInput());
            String id = ctx.IDENTIFIER().getText();
            scope.assign(id, newVal);
            return model.BData.VOID;
        } else {
            model.BData newVal = this.visit(ctx.expression());
            if (ctx.indexes() != null) {
                model.BData val = scope.resolve(ctx.IDENTIFIER().getText());
                List<ExpressionContext> exps = ctx.indexes().expression();
                setAtIndex(ctx, exps, val, newVal);
            } else {
                String id = ctx.IDENTIFIER().getText();
                scope.assign(id, newVal);
            }
            return model.BData.VOID;
        }
    }

    // Identifier '(' exprList? ')' #identifierFunctionCall
    @Override
    public model.BData visitIdentifierFunctionCall(IdentifierFunctionCallContext ctx) {
        List<ExpressionContext> params = ctx.exprList() != null ? ctx.exprList().expression() : new ArrayList<ExpressionContext>();
        String id = ctx.IDENTIFIER().getText() + params.size();
        Function function;
        if ((function = functions.get(id)) != null) {
            return function.invoke(params, functions, scope);
        }
        throw new BException(ctx);
    }

    // Println '(' expression? ')'  #printlnFunctionCall
    @Override
    public model.BData visitPrintlnFunctionCall(PrintlnFunctionCallContext ctx) {
            B.appendOutput(this.visit(ctx.expression()).toString());
        return model.BData.VOID;
    }

    // Print '(' expression ')'     #printFunctionCall
    @Override
    public model.BData visitPrintFunctionCall(PrintFunctionCallContext ctx) {
            B.appendOutput(this.visit(ctx.expression()).toString());
        return model.BData.VOID;
    }

    // ifStatement
    //  : ifStat elseIfStat* elseStat? End
    //  ;
    //
    // ifStat
    //  : If expression Do block
    //  ;
    //
    // elseIfStat
    //  : Else If expression Do block
    //  ;
    //
    // elseStat
    //  : Else Do block
    //  ;
    @Override
    public model.BData visitIfStatement(IfStatementContext ctx) {

        // if ...
        if (this.visit(ctx.ifStat().expression()).asBoolean()) {
            return this.visit(ctx.ifStat().block());
        }
        // else if ...
        for (int i = 0; i < ctx.elseIfStat().size(); i++) {
            if (this.visit(ctx.elseIfStat(i).expression()).asBoolean()) {
                return this.visit(ctx.elseIfStat(i).block());
            }
        }

        // else ...
        if (ctx.elseStat() != null) {
            return this.visit(ctx.elseStat().block());
        }

        return model.BData.VOID;
    }

    // block
    // : (statement | functionDecl)* (Return expression)?
    // ;
    @Override
    public model.BData visitBlock(BlockContext ctx) {

        scope = new Scope(scope); // create new local scope
        for (StatementContext sx : ctx.statement()) {
            this.visit(sx);
        }
        ExpressionContext ex;
        if ((ex = ctx.expression()) != null) {
            returnValue.value = this.visit(ex);
            scope = scope.parent();
            throw returnValue;
        }
        scope = scope.parent();
        return model.BData.VOID;
    }

    // forStatement
    // : For Identifier '=' expression To expression OBrace block CBrace
    // ;
    @Override
    public model.BData visitForStatement(ForStatementContext ctx) {
        int start = this.visit(ctx.expression(0)).asDouble().intValue();
        int stop = this.visit(ctx.expression(1)).asDouble().intValue();
        for (int i = start; i <= stop; i++) {
            scope.assign(ctx.IDENTIFIER().getText(), new model.BData(i));
            model.BData returnValue = this.visit(ctx.block());
            if (returnValue != model.BData.VOID) {
                return returnValue;
            }
        }
        return model.BData.VOID;
    }

    // whileStatement
    // : While expression OBrace block CBrace
    // ;
    @Override
    public model.BData visitWhileStatement(WhileStatementContext ctx) {
        while (this.visit(ctx.expression()).asBoolean()) {
            model.BData returnValue = this.visit(ctx.block());
            if (returnValue != model.BData.VOID) {
                return returnValue;
            }
        }
        return model.BData.VOID;
    }

    @Override
    public model.BData visitDoWhileStatement(DoWhileStatementContext ctx) {
        do {
            model.BData returnValue = this.visit(ctx.block());
            if (returnValue != model.BData.VOID) {
                return returnValue;
            }
        } while (this.visit(ctx.expression()).asBoolean());
        return model.BData.VOID;
    }

    @Override
    public model.BData visitTryCatchNullStatement(TryCatchNullStatementContext ctx) {
        try{
            scope = new Scope(scope);
            for(StatementContext sx : ctx.statement()) {
                this.visit(sx);
            }
        } catch(NullPointerException e) {
            scope = new Scope(scope);
            for(StatementContext sx : ctx.statement()) {
                this.visit(sx);
            }
        } finally {
            scope = new Scope(scope);
            for(StatementContext sx : ctx.statement()) {
                this.visit(sx);
            }
        }
        return model.BData.VOID;
    }

    @Override public model.BData visitTryCatchIndexOutOfBoundsStatement(TryCatchIndexOutOfBoundsStatementContext ctx) {
        try {
            scope = new Scope(scope);
            for(StatementContext sx : ctx.statement()) {
                this.visit(sx);
            }
        } catch(IndexOutOfBoundsException e) {
            scope = new Scope(scope);
            for(StatementContext sx : ctx.statement()) {
                this.visit(sx);
            }
        } finally {
            scope = new Scope(scope);
            for(StatementContext sx : ctx.statement()) {
                this.visit(sx);
            }
        }

        return model.BData.VOID;
    }

    @Override public model.BData visitTryCatchDivideByZeroStatement(TryCatchDivideByZeroStatementContext ctx) {
        try{
            scope = new Scope(scope);
            for(StatementContext sx : ctx.statement()) {
                this.visit(sx);
            }
        } catch(ArithmeticException e) {
            scope = new Scope(scope);
            for(StatementContext sx : ctx.statement()) {
                this.visit(sx);
            }
        } finally {
            scope = new Scope(scope);
            for(StatementContext sx : ctx.statement()) {
                this.visit(sx);
            }
        }
        return model.BData.VOID;
    }
}
