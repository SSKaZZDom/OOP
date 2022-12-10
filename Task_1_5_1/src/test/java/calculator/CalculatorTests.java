package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test for Calculator.
 * 9 unit tests & 1 test from the example in tasks.
 */
public class CalculatorTests {
    @Test
    public void testUnitMinus() throws IncorrectInputException {
        String str = "- 1 1";
        Calculator calc = new Calculator(str);
        double res = calc.calculator();
        Assertions.assertEquals(0.0, res);
    }

    @Test
    public void testUnitPlus() throws IncorrectInputException {
        String str = "+ 1 1";
        Calculator calc = new Calculator(str);
        double res = calc.calculator();
        Assertions.assertEquals(2.0, res);
    }

    @Test
    public void testUnitDivision() throws IncorrectInputException {
        String str = "/ 1 1";
        Calculator calc = new Calculator(str);
        double res = calc.calculator();
        Assertions.assertEquals(1.0, res);
    }

    @Test
    public void testUnitMultiplication() throws IncorrectInputException {
        String str = "* 2 2";
        Calculator calc = new Calculator(str);
        double res = calc.calculator();
        Assertions.assertEquals(4.0, res);
    }

    @Test
    public void testUnitLog() throws IncorrectInputException {
        String str = "log 2 8";
        Calculator calc = new Calculator(str);
        double res = calc.calculator();
        Assertions.assertEquals(3.0, res);
    }

    @Test
    public void testUnitPow() throws IncorrectInputException {
        String str = "pow 2 3";
        Calculator calc = new Calculator(str);
        double res = calc.calculator();
        Assertions.assertEquals(8.0, res);
    }

    @Test
    public void testUnitSin() throws IncorrectInputException {
        String str = "sin 0";
        Calculator calc = new Calculator(str);
        double res = calc.calculator();
        Assertions.assertEquals(0.0, res);
    }

    @Test
    public void testUnitCos() throws IncorrectInputException {
        String str = "cos 0";
        Calculator calc = new Calculator(str);
        double res = calc.calculator();
        Assertions.assertEquals(1.0, res);
    }

    @Test
    public void testUnitSqrt() throws IncorrectInputException {
        String str = "sqrt 9";
        Calculator calc = new Calculator(str);
        double res = calc.calculator();
        Assertions.assertEquals(3.0, res);
    }

    @Test
    public void testFromTask() throws IncorrectInputException {
        String str = "sin + - 1 2 1";
        Calculator calc = new Calculator(str);
        double res = calc.calculator();
        Assertions.assertEquals(0.0, res);
    }

    @Test
    public void testUnitException() {
        String str = "+ 1 1 1";
        Calculator calc = new Calculator(str);
        try {
            calc.calculator();
        } catch (IncorrectInputException e) {
            Assertions.assertNotEquals("", e.getMessage());
        }
    }
}
