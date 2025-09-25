package com.meggalord.expense_collector.expense;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;

import com.meggalord.expense_collector.report.Report;
import com.meggalord.expense_collector.tag.Tag;
import com.meggalord.expense_collector.utils.BaseModel;

@Entity
@Table(name = "expenses")
public class Expense extends BaseModel {

    private String description;
    private Float amount;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable(name = "jn_expenses_tags", joinColumns = @JoinColumn(name = "expense_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    private List<Tag> tags;

    @ManyToMany(mappedBy = "expenses")
    private List<Report> reports;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Report> getReport() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

}
