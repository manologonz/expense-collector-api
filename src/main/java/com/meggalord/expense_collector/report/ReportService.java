package com.meggalord.expense_collector.report;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.meggalord.expense_collector.expense.ExpenseRepository;
import com.meggalord.expense_collector.expense.dto.ExpenseResponseDTO;
import com.meggalord.expense_collector.report.dto.ReportResponseDTO;
import com.meggalord.expense_collector.report.dto.ReportUpdateDTO;

@Service
public class ReportService {

    private final ReportRepository reportRepository;
    private final ExpenseRepository expenseRepository;

    public ReportService(ReportRepository reportRepository, ExpenseRepository expenseRepository) {
        this.reportRepository = reportRepository;
        this.expenseRepository = expenseRepository;
    }

    public Page<Report> getReports(int page, int limit) {
        return null; // TODO: build list
    }

    public ReportResponseDTO findReportById(Long reportId) {
        return null; // TODO: build find
    }

    public ReportResponseDTO updateReport(Long reportId, ReportUpdateDTO data) {
        return null; // TODO: build update
    }

    public ReportResponseDTO deleteReport(Long reportId) {
        return null; // TODO: build delete
    }

    public ExpenseResponseDTO addExpenseToReport(Long reportId, Long expenseId) {
        return null; // TODO: build add expense
    }

    public ExpenseResponseDTO removeExpenseFromReport(Long reportId, Long expenseId) {
        return null; // TODO: build remove expense
    }
}
