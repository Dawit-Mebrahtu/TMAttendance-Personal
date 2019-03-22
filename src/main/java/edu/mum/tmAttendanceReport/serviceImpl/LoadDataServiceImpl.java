
package edu.mum.tmAttendanceReport.serviceImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.tmAttendanceReport.entity.DateInfo;
import edu.mum.tmAttendanceReport.entity.Place;
import edu.mum.tmAttendanceReport.entity.Student;
import edu.mum.tmAttendanceReport.entity.TMAttendance;
import edu.mum.tmAttendanceReport.entity.TMAttendanceIdentity;
import edu.mum.tmAttendanceReport.entity.TimeInfo;
import edu.mum.tmAttendanceReport.service.DateInfoService;
import edu.mum.tmAttendanceReport.service.LoadDataService;
import edu.mum.tmAttendanceReport.service.PlaceService;
import edu.mum.tmAttendanceReport.service.StudentService;
import edu.mum.tmAttendanceReport.service.TMAttendanceService;
import edu.mum.tmAttendanceReport.service.TimeInfoService;



 @Service
public class LoadDataServiceImpl implements LoadDataService{
	
	@Autowired
	private  StudentService studentService;

	@Autowired
	private DateInfoService dateInfoService;

	@Autowired
	private TimeInfoService timeInfoService;

	@Autowired
	private PlaceService placeService;

	@Autowired
	private TMAttendanceService tmAttendanceService;

	//SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
	
	//DateFormat format = new SimpleDateFormat("MM/dd/yy");
	
	DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("MM/dd/yy");
	
	DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public void loadData() {

		Stream<String> data = null;
		Path path = Paths.get("data/rc_data.txt");

		try {
			data = Files.lines(path).parallel().distinct();
			parseData(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void parseData(Stream<String> list) {

		List<TMAttendance> listOfTMAttendance = list.map(line -> {
			
			TMAttendance tmAttendance = new TMAttendance();
			String[] values = line.split(",");
			
			//System.out.println(values);
			String studentBarCode = values[0].trim();
			//System.out.println(studentService == null ?"Null":"Not Null");
			Student student = studentService.getStudentByBarCode(studentBarCode);
			
			if(student != null){
				try {
					//System.out.println(format.parse(values[1].trim()));
					java.util.Date date = java.sql.Date.valueOf(formatDate(LocalDate.parse(values[1].trim(), fmt1)));
					//Date date = formatDate(LocalDate.parse(values[1].trim(), fmt1));
					//System.out.println(date);
					DateInfo dateInfo = dateInfoService.getDateInfoByDate(date);

					TMAttendanceIdentity tmIdentity = new TMAttendanceIdentity();
					tmIdentity.setStudentId(student);
					tmIdentity.setDate(dateInfo);

					tmAttendance.setTmAttendanceIdentity(tmIdentity);
					//System.out.println("SET TM ATTENDANCE ID ROW!!");
				} catch (ParseException e) {
					e.printStackTrace();
					showError();
				}
				
				TimeInfo timeInfo = timeInfoService.getByTimeOfDay(values[2].trim());
				tmAttendance.setTimeInfo(timeInfo);

				Place place = placeService.getPlaceByName(values[3].trim());
				tmAttendance.setPlace(place);
				
				return tmAttendance;
			}else {
				return null;
			}
		}).collect(Collectors.toList());
		
		saveDataRow(listOfTMAttendance);
	}

	private static void showError() {
		System.out.println("Can't parse DATE");
	}

	public void saveDataRow(List<TMAttendance> tm) {
		for (TMAttendance tmAttendance : tm) {
			if(!tm.equals(null)) {
				TMAttendance saveObject = tmAttendanceService.save(tmAttendance);
			}
		}
	}
	
	public LocalDate formatDate(LocalDate dateValue) throws ParseException{
//		LocalDateTime ldt = dateValue.toInstant()
//			      .atZone(ZoneId.systemDefault())
//			      .toLocalDateTime();
//		DateTimeFormatter.ofPattern("MM/dd/yy", Locale.ENGLISH).format(ldt);
//		DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(ldt);
		String dateString = fmt2.format(dateValue);
		return LocalDate.parse(dateString, fmt2);
     }

}

 
 

