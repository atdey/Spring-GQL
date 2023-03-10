package com.hashedin.javacapability.graphql.model.request;

import lombok.Data;

import java.util.Set;

@Data
public class UserDetailsRequest {

    private String userName;
    private String address;
    private String phone;
    private Set<CourseRequest> courses;
}
