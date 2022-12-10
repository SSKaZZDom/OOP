package calculator;

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
     *    List = [Element(true, 4.0), Element(false, 1.0), Element(false, 1.0)]
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
        double func;
        double num1;
        double num2;
        if (check(list)) {
            while (list.size() > 1) {
                for (int i = 0; i < list.size() - 2; i++) {
                    if (list.get(i).flag()) {
                        if (list.get(i).num() < 3) {
                            if (!list.get(i + 1).flag()) {
                                elem = unaryFunction(list.get(i).num(), list.get(i + 1).num());
                                list.set(i + 1, new Element(false, elem));
                                rem.add(i);
                                i++;
                            }
                        } else {
                            if (!list.get(i + 1).flag() && !list.get(i + 2).flag()) {
                                func = list.get(i).num();
                                num1 = list.get(i + 1).num();
                                num2 = list.get(i + 2).num();
                                elem = binaryFunction(func, num1, num2);
                                list.set(i + 1, new Element(false, elem));
                                rem.add(i);
                                rem.add(i + 2);
                                i += 2;
                            }
                        }
                    }
                }
                if (list.get(list.size() - 2).flag() && !list.get(list.size() - 1).flag()) {
                    func = list.get(list.size() - 2).num();
                    num1 = list.get(list.size() - 1).num();
                    elem = unaryFunction(func, num1);
                    list.set(list.size() - 1, new Element(false, elem));
                    rem.add(list.size() - 2);
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
        List<String> funcs = new ArrayList<>();
        funcs.add("sin");
        funcs.add("cos");
        funcs.add("sqrt");
        funcs.add("+");
        funcs.add("-");
        funcs.add("/");
        funcs.add("*");
        funcs.add("log");
        funcs.add("pow");
        String sub = "";
        double elem;
        int index;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                sub += str.charAt(i);
            } else if (!sub.equals("")) {
                index = funcs.indexOf(sub);
                if (index != -1) {
                    result.add(new Element(true, index));
                } else {
                    try {
                        elem = Double.parseDouble(sub);
                        result.add(new Element(false, elem));
                    } catch (NumberFormatException e) {
                        System.out.println("NumberFormatException: " + e.getMessage());
                    }
                }
                sub = "";
            }
        }
        if (sub != "") {
            index = funcs.indexOf(sub);
            if (index != -1) {
                result.add(new Element(true, index));
            } else {
                try {
                    elem = Double.parseDouble(sub);
                    result.add(new Element(false, elem));
                } catch (NumberFormatException e) {
                    System.out.println("NumberFormatException: " + e.getMessage());
                }
            }
        }
        return result;
    }

    private double unaryFunction(double func, double num) {
        return switch ((int) func) {
            case 0 -> Math.sin(num);
            case 1 -> Math.cos(num);
            default -> Math.sqrt(num);
        };
    }

    private double binaryFunction(double func, double num1, double num2) {
        return switch ((int) func) {
            case 3 -> num1 + num2;
            case 4 -> num1 - num2;
            case 5 -> num1 / num2;
            case 6 -> num1 * num2;
            case 7 -> Math.log(num2) / Math.log(num1);
            default -> Math.pow(num1, num2);
        };
    }

    private boolean check(List<Element> list) {
        int cntBin = 0;
        int cntNum = 0;
        for (Element element : list) {
            if (!element.flag()) {
                cntNum++;
            } else if (element.num() >= 3) {
                cntBin++;
            }
        }
        if (list.get(list.size() - 1).flag() && !list.get(0).flag()) {
            return false;
        }
        return cntBin == cntNum - 1;
    }
}
