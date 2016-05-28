package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.Date;
import com.dodevjutsu.katas.bank.Transaction;
import org.junit.Test;

import static com.dodevjutsu.katas.bank.tests.helpers.StatementLineBuilder.aStatementLine;
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
            is(aStatementLine().from(transactionDate)
                .ofAmount(transactionAmount)
                .andBalance(2500).build()
            )
        );
    }
}
