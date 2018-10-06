package ru.rasl;

import static ru.rasl.Constant.*;

import java.util.Stack;

public class CalcLogic {
    private static String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String infixToRPN() {
        String expressions = value.replace(" ", "");
        String RPN = "";
        Stack<String> stackOperations = new Stack<String>();
        int priority;
        for (int i = 0; i < expressions.length(); i++) {
            if (!standardOperators.containsKey(Character.toString(expressions.charAt(i)))) {
                RPN += expressions.charAt(i);
            } else {
                priority = standardOperators.get(Character.toString(expressions.charAt(i)));
                if (priority == 1) {
                    stackOperations.push(Character.toString(expressions.charAt(i)));
                }
                if (priority > 1) {
                    RPN += ' ';

                    while (!stackOperations.empty()) {
                        if (standardOperators.get(stackOperations.peek()) >= priority) {
                            RPN += stackOperations.pop();
                        } else {
                            break;
                        }
                    }
                    stackOperations.push(Character.toString(expressions.charAt(i)));
                }

                if (priority == -1) {
                    RPN += ' ';
                    while (standardOperators.get(stackOperations.peek()) != 1) {
                        RPN += stackOperations.pop();
                    }
                    stackOperations.pop();
                }

            }
        }
        while (!stackOperations.empty()) {
            RPN += stackOperations.pop();
        }

        return RPN;
    }

    public double RPNtoAnswer(String rpn) {
        String operand = new String();
        Stack<Double> stack = new Stack<Double>();
        for (int i = 0; i < rpn.length(); i++) {
            if (rpn.charAt(i) == ' ') continue;

            if (!standardOperators.containsKey(Character.toString(rpn.charAt(i)))) {
                while (rpn.charAt(i) != ' ' && !standardOperators.containsKey(Character.toString(rpn.charAt(i)))) {
                    operand += rpn.charAt(i++);
                    if (i == rpn.length()) break;
                }
                stack.push(Double.parseDouble(operand));
                operand = new String();
            }

            if (standardOperators.containsKey(Character.toString(rpn.charAt(i))) && standardOperators.get(Character.toString(rpn.charAt(i))) > 1) {
                double a = stack.pop(), b = stack.pop();
                if (rpn.charAt(i) == '+') {
                    stack.push(a + b);
                }
                if (rpn.charAt(i) == '-') {
                    stack.push(a - b);
                }
                if (rpn.charAt(i) == '*') {
                    stack.push(a * b);
                }
                if (rpn.charAt(i) == '/') {
                    stack.push(a / b);
                }
            }
        }
        return stack.pop();
    }
}
