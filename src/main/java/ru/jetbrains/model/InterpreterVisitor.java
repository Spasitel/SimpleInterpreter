package ru.jetbrains.model;

import ru.jetbrains.model.antlrGen.SimpleBaseVisitor;
import ru.jetbrains.model.antlrGen.SimpleParser;
import ru.jetbrains.model.data.BinaryLambda;
import ru.jetbrains.model.data.Data;
import ru.jetbrains.model.data.Numerical;
import ru.jetbrains.model.data.UnaryLambda;
import ru.jetbrains.model.state.ProgramState;

//TODO change to SimpleVisitor
public class InterpreterVisitor extends SimpleBaseVisitor<Data> {

    private ProgramState state;

    public InterpreterVisitor(ProgramState state) {
        this.state = state;
    }

    @Override
    public Data visitConstant(SimpleParser.ConstantContext ctx) {
        double value = Double.parseDouble(ctx.CONST().getSymbol().getText());

        switch (state.getReturnType().getType()) {
            case NUMERICAL:
                return new Numerical(value);
            case UNARY_LAMBDA:
                return new UnaryLambda(x -> value);
            case BINARY_LAMBDA:
                return new BinaryLambda((x, y) -> value);
            default:
                throw new IllegalStateException();
        }
    }

    //TODO all operations
}
