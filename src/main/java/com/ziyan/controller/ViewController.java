package com.ziyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by 子炎 on 2017/5/12.
 */
@Controller
public class ViewController {
    @GetMapping("/header.html")
    public String getHead() {
        return "header";
    }

    @GetMapping("/menu.html")
    public String getMenu() {
        return "menu";
    }
}