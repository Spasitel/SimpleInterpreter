// Generated from C:/workspace/SimpleInterpreter/src/main/resources\simple.g4 by ANTLR 4.7.2
package ru.jetbrains.antlr.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link simpleParser}.
 */
public interface simpleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link simpleParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(simpleParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(simpleParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(simpleParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(simpleParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(simpleParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(simpleParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#out}.
	 * @param ctx the parse tree
	 */
	void enterOut(simpleParser.OutContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#out}.
	 * @param ctx the parse tree
	 */
	void exitOut(simpleParser.OutContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(simpleParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(simpleParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(simpleParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(simpleParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#sequence}.
	 * @param ctx the parse tree
	 */
	void enterSequence(simpleParser.SequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#sequence}.
	 * @param ctx the parse tree
	 */
	void exitSequence(simpleParser.SequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#sequence_def}.
	 * @param ctx the parse tree
	 */
	void enterSequence_def(simpleParser.Sequence_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#sequence_def}.
	 * @param ctx the parse tree
	 */
	void exitSequence_def(simpleParser.Sequence_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#map}.
	 * @param ctx the parse tree
	 */
	void enterMap(simpleParser.MapContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#map}.
	 * @param ctx the parse tree
	 */
	void exitMap(simpleParser.MapContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#reduce}.
	 * @param ctx the parse tree
	 */
	void enterReduce(simpleParser.ReduceContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#reduce}.
	 * @param ctx the parse tree
	 */
	void exitReduce(simpleParser.ReduceContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#numerical}.
	 * @param ctx the parse tree
	 */
	void enterNumerical(simpleParser.NumericalContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#numerical}.
	 * @param ctx the parse tree
	 */
	void exitNumerical(simpleParser.NumericalContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#multiplyingExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyingExpression(simpleParser.MultiplyingExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#multiplyingExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyingExpression(simpleParser.MultiplyingExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#powExpression}.
	 * @param ctx the parse tree
	 */
	void enterPowExpression(simpleParser.PowExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#powExpression}.
	 * @param ctx the parse tree
	 */
	void exitPowExpression(simpleParser.PowExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#signedAtom}.
	 * @param ctx the parse tree
	 */
	void enterSignedAtom(simpleParser.SignedAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#signedAtom}.
	 * @param ctx the parse tree
	 */
	void exitSignedAtom(simpleParser.SignedAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(simpleParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(simpleParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(simpleParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(simpleParser.VariableContext ctx);
}