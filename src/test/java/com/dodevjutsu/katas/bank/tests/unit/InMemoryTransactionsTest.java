package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.Calendar;
import com.dodevjutsu.katas.bank.InMemoryTransactions;
import com.dodevjutsu.katas.bank.Transactions;

public class InMemoryTransactionsTest extends TransactionsTest {
    @Override
    protected Transactions getImplementationUsing(Calendar calendar) {
        return new InMemoryTransactions(calendar);
    }
}
