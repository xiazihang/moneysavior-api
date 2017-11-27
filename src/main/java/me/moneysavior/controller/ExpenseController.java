package me.moneysavior.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ExpenseController {

    @RequestMapping(value = "/expense", method = GET)
    public String getExpense() {
        return "test expense controller";
    }
}
