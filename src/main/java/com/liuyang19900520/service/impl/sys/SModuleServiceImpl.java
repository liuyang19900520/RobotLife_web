package com.liuyang19900520.service.impl.sys;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuyang19900520.common.PageVo;
import com.liuyang19900520.dao.SModuleDao;
import com.liuyang19900520.domain.SModule;
import com.liuyang19900520.service.sys.SModuleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SModuleServiceImpl implements SModuleService {
    @Autowired
    private SModuleDao sModuleDao;

    @Override
    public List<SModule> listModuleByUserId(String userId) {
        List<SModule> modules = sModuleDao.listModuleByUserId(userId);
        for (SModule module : modules) {
            if (StringUtils.isNotBlank(module.getModuleId())) {
                SModule condition = new SModule();
                condition.setParentId(module.getModuleId());
                List<SModule> children = sModuleDao.listModules(condition);
                module.setChildrenModule(children);
            }
        }
        return modules;
    }

    @Override
    public List<SModule> listModule(SModule module) {
        List<SModule> sModules = sModuleDao.listModules(module);
        return sModules;
    }

    @Override
    public PageVo<SModule> listPageModule(SModule module, int start, int length) {

        PageHelper.startPage(start / length + 1, length);
        List<SModule> modules = sModuleDao.listModules(module);
        PageInfo<SModule> pageInfo = new PageInfo<>(modules);
        PageVo<SModule> result = new PageVo<>();

        result.setData(pageInfo.getList());
        result.setRecordsFiltered(String.valueOf(pageInfo.getTotal()));
        result.setRecordsTotal(String.valueOf(pageInfo.getTotal()));

        return result;

    }

    @Override
    public List<SModule> listParentModule() {
        SModule module = new SModule();
        module.setParentId("0");
        List<SModule> modules = sModuleDao.listModules(module);
        return modules;
    }

    @Override
    public boolean saveModule(SModule module) {

        String moduleId = module.getModuleId();
        SModule moduleDB = sModuleDao.selectModuleById(moduleId);
        if (moduleDB != null) {
            return UpdateModule(moduleDB, module);
        } else {
            return insertModule(module);
        }
    }

    private boolean UpdateModule(SModule moduleDB, SModule moduleInput) {
        moduleDB.setModuleName(moduleInput.getModuleName());
        moduleDB.setModuleLevel(moduleInput.getModuleLevel());
        moduleDB.setParentId(moduleInput.getParentId());
        moduleDB.setModuleUrl(moduleInput.getModuleUrl());
        moduleDB.setModuleRank(moduleInput.getModuleRank());
        moduleDB.setModuleImg(moduleInput.getModuleImg());
        moduleDB.setUpdateTime(new Date());
        moduleDB.setUpdateBy(moduleInput.getUpdateBy());
        moduleDB.setDeleteFlag(moduleInput.getDeleteFlag());
        int isUpdated = sModuleDao.updateModule(moduleDB);
        return isUpdated >= 0;
    }

    private boolean insertModule(SModule module) {
        module.setModuleId(UUID.randomUUID().toString());
        module.setCreateTime(new Date());
        module.setUpdateTime(new Date());
        module.setCreateBy(module.getUpdateBy());
        int isInserted = sModuleDao.insertModule(module);
        return isInserted > 0;
    }


}
