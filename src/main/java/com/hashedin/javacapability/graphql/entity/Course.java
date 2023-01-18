package com.hashedin.javacapability.graphql.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "course_seq")
    private Long id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "category")
    private String category;

    @Column(name = "user_details_id")
    private Long userDetailsId;
}
