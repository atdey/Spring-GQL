package com.hashedin.javacapability.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.hashedin.javacapability.graphql.model.response.UserDetailsResponse;
import com.hashedin.javacapability.graphql.model.request.UserDetailsRequest;
import com.hashedin.javacapability.graphql.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMutation implements GraphQLMutationResolver {

    @Autowired
    private UserDetailsService userDetailsService;

    public UserDetailsResponse createUser(UserDetailsRequest userDetailsRequest) {
        return userDetailsService.addUser(userDetailsRequest);
    }

    public UserDetailsResponse updateUser(Long id, UserDetailsRequest userDetailsRequest) {
        return userDetailsService.updateUser(id, userDetailsRequest);
    }

    public String deleteUser(Long id) {
        userDetailsService.deleteUser(id);
        return "Data Deleted";
    }
}
