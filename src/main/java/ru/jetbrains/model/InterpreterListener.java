package ru.jetbrains.model;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import ru.jetbrains.model.antlrGen.SimpleBaseListener;
import ru.jetbrains.model.antlrGen.SimpleParser;
import ru.jetbrains.model.data.BinaryLambda;
import ru.jetbrains.model.data.Numerical;
import ru.jetbrains.model.data.UnaryLambda;
import ru.jetbrains.model.state.Context;
import ru.jetbrains.model.state.ProgramState;

//TODO change to SimpleListener
public class InterpreterListener extends SimpleBaseListener {

    private ProgramState state;

    public InterpreterListener(ProgramState state) {
        this.state = state;
    }

    /*
    Special cases
     */
    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        System.out.println("Enter " + ctx.getClass().getSimpleName());
        //TODO remove
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        System.out.println("Exit " + ctx.getClass().getSimpleName());
        //TODO remove
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        super.visitErrorNode(node);
        //TODO: exception handle
    }

    /*

     */

    @Override
    public void enterConstant(SimpleParser.ConstantContext ctx) {
        //nothing to do
    }

    @Override
    public void exitConstant(SimpleParser.ConstantContext ctx) {
        double value = Double.parseDouble(ctx.CONST().getSymbol().getText());
        Context peek = state.getASTStack().peek();
        switch (peek.getReturnType()) {
            case NUMERICAL:
                peek.accept(new Numerical(value));
                break;
            case UNARY_LAMBDA:
                peek.accept(new UnaryLambda(x -> value));
                break;
            case BINARY_LAMBDA:
                peek.accept(new BinaryLambda((x, y) -> value));
                break;
            default:
                throw new IllegalStateException();
        }
    }

    @Override
    public void enterAtom(SimpleParser.AtomContext ctx) {
        state.getASTStack().push(state.getASTStack().peek().createSimilarTemplate());
    }

    @Override
    public void exitAtom(SimpleParser.AtomContext ctx) {
        //TODO
    }

    //TODO all operations
}
