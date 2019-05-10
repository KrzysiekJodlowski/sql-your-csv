package com.codecool.sqlyourcsv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SqlYourCsvController {

    @RequestMapping(value = "/sql_your_csv", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "<h1>SQL YOUR CSV</h1>";
    }
}
