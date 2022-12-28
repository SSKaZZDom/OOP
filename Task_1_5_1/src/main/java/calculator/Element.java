package calculator;

/**
 * Element of list-result of parsing.
 */
interface Element {
    ElementFunc.Func func();

    double num();
}
