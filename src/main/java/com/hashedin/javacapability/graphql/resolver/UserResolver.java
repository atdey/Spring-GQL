package com.hashedin.javacapability.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.hashedin.javacapability.graphql.entity.Subjects;
import com.hashedin.javacapability.graphql.model.dto.SubjectsDTO;
import com.hashedin.javacapability.graphql.model.dto.UserDetailsDTO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class UserResolver implements GraphQLResolver<UserDetailsDTO> {

    @Autowired
    private ModelMapper modelMapper;

    public Set<SubjectsDTO> getSubjects(UserDetailsDTO userDetailsDTO) {
        Set<SubjectsDTO> subjectsDTOS = new HashSet<>();
        if (userDetailsDTO.getUserDetails().getSubjects() != null) {
            for (Subjects subjects : userDetailsDTO.getUserDetails().getSubjects()) {
                subjectsDTOS.add(modelMapper.map(subjects, SubjectsDTO.class));
            }
        }
        return subjectsDTOS;
    }
}
