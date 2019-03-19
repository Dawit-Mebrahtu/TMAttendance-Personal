-- Authentication role types
INSERT INTO `role` VALUES (1,'ADMIN');
INSERT INTO `role` VALUES (2,'FACULTY');
INSERT INTO `role` VALUES (3,'STUDENT');


-- Authentication credentials
INSERT INTO `users`(user_id, active, email, password) VALUES (1, 1, 'dmebrahtu@mum.edu', '$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe');
INSERT INTO `users`(user_id, active, email, password) VALUES (2, 1, 'jndamutsa@mum.edu', '$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe');
INSERT INTO `users`(user_id, active, email, password) VALUES (3, 1, 'ngoitom@mum.edu', '$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe');
INSERT INTO `users`(user_id, active, email, password) VALUES (4, 1, 'shaileslassie@mum.edu', '$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe');
INSERT INTO `users`(user_id, active, email, password) VALUES (5, 1, 'rxing@mum.edu', '$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe');


-- User and Role join table
INSERT INTO `user_role`(user_id, role_id) VALUES (1, 3);
INSERT INTO `user_role`(user_id, role_id) VALUES (2, 1);
INSERT INTO `user_role`(user_id, role_id) VALUES (3, 1);
INSERT INTO `user_role`(user_id, role_id) VALUES (4, 2);


-- Admins info
INSERT INTO `admin`(id, name, user_id) VALUES (1, 'Jesse', 2);
INSERT INTO `admin`(id, name, user_id) VALUES (2, 'Natsiner', 3);


-- Faculties info
INSERT INTO `faculty`(id, first_name, last_name, user_id) VALUES (1, 'Sofia', 'Haileslassie', 4);
INSERT INTO `faculty`(id, first_name, last_name, user_id) VALUES(2, 'Rujuan', 'Xing', 5);


-- Date info (everydays date info)
INSERT INTO `date_info`(id, date_record) VALUES(1, '2018-08-04');
INSERT INTO `date_info`(id, date_record) VALUES(2, '2018-11-04');
INSERT INTO `date_info`(id, date_record) VALUES(3, '2019-01-04');


-- TM Attendance slots
INSERT INTO `time_info`(id, time_of_day) VALUES(1, 'EAM');
INSERT INTO `time_info`(id, time_of_day) VALUES(2, 'AM');
INSERT INTO `time_info`(id, time_of_day) VALUES(3, 'PM');


-- University addmission dates info
INSERT INTO entry(id, start_Period, date_info_id) VALUES(1, 'August', 1);
INSERT INTO entry(id, start_Period, date_info_id) VALUES(2, 'November', 2);
INSERT INTO entry(id, start_Period, date_info_id) VALUES(3, 'January', 3);


-- Students info
INSERT INTO `student`(student_id, first_name, last_name, bar_code, entry_id, user_id) VALUES (986826, 'Dawit', 'Mebrahtu', '101100011', 1, 1);


-- University block dates info
INSERT INTO `block`(id, start_date, end_date, period) VALUES(1, '2010-02-21', '2019-03-21', 22);


-- University course catalog 
INSERT INTO `course`(code, name) VALUES('CS545', 'Web Application Architecture');
INSERT INTO `course`(code, name) VALUES('CS572', 'Modern Web Applications');
INSERT INTO `course`(code, name) VALUES('CS425', 'Software Engineering');
INSERT INTO `course`(code, name) VALUES('CS472', 'Web Application Program');


-- Course offered in each block info
INSERT INTO `course_offered`(block_id, course_id, faculty_id) VALUES(1, 'CS545', 2);


-- Course offered in each block and students enrolled in the course info
INSERT INTO `course_offered_students`(course_offered_block_id, course_offered_course_id, students_student_id) VALUES(1, 'CS545', 986826);

-- TM attendance locations
INSERT INTO `place`(id, name) VALUES(1, 'Dalby Hall');
INSERT INTO `place`(id, name) VALUES(2, 'Dome');
INSERT INTO `place`(id, name) VALUES(3, 'Ladies Palace');


-- Students TM checking record
INSERT INTO `tmcheck`(student_id, number_of_checks) VALUES(986826, 2);

-- Students Retreat record
INSERT INTO `retreat`(student_id, number_of_retreats) VALUES(986826, 1);


