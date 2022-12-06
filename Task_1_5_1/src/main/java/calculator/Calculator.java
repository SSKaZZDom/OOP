package calculator;

import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class Calculator {
    String str;
    public Calculator (String str) {
        this.str = str;
    }
    public double calculator() {
        List<Element> list = new ArrayList<>(parse(str));
        List<Integer> rem = new ArrayList<>();
        double elem;
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
                                elem = binaryFunction(list.get(i).num(), list.get(i + 1).num(), list.get(i + 2).num());
                                list.set(i + 1, new Element(false, elem));
                                rem.add(i);
                                rem.add(i + 2);
                                i += 2;
                            }
                        }
                    }
                }
                if (list.get(list.size() - 2).flag() && !list.get(list.size() - 1).flag()) {
                    elem = unaryFunction(list.get(list.size() - 2).num(), list.get(list.size() - 1).num());
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
            return 2134213432;
        }
    }

    private List<Element> parse (String str) {
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
        if(sub != "") {
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

    private double unaryFunction (double func, double num) {
        return switch ((int)func) {
            case 0 -> Math.sin(num);
            case 1 -> Math.cos(num);
            default -> Math.sqrt(num);
        };
    }

    private double binaryFunction (double func, double num1, double num2) {
        return switch ((int)func) {
            case 3 -> num1 + num2;
            case 4 -> num1 - num2;
            case 5 -> num1 / num2;
            case 6 -> num1 * num2;
            case 7 -> Math.log(num2) / Math.log(num1);
            default -> Math.pow(num1, num2);
        };
    }

    private boolean check (List<Element> list) {
        int cntBin = 0;
        int cntNum = 0;
        for (Element element : list) {
            if (!element.flag()) {
                cntNum++;
            } else if (element.num() >= 3) {
                cntBin++;
            }
        }
        return cntBin == cntNum - 1;
    }
}
