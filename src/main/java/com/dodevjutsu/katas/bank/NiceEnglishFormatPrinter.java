package com.dodevjutsu.katas.bank;

import java.util.List;

public class NiceEnglishFormatPrinter implements Printer {
    private final Console console;

    public NiceEnglishFormatPrinter(Console console) {
        this.console = console;
    }

    @Override
    public void printStatement(Statement statement) {
        printHeader();
        printLines(statement.linesInReverseOrder());
    }

    private void printHeader() {
        console.print(NiceEnglishFormat.STATEMENT_HEADER);
    }

    private void printLines(List<StatementLine> reversed) {
        reversed.stream()
            .map(statementLine -> NiceEnglishFormat.format(statementLine))
            .forEach(line -> console.print(line));
    }

    private static class NiceEnglishFormat {
        static final String STATEMENT_HEADER = "date || credit || debit || balance";

        public static String format(StatementLine statementLine) {
            return String.format(
                lineFormat(statementLine),
                formatDateOf(statementLine),
                formatAmountOf(statementLine),
                formatBalanceOf(statementLine)
            );
        }

        private static String lineFormat(StatementLine statementLine) {
            if (statementLine.isDebit()) {
                return "%s || || %s || %s";
            }
            return "%s || %s || || %s";
        }

        private static String formatBalanceOf(StatementLine statementLine) {
            return String.format("%d.00", statementLine.balance());
        }

        private static String formatAmountOf(StatementLine statementLine) {
            return String.format("%d.00", Math.abs(statementLine.amount()));
        }

        private static String formatDateOf(StatementLine statementLine) {
            return String.format("%s/%s/%s", statementLine.day(), statementLine.month(), statementLine.year());
        }
    }
}
