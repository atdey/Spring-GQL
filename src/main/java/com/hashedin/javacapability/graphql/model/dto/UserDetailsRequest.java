package com.hashedin.javacapability.graphql.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Set;

@Data
public class UserDetailsRequest {

    private String userName;
    private String address;
    private String phone;
    private Set<SubjectsRequest> subjects;
}
