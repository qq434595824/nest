package com.ziyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by 子炎 on 2017/5/12.
 */

@Controller
public class ViewController {

    @GetMapping("static/{app}/js/{file}.js")
    public String getJs(@PathVariable String app, @PathVariable String file, HttpServletResponse response) {
        response.setContentType("text/js");
        return "static/" + app + "/js/" + file + ".js";
    }

    @GetMapping("static/{app}/css/{file}.css")
    public String getCss(@PathVariable String app, @PathVariable String file, HttpServletResponse response) {
        response.setContentType("text/css");
        return "static/" + app + "/css/" + file + ".css";
    }

    @GetMapping("/{app}/{view}.html")
    public String getView(@PathVariable String app, @PathVariable String view) {
        return "templates/" + app + "/" + view + ".html";
    }

    @GetMapping("/header.html")
    public String getHead() {
        return "templates/header.html";
    }

    @GetMapping("/menu.html")
    public String getMenu() {
        return "templates/menu.html";
    }
}
