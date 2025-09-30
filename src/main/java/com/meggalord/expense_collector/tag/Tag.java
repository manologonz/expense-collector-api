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
    private String slug;

    @ManyToMany(mappedBy = "tags")
    private List<Expense> expenses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.slug = this.slugify(name);
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

    public String getSlug() {
        return slug;
    }

    public String slugify(String text) {
        if (text == null || text.trim().isEmpty()) {
            return "";
        }

        return text
                .toLowerCase() // Convert to lowercase
                .trim() // Remove leading/trailing spaces
                .replaceAll("[^a-z0-9\\s-]", "") // Remove special characters, keep alphanumeric, spaces, hyphens
                .replaceAll("\\s+", "-") // Replace one or more spaces with single hyphen
                .replaceAll("-+", "-") // Replace multiple consecutive hyphens with single hyphen
                .replaceAll("^-|-$", ""); // Remove leading and trailing hyphens
    }

}
