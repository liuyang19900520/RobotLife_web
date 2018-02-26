package com.liuyang19900520.service;

import com.liuyang19900520.domain.SModule;

import java.util.List;


public interface SModuleService {


    /**
     * 获取权限
     *
     * @param userId
     * @return 权限列表
     */
    List<SModule> listModuleByUserId(String userId);
}
