package com.endterm.endterm.repository;

import com.endterm.endterm.entity.Course;
import com.endterm.endterm.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;


    //Adding information about course 1-1
    @Test
    public void SaveCourseMaterial(){
        Course course =
                Course.builder()
                        .title("Engineering")
                        .credit(6)
                        .build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.engineering.com")
                        .course(course)
                        .build();

        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials =
                repository.findAll();
        System.out.println("courseMaterials = " + courseMaterials);
    }
}