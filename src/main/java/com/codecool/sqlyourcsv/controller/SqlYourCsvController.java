package com.codecool.sqlyourcsv.controller;

import com.codecool.sqlyourcsv.model.UserQuery;
import com.codecool.sqlyourcsv.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SqlYourCsvController {

    private DataService dataService;

    @Autowired
    public SqlYourCsvController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/sql-your-csv")
    public String hello(Model model) {
        model.addAttribute("userQuery", new UserQuery());
        model.addAttribute("users", this.dataService.getFileData());
        return "sql_your_csv";
    }

    @PostMapping("/sql-your-csv")
    public String result(@ModelAttribute UserQuery userQuery) {
        return "result";
    }
}
