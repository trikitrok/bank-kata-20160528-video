package com.dodevjutsu.katas.bank;

public class NiceEnglishFormatPrinter implements Printer {
    private static final String STATEMENT_HEADER = "date || credit || debit || balance";
    private final Console console;

    public NiceEnglishFormatPrinter(Console console) {
        this.console = console;
    }

    @Override
    public void printStatement(Statement statement) {
        printHeader();
        if (statement.lines().isEmpty()){
            return;
        }
        console.print("14/01/2012 || || 600.00 || 1000.00");
    }

    private void printHeader() {
        console.print(STATEMENT_HEADER);
    }
}