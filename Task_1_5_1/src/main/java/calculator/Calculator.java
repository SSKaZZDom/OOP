package calculator;

import calculator.ElementFunc.Func;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;


/**
 * Class Calculator.
 * Constructor contains string with numbers and prefix functions
 * Single function "calculator" works with this string and return the result
 */
public class Calculator {
    String str;

    public Calculator(String str) {
        this.str = str;
    }

    /**
     * Main function of calculator.
     * Steps:
     * 0) Check for the validity of input string
     * 1) Parse String, for example from "- 1 1" it does list of elements -
     *    List = [ElementFunc(MINUS), ElementNum(1.0), ElementNum(1.0)]
     * 2) Find all actions, which we can do, for example in "sin + - 1 1 sin 0"
     *    on the first iteration we do "- 1 1" and "sin 0"
     *    on the second iteration we do "+ 1 0"
     *    and on the final step we do "sin 1"
     * 3) Return the result as double
     */
    public double calculator() throws IncorrectInputException {
        List<Element> list = new ArrayList<>(parse(str));
        List<Integer> rem = new ArrayList<>();
        double elem;
        Func func;
        double num1;
        double num2;
        if (capitalCheck(list)) {
            while (list.size() > 1) {
                if (iterationCheck(list)) {
                    for (int i = 0; i < list.size() - 2; i++) {
                        func = list.get(i).func();
                        if ((func == Func.SIN
                            || func == Func.COS
                            || func == Func.SQRT)
                            && list.get(i + 1).getClass() == ElementNum.class) {
                            elem = unaryFunction(func, list.get(i + 1).num());
                            list.set(i + 1, new ElementNum(elem));
                            rem.add(i);
                            i++;
                        }
                        if ((func == Func.MINUS
                            || func == Func.PLUS
                            || func == Func.MULT
                            || func == Func.DIV
                            || func == Func.LOG
                            || func == Func.POW)
                            && list.get(i + 1).getClass() == ElementNum.class
                            && list.get(i + 2).getClass() == ElementNum.class) {
                            num1 = list.get(i + 1).num();
                            num2 = list.get(i + 2).num();
                            elem = binaryFunction(func, num1, num2);
                            list.set(i + 1, new ElementNum(elem));
                            rem.add(i);
                            rem.add(i + 2);
                            i += 2;
                        }
                    }
                    if ((list.get(list.size() - 2).func() == Func.SQRT
                        || list.get(list.size() - 2).func() == Func.SIN
                        || list.get(list.size() - 2).func() == Func.COS)
                        && list.get(list.size() - 1).getClass() == ElementNum.class) {
                        func = list.get(list.size() - 2).func();
                        num1 = list.get(list.size() - 1).num();
                        elem = unaryFunction(func, num1);
                        list.set(list.size() - 1, new ElementNum(elem));
                        rem.add(list.size() - 2);
                    }
                } else {
                    throw new IncorrectInputException("Your input string is incorrect");
                }
                for (int i = rem.size() - 1; i >= 0; i--) {
                    list.remove((int) rem.get(i));
                }
                rem.clear();
            }
            return list.get(0).num();
        } else {
            throw new IncorrectInputException("Your input string is incorrect");
        }
    }

    private List<Element> parse(String str) {
        List<Element> result = new ArrayList<>();
        List<String> subs = new ArrayList<>();
        subs.add("sin");
        subs.add("cos");
        subs.add("sqrt");
        subs.add("+");
        subs.add("-");
        subs.add("/");
        subs.add("*");
        subs.add("log");
        subs.add("pow");
        List<Func> funcs = new ArrayList<>();
        funcs.add(Func.SIN);
        funcs.add(Func.COS);
        funcs.add(Func.SQRT);
        funcs.add(Func.PLUS);
        funcs.add(Func.MINUS);
        funcs.add(Func.DIV);
        funcs.add(Func.MULT);
        funcs.add(Func.LOG);
        funcs.add(Func.POW);
        String sub = "";
        double elem;
        int index;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                sub += str.charAt(i);
            } else if (!sub.equals("")) {
                index = subs.indexOf(sub);
                if (index != -1) {
                    result.add(new ElementFunc(funcs.get(index)));
                } else {
                    try {
                        elem = Double.parseDouble(sub);
                        result.add(new ElementNum(elem));
                    } catch (NumberFormatException e) {
                        System.out.println("NumberFormatException: " + e.getMessage());
                    }
                }
                sub = "";
            }
        }
        if (!sub.equals("")) {
            index = subs.indexOf(sub);
            if (index != -1) {
                result.add(new ElementFunc(funcs.get(index)));
            } else {
                try {
                    elem = Double.parseDouble(sub);
                    result.add(new ElementNum(elem));
                } catch (NumberFormatException e) {
                    System.out.println("NumberFormatException: " + e.getMessage());
                }
            }
        }
        return result;
    }

    private double unaryFunction(Func func, double num) throws IncorrectInputException {
        return switch (func) {
            case SIN -> Math.sin(num);
            case COS -> Math.cos(num);
            case SQRT -> Math.sqrt(num);
            default -> throw new IncorrectInputException("Your input string is incorrect");
        };
    }

    private double binaryFunction(Func func, double num1, double num2)
            throws IncorrectInputException {
        return switch (func) {
            case PLUS -> num1 + num2;
            case MINUS -> num1 - num2;
            case DIV -> num1 / num2;
            case MULT -> num1 * num2;
            case LOG -> Math.log(num2) / Math.log(num1);
            case POW -> Math.pow(num1, num2);
            default -> throw new IncorrectInputException("Your input string is incorrect");
        };
    }

    private boolean capitalCheck(List<Element> list) {
        int cntBin = 0;
        int cntNum = 0;
        for (Element element : list) {
            if (element.getClass() == ElementNum.class) {
                cntNum++;
            } else if (element.func() == Func.LOG
                    || element.func() == Func.POW
                    || element.func() == Func.PLUS
                    || element.func() == Func.MINUS
                    || element.func() == Func.MULT
                    || element.func() == Func.DIV) {
                cntBin++;
            }
        }
        return cntBin == cntNum - 1;
    }

    private boolean iterationCheck(List<Element> list) {
        return list.get(list.size() - 1).getClass() == ElementNum.class
                && list.get(0).getClass() == ElementFunc.class;
    }
}
