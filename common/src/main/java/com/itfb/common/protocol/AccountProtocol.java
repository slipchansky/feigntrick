package com.itfb.common.protocol;

import java.util.List;

import com.itfb.common.model.AccountDto;
import com.itfb.common.model.NewAccountDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



public interface AccountProtocol {

    public static String API_PREFIX = "/api/v1/accounts";

    @PostMapping(API_PREFIX+"/")
    @ApiOperation("Create new account")
    public AccountDto createAccount(@RequestBody NewAccountDto account);

    @GetMapping(API_PREFIX+"/{id}")
    @ApiOperation("Get an existing account by id")
    public AccountDto getAccount(@PathVariable Integer id);

    @GetMapping(API_PREFIX+"/")
    @ApiOperation("Get all existing accounts")
    public List<AccountDto> getAccounts();

    @DeleteMapping(API_PREFIX+"/{id}")
    @ApiOperation("Delete existing account by id")
    public ResponseEntity<Void> deleteAccount(@PathVariable Integer id);
}
