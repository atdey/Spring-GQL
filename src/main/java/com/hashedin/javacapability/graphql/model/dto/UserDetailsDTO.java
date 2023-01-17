package com.hashedin.javacapability.graphql.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hashedin.javacapability.graphql.entity.Subjects;
import com.hashedin.javacapability.graphql.entity.UserDetails;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
public class UserDetailsDTO {
    @JsonIgnore
    private Long id;
    private String userName;
    private String address;
    private String phone;
    private Set<SubjectsDTO> subjects;
    private UserDetails userDetails;
}
