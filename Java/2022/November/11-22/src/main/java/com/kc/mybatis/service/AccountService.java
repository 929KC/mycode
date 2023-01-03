package com.kc.mybatis.service;

import com.kc.mybatis.expection.MoneyNotEnoughException;

/**
 * @author 929KC
 * @date 2022/11/21 20:17
 * @description:
 */
public interface AccountService {
    void transfer(String fromAcno,String toAcno,double money) throws MoneyNotEnoughException;
}
