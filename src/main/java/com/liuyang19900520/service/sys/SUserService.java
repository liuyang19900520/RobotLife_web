package com.liuyang19900520.service.sys;

import com.liuyang19900520.domain.SUser;

import java.util.List;
import java.util.Set;

public interface SUserService {

    /**
     * 根据账号Account查询当前用户
     *
     * @param user
     * @return
     */
    boolean registerUser(SUser user);

    /**
     * 根据账号Account查询当前用户
     *
     * @param account
     * @return
     */
    SUser findByAccount(String account);

    /**
     * 获取资源集合
     *
     * @param account
     * @return
     */
    Set<String> findPermissions(String account);

    /**
     * 获取URL权限
     *
     * @param account
     * @return
     */
    List<String> findPermissionUrl(String account);


    /**
     * 根据账号Account查询当前用户所有信息
     *
     * @param account
     * @return
     */
    SUser findAllInfoByAccount(String account);

}
