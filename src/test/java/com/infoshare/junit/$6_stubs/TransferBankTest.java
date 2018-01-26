package com.infoshare.junit.$6_stubs;

import com.infoshare.junit.banking.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

public class TransferBankTest {

    @Test
    public void stub_account_owners() {
        TransferBank bank = mock(GenericBank.class);

        // TODO use when(...).thenReturn(...) to make test pass

        Account account1 = bank.getAccountFor("1");
        Account account2 = bank.getAccountFor("2");

        SoftAssertions softAssert = new SoftAssertions();
        softAssert.assertThat(account1.getOwner()).isEqualTo("Kent Beck");
        softAssert.assertThat(account2.getOwner()).isEqualTo("Erich Gamma");
        softAssert.assertAll();
    }

    @Test
    public void should_return_last_defined_value_consistently() {
        TransferBank bank = mock(TransferBank.class);

        when(bank.getCommercialAccountsCount()).thenReturn(100, 200);

        assertThat(bank.getCommercialAccountsCount()).isEqualTo(100);
        assertThat(bank.getCommercialAccountsCount()).isEqualTo(200);
        assertThat(bank.getCommercialAccountsCount()).isEqualTo(200);
    }

    @Test
    public void verify_processing() throws Exception {
        // given
        TransferBank bank = spy(new GenericBank());

        Account sourceAccount = bank.getAccountFor("Kent Beck");
        LocalDateTime transactionDate = LocalDateTime.now().minus(Duration.ofMinutes(10));
        System.out.println(transactionDate);
        sourceAccount.register(new Transaction(10000, transactionDate));

        Account targetAccount = mock(Account.class);
        when(targetAccount.getBalance()).thenReturn(100000);

        new TransactionsBuilder()
                .using(bank)
                .totalOf(20)
                .after(LocalDateTime.of(2015, Month.DECEMBER, 1, 0, 0))
                .before(LocalDateTime.of(2016, Month.APRIL, 30, 0, 0))
                .valueBetween(1, 300)
                .transferBetween(sourceAccount, targetAccount);

        // when
        Collection<Transaction> process = bank.process();

        // then
        verify(bank, times(1)).process();
        verify(targetAccount, times(20)).register(isA(Transaction.class));

    }


}
