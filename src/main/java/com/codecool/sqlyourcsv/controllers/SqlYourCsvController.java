package com.codecool.sqlyourcsv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SqlYourCsvController {

    @GetMapping("/sql-your-csv")
    public String hello() {
        return "sql_your_csv";
    }
}
