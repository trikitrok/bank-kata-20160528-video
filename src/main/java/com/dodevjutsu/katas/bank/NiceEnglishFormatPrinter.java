package com.dodevjutsu.katas.bank;

public class NiceEnglishFormatPrinter implements Printer {
    private final Console console;

    public NiceEnglishFormatPrinter(Console console) {
        this.console = console;
    }

    @Override
    public void printStatement(Statement statement) {
        console.print("date || credit || debit || balance");
    }
}
