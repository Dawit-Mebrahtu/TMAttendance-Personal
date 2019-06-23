package edu.mum.tmAttendanceReport.controller;

import edu.mum.tmAttendanceReport.dto.StudentReport;
import edu.mum.tmAttendanceReport.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ReportController {

    @Autowired
    private ServletContext context;

    @Autowired
    BlockService blockService;

    @GetMapping("/faculty/excelreport")
    public void exportAsExcel(HttpServletRequest request, HttpServletResponse response){
        HttpSession httpSession = request.getSession();

        List<StudentReport> studentReports = (List<StudentReport>) httpSession.getAttribute("studentReports");
        boolean isFlag = blockService.createExcel(studentReports,context, request, response);

        if(isFlag){
            String fullPath = request.getServletContext().getRealPath("/resources/reports/blockreport.xls");
            fileDownload(fullPath, response, "blockreport.xls");
        }

    }

    private void fileDownload(String fullPath, HttpServletResponse response, String filename) {

        File file = new File(fullPath);
        final int BUFFER_SIZE = 4096;
        if(file.exists()){
            try{
                FileInputStream inputStream = new FileInputStream(file);
                String mimeType = context.getMimeType(fullPath);
                response.setContentType(mimeType);
                response.setHeader("content-disposition", "attachment; filename = " + filename);

                OutputStream outuptStream = response.getOutputStream();
                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1){
                    outuptStream.write(buffer, 0, bytesRead);
                }

                inputStream.close();
                outuptStream.close();
                file.delete();

            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
