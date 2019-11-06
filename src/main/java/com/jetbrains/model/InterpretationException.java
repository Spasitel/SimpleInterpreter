package com.jetbrains.model;

import com.jetbrains.common.Position;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class InterpretationException extends RuntimeException {
    private final String msg;
    private final Position position;

    public InterpretationException(String msg, Token symbol) {
        this.msg = msg;
        this.position = new Position(symbol);
    }

    public InterpretationException(String msg, ParserRuleContext context) {
        this.msg = msg;
        this.position = new Position(context);
    }

    @Override
    public String getMessage() {
        return msg;
    }

    String getMsg() {
        return msg;
    }

    Position getPosition() {
        return position;
    }
}
