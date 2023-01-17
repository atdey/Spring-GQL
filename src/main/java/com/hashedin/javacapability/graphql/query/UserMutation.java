package com.hashedin.javacapability.graphql.query;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.hashedin.javacapability.graphql.model.dto.UserDetailsDTO;
import com.hashedin.javacapability.graphql.model.dto.UserDetailsRequest;
import com.hashedin.javacapability.graphql.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMutation implements GraphQLMutationResolver {

    @Autowired
    private UserDetailsService userDetailsService;

    public UserDetailsDTO createUser(UserDetailsRequest userDetailsDTORequest) {
        return userDetailsService.addUser(userDetailsDTORequest);
    }
}
