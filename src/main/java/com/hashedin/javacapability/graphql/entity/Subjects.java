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
@Table(name = "subjects")
public class Subjects {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "subjects_seq")
    private Long id;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "stream")
    private String stream;

    @ManyToOne
    @JoinColumn(name = "user_details_id", insertable = false, updatable = false)
    private UserDetails userDetailsId;
}
