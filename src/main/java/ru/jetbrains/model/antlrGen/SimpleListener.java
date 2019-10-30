// Generated from C:/workspace/SimpleInterpreter/src/main/resources\Simple.g4 by ANTLR 4.7.2
package ru.jetbrains.model.antlrGen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleParser}.
 */
public interface SimpleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SimpleParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SimpleParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(SimpleParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(SimpleParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(SimpleParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(SimpleParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#out}.
	 * @param ctx the parse tree
	 */
	void enterOut(SimpleParser.OutContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#out}.
	 * @param ctx the parse tree
	 */
	void exitOut(SimpleParser.OutContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(SimpleParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(SimpleParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(SimpleParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(SimpleParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#sequence}.
	 * @param ctx the parse tree
	 */
	void enterSequence(SimpleParser.SequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#sequence}.
	 * @param ctx the parse tree
	 */
	void exitSequence(SimpleParser.SequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#sequence_def}.
	 * @param ctx the parse tree
	 */
	void enterSequence_def(SimpleParser.Sequence_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#sequence_def}.
	 * @param ctx the parse tree
	 */
	void exitSequence_def(SimpleParser.Sequence_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#map}.
	 * @param ctx the parse tree
	 */
	void enterMap(SimpleParser.MapContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#map}.
	 * @param ctx the parse tree
	 */
	void exitMap(SimpleParser.MapContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#unaryLambda}.
	 * @param ctx the parse tree
	 */
	void enterUnaryLambda(SimpleParser.UnaryLambdaContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#unaryLambda}.
	 * @param ctx the parse tree
	 */
	void exitUnaryLambda(SimpleParser.UnaryLambdaContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#reduce}.
	 * @param ctx the parse tree
	 */
	void enterReduce(SimpleParser.ReduceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#reduce}.
	 * @param ctx the parse tree
	 */
	void exitReduce(SimpleParser.ReduceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#binaryLambda}.
	 * @param ctx the parse tree
	 */
	void enterBinaryLambda(SimpleParser.BinaryLambdaContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#binaryLambda}.
	 * @param ctx the parse tree
	 */
	void exitBinaryLambda(SimpleParser.BinaryLambdaContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#numerical}.
	 * @param ctx the parse tree
	 */
	void enterNumerical(SimpleParser.NumericalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#numerical}.
	 * @param ctx the parse tree
	 */
	void exitNumerical(SimpleParser.NumericalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#multiplyingExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyingExpression(SimpleParser.MultiplyingExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#multiplyingExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyingExpression(SimpleParser.MultiplyingExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#powExpression}.
	 * @param ctx the parse tree
	 */
	void enterPowExpression(SimpleParser.PowExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#powExpression}.
	 * @param ctx the parse tree
	 */
	void exitPowExpression(SimpleParser.PowExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#signedAtom}.
	 * @param ctx the parse tree
	 */
	void enterSignedAtom(SimpleParser.SignedAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#signedAtom}.
	 * @param ctx the parse tree
	 */
	void exitSignedAtom(SimpleParser.SignedAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(SimpleParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(SimpleParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(SimpleParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(SimpleParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(SimpleParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(SimpleParser.ConstantContext ctx);
}