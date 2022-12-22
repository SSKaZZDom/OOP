package calculator;

/**
 * Function Element.
 */
public class ElementFunc extends Element{
    enum Func {
        LOG,
        SIN,
        COS,
        SQRT,
        MINUS,
        PLUS,
        MULT,
        DIV,
        POW,
        DEFAULT
    }
    Func func;
    ElementFunc(Func func) {
        this.func = func;
    }
    @Override
    Func func() {
        return func;
    }

    @Override
    double num() {
        return -234;
    }
}
