package com.endterm.endterm.entity;


import lombok.*;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")

public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )

    //Creating atrb for Course Material column
    private Long courseMaterialId;
    private String url;


    //1
    @OneToOne(
            //any operation
            cascade = CascadeType.ALL,
            //
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            //Определение название столбца, на какой будет ссылаться
            name = "course_id",
            referencedColumnName = "courseId"
    )

    private Course course;

}
