package com.meggalord.expense_collector.expense;

import com.meggalord.expense_collector.tag.TagService;
import org.springframework.stereotype.Service;

import com.meggalord.expense_collector.expense.dto.ExpenseTagUpdateDTO;
import com.meggalord.expense_collector.expense.dto.ExpenseUpdateDTO;
import com.meggalord.expense_collector.tag.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    private final TagService tagService;
    private ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository, TagService tagService) {
        this.expenseRepository = expenseRepository;
        this.tagService = tagService;
    }

    public List<Expense> getExpenses() {
        return expenseRepository.findAll();
    }

    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Expense findExpenseById(Long expenseId) {
        return expenseRepository.findById(expenseId).orElseThrow(() -> new IllegalAccessError("Not found"));
    }

    public Expense updateExpense(Long expenseId, ExpenseUpdateDTO data) {
        Expense expense = this.findExpenseById(expenseId);

        if (data.description() != null) {
            expense.setDescription(data.description());
        }

        if (data.amount() != null) {
            expense.setAmount(data.amount());
        }

        return expenseRepository.save(expense);
    }

    public Expense updateExpenseTags(Long expenseId, ExpenseTagUpdateDTO data) {
        Expense expense = this.findExpenseById(expenseId);
        List<Tag> tagList = new ArrayList<Tag>();

        if (data.tagIds() != null) {
            tagList = data.tagIds().stream().map(tagService::findTagById).collect(Collectors.toList());
            expense.setTags(tagList);
        }

        return expenseRepository.save(expense);
    }

    public Expense deleteExpense(Long expeseId) {
        Expense expense = this.findExpenseById(expeseId);
        expenseRepository.delete(expense);

        return expense;
    }
}
