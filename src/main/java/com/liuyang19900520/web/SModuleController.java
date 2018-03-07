package com.liuyang19900520.web;

import com.liuyang19900520.common.PageVo;
import com.liuyang19900520.common.ResultVo;
import com.liuyang19900520.common.json.JSON;
import com.liuyang19900520.domain.SModule;
import com.liuyang19900520.domain.SUser;
import com.liuyang19900520.service.sys.SModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.liuyang19900520.common.SysConstant.LOGIN_USER_KEY;

@Slf4j
@Controller
@RequestMapping("/system")
public class SModuleController {

    @Autowired
    SModuleService sModuleService;

    @GetMapping("/module/index")
    public String index() {
        return "system/module_index";
    }


    @GetMapping("/module/parentIds")
    @JSON(type = SModule.class, include = "moduleId,moduleName")
    public List<SModule> parentIds() {
        List<SModule> sModules = sModuleService.listParentModule();
        return sModules;
    }


    @GetMapping("/module/list/index")
    public String indexList() {
        return "system/module_list";
    }

    /**
     * 获取侧边栏内容
     *
     * @param session
     * @param map
     * @return
     */
    @GetMapping("/module/list")
    public String listModulesGet(HttpSession session, ModelMap map) {
        SUser currentUser = (SUser) session.getAttribute(LOGIN_USER_KEY);
        List<SModule> modules = sModuleService.listModuleByUserId(currentUser.getUserId());
        map.addAttribute("modules", modules);
        return "nav_side";
    }

    @PostMapping("/module/list")
    @JSON(type = SModule.class, filter = "id,createBy,createTime,updateBy,updateTime")
    public PageVo<SModule> listModulesPost(HttpSession session, @RequestParam(required = false, defaultValue = "1") int start,
                                           @RequestParam(required = false, defaultValue = "100") int length) {
        SUser currentUser = (SUser) session.getAttribute("LOGIN_USER_KEY");
        SModule module = new SModule();
        PageVo<SModule> modules = sModuleService.listPageModule(module, start, length);
        return modules;
    }


    @PostMapping("/module/save")
    @ResponseBody
    public ResultVo saveModule(HttpSession session, SModule module) {
        SUser currentUser = (SUser) session.getAttribute("LOGIN_USER_KEY");

        boolean b = sModuleService.saveModule(module);
        ResultVo resultVo = new ResultVo();

        if (b) {
            resultVo.setRet(ResultVo.SUCCESS);
        }
        return resultVo;
    }

    @PostMapping("/module/module")
    @JSON(type = SModule.class, filter = "id,createBy,createTime,updateBy,updateTime")
    public SModule findModule(HttpSession session, String moduleId) {
        SUser currentUser = (SUser) session.getAttribute("LOGIN_USER_KEY");
        SModule module = new SModule();
        module.setModuleId(moduleId);
        List<SModule> modules = sModuleService.listModule(module);
        if (modules != null) {
            SModule moduleResult = modules.get(0);
            return moduleResult;
        }
        return null;
    }


    @GetMapping("/module/model/index")
    public String indexModel() {
        return "system/module_model";
    }

}
