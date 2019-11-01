package ru.jetbrains.model;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import ru.jetbrains.model.antlrGen.SimpleLexer;
import ru.jetbrains.model.antlrGen.SimpleParser;
import ru.jetbrains.model.state.ProgramResult;
import ru.jetbrains.model.state.ProgramState;

public class Interpreter {

    public ProgramResult process(String prog) {
        CharStream input = CharStreams.fromString(prog);
        SimpleLexer lex = new SimpleLexer(input); // transforms characters into tokens
        lex.removeErrorListeners();
        CommonTokenStream tokens = new CommonTokenStream(lex); // a token stream
        SimpleParser parser = new SimpleParser(tokens); // transforms tokens into parse trees
        parser.removeErrorListeners();

        ErrorListener errorListener = new ErrorListener();
        parser.addErrorListener(errorListener);

        SimpleParser.ProgramContext tree = parser.program();

        if (!errorListener.getErrors().isEmpty()) {
            ProgramResult programResult = new ProgramResult();
            programResult.getErrors().addAll(errorListener.getErrors());
            return programResult;
        }

        ProgramState programState = new ProgramState();
        InterpreterVisitor interpreterVisitor = new InterpreterVisitor(programState);
        interpreterVisitor.visit(tree);

        return programState.getResult();
    }
}
