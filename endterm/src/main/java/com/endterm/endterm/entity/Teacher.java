package com.endterm.endterm.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Teacher {

    @Id
    @SequenceGenerator(
            //main seq
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    //creating attrb for Teacher column
    private Long teacherId;
    private String firstName;
    private String lastName;

    @OneToMany(
            cascade = CascadeType.ALL
    )

    //ссылается на первичный ключ, для какой именно определнной колонки
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"

    )

    private List<Course> courses;

}
