package com.hashedin.javacapability.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class TestQuery implements GraphQLQueryResolver {

    public String helloWorld() {
        return "Hello World!!!";
    }

    public String byeWorld() {
        return "Bye World :(";
    }

    public String fullName(String firstName, String lastName) {
        return firstName +" "+ lastName;
    }
}
