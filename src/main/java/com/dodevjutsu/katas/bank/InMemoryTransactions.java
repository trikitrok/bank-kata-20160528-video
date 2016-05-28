package com.dodevjutsu.katas.bank;

import java.util.ArrayList;

public class InMemoryTransactions implements Transactions {
    public InMemoryTransactions(Calendar calendar) {
    }

    @Override
    public void record(int amount) {

    }

    @Override
    public Statement statement() {
        return new Statement(new ArrayList<>());
    }
}
