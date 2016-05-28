package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.*;
import com.dodevjutsu.katas.bank.tests.helpers.StatementFactory;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

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
        Statement expectedStatement = aStatementContaining(
            new StatementLine(new Date("10-05-2016"), 500, 500),
            new StatementLine(new Date("10-05-2016"), -200, 300)
        );
        context.checking(new Expectations() {{
            exactly(2).of(calendar).day();
            will(onConsecutiveCalls(
                returnValue(new Date("10-05-2016")),
                returnValue(new Date("10-05-2016"))
            ));
        }});

        transactions.record(500);
        transactions.record(-200);

        assertThat(transactions.statement(), is(expectedStatement));

        context.assertIsSatisfied();
    }

    protected abstract Transactions getImplementationUsing(Calendar calendar);
}
