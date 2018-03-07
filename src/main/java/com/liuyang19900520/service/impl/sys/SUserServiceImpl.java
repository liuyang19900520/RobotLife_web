package com.liuyang19900520.service.impl.sys;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.liuyang19900520.common.utils.LPwsUtils;
import com.liuyang19900520.dao.SUserDao;
import com.liuyang19900520.domain.SModule;
import com.liuyang19900520.domain.SUser;
import com.liuyang19900520.service.sys.SModuleService;
import com.liuyang19900520.service.sys.SUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class SUserServiceImpl implements SUserService {
    @Autowired
    private SUserDao sUserDao;

    @Autowired
    private SModuleService sModuleService;

    @Override
    public boolean registerUser(SUser user) {
        int isInserted = -1;
        // 生成uuid
        String id = UUID.randomUUID().toString();
        String newPs = LPwsUtils.MD5Pwd(user.getPassword(), user.getUserName());
        SUser dbUser = sUserDao.findByUserName(user.getUserName());
        user.setUserId(id);
        user.setPassword(newPs);
        if (dbUser == null) {
            isInserted = sUserDao.insertUser(user);
        }

        return isInserted > 0;


    }

    @Override
    public SUser findByAccount(String account) {


        return sUserDao.findByUserName(account);
    }

    @Override
    public Set<String> findPermissions(String account) {
        Set<String> set = Sets.newHashSet();
        SUser user = findByAccount(account);
        List<SModule> modules = sModuleService.listModuleByUserId(user.getUserId());

        for (SModule info : modules) {
            set.add(info.getModuleId());
        }
        return set;
    }

    @Override
    public List<String> findPermissionUrl(String account) {
        List<String> list = Lists.newArrayList();

        SUser user = findByAccount(account);
        List<SModule> modules = sModuleService.listModuleByUserId(user.getUserId());

        for (SModule info : modules) {
            if (StringUtils.equals(SModule.URL_TYPE, info.getModuleLevel())) {
                list.add(info.getModuleUrl());
            }
        }

        return list;
    }

    @Override
    public SUser findAllInfoByAccount(String account) {
        return sUserDao.findAllInfoByUserName(account);
    }
}
