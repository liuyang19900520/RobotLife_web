package com.liuyang19900520.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class SysController {

    @GetMapping("/images")
    public String ImgIndex() {
        return "images";
    }


}
