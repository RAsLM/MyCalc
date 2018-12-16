package ru.rasl;

import static ru.rasl.Constant.*;

import java.io.IOException;
/**
 * My java implementation calculator.
 * @author Aslanov Ruslan (RAsl)
 * Main class
 */
public class Calc {
    public static void main(String[] args) throws IOException {
        Console console = new Console();
        CalcLogic calcLogic = new CalcLogic();
        console.write(GREETING);
        console.write(SupportedOperations);
        console.write(EnterExpression);
        String value = console.read();
        console.write(ExpressionResult);
        console.write(Double.toString(calcLogic.RPNtoAnswer(calcLogic.infixToRPN(value))));
    }
}
