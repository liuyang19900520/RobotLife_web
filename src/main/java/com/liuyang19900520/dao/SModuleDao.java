package com.liuyang19900520.dao;

import com.liuyang19900520.domain.SModule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SModuleDao {
    /**
     * 获取权限
     *
     * @param userId
     * @return 权限列表
     */
    List<SModule> listModuleByUserId(String userId);


    /**
     * 获取权限
     *
     * @param module
     * @return 权限列表
     */
    List<SModule> listModules(SModule module);

    SModule selectModuleById(@Param("moduleId") String moduleId);

    /**
     * 创建账本
     *
     * @param module
     * @return 插入成功1 失败0
     */
    int insertModule(SModule module);

    int updateModule(SModule module);

    int deleteModuleWithFlag(@Param("moduleId") String moduleId);

}
