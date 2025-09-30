package com.meggalord.expense_collector.report;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meggalord.expense_collector.report.dto.ReportMapper;

@RestController
@RequestMapping("/api/v1/report")
public class ReportController {

    private final ReportService reportService;
    private final ReportMapper reportMapper;

    public ReportController(ReportService reportService, ReportMapper reportMaper) {
        this.reportService = reportService;
        this.reportMapper = reportMaper;
    }

}
