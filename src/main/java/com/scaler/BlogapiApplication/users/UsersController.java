package com.scaler.BlogapiApplication.users;

import com.scaler.BlogapiApplication.security.TokenService;
import com.scaler.BlogapiApplication.users.dto.CreateUserRequestDto;
import com.scaler.BlogapiApplication.users.dto.LoginUserRequestDto;
import com.scaler.BlogapiApplication.users.dto.UserResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;
    private final ModelMapper modelMapper;
    private  final TokenService tokenService;
    public UsersController(UsersService usersService,@Autowired ModelMapper modelMapper,@Autowired TokenService tokenService){
        this.usersService=usersService;
        this.modelMapper=modelMapper;
        this.tokenService=tokenService;
    }

    @PostMapping("/signup")
    ResponseEntity<UserResponseDto> signupUser(@RequestBody CreateUserRequestDto createUserRequestDto ){
        var savedUser=usersService.createUser(createUserRequestDto.getUsername(), createUserRequestDto.getEmail(), createUserRequestDto.getPassword());
        var userResponse= modelMapper.map(savedUser,UserResponseDto.class);
        userResponse.setToken(tokenService.createToken(savedUser.getUsername()));
        return ResponseEntity.accepted().body(userResponse);
    }

    @PostMapping("/login")
    ResponseEntity<UserResponseDto> loginUser(@RequestBody LoginUserRequestDto loginUserRequestDto){
        var savedUser=usersService.loginUser(loginUserRequestDto.getUsername(),loginUserRequestDto.getPassword());
        var userResponse=modelMapper.map(savedUser,UserResponseDto.class);
        userResponse.setToken(tokenService.createToken(savedUser.getUsername()));
        return ResponseEntity.accepted().body(userResponse);
    }

    @PatchMapping("/{id}")
    ResponseEntity<UserResponseDto> updateUser(){
        return null;
    }
}
