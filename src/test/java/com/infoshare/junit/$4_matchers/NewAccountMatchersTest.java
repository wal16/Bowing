package com.infoshare.junit.$4_matchers;

import com.infoshare.junit.banking.Account;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class NewAccountMatchersTest {

    private Account emptyAccount;

    @Before
    public void setUp() throws Exception {
        emptyAccount = new Account("Erich Gamma");
    }

    @Test
    public void new_account_should_have_empty_history_1() {
        assertThat(emptyAccount.history(), hasSize(0));
    }

    @Test
    public void new_account_should_have_empty_history_2() {
        assertThat(emptyAccount.history(), is(empty()));
    }

}
