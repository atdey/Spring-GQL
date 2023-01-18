package com.hashedin.javacapability.graphql.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hashedin.javacapability.graphql.entity.UserDetails;
import lombok.Data;

import javax.persistence.*;

@Data
public class CourseResponse {

    private Long id;
    private String courseName;
    private String category;
    private Long userDetailsId;
}
