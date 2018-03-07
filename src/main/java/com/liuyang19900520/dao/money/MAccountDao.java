package com.liuyang19900520.dao.money;

import com.liuyang19900520.domain.money.MAccount;

import java.util.List;

public interface MAccountDao {
    /**
     * 获取权限
     *
     * @param userId
     * @return 权限列表
     */
    List<MAccount> listAccountsByUserId(String userId);

    /**
     * 创建账本
     *
     * @param mAccount
     * @return 插入成功1 失败0
     */
    int insertAccount(MAccount mAccount);

}
