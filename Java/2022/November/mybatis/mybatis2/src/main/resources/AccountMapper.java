package com.kc.mybatis.dao.impl;

import com.kc.mybatis.model.Account;

/**
 * @author: 929KC
 * @date 2022/11/21 16:39
 * @description:
 * @version: 0.0.1
 **/
public interface AccountMapper {
    /**
     *
     * @author 929KC
     * @date 2022/11/21 2022/11/21
     * @param actno
     * @return Account
     * @description: 根据账号获取账户信息
     */
    Account selectByActno(String actno);
    /**
     *
     * @author 929KC
     * @date 2022/11/21 2022/11/21
     * @param act
     * @return int
     * @description: 1表示更新失败,其它值表示更新成功
     */
    int  update(Account act);
}
