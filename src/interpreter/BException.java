package interpreter;

import org.antlr.v4.runtime.ParserRuleContext;

public class BException extends RuntimeException {
    public BException(ParserRuleContext ctx) {
        this("Illegal expression: " + ctx.getText(), ctx);
    }

    public BException(String msg, ParserRuleContext ctx) {
        super(msg + " line:" + ctx.start.getLine());
    }
}
