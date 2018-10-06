package ru.rasl;
import static ru.rasl.Constant.*;

import java.io.IOException;

public class Calc {
    public static void main(String[] args) throws IOException {
        Console console = new Console();
        CalcLogic calcLogic = new CalcLogic();
        console.write(GREETING);
        console.write(EnterExpression);
        calcLogic.setValue(console.read());
        System.out.println(calcLogic.RPNtoAnswer(calcLogic.infixToRPN()));
    }
}
