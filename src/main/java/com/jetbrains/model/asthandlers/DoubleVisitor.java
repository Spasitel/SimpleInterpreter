package com.jetbrains.model.asthandlers;

import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Visitor for AST nodes which return double value
 */
public interface DoubleVisitor {
    double visitDouble(ParseTree tree);
}
