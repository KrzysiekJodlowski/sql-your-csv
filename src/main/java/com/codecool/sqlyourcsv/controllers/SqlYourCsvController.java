package com.codecool.sqlyourcsv.controllers;

import com.codecool.sqlyourcsv.model.UserQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SqlYourCsvController {

    @GetMapping("/sql-your-csv")
    public String hello(Model model) {
        model.addAttribute("query", new UserQuery());
        return "sql_your_csv";
    }

    @PostMapping("/sql-your-csv")
    public String result(@ModelAttribute UserQuery userQuery) {
        return "result";
    }
}
