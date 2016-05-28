package com.dodevjutsu.katas.bank;

import com.dodevjutsu.katas.bank.Calendar;
import com.dodevjutsu.katas.bank.Console;

public class Account {
    private Transactions transactions;
    private Printer printer;

    public Account(Calendar calendar, Console console) {
    }

    public Account(Transactions transactions, Printer printer) {
        this.transactions = transactions;
        this.printer = printer;
    }

    public void deposit(int amount) {
        transactions.record(amount);
    }

    public void withdraw(int amount) {
        transactions.record(-amount);
    }

    public void printStatement() {
        transactions.statement();
    }
}
