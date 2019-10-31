package ru.jetbrains.model;

import ru.jetbrains.model.antlrGen.SimpleBaseVisitor;
import ru.jetbrains.model.antlrGen.SimpleParser;
import ru.jetbrains.model.data.BinaryLambda;
import ru.jetbrains.model.data.Data;
import ru.jetbrains.model.data.Numerical;
import ru.jetbrains.model.data.UnaryLambda;
import ru.jetbrains.model.state.ProgramState;

import java.util.function.DoubleBinaryOperator;

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

    @Override
    public Data visitSignedNum(SimpleParser.SignedNumContext ctx) {
        Data child;
        if (ctx.cons != null) {
            child = visit(ctx.cons);
        } else if (ctx.paren != null) {
            child = visit(ctx.paren);
        } else if (ctx.red != null) {
            child = visit(ctx.red);
        } else if (ctx.vari != null) {
            child = visit(ctx.vari);
        } else {
            throw new IllegalStateException();
        }
        if (ctx.sing == null)
            return child;

        assert state.getReturnType().getType().equals(child.getType());
        switch (state.getReturnType().getType()) {
            case NUMERICAL:
                return new Numerical(-getNumericalValue(child));
            case UNARY_LAMBDA:
                return new UnaryLambda(x -> -applyUnary(child, x));
            case BINARY_LAMBDA:
                return new BinaryLambda((x, y) -> -applyBinary(child, x, y));
            default:
                throw new IllegalStateException();
        }
    }

    private double getNumericalValue(Data child) {
        //TODO checks and right exceptions
        return ((Numerical) child).getValue();
    }

    private double applyBinary(Data child, double x, double y) {
        //TODO checks and right exceptions
        return (Double) ((BinaryLambda) child).getOperator().apply(x, y);
    }

    private double applyUnary(Data child, double x) {
        //TODO checks and right exceptions
        return (Double) ((UnaryLambda) child).getOperator().apply(x);
    }

    @Override
    public Data visitOpNum(SimpleParser.OpNumContext ctx) {
        Data left = visit(ctx.left);
        Data right = visit(ctx.right);
        char op = ctx.op.getText().charAt(0);

        final DoubleBinaryOperator operator;

        switch (op) {
            case '^':
                operator = Math::pow;
                break;
            case '*':
                operator = (x, y) -> x * y;
                break;
            case '/':
                operator = (x, y) -> x / y;
                break;
            case '+':
                operator = Double::sum;
                break;
            case '-':
                operator = (x, y) -> x - y;
                break;
            default:
                throw new IllegalStateException();
        }

        switch (state.getReturnType().getType()) {
            case NUMERICAL:
                return new Numerical(operator.applyAsDouble(getNumericalValue(left), getNumericalValue(right)));
            case UNARY_LAMBDA:
                return new UnaryLambda(x -> operator.applyAsDouble(applyUnary(left, x), applyUnary(right, x)));
            case BINARY_LAMBDA:
                return new BinaryLambda(
                        (x, y) -> operator.applyAsDouble(applyBinary(left, x, y), applyBinary(left, x, y)));
            default:
                throw new IllegalStateException();
        }
    }

    //TODO all operations
}
