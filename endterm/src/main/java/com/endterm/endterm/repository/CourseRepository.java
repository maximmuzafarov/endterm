package com.endterm.endterm.repository;

import com.endterm.endterm.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface CourseRepository extends JpaRepository<Course, Long> {
}
