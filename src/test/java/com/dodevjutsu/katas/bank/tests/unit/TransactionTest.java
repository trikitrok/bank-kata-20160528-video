package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.Date;
import com.dodevjutsu.katas.bank.StatementLine;
import com.dodevjutsu.katas.bank.Transaction;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TransactionTest {

    @Test
    public void generates_statement_line() {
        int accumulatedBalance = 2000;
        int transactionAmount = 500;
        Date transactionDate = new Date("12-04-2005");
        Transaction transaction = new Transaction(transactionDate, transactionAmount);

        assertThat(
            transaction.generateStatementLine(accumulatedBalance),
            is(new StatementLine(transactionDate, transactionAmount, 2500))
        );
    }
}
