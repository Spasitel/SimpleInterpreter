package com.jetbrains.model;

import com.jetbrains.common.Position;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class InterpretationException extends RuntimeException {
    private final String message;
    private final Position position;

    public InterpretationException(String message, Token symbol) {
        this.message = message;
        this.position = new Position(symbol);
    }

    public InterpretationException(String message, ParserRuleContext context) {
        this.message = message;
        this.position = new Position(context);
    }

    @Override
    public String getMessage() {
        return message;
    }

    Position getPosition() {
        return position;
    }
}
