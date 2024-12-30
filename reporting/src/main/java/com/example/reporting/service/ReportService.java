package com.example.reporting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reporting.entity.Report;
import com.example.reporting.repository.ReportRepository;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public Report createReport(Report report) {
        return reportRepository.save(report);
    }

    public Report getReportById(Long id) {
        return reportRepository.findById(id).orElse(null);
    }
    
    public Report updateReport(Long id, Report reportDetails) {
        Report report = reportRepository.findById(id).orElse(null);
        if (report != null) {
            report.setTitle(reportDetails.getTitle());
            report.setContent(reportDetails.getContent());
            return reportRepository.save(report);
        }
        return null;
    }

    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }



}
