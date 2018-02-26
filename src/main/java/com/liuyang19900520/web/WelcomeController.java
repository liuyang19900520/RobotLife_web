package com.liuyang19900520.web;

import com.liuyang19900520.domain.SUser;
import com.liuyang19900520.service.SUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@Controller
public class WelcomeController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    SUserService sUserService;

    @GetMapping("/index")
    public String welcome(Map<String, Object> model, HttpServletRequest request, @ModelAttribute("loginKey") String uid) {

        model.put("time", new Date());
        SUser user = (SUser) request.getSession().getAttribute("LOGIN_USER_KEY");
        model.put("message", user.getNickName());
        return "starter";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register/signup")
    public String signup(SUser user) {

        logger.info(user.getUserName());
        sUserService.registerUser(user);
        return "redirect:/index";
    }
}
