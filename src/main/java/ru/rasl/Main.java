package ru.rasl;

import java.io.IOException;

public class Main {
    static Console console = new Console();
    static int firstNumber;
    static int secondNumber;
    static  String mathOperation;

    public static void main(String[] args) throws IOException {
        console.write(Constant.GREETING);
        console.read();
    }
}
