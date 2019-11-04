package com.jetbrains.model;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class InterpreterException extends RuntimeException {
    private final String msg;
    private final Integer line;
    private final int startIndex;
    private final int stopIndex;

    public InterpreterException(String msg, Token symbol) {
        this.msg = msg;
        this.line = symbol.getLine();
        this.startIndex = symbol.getStartIndex();
        this.stopIndex = symbol.getStopIndex();
    }

    public InterpreterException(String msg, ParserRuleContext context) {
        this.msg = msg;
        this.line = context.getStart().getLine();
        this.startIndex = context.getStart().getStartIndex();
        this.stopIndex = context.getStop().getStopIndex();
    }

    @Override
    public String getMessage() {
        return msg + " at " + line + " : " + startIndex + "-" + stopIndex;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getLine() {
        return line;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getStopIndex() {
        return stopIndex;
    }
}
