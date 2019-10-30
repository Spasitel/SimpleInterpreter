package ru.jetbrains.model.state;

import ru.jetbrains.model.data.Data;
import ru.jetbrains.model.data.DataType;

import java.util.Optional;

/**
 * Context of operation in AST. Content data to calculate result of the operation.
 */
public interface Context {
    //TODO - create different types of contexts

    public void accept(Data data);

    public DataType getReturnType();

    public Optional<String> getFirstLambdaParameter();

    public Optional<String> getSecondLambdaParameter();

    public Context createSimilarTemplate();

}
