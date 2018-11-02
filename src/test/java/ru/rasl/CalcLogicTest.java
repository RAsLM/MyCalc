package ru.rasl;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalcLogicTest {
    @Test
    public void setValue() {

    }

    @Test
    public void infixToRPNTest() {
        CalcLogic calcLogic = new CalcLogic();

        List<String> expressions = Arrays.asList(
                "2+2*2"
        );
        System.out.println(expressions.toString());

        for (String expression : expressions) {
            calcLogic.infixToRPN(expression);
        }

        List<String> expecteds = Arrays.asList(
                "2, 2, 2, *, +"
        );
        for (int i = 0; i < expressions.size(); i++) {
            Assert.assertEquals(expecteds.get(i), calcLogic.infixToRPN(expressions.get(i)));
        }


    }

    @Test
    public void RPNtoAnswer() {
    }
}
