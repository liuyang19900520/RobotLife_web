package com.liuyang19900520.service.money;

import com.liuyang19900520.domain.money.MAccount;

import java.util.List;


public interface MAccountService {
    /**
     * 根据创建的用户获取所有分类
     *
     * @param userId
     * @return 账本列表
     */
    List<MAccount> listAccountsByUserId(String userId);


    /**
     * 创建账本
     *
     * @param mAccount
     * @return
     */
    List<MAccount> createAccounts(MAccount mAccount);
}
