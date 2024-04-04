package com.itfb.client;

import java.util.List;

import com.itfb.client.client.AccountClient;
import com.itfb.common.model.AccountDto;
import com.itfb.common.model.NewAccountDto;
import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;

@SpringBootTest(classes = ClientApp.class)
public class ClientTest {

    @Autowired
    private AccountClient accountClient;


    @Test
    public void testList() {
        List<AccountDto> accounts = accountClient.getAccounts();
        Assertions.assertEquals(3, accounts.size());
    }

    @Test
    public void testRead() {
        AccountDto account = accountClient.getAccount(1);
        Assertions.assertEquals("first", account.getName());
    }

    @Test
    public void testCreate() {
        int createdId = 0;
        try {
            AccountDto account = accountClient.createAccount(new NewAccountDto("test"));
            createdId = account.getId();
            Assertions.assertEquals("test", account.getName());
            AccountDto found = accountClient.getAccount(account.getId());
            Assertions.assertEquals(account, found);
            Assertions.assertEquals(4, accountClient.getAccounts().size());
        } finally {
            accountClient.deleteAccount(createdId);
        }
    }

    @Test
    public void testDelete() {
       AccountDto account = accountClient.createAccount(new NewAccountDto("test"));
       Assertions.assertEquals(4, accountClient.getAccounts().size());
        accountClient.deleteAccount(account.getId());
        Assertions.assertEquals(3, accountClient.getAccounts().size());
    }

    @Test
    public void testNotFound() {
        Assertions.assertThrows(FeignException.NotFound.class, () -> accountClient.getAccount(-1));
    }

}
