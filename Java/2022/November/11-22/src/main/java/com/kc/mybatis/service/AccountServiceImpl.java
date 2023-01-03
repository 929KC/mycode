package com.kc.mybatis.service;

import com.kc.mybatis.dao.AccountImpl;
import com.kc.mybatis.dao.impl.AccountMapper;
import com.kc.mybatis.expection.MoneyNotEnoughException;
import com.kc.mybatis.model.Account;

/**
 * @author 929KC
 * @date 2022/11/21 20:20
 * @description: 用户转账
 */
public class AccountServiceImpl implements AccountService{
    private AccountMapper  accountMapper = new AccountImpl();
    @Override
    public void transfer(String fromAcno, String toAcno, double money) throws MoneyNotEnoughException {
        Account fromAccount = accountMapper.selectByActno(fromAcno);
        if (fromAccount.getBalance()<money) {
            throw new MoneyNotEnoughException("对不起,余额不足!");
        }
        try {
            Account toAccount = accountMapper.selectByActno(toAcno);
            fromAccount.setBalance(fromAccount.getBalance()-money);
            toAccount.setBalance(toAccount.getBalance()+money);
            accountMapper.update(fromAccount);
            accountMapper.update(toAccount);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
