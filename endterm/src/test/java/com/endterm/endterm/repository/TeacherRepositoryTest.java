package com.endterm.endterm.repository;

import com.endterm.endterm.entity.Course;
import com.endterm.endterm.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest

class TeacherRepositoryTest {


    @Autowired
    private TeacherRepository teacherRepository;


    //Infor for teacher and adding courses ! 1-many
    @Test
    public void saveTeacher(){

        Course coursePython = Course.builder()
                .title("Python")
                .credit(5)
                .build();

        Course courseJava = Course.builder()
                .title("Java")
                .credit(6)
                .build();

        Teacher teacher =
                Teacher.builder()
                        .firstName("Maxim")
                        .lastName("Petrov")
                        .courses(List.of(coursePython,courseJava))
                        .build();

        teacherRepository.save(teacher);

    }
}