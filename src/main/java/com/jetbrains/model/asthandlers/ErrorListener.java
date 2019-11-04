package com.jetbrains.model.asthandlers;

import com.jetbrains.common.ErrorInfo;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class ErrorListener implements ANTLRErrorListener {
    private final Logger logger = LoggerFactory.getLogger(ErrorListener.class);
    private final List<ErrorInfo> errors = new ArrayList<>();

    public List<ErrorInfo> getErrors() {
        return errors;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
                            String msg, RecognitionException e) {
        logger.error("Syntax error in {},{} : {}", line, charPositionInLine, msg);

        int stopIndex = 0;
        if (offendingSymbol instanceof Token) {
            stopIndex = ((Token) offendingSymbol).getStopIndex();
        }

        errors.add(new ErrorInfo(msg, line, charPositionInLine, stopIndex));
    }

    @Override
    public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact,
                                BitSet ambigAlts, ATNConfigSet configs) {
        logger.error("Ambiguity. start {}, stop {}", startIndex, stopIndex);
        errors.add(new ErrorInfo("Internal error: Ambiguity"));
    }

    @Override
    public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex,
                                            BitSet conflictingAlts, ATNConfigSet configs) {
        logger.error("AttemptingFullContext. start {}, stop {}", startIndex, stopIndex);
        errors.add(new ErrorInfo("Internal error: AttemptingFullContext"));
    }

    @Override
    public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction,
                                         ATNConfigSet configs) {
        logger.error("ContextSensitivity. start {}, stop {}", startIndex, stopIndex);
        errors.add(new ErrorInfo("Internal error: ContextSensitivity"));
    }
}
