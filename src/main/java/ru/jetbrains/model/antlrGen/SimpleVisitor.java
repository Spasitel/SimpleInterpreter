// Generated from C:/workspace/SimpleInterpreter/src/main/resources\Simple.g4 by ANTLR 4.7.2
package ru.jetbrains.model.antlrGen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpleParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpleVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimpleParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(SimpleParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(SimpleParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(SimpleParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#out}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOut(SimpleParser.OutContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(SimpleParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(SimpleParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequence(SimpleParser.SequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#sequence_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequence_def(SimpleParser.Sequence_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#map}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMap(SimpleParser.MapContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#unaryLambda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryLambda(SimpleParser.UnaryLambdaContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#reduce}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReduce(SimpleParser.ReduceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#binaryLambda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryLambda(SimpleParser.BinaryLambdaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code signedNum}
	 * labeled alternative in {@link SimpleParser#numerical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedNum(SimpleParser.SignedNumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code opNum}
	 * labeled alternative in {@link SimpleParser#numerical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpNum(SimpleParser.OpNumContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(SimpleParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(SimpleParser.ConstantContext ctx);
}