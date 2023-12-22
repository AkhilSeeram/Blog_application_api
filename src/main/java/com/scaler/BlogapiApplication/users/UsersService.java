package com.scaler.BlogapiApplication.users;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    // we can write @Autowired in constructor. it is optional.
    public UsersService(UsersRepository usersRepository, @Autowired PasswordEncoder passwordEncoder){
        this.usersRepository=usersRepository;
        this.passwordEncoder=passwordEncoder;
    }
    public UserEntity createUser(String name,String password,String email){
        var savedUser=usersRepository.save(UserEntity.builder()
                        .username(name)
                        .password(passwordEncoder.encode(password))
                        .email(email)
                        .build());

        return savedUser;
    }
    public UserEntity loginUser(String name,String password){
        var savedUser=usersRepository.findByUsername(name);
        if(savedUser != null){
            if(passwordEncoder.matches(password,savedUser.getPassword())) return savedUser;
        }
        throw new IllegalArgumentException("Invalid username or password");
    }

}
