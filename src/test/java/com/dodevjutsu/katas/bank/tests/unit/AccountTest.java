package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.Account;
import com.dodevjutsu.katas.bank.Printer;
import com.dodevjutsu.katas.bank.Statement;
import com.dodevjutsu.katas.bank.Transactions;
import com.dodevjutsu.katas.bank.tests.helpers.StatementFactory;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {
    private static final int ANY_AMOUNT = 500;
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
            oneOf(transactions).record(ANY_AMOUNT);
        }});

        account.deposit(ANY_AMOUNT);

        context.assertIsSatisfied();
    }

    @Test
    public void withdraws_an_amount() {
        context.checking(new Expectations() {{
            oneOf(transactions).record(-ANY_AMOUNT);
        }});

        account.withdraw(ANY_AMOUNT);

        context.assertIsSatisfied();
    }

    @Test
    public void a_statement_of_account_transactions_gets_created_for_printing() {
        context.checking(new Expectations() {{
            ignoring(printer);
            oneOf(transactions).statement();
            will(returnValue(with(any(Statement.class))));
        }});

        account.printStatement();

        context.assertIsSatisfied();
    }

    @Test
    public void the_generated_account_transactions_statement_gets_printed() {
        Statement statement = StatementFactory.anyStatement();
        context.checking(new Expectations() {{
            oneOf(transactions).statement();
            will(returnValue(statement));

            oneOf(printer).printStatement(with(same(statement)));
        }});

        account.printStatement();

        context.assertIsSatisfied();
    }
}
