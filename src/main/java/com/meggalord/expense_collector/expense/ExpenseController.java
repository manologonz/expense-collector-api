package com.meggalord.expense_collector.expense;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v1/expense")
public class ExpenseController {

    @GetMapping("")
    public String getExpenses(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit) {

        String value = String.format("Expense: page=%d, limit=%d", page, limit);
        return new String(value);
    }

}
