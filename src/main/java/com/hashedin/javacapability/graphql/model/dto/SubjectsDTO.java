package com.hashedin.javacapability.graphql.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hashedin.javacapability.graphql.entity.UserDetails;
import lombok.Data;

import javax.persistence.*;

@Data
public class SubjectsDTO {

    private Long id;
    private String subjectName;
    private String stream;
    private Long userDetailsId;
}
