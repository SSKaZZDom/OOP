package calculator;

/**
 * Function Element.
 */
public class ElementFunc implements Element {
    enum Func {
        LOG("log"),
        SIN("sin"),
        COS("cos"),
        SQRT("sqrt"),
        MINUS("-"),
        PLUS("+"),
        MULT("*"),
        DIV("/"),
        POW("pow");
        final String str;
        Func(String str) {
            this.str = str;
        }
    }

    Func func;

    ElementFunc(Func func) {
        this.func = func;
    }

    @Override
    public Func func() {
        return func;
    }

    @Override
    public double num() {
        return 0;
    }
}
