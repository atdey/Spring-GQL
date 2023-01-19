package com.hashedin.javacapability.graphql.model.response;

import lombok.Data;

@Data
public class CourseResponse {

    private Long id;
    private String courseName;
    private String category;
    private Long userDetailsId;
}
