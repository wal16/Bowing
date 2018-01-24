package com.infoshare.junit.$3_basic_asserts;

import com.infoshare.junit.banking.Account;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class NewAccountTest {

    private Account emptyAccount;

    @Before
    public void setUp() throws Exception {
        emptyAccount = new Account("Erich Gamma");
    }

    @Test
    public void new_account_should_have_empty_history_1() {
        // TODO use assertSame, assertEquals, assertArrayEquals, assertTrue
        fail();
    }

    @Test
    public void new_account_should_have_empty_history_2() {
        // TODO use assertSame, assertEquals, assertArrayEquals, assertTrue
        fail();
    }

    @Test
    public void new_account_should_have_empty_history_3() {
        // TODO use assertSame, assertEquals, assertArrayEquals, assertTrue
        fail();
    }

    @Test
    public void new_account_should_have_empty_history_4() {
        // TODO use assertSame, assertEquals, assertArrayEquals, assertTrue
        fail();
    }

}
