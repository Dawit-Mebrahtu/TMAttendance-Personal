package edu.mum.tmAttendanceReport.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.mum.tmAttendanceReport.entity.Student;

import java.util.List;
//import java.util.StringTokenizer;

public class LoadData {
	
	public static List<Student> load() {
		
		Stream<String> data = null;
		Path path = Paths.get("data/rc_data.txt");
		try {
			data = Files.lines(path).parallel().distinct();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	    List<Student> list = parseData(data);
	    return list; 
	}

	@SuppressWarnings("deprecation")
	public static List<Student> parseData(Stream<String> list){
		
		List<Student> students = list.map(line -> {
			//StringTokenizer tokens = new StringTokenizer(line, ",");
			String[] tokens = line.split(",");
			final DateFormat format = new SimpleDateFormat("MM/dd/yy");
			Student student = new Student();
			 
			student.setId(Long.parseLong(tokens[0]));
			try {
				student.setDate(format.parse(tokens[1]));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			student.setPeriod(tokens[2]);
			student.setPlace(tokens[3]);
			return student;
		}).collect(Collectors.toList());
		
		
		
		return students;
	} 
}
