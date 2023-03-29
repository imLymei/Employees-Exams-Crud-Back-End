package com.imLymei.EmployeeExam.service;

import com.imLymei.EmployeeExam.model.Account;
import com.imLymei.EmployeeExam.model.Response;

import java.util.List;

public interface AccountService {
    public Response findUsername(Account account);
}
