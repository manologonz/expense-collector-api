package com.meggalord.expense_collector.report;

import java.time.LocalDate;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToMany;

import com.meggalord.expense_collector.utils.BaseModel;
import com.meggalord.expense_collector.expense.Expense;

@Entity
@Table(name = "reports")
public class Report extends BaseModel {

    private String name;
    private LocalDate dueDate;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable(name = "jn_reports_expenses", joinColumns = @JoinColumn(name = "report_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "expense_id", referencedColumnName = "id"))
    private List<Expense> expenses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}
