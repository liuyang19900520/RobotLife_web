package com.liuyang19900520.web;

import com.liuyang19900520.domain.money.MAccount;
import com.liuyang19900520.service.money.MAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/account")
public class MAccountController {

   @Autowired
   MAccountService mAccountService;

    @GetMapping("/account/create")
    public String loginForm() {
        return "money/account_create";
    }

    @PostMapping("/account/create")
    public String createAccount(HttpSession session, MAccount mAccount) {
        log.info(session.getAttribute("LOGIN_USER_KEY").toString());
        return "login";
    }

    @GetMapping("/index")
    public String a() {
        String a="advanced";
        return a;
    }




}
