package com.kelaslatihan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.kelaslatihan.service.ReportService;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/products")
    public void getReport(HttpServletResponse response) throws Exception {

        // HttpHeaders respHeaders = new HttpHeaders();
        // respHeaders.setContentType(MediaType.valueOf("application/pdf"));
        // respHeaders.setContentDispositionFormData("Content-Disposition", "attachment;
        // filename=\"product_list.pdf\""); 
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"product_list.pdf\"");
        JasperPrint jasperPrint = reportService.generateJasperPrint();
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
    }
}
