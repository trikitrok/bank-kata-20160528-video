package com.dodevjutsu.katas.bank;

public class Transaction {
    private final Date date;
    private final int amount;

    public Transaction(Date date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
            "date=" + date +
            ", amount=" + amount +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;

        Transaction that = (Transaction) o;

        if (amount != that.amount) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + amount;
        return result;
    }

    public StatementLine generateStatementLine(int accumulatedBalance) {
        return new StatementLine(date, amount, amount + accumulatedBalance);
    }

    public int amount() {
        return amount;
    }
}
