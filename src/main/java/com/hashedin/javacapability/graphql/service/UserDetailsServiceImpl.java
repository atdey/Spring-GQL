package com.hashedin.javacapability.graphql.service;

import com.hashedin.javacapability.graphql.entity.UserDetails;
import com.hashedin.javacapability.graphql.model.dto.UserDetailsDTO;
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
    public UserDetailsDTO addUser(UserDetailsDTO userDetailsDTO) {
        UserDetails userDetails = new UserDetails();
        modelMapper.map(userDetailsDTO, userDetails);
        userDetailsRepository.save(userDetails);
        userDetailsDTO.setId(userDetails.getId());
        return userDetailsDTO;
    }

    @Override
    public UserDetailsDTO addUser(UserDetailsRequest userDetailsDTORequest) {
        UserDetails userDetails = new UserDetails();
        modelMapper.map(userDetailsDTORequest, userDetails);
        userDetailsRepository.save(userDetails);
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        modelMapper.map(userDetails, userDetailsDTO);
        return userDetailsDTO;
    }

    @Override
    public UserDetailsDTO getUser(Long id) {
        Optional<UserDetails> userDTOOptional =  userDetailsRepository.findById(id);
        if (userDTOOptional.isPresent()) {
            UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
            //UserDetails userDetails = userDTOOptional.get();
            //modelMapper.map(userDTOOptional.get(), userDetailsDTO);
            userDetailsDTO.setId(userDTOOptional.get().getId());
            userDetailsDTO.setUserName(userDTOOptional.get().getUserName());
            userDetailsDTO.setAddress(userDTOOptional.get().getAddress());
            userDetailsDTO.setPhone(userDTOOptional.get().getPhone());
            userDetailsDTO.setUserDetails(userDTOOptional.get());
            return userDetailsDTO;
        }
        throw new RuntimeException("Invalid ID");
    }

    @Override
    public UserDetailsDTO getUser(String userName) {
        Optional<UserDetails> userDTOOptional =  userDetailsRepository.findByUserName(userName);
        if (userDTOOptional.isPresent()) {
            UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
            modelMapper.map(userDTOOptional.get(), userDetailsDTO);
            return userDetailsDTO;
        }
        throw new RuntimeException("Invalid UserName");
    }

    @Override
    public List<UserDetailsDTO> getAllUsers() {
        return userDetailsRepository.findAll().stream().map(userDetails -> modelMapper.map(userDetails,
                UserDetailsDTO.class)).collect(Collectors.toList());
    }
}
