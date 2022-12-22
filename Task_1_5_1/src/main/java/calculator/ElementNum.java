package calculator;

/**
 * Double Element.
 */
public class ElementNum extends Element {
    double num;

    ElementNum(double num) {
        this.num = num;
    }

    @Override
    ElementFunc.Func func() {
        return ElementFunc.Func.DEFAULT;
    }

    @Override
    double num() {
        return num;
    }
}
