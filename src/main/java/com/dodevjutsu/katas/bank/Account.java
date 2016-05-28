package com.dodevjutsu.katas.bank;

public class Account {
    private Transactions transactions;
    private Printer printer;

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
        printer.printStatement(transactions.statement());
    }
}
