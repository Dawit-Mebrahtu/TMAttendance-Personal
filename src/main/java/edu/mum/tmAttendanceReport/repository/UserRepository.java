package edu.mum.tmAttendanceReport.repository;

import org.springframework.data.repository.CrudRepository;

import edu.mum.tmAttendanceReport.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{
	public User findByEmail(String email);
}
