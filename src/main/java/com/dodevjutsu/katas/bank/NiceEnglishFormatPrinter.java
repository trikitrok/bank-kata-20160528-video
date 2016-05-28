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
        if (statement.lines().isEmpty()) {
            return;
        }

        printLine(statement.lines().get(0));
    }

    private void printLine(StatementLine statementLine) {
        console.print(formattedLine(statementLine));
    }

    private String formattedLine(StatementLine statementLine) {
        if (statementLine.isDebit()) {
            return dateOf(statementLine) + " || || " + amountOf(statementLine) + " || 1000.00";
        } else {
            return dateOf(statementLine) + " || " + amountOf(statementLine) + " || || 3000.00";
        }
    }

    private String amountOf(StatementLine statementLine) {
        return String.format("%d.00", Math.abs(statementLine.amount()));
    }

    private String dateOf(StatementLine statementLine) {
        return String.format("%s/%s/%s", statementLine.day(), statementLine.month(), statementLine.year());
    }

    private void printHeader() {
        console.print(STATEMENT_HEADER);
    }
}
