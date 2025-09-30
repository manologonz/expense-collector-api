package com.meggalord.expense_collector.report.dto;

import org.springframework.stereotype.Component;
import com.meggalord.expense_collector.report.Report;

@Component
public class ReportMapper {

    public Report toEntity(ReportCreateDTO dto) {
        Report report = new Report();
        report.setName(dto.name());
        report.setDueDate(dto.duDate());

        return report;
    }

    public ReportResponseDTO toDTO(Report report) {
        return new ReportResponseDTO(
                report.getName(),
                report.getDueDate(),
                report.getCreatedAt(),
                report.getUpdatedAt());
    }
}
