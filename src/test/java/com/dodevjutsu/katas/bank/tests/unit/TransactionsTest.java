package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.*;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import static com.dodevjutsu.katas.bank.tests.helpers.StatementFactory.aStatementContaining;
import static com.dodevjutsu.katas.bank.tests.helpers.StatementFactory.anEmptyStatement;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

abstract public class TransactionsTest {

    private Mockery context;
    private Transactions transactions;
    private Calendar calendar;

    @Before
    public void setUp() {
        context = new Mockery();
        calendar = context.mock(Calendar.class);
        transactions = getImplementationUsing(calendar);
    }

    @Test
    public void generates_an_empty_account_statement_when_no_transactions_were_recorded() {
        assertThat(transactions.statement(), is(anEmptyStatement()));
    }

    @Test
    public void generates_an_account_statement_containing_all_recorded_transactions() {
        final Date firstTransactionDate = new Date("10-05-2016");
        int firstTransactionAmount = 500;
        final Date secondTransactionDate = new Date("15-05-2016");
        int secondTransactionAmount = -200;
        Statement expectedStatement = aStatementContaining(
            new StatementLine(firstTransactionDate, firstTransactionAmount, 500),
            new StatementLine(secondTransactionDate, secondTransactionAmount, 300)
        );
        context.checking(new Expectations() {{
            exactly(2).of(calendar).day();
            will(onConsecutiveCalls(
                returnValue(firstTransactionDate),
                returnValue(secondTransactionDate)
            ));
        }});

        transactions.record(firstTransactionAmount);
        transactions.record(secondTransactionAmount);

        assertThat(transactions.statement(), is(expectedStatement));

        context.assertIsSatisfied();
    }

    protected abstract Transactions getImplementationUsing(Calendar calendar);
}
