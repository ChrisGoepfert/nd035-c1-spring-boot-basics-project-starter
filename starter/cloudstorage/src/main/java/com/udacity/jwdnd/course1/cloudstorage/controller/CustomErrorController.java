package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.constants.Attributes;
import com.udacity.jwdnd.course1.cloudstorage.constants.Templates;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CustomErrorController implements ErrorController {

    @GetMapping("/error")
    public String getErrorPage(Model model) {
        model.addAttribute(Attributes.UNKNOWN_ERROR, true);
        return Templates.RESULT;
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
