package com.dodevjutsu.katas.bank.tests.unit;

import com.dodevjutsu.katas.bank.Date;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DateTest {

    private Date date;

    @Before
    public void setUp() throws Exception {
        date = new Date("10-05-2006");
    }

    @Test
    public void day() {
        assertThat(date.day(), is("10"));
    }

    @Test
    public void moth() {
        assertThat(date.month(), is("05"));
    }

    @Test
    public void year() {
        assertThat(date.year(), is("2006"));
    }
}
