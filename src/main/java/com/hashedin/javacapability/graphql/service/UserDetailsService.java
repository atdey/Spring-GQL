package com.hashedin.javacapability.graphql.service;

import com.hashedin.javacapability.graphql.model.dto.UserDetailsDTO;
import com.hashedin.javacapability.graphql.model.dto.UserDetailsRequest;

import java.util.List;

public interface UserDetailsService {

    UserDetailsDTO addUser(UserDetailsDTO userDetailsDTO);

    UserDetailsDTO addUser(UserDetailsRequest userDetailsDTORequest);

    UserDetailsDTO getUser(Long id);

    UserDetailsDTO getUser(String userName);

    List<UserDetailsDTO> getAllUsers();

}
