package com.jetbrains.common;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

/**
 * TODO
 */
public class Position {
    private int startIndex = -1;
    private int line = -1;
    private int positionInLine = -1;
    private int length;

    public Position(int line, int positionInLine) {
        this.line = line;
        this.positionInLine = positionInLine;
        this.length = 1;
    }

    public Position(Token token) {
        startIndex = token.getStartIndex();
        length = token.getStopIndex() - token.getStartIndex() + 1;
    }

    public Position(ParserRuleContext context) {
        startIndex = context.getStart().getStartIndex();
        length = context.getStop().getStopIndex() - startIndex + 1;
    }

    private static int ordinalIndexOf(String str, String substr, int n) {
        int pos = str.indexOf(substr);
        while (--n > 0 && pos != -1)
            pos = str.indexOf(substr, pos + 1);
        return pos;
    }

    public int getStartIndex(String program) {
        if (startIndex >= 0)
            return startIndex;

        int result = ordinalIndexOf(program, "\n", line);
        return result + positionInLine;
    }

    public int getLength() {
        return length;
    }

    public String getLineAndPosition(String program) {
        if (line > -1)
            return (line + 1) + ":" + positionInLine;

        String sub = program.substring(0, startIndex);
        int resultLine = (int) (sub.chars().filter(ch -> ch == '\n').count()) + 1;
        int resultPosition = sub.length() - sub.lastIndexOf('\n');
        return resultLine + ":" + resultPosition;
    }
}

