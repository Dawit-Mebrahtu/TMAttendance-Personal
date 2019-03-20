package edu.mum.tmAttendanceReport.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.tmAttendanceReport.entity.Block;
import edu.mum.tmAttendanceReport.entity.Student;

@Repository
public interface BlockRepository extends CrudRepository<Block, Long>{



}
