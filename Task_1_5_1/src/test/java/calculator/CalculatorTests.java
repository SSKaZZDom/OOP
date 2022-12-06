package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTests {
    @Test
    public void testUnitMinus(){
        String str = "- 1 1";
        Calculator calc = new Calculator(str);
        double res = calc.calculator();
        Assertions.assertEquals(0.0, res);
    }

    @Test
    public void testUnitPlus(){
        String str = "+ 1 1";
        Calculator calc = new Calculator(str);
        double res = calc.calculator();
        Assertions.assertEquals(2.0, res);
    }

    @Test
    public void testUnitDivision(){
        String str = "/ 1 1";
        Calculator calc = new Calculator(str);
        double res = calc.calculator();
        Assertions.assertEquals(1.0, res);
    }

    @Test
    public void testUnitMultiplication(){
        String str = "* 2 2";
        Calculator calc = new Calculator(str);
        double res = calc.calculator();
        Assertions.assertEquals(4.0, res);
    }

    @Test
    public void testUnitLog(){
        String str = "log 2 8";
        Calculator calc = new Calculator(str);
        double res = calc.calculator();
        Assertions.assertEquals(3.0, res);
    }

    @Test
    public void testUnitPow(){
        String str = "pow 2 3";
        Calculator calc = new Calculator(str);
        double res = calc.calculator();
        Assertions.assertEquals(8.0, res);
    }

    @Test
    public void testUnitSin(){
        String str = "sin 0";
        Calculator calc = new Calculator(str);
        double res = calc.calculator();
        Assertions.assertEquals(0.0, res);
    }

    @Test
    public void testUnitCos(){
        String str = "cos 0";
        Calculator calc = new Calculator(str);
        double res = calc.calculator();
        Assertions.assertEquals(1.0, res);
    }

    @Test
    public void testUnitSqrt(){
        String str = "sqrt 9";
        Calculator calc = new Calculator(str);
        double res = calc.calculator();
        Assertions.assertEquals(3.0, res);
    }

    @Test
    public void testFromTask() {
        String str = "sin + - 1 2 1";
        Calculator calc = new Calculator(str);
        double res = calc.calculator();
        Assertions.assertEquals(0.0, res);
    }
}
