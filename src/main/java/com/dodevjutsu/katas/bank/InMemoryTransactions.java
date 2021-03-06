package com.dodevjutsu.katas.bank;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTransactions implements Transactions {
    List<Transaction> transactions = new ArrayList<>();
    private Calendar calendar;

    public InMemoryTransactions(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void record(int amount) {
        transactions.add(new Transaction(calendar.day(), amount));
    }

    @Override
    public Statement statement() {
        int accumulatedBalance = 0;
        List<StatementLine> statementLines = new ArrayList<>();
        for(Transaction transaction : transactions) {
            StatementLine statementLine = transaction.generateStatementLine(accumulatedBalance);
            statementLines.add(statementLine);
            accumulatedBalance = statementLine.balance();
        }
        return new Statement(statementLines);
    }
}
