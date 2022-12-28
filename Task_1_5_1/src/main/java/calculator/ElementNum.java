package calculator;

/**
 * Double Element.
 */
public class ElementNum implements Element {
    double num;

    ElementNum(double num) {
        this.num = num;
    }

    @Override
    public ElementFunc.Func func() {
        return null;
    }

    @Override
    public double num() {
        return num;
    }
}
