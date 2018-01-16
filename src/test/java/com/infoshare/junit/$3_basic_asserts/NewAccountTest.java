package com.infoshare.junit.$3_basic_asserts;

import com.infoshare.junit.banking.Account;
import com.infoshare.junit.banking.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class NewAccountTest {

    private Account emptyAccount;

    @Before
    public void setUp() throws Exception {
        emptyAccount = new Account("Erich Gamma");
    }

    @Test
    public void new_account_should_have_empty_history_1() {
        assertSame(0, emptyAccount.history().size());
    }

    @Test
    public void new_account_should_have_empty_history_2() {
        assertEquals(new HashSet<Transaction>(), emptyAccount.history());
    }

    @Test
    public void new_account_should_have_empty_history_3() {
        assertArrayEquals(new Transaction[]{}, emptyAccount.history().toArray());
    }

    @Test
    public void new_account_should_have_empty_history_4() {
        assertTrue(emptyAccount.history().size() == 0);
    }

}
