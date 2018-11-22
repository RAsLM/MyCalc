package ru.rasl;


import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class CalcLogicTest {

    @Test
    public void infixToRPNTest() {
        CalcLogic calcLogic = new CalcLogic();

        List<String> expressions = Arrays.asList(
                "2+2*2",
                "-2+2*2",
                "234*1+(-3*45)"
        );

        List<String> expecteds = Arrays.asList(
                "[2, 2, 2, *, +]",
                "[2, &, 2, 2, *, +]",
                "[234, 1, *, 3, &, 45, *, +]"
        );
        for (int i = 0; i < expressions.size(); i++) {
            Assert.assertEquals(expecteds.get(i), calcLogic.infixToRPN(expressions.get(i)).toString());
        }


    }

    @Test
    public void RPNtoAnswerTest() {
        CalcLogic calcLogic = new CalcLogic();

        List<String> list = Arrays.asList(
                "2, 2, 2, *, +",
                "2, &, 2, 2, *, +",
                "234, 1, *, 3, &, 45, *, +"
        );
        System.out.println(list.get(0));
        List<List<String>> expressions = new ArrayList<>(Arrays.asList(list));
        List<Double> expecteds = Arrays.asList(
                1.0,
                2.0,
                3.0
        );
        for (List s: expressions) {
            System.out.println(s.toString());
        }
    }
}
