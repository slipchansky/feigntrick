package com.itfb.server.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import com.itfb.server.exceptions.NotFoundExeption;
import com.itfb.common.model.AccountDto;
import com.itfb.common.model.NewAccountDto;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private AtomicInteger idCounter = new AtomicInteger(4);

    private List<AccountDto> accounts = new ArrayList<>();

    @PostConstruct
    void init() {
        accounts.add(new AccountDto(1, "first"));
        accounts.add(new AccountDto(2, "second"));
        accounts.add(new AccountDto(3, "third"));
    }

    public AccountDto create(NewAccountDto forCreate) {
        AccountDto result;
        accounts.add(result = new AccountDto(idCounter.incrementAndGet(), forCreate.getName()));
        return result;
    }

    public AccountDto get(int id) {
        return accounts.stream().filter(a -> a.getId() == id).findFirst().orElseThrow(NotFoundExeption::new);
    }

    public List<AccountDto> list() {
        return accounts;
    }

    public void delete(int id) {
        accounts.remove(get(id));
    }

}
