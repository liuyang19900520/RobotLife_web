package com.liuyang19900520.service.money;

import com.liuyang19900520.domain.SModule;

import java.util.List;


public interface MCategoryService {


    /**
     * 根据创建的用户获取所有分类
     *
     * @param userId
     * @return 权限列表
     */
    List<SModule> listModuleByUserId(String userId);
}
