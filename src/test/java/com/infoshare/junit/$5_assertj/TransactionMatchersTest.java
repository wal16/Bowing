package com.infoshare.junit.$5_assertj;

import com.infoshare.junit.banking.Account;
import com.infoshare.junit.banking.Transaction;
import com.infoshare.junit.banking.TransactionsBuilder;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class TransactionMatchersTest {

    private static final int TRANSACTION_COUNT = 100;

    private static Account account;

    @Before
    public void setUp() throws Exception {
        account = new Account("Kent Beck");
        new TransactionsBuilder()
                .after(LocalDateTime.of(2015, Month.DECEMBER, 1, 0, 0))
                .before(LocalDateTime.of(2016, Month.APRIL, 30, 0, 0))
                .valueBetween(1, 100000)
                .totalOf(TRANSACTION_COUNT)
                .register(account);
    }

    @Test
    public void account_balance_should_be_equal_to_sum_of_transactions() throws Exception {
        Integer historyBalance = sumOfTransactions(account.history());

//         uncomment to see error message
//        account.register(new Transaction(BigDecimal.TEN,LocalDateTime.now()));

        assertEquals(historyBalance, account.getBalance());
        // TODO express assert above using AssertJ
        fail();
    }

    @Test
    public void registering_transaction_should_change_balance_1() throws Exception {
        // given
        Integer originalBalance = account.getBalance();
        // when
        new TransactionsBuilder().value(100).totalOf(1).register(account);
        // then
        assertFalse(account.getBalance().equals(originalBalance));
        // TODO express assert above using AssertJ
        fail();
    }

    @Test
    public void registering_transaction_should_change_balance_2() throws Exception {
        // given
        Integer originalBalance = account.getBalance();
        // when
        new TransactionsBuilder().value(100).totalOf(1).register(account);
        // then
        assertTrue(account.getBalance().doubleValue()>originalBalance.doubleValue());
        // TODO express assert above using AssertJ
        fail();
    }

    @Test
    public void registering_transaction_should_change_history() throws Exception {
        //given
        Set<Transaction> originalHistory = account.history();
        // when
        new TransactionsBuilder().valueBetween(100, 1000).totalOf(1).register(account);
        // then

        assertNotEquals(originalHistory, account.history());
        // TODO express assert above using AssertJ
        // TODO check if every transaction has amount between 100 and 1000
        fail();
    }

    @Test
    public void account_should_not_change_history_without_adding_transaction() {
        // when
        Set<Transaction> historyOne = account.history();
        Set<Transaction> historyTwo = account.history();
        // then
        assertEquals("history shouldn't change", historyOne, historyTwo);
        // TODO express assert above using AssertJ
        fail();
    }

    private Integer sumOfTransactions(Collection<Transaction> transactions) {
        return transactions.stream().collect(Collectors.summingInt(t -> t.getAmount()));
    }
}

