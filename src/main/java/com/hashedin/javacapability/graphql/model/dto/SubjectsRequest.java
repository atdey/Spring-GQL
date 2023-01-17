package com.hashedin.javacapability.graphql.model.dto;

import lombok.Data;

@Data
public class SubjectsRequest {

    private Long id;
    private String subjectName;
    private String stream;
    private Long userDetailsId;
}
