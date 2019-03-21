package edu.mum.tmAttendanceReport.service;

import edu.mum.tmAttendanceReport.entity.User;

public interface UserService {
	public User findById(Long id);
	public User findByEmail(String email);
}
