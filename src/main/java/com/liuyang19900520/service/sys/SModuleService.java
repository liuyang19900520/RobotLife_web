package com.liuyang19900520.service.sys;

import com.liuyang19900520.common.PageVo;
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

    List<SModule> listModule(SModule module);

    PageVo<SModule> listPageModule(SModule module,int start, int length);

    List<SModule> listParentModule();

    boolean saveModule(SModule module);

}
