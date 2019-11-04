package com.jetbrains.common;

import java.util.Optional;

/**
 *
 */
public class ErrorInfo {
    private final String msg;
    private final Integer line;
    private final int startIndex;
    private final int stopIndex;

    public ErrorInfo(String msg, int line, int startIndex, int stopIndex) {
        this.msg = msg;
        this.line = line;
        this.startIndex = startIndex;
        this.stopIndex = Math.max(stopIndex, startIndex);
    }

    public ErrorInfo(String msg) {
        this.msg = msg;
        this.line = null;
        this.startIndex = 0;
        this.stopIndex = 0;
    }

    public Optional<Integer> getLine() {
        return Optional.ofNullable(line);
    }

    public int getStopIndex() {
        return stopIndex;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public String getMsg() {
        return msg;
    }
}
