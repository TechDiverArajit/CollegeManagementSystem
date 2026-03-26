package com.springbootprojects.CollegeManagementSystem.Services;

import com.springbootprojects.CollegeManagementSystem.DTOs.SignUpDTO;
import com.springbootprojects.CollegeManagementSystem.DTOs.UserDTO;
import com.springbootprojects.CollegeManagementSystem.Entities.User;
import com.springbootprojects.CollegeManagementSystem.Exceptions.ResourceNotFoundException;
import com.springbootprojects.CollegeManagementSystem.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmailID(username).orElseThrow(()-> new ResourceNotFoundException("No username found with" + username));
    }

    public UserDTO createUser(SignUpDTO signUpDTO) {
        Optional<User> user = userRepository.findByEmailID(signUpDTO.getEmailID());
        if(user.isPresent()){
            throw new BadCredentialsException("User already exists , please login");
        }
        User toBeCreated = modelMapper.map(signUpDTO,User.class);
        toBeCreated.setPassword(passwordEncoder.encode(toBeCreated.getPassword()));
        User savedUser = userRepository.save(toBeCreated);

        return modelMapper.map(savedUser,UserDTO.class);

    }
}
