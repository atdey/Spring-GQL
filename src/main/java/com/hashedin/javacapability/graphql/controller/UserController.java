package com.hashedin.javacapability.graphql.controller;

import com.hashedin.javacapability.graphql.model.dto.UserDetailsDTO;
import com.hashedin.javacapability.graphql.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/user")
    public ResponseEntity<String> addUser(@RequestBody UserDetailsDTO userDetailsDTO) {
        userDetailsService.addUser(userDetailsDTO);
        return ResponseEntity.ok("Data inserted");
    }

    @GetMapping("/user/id/{id}")
    public ResponseEntity<UserDetailsDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userDetailsService.getUser(id));
    }

    @GetMapping("/user/username/{name}")
    public ResponseEntity<UserDetailsDTO> getUserByName(@PathVariable String name) {
        return ResponseEntity.ok(userDetailsService.getUser(name));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDetailsDTO>> getAllUsers() {
        return ResponseEntity.ok(userDetailsService.getAllUsers());
    }
}
