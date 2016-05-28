package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.Account;
import com.dodevjutsu.katas.bank.Printer;
import com.dodevjutsu.katas.bank.Transactions;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {

    private Mockery context;
    private Transactions transactions;
    private Printer printer;
    private Account account;

    @Before
    public void setUp() {
        context = new Mockery();
        transactions = context.mock(Transactions.class);
        printer = context.mock(Printer.class);
        account = new Account(transactions, printer);
    }

    @Test
    public void deposits_an_amount() {
        context.checking(new Expectations() {{
            oneOf(transactions).record(500);
        }});

        account.deposit(500);

        context.assertIsSatisfied();
    }

    @Test
    public void withdraws_an_amount() {
        context.checking(new Expectations() {{
            oneOf(transactions).record(-500);
        }});

        account.withdraw(500);

        context.assertIsSatisfied();
    }
}
