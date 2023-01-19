package com.hashedin.javacapability.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.hashedin.javacapability.graphql.model.response.UserDetailsResponse;
import com.hashedin.javacapability.graphql.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserQuery implements GraphQLQueryResolver {

    @Autowired
    private UserDetailsService userDetailsService;

    public List<UserDetailsResponse> userList() {
        return userDetailsService.getAllUsers();
    }

    public UserDetailsResponse userById(Long id) {
        return userDetailsService.getUser(id);
    }
}
