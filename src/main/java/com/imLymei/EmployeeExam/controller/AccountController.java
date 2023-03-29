package com.imLymei.EmployeeExam.controller;

import com.imLymei.EmployeeExam.model.Account;
import com.imLymei.EmployeeExam.model.Response;
import com.imLymei.EmployeeExam.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PutMapping("/login")
    public Response login(@RequestBody Account account){
        return accountService.findUsername(account);
    }
}
