package com.hashedin.javacapability.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.hashedin.javacapability.graphql.entity.Course;
import com.hashedin.javacapability.graphql.model.dto.CourseResponse;
import com.hashedin.javacapability.graphql.model.dto.UserDetailsResponse;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class UserResolver implements GraphQLResolver<UserDetailsResponse> {

    @Autowired
    private ModelMapper modelMapper;

    public Set<CourseResponse> getCourses(UserDetailsResponse userDetailsResponse) {
        Set<CourseResponse> courseResponses = new HashSet<>();
        if (userDetailsResponse.getUserDetails().getCourses() != null) {
            for (Course course : userDetailsResponse.getUserDetails().getCourses()) {
                courseResponses.add(modelMapper.map(course, CourseResponse.class));
            }
        }
        return courseResponses;
    }
}
