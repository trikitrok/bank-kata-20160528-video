package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.Calendar;
import com.dodevjutsu.katas.bank.Statement;
import com.dodevjutsu.katas.bank.Transactions;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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

    private Statement anEmptyStatement() {
        return new Statement(new ArrayList<>());
    }

    protected abstract Transactions getImplementationUsing(Calendar calendar);
}
