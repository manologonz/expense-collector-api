package com.meggalord.expense_collector.expense;

import org.springframework.web.bind.annotation.RestController;

import com.meggalord.expense_collector.expense.dto.ExpenseCreateDTO;
import com.meggalord.expense_collector.expense.dto.ExpenseMapper;
import com.meggalord.expense_collector.expense.dto.ExpenseResponseDTO;
import com.meggalord.expense_collector.expense.dto.ExpenseSoloResponeseDTO;
import com.meggalord.expense_collector.expense.dto.ExpenseTagUpdateDTO;
import com.meggalord.expense_collector.expense.dto.ExpenseUpdateDTO;
import com.meggalord.expense_collector.utils.pagination.PaginatedResponse;

import jakarta.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/expense")
public class ExpenseController {

    private final ExpenseService expenseService;
    private final ExpenseMapper expenseMapper;

    public ExpenseController(ExpenseService expenseService, ExpenseMapper expenseMapper) {
        this.expenseService = expenseService;
        this.expenseMapper = expenseMapper;
    }

    @GetMapping()
    public PaginatedResponse<ExpenseResponseDTO> getExpenses(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit) {

        Page<Expense> expensePage = expenseService.getExpenses(page, limit);

        List<ExpenseResponseDTO> data = expensePage.getContent().stream().map(expenseMapper::toDTO)
                .collect(Collectors.toList());

        return PaginatedResponse.of(data, page, limit, expensePage.getTotalPages());
    };

    @PostMapping()
    public ExpenseResponseDTO createExpense(@Valid @RequestBody ExpenseCreateDTO entity) {
        Expense data = expenseMapper.toEntity(entity);

        Expense savedData = expenseService.createExpense(data);

        return expenseMapper.toDTO(savedData);
    }

    @GetMapping("/{expenseId}")
    public ExpenseResponseDTO getExpenseById(@PathVariable(value = "expenseId", required = true) Long expenseId) {
        Expense expense = expenseService.findExpenseById(expenseId);

        return expenseMapper.toDTO(expense);
    }

    @PutMapping("/{expenseId}")
    public ExpenseResponseDTO updateExpense(@PathVariable(value = "expenseId", required = true) Long expenseId,
            @Valid @RequestBody ExpenseUpdateDTO data) {

        Expense updatedExpense = expenseService.updateExpense(expenseId, data);

        return expenseMapper.toDTO(updatedExpense);
    }

    @DeleteMapping("/{expenseId}")
    public ExpenseSoloResponeseDTO deleteExpense(@PathVariable(value = "expenseId", required = true) Long expenseId) {
        Expense deletedExpense = expenseService.deleteExpense(expenseId);

        return expenseMapper.toSoloDto(deletedExpense);
    }

    @PostMapping("/{expenseId}/tags")
    public ExpenseResponseDTO updateExpenseTags(@PathVariable(value = "expenseId", required = true) Long expenseId,
            @RequestBody ExpenseTagUpdateDTO data) {

        Expense updatedExpense = expenseService.updateExpenseTags(expenseId, data);

        return expenseMapper.toDTO(updatedExpense);
    }

}
