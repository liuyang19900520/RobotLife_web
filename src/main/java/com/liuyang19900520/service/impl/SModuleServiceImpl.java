package com.liuyang19900520.service.impl;

import com.liuyang19900520.dao.SModuleDao;
import com.liuyang19900520.domain.SModule;
import com.liuyang19900520.service.SModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SModuleServiceImpl implements SModuleService {
    @Autowired
    private SModuleDao sModuleDao;

    @Override
    public List<SModule> listModuleByUserId(String userId) {

        return sModuleDao.listModuleByUserId(userId);
    }
}
