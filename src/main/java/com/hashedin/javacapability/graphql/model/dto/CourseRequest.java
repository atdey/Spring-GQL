package com.hashedin.javacapability.graphql.model.dto;

import lombok.Data;

@Data
public class CourseRequest {

    private Long id;
    private String courseName;
    private String category;
    private Long userDetailsId;
}
