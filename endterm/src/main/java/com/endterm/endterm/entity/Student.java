package com.endterm.endterm.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(
                name = "emailid_unique",
                columnNames = "email_address"
        )
)

public class Student {
    //prv key
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    //automat gen
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    //creating attrb for Student column
    private Long studentId;
    private String firstName;
    private String lastName;

    //rel pol with stlb
    @Column(
            name = "email_address",
            nullable = false
    )
    private String emailId;



    @Embedded
    private Guardian guardian;

}
