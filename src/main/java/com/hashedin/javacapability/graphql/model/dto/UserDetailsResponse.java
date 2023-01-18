package com.hashedin.javacapability.graphql.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hashedin.javacapability.graphql.entity.UserDetails;
import lombok.Data;

import java.util.Set;

@Data
public class UserDetailsResponse {
    @JsonIgnore
    private Long id;
    private String userName;
    private String address;
    private String phone;
    private Set<CourseResponse> courses;
    private UserDetails userDetails;
}
