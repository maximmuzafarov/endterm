package com.endterm.endterm.repository;

import com.endterm.endterm.entity.Guardian;
import com.endterm.endterm.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest


class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("muzafarov@gmail.com")
                .firstName("Maxim")
                .lastName("Muzafarov")
                //.guardianName("Vladlen")
                //.guardianEmail("vladlen@gmail.com")
                //.guardianMobile("877725433721")
                .build();

        studentRepository.save(student);

    }
    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .email("vladlen@gmail.com")
                .name("Vladlen")
                .mobile("87772543321")
                .build();

        Student student = Student.builder()
                .firstName("Matvei")
                .emailId("matvei@gmail.com")
                .lastName("Petrov")
                .guardian(guardian)
                .build();
        studentRepository.save((student));
    }


    @Test
    public void printAllStudent(){
        List<Student> studentList =
                studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }
    @Test
    public  void printStudentByFirstNameContaining(){

        List<Student> students =
                studentRepository.findByFirstNameContaining("Mat");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students =
                studentRepository.findByGuardianName("Vladlen");
        System.out.println("students = " + students);
    }


    @Test
    public void printgetStudentByEmailAddress() {
        Student student =
                studentRepository.getStudentByEmailAddress("muzafarov@gmail.com");
        System.out.println("student = " + student);
    }


    //Search firstname know only mail
    @Test
    public void printgetStudentFirstNameByEmailAddress() {
        String firstName =
                studentRepository.getStudentFirstNameByEmailAddress("matvei@gmail.com");
        System.out.println("firstName = " + firstName);
    }


    @Test
    public void printgetStudentByEmailAddressNative(){
        Student student =
                studentRepository.getStudentByEmailAddressNative("matvei@gmail.com");
        System.out.println("student = " + student);

    }

    @Test
    public void printgetStudentByEmailAddressNativeNameParam(){
        Student student =
                studentRepository.getStudentByEmailAddressNativeNameParam("matvei@gmail.com");
        System.out.println("student = " + student);

    }

    //Update information bd
    @Test
    public  void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId("Maxim Muzafarov","muzafarov@gmail.com");
    }

}