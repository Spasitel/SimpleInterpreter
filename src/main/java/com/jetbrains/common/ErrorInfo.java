package com.jetbrains.common;

import java.util.Optional;

/**
 * TODO
 */
public class ErrorInfo {
    private final String msg;
    private final Position position;

    public ErrorInfo(String msg, Position position) {
        this.msg = msg;
        this.position = position;
    }

    public ErrorInfo(String msg) {
        this.msg = msg;
        this.position = null;
    }

    public Optional<Position> getPosition() {
        return Optional.ofNullable(position);
    }

    public String getMsg() {
        return msg;
    }
}
