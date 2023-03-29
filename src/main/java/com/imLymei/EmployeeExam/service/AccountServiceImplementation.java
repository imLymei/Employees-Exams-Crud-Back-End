package com.imLymei.EmployeeExam.service;

import com.imLymei.EmployeeExam.controller.AccountController;
import com.imLymei.EmployeeExam.model.Account;
import com.imLymei.EmployeeExam.model.Response;
import com.imLymei.EmployeeExam.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImplementation implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Response findUsername(Account account) {
        Response response = new Response("error/Usuário não encontrado");
        List<Account> findAccount = accountRepository.findAccountByUsernameIs(account.getUsername());
        if (!findAccount.isEmpty()){
            Account myAccount = accountRepository.findAccountByUsername(account.getUsername());
            if (myAccount.getPassword().equals(account.getPassword())){
                response.setMessage("success/Usuário logado");
            } else {
                response.setMessage("error/Senha incorreta");
            }
        }
        return response;
    }
}
