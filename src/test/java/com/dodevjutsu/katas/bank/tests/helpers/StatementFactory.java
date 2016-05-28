package com.dodevjutsu.katas.bank.tests.helpers;

import com.dodevjutsu.katas.bank.Statement;
import com.dodevjutsu.katas.bank.StatementLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StatementFactory {

    public static Statement aStatementContaining(StatementLine... statementLines) {
        return new Statement(Arrays.asList(statementLines));
    }

    public static Statement aStatementContaining(StatementLineBuilder... statementLineBuilders) {
        List<StatementLine> statementLines = Arrays.asList(statementLineBuilders).stream()
            .map(statementLineBuilder -> statementLineBuilder.build())
            .collect(Collectors.toList());
        return new Statement(statementLines);
    }

    public static Statement anEmptyStatement() {
        return new Statement(new ArrayList<>());
    }

    public static Statement anyStatement() {
        return anEmptyStatement();
    }
}
