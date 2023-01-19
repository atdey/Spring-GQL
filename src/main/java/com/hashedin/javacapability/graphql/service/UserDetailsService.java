package com.hashedin.javacapability.graphql.service;

import com.hashedin.javacapability.graphql.model.response.UserDetailsResponse;
import com.hashedin.javacapability.graphql.model.request.UserDetailsRequest;

import java.util.List;

public interface UserDetailsService {

    UserDetailsResponse addUser(UserDetailsRequest userDetailsDTORequest);

    UserDetailsResponse updateUser(Long id, UserDetailsRequest userDetailsDTORequest);

    void deleteUser(Long id);

    UserDetailsResponse getUser(Long id);

    UserDetailsResponse getUser(String userName);

    List<UserDetailsResponse> getAllUsers();

}
