package com.qsoft.bankaccount.business.impl;

import com.qsoft.bankaccount.business.BankAccountService;
import com.qsoft.bankaccount.persistence.dao.BankAccountDAO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: luult
 * Date: 7/2/13
 * Time: 2:19 PM
 */
public class BankAccountServiceImpl implements BankAccountService
{
    @Autowired
    private BankAccountDAO bankAccountDAO;
}
