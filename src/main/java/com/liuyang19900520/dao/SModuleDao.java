package com.liuyang19900520.dao;

import com.liuyang19900520.domain.SModule;

import java.util.List;

public interface SModuleDao {
    /**
     * 获取权限
     *
     * @param userId
     * @return 权限列表
     */
    List<SModule> listModuleByUserId(String userId);

}
