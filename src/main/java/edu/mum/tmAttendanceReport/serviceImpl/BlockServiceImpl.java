package edu.mum.tmAttendanceReport.serviceImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.tmAttendanceReport.dto.StudentReport;
import edu.mum.tmAttendanceReport.entity.Block;
import edu.mum.tmAttendanceReport.entity.Student;
import edu.mum.tmAttendanceReport.entity.TMAttendance;
import edu.mum.tmAttendanceReport.repository.BlockRepository;
import edu.mum.tmAttendanceReport.service.BlockService;
import edu.mum.tmAttendanceReport.service.TMAttendanceService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class BlockServiceImpl implements BlockService {

	@Autowired
	private BlockRepository blockRepository;
	
	@Autowired
	private TMAttendanceService tmAttendanceService;
	
	public List<Block> findAll(){
		return (List<Block>) blockRepository.findAll();
	}

	@Override
	public Block findById(Long id) {
		return blockRepository.findById(id).get();
	}

	@Override
	public List<Block> findByStartDateAfter(Date startDate) {
		return blockRepository.findByStartDateAfter(startDate);
	}

	@Override
	public List<StudentReport> generateResult(List<Student> list, Block block) {
		//final DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		java.sql.Date startDate = new java.sql.Date(block.getStartDate().getTime());
		java.sql.Date endDate = new java.sql.Date(block.getEndDate().getTime());
		Integer numberOfDaysInBlock = Integer.parseInt(block.getPeriod());

		List<StudentReport> studentReportList = new ArrayList<>();

		for (Student student : list) {
			StudentReport studentReport = new StudentReport();
			studentReport.setId(String.valueOf(student.getStudentId()));
			studentReport.setFirstName(student.getFirstName());
			studentReport.setLastName(student.getLastName());

			List<TMAttendance> studentBlockAttendanceList = tmAttendanceService
					.findAttendanceByDates(student.getStudentId(), startDate, endDate);

			double percentage =  ((double) studentBlockAttendanceList.size() / numberOfDaysInBlock) * 100;
			studentReport.setPercentage(String.valueOf(percentage));

			if (percentage >= 90.0) {
				studentReport.setCreditScore("1.5");
			} else if (percentage >= 80.0) {
				studentReport.setCreditScore("1.0");
			} else if (percentage >= 70.0) {
				studentReport.setCreditScore("0.5");
			} else {
				studentReport.setCreditScore("0.0");
			}

			System.out.println(studentReport);

			studentReportList.add(studentReport);
		}

		return studentReportList;
	}

	@Override
	public boolean createExcel(List<StudentReport> studentReports, ServletContext context, HttpServletRequest request, HttpServletResponse response) {
		String filePath = context.getRealPath("/resources/reports");
		File file = new File(filePath);
		boolean exists = new File(filePath).exists();

		if(!exists){
			new File(filePath).mkdirs();
		}

		try{
			FileOutputStream outputStream = new FileOutputStream(file + "/" + "blockreport.xls");

			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet worksheet = workbook.createSheet("Block");
			worksheet.setDefaultColumnWidth(30);

			HSSFCellStyle headerCellStyle = workbook.createCellStyle();

			HSSFRow headerRow = worksheet.createRow(0);

			HSSFCell firstName = headerRow.createCell(0);
			firstName.setCellValue("First Name");

			HSSFCell lastName = headerRow.createCell(1);
			lastName.setCellValue("Last Name");

			HSSFCell idNumber = headerRow.createCell(2);
			idNumber.setCellValue("ID Number");

			HSSFCell percentage = headerRow.createCell(3);
			percentage.setCellValue("Attendance Percentage");

			HSSFCell extraCredit = headerRow.createCell(4);
			extraCredit.setCellValue("Extra Credit");

			int i=1;
			for(StudentReport studentReport: studentReports){
				HSSFRow bodyRow = worksheet.createRow(i++);

				HSSFCellStyle bodyCellStyle = workbook.createCellStyle();
//			bodyCellStyle.setFillForegroundColor();

				HSSFCell firstNameValue = bodyRow.createCell(0);
				firstNameValue.setCellValue(studentReport.getFirstName());

				HSSFCell lastNameValue = bodyRow.createCell(1);
				lastNameValue.setCellValue(studentReport.getLastName());

				HSSFCell idNumberValue = bodyRow.createCell(2);
				idNumberValue.setCellValue(studentReport.getId());

				HSSFCell percentageValue = bodyRow.createCell(3);
				percentageValue.setCellValue(studentReport.getPercentage());

				HSSFCell extraCreditValue = bodyRow.createCell(4);
				extraCreditValue.setCellValue(studentReport.getCreditScore());
			}

			workbook.write(outputStream);
			outputStream.flush();
			outputStream.close();

			return true;

		}catch (Exception ex){
			return false;
		}

	}
}
