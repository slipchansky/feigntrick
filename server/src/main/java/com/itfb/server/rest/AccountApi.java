package com.itfb.server.rest;

import java.util.List;

import com.itfb.common.protocol.AccountProtocol;
import com.itfb.common.model.AccountDto;
import com.itfb.common.model.NewAccountDto;
import com.itfb.server.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountApi implements AccountProtocol {

    @Autowired
    private AccountService accountService;

    @Override
    public AccountDto createAccount(NewAccountDto account) {
        return accountService.create(account);
    }

    @Override
    public AccountDto getAccount(Integer id) {
        return accountService.get(id);
    }

    @Override
    public List<AccountDto> getAccounts() {
        return accountService.list();
    }

    @Override
    public ResponseEntity<Void> deleteAccount(Integer id) {
        accountService.delete(id);
        return ResponseEntity.ok(null);
    }
}
