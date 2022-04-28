package com.endterm.endterm.repository;

import com.endterm.endterm.entity.Course;
import com.endterm.endterm.entity.Student;
import com.endterm.endterm.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CourseRepositoryTest {

        @Autowired
        private CourseRepository courseRepository;


        @Test
        public void Courses(){
            List<Course> courses =
                    courseRepository.findAll();
            System.out.println("courses = " + courses);

        }
    /*
    @Test
    public void saveCourseWithStudentAndTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Lizze")
                .lastName("Morgan")
                .build();

        Student student = Student.builder()
                .firstName("Abhishek")
                .lastName("Singh")
                .emailId("abhishek@gmail.com")
                .build();

        Course course = Course
                .builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }

     */
}