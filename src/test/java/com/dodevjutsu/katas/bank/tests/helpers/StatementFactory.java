package com.dodevjutsu.katas.bank.tests.helpers;

import com.dodevjutsu.katas.bank.Statement;
import com.dodevjutsu.katas.bank.StatementLine;

import java.util.ArrayList;
import java.util.Arrays;

public class StatementFactory {

    public static Statement aStatementContaining(StatementLine... statementLines) {
        return new Statement(Arrays.asList(statementLines));
    }

    public static Statement anEmptyStatement() {
        return new Statement(new ArrayList<>());
    }

    public static Statement anyStatement() {
        return anEmptyStatement();
    }
}
