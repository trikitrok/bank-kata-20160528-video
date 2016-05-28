package com.dodevjutsu.katas.bank;

import java.util.List;

public class NiceEnglishFormatPrinter implements Printer {
    private static final String STATEMENT_HEADER = "date || credit || debit || balance";
    private final Console console;

    public NiceEnglishFormatPrinter(Console console) {
        this.console = console;
    }

    @Override
    public void printStatement(Statement statement) {
        printHeader();
        printLines(statement.linesInReverseOrder());
    }

    private void printLines(List<StatementLine> reversed) {
        reversed.stream()
            .map(this::format)
            .forEach(line -> console.print(line));
    }

    private String format(StatementLine statementLine) {
        return String.format(
            lineFormat(statementLine),
            formatDateOf(statementLine),
            formatAmountOf(statementLine),
            formatBalanceOf(statementLine)
        );
    }

    private String lineFormat(StatementLine statementLine) {
        if (statementLine.isDebit()) {
            return "%s || || %s || %s";
        }
        return "%s || %s || || %s";
    }

    private String formatBalanceOf(StatementLine statementLine) {
        return String.format("%d.00", statementLine.balance());
    }

    private String formatAmountOf(StatementLine statementLine) {
        return String.format("%d.00", Math.abs(statementLine.amount()));
    }

    private String formatDateOf(StatementLine statementLine) {
        return String.format("%s/%s/%s", statementLine.day(), statementLine.month(), statementLine.year());
    }

    private void printHeader() {
        console.print(STATEMENT_HEADER);
    }
}
