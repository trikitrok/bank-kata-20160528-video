package com.dodevjutsu.katas.bank.tests.helpers;

import com.dodevjutsu.katas.bank.Date;
import com.dodevjutsu.katas.bank.StatementLine;

public class StatementLineBuilder {

    private Date date;
    private int amount;
    private int balance;

    public static StatementLineBuilder aStatementLine() {
        return new StatementLineBuilder();
    }

    public StatementLineBuilder from(String date) {
        this.date = new Date(date);
        return this;
    }

    public StatementLineBuilder ofAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public StatementLineBuilder andBalance(int balance) {
        this.balance = balance;
        return this;
    }

    public StatementLineBuilder from(Date date) {
        this.date = date;
        return this;
    }

    public StatementLine build() {
        return new StatementLine(date, amount, balance);
    }
}
