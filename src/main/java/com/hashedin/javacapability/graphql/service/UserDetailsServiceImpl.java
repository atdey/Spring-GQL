package com.hashedin.javacapability.graphql.service;

import com.hashedin.javacapability.graphql.entity.UserDetails;
import com.hashedin.javacapability.graphql.model.dto.UserDetailsResponse;
import com.hashedin.javacapability.graphql.model.dto.UserDetailsRequest;
import com.hashedin.javacapability.graphql.repository.UserDetailsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDetailsResponse addUser(UserDetailsRequest userDetailsDTORequest) {
        UserDetails userDetails = new UserDetails();
        modelMapper.map(userDetailsDTORequest, userDetails);
        userDetailsRepository.save(userDetails);
        UserDetailsResponse userDetailsResponse = new UserDetailsResponse();
        modelMapper.map(userDetails, userDetailsResponse);
        return userDetailsResponse;
    }

    @Override
    public UserDetailsResponse updateUser(Long id, UserDetailsRequest userDetailsDTORequest) {
        UserDetails userDetails = new UserDetails();
        modelMapper.map(userDetailsDTORequest, userDetails);
        userDetails.setId(id);
        userDetailsRepository.save(userDetails);
        UserDetailsResponse userDetailsResponse = new UserDetailsResponse();
        modelMapper.map(userDetails, userDetailsResponse);
        return userDetailsResponse;
    }

    @Override
    public void deleteUser(Long id) {
        userDetailsRepository.deleteById(id);
    }

    @Override
    public UserDetailsResponse getUser(Long id) {
        Optional<UserDetails> userDTOOptional =  userDetailsRepository.findById(id);
        if (userDTOOptional.isPresent()) {
            UserDetailsResponse userDetailsResponse = new UserDetailsResponse();
            //UserDetails userDetails = userDTOOptional.get();
            //modelMapper.map(userDTOOptional.get(), userDetailsDTO);
            userDetailsResponse.setId(userDTOOptional.get().getId());
            userDetailsResponse.setUserName(userDTOOptional.get().getUserName());
            userDetailsResponse.setAddress(userDTOOptional.get().getAddress());
            userDetailsResponse.setPhone(userDTOOptional.get().getPhone());
            userDetailsResponse.setUserDetails(userDTOOptional.get());
            return userDetailsResponse;
        }
        throw new RuntimeException("Invalid ID");
    }

    @Override
    public UserDetailsResponse getUser(String userName) {
        Optional<UserDetails> userDTOOptional =  userDetailsRepository.findByUserName(userName);
        if (userDTOOptional.isPresent()) {
            UserDetailsResponse userDetailsResponse = new UserDetailsResponse();
            modelMapper.map(userDTOOptional.get(), userDetailsResponse);
            return userDetailsResponse;
        }
        throw new RuntimeException("Invalid UserName");
    }

    @Override
    public List<UserDetailsResponse> getAllUsers() {
        return userDetailsRepository.findAll().stream().map(userDetails -> modelMapper.map(userDetails,
                UserDetailsResponse.class)).collect(Collectors.toList());
    }
}
