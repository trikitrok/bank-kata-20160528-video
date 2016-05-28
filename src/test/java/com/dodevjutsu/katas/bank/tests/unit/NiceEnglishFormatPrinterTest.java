package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.*;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import static com.dodevjutsu.katas.bank.tests.helpers.StatementFactory.aStatementContaining;
import static com.dodevjutsu.katas.bank.tests.helpers.StatementFactory.anEmptyStatement;

public class NiceEnglishFormatPrinterTest {

    private Mockery context;
    private Console console;
    private Printer printer;

    @Before
    public void setUp() {
        context = new Mockery();
        console = context.mock(Console.class);
        printer = new NiceEnglishFormatPrinter(console);
    }

    @Test
    public void prints_only_the_header_when_the_statement_is_empty() {
        context.checking(new Expectations() {{
            oneOf(console).print("date || credit || debit || balance");
        }});

        printer.printStatement(anEmptyStatement());

        context.assertIsSatisfied();
    }

    @Test
    public void prints_a_statement_containing_a_debit_line() {
        context.checking(new Expectations() {{
            oneOf(console).print("date || credit || debit || balance");
            oneOf(console).print("14/01/2012 || || 600.00 || 1000.00");
        }});

        printer.printStatement(
            aStatementContaining(
                new StatementLine(new Date("14-01-2012"), -600, 1000)
            )
        );

        context.assertIsSatisfied();
    }

    @Test
    public void prints_a_statement_containing_a_credit_line() {
        context.checking(new Expectations() {{
            oneOf(console).print("date || credit || debit || balance");
            oneOf(console).print("14/01/2012 || || 500.00 || 2500.00");
            oneOf(console).print("13/01/2012 || 2000.00 || || 3000.00");
        }});

        printer.printStatement(
            aStatementContaining(
                new StatementLine(new Date("13-01-2012"), 2000, 3000),
                new StatementLine(new Date("14-01-2012"), -500, 2500)
            )
        );

        context.assertIsSatisfied();
    }

    @Test
    public void prints_a_statement_containing_a_debit_and_a_credit_line_in_reverse_order() {
        context.checking(new Expectations() {{
            oneOf(console).print("date || credit || debit || balance");
            oneOf(console).print("13/01/2012 || 2000.00 || || 3000.00");
        }});

        printer.printStatement(
            aStatementContaining(
                new StatementLine(new Date("13-01-2012"), 2000, 3000)
            )
        );

        context.assertIsSatisfied();
    }
}
