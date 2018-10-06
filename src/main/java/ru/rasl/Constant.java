package ru.rasl;

import java.util.HashMap;
import java.util.Map;

public class Constant {
    static final String GREETING = "<=== Консольный калькулятор ===> \nЭто простой колькулятор без графической оболочки";
    static final String EnterExpression = "Введите выражение";
    public static final Map<String, Integer> standardOperators;
    static{
        standardOperators = new HashMap<String, Integer>();
        standardOperators.put("^", 4);
        standardOperators.put("*", 3);
        standardOperators.put("/", 3);
        standardOperators.put("+", 2);
        standardOperators.put("-", 2);
        standardOperators.put("(", 1);
        standardOperators.put(")", -1);
    }
}
