// Generated from C:/workspace/SimpleInterpreter/src/main/resources\Simple.g4 by ANTLR 4.7.2
package com.jetbrains.simpleinterpreter.model.antlrgen;
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
	 * Visit a parse tree produced by the {@code varStmt}
	 * labeled alternative in {@link SimpleParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarStmt(SimpleParser.VarStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code outStmt}
	 * labeled alternative in {@link SimpleParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutStmt(SimpleParser.OutStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printStmt}
	 * labeled alternative in {@link SimpleParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStmt(SimpleParser.PrintStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code reduce}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReduce(SimpleParser.ReduceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parentheses}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentheses(SimpleParser.ParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constant}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(SimpleParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sequenceDef}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequenceDef(SimpleParser.SequenceDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variable}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(SimpleParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code opExpression}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpExpression(SimpleParser.OpExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code map}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMap(SimpleParser.MapContext ctx);
}