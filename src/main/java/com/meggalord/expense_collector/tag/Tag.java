package com.meggalord.expense_collector.tag;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToMany;

import java.util.List;

import com.meggalord.expense_collector.utils.BaseModel;
import com.meggalord.expense_collector.expense.Expense;

@Entity
@Table(name = "tags")
public class Tag extends BaseModel {

    private String name;
    private String color;

    @ManyToMany(mappedBy = "tags")
    private List<Expense> expenses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

}
