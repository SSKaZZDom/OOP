package calculator;

/**
 * Element of list-result of parsing.
 */
public abstract class Element {
    abstract ElementFunc.Func func();

    abstract double num();
}
