package ru.rasl;

import static ru.rasl.Constant.*;

import java.util.*;

public class CalcLogic {

    public List<String> infixToRPN(String value) {
        String expressions = value.replace(" ", "");
        //находим унарный минус в начале строки
        expressions = expressions.replaceAll("^-d*","&");
        //находим унарный минус в конце строки
        expressions = expressions.replaceAll("[(]-","(&");
        String delimiters = "()+-*/&";
        StringTokenizer tokenizer = new StringTokenizer(expressions, delimiters, true);
        List<String> RPN = new ArrayList<>();
        Stack<String> stackOperations = new Stack<String>();
        int priority;
        String curr = "";
        while (tokenizer.hasMoreTokens()){
            curr = tokenizer.nextToken();
            if (!standardOperators.containsKey(curr)) {
                RPN.add(curr);
            } else {
                priority = standardOperators.get(curr);
                if ("(".equals(curr)) {
                    stackOperations.push(curr);
                }
                if (priority > standardOperators.get("(")) {
                    while (!stackOperations.empty()) {
                        if (standardOperators.get(stackOperations.peek()) >= priority) {
                            RPN.add(stackOperations.pop());
                        } else {
                            break;
                        }
                    }
                    stackOperations.push(curr);
                }

                if (")".equals(curr)) {
                    if(!stackOperations.contains("(")){
                        continue;
                    }
                    while (standardOperators.get(stackOperations.peek()) != standardOperators.get("(")) {
                        RPN.add(stackOperations.pop());
                    }
                    stackOperations.pop();
                }
            }
        }

        while (!stackOperations.empty()) {
            RPN.add(stackOperations.pop());
        }
        return RPN;
    }
    public double RPNtoAnswer(List<String> rpn) {
        Stack<Double> stack = new Stack<Double>();
        for (int i = 0; i < rpn.size(); i++) {

            if (!standardOperators.containsKey(rpn.get(i))) {
                stack.push(Double.parseDouble(rpn.get(i)));
            }

            if (standardOperators.containsKey(rpn.get(i)) && standardOperators.get(rpn.get(i)) > standardOperators.get("(")) {
                if(rpn.get(i).equals("&")){
                    double a = stack.pop();
                    stack.push(a*-1);
                    continue;
                }
                double a = stack.pop(), b = stack.pop();
                if (rpn.get(i).equals("+")) {
                    stack.push(a + b);
                }
                if (rpn.get(i).equals("-")) {
                    stack.push(a - b);
                }
                if (rpn.get(i).equals("*")) {
                    stack.push(a * b);
                }
                if (rpn.get(i).equals("/")) {
                    stack.push(b / a);
                }
            }
        }
        return stack.pop();
    }
}

