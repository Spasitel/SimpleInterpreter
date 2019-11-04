package com.jetbrains.model;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class InterpretationException extends RuntimeException {
    private final String msg;
    private final Integer line;
    private final int startIndex;
    private final int stopIndex;

    public InterpretationException(String msg, Token symbol) {
        this.msg = msg;
        this.line = symbol.getLine();
        this.startIndex = symbol.getStartIndex();
        this.stopIndex = symbol.getStopIndex();
    }

    public InterpretationException(String msg, ParserRuleContext context) {
        this.msg = msg;
        this.line = context.getStart().getLine();
        this.startIndex = context.getStart().getStartIndex();
        this.stopIndex = context.getStop().getStopIndex();
    }

    @Override
    public String getMessage() {
        return msg + " at " + line + " : " + startIndex + "-" + stopIndex;
    }

    String getMsg() {
        return msg;
    }

    Integer getLine() {
        return line;
    }

    int getStartIndex() {
        return startIndex;
    }

    int getStopIndex() {
        return stopIndex;
    }
}
