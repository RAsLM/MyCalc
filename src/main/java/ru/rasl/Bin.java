package ru.rasl;

import java.io.IOException;

public class Bin {
    public static void main(String[] args) throws IOException {
        Console console = new Console();
        console.consoleWriter(Constant.GREETING);
        console.consoleReader();
    }
}
