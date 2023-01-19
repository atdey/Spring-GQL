package com.hashedin.javacapability.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.hashedin.javacapability.graphql.entity.Course;
import com.hashedin.javacapability.graphql.model.enums.CourseFilter;
import com.hashedin.javacapability.graphql.model.response.CourseResponse;
import com.hashedin.javacapability.graphql.model.response.UserDetailsResponse;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserResolver implements GraphQLResolver<UserDetailsResponse> {

    @Autowired
    private ModelMapper modelMapper;

    public Set<CourseResponse> getCourses(UserDetailsResponse userDetailsResponse, CourseFilter courseFilter) {
        Set<CourseResponse> courseResponses = new HashSet<>();
        if (userDetailsResponse.getUserDetails().getCourses() != null) {
            courseResponses = userDetailsResponse.getUserDetails().getCourses().stream()
                    .filter(course -> courseFilter==null || course.getCourseName().equalsIgnoreCase(courseFilter.name()))
                    .map(course -> modelMapper.map(course, CourseResponse.class))
                    .collect(Collectors.toSet());
        }
        return courseResponses;
    }
}
