package com.scaler.BlogapiApplication.users;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UsersRepositoryTests {
    @Autowired private UsersRepository usersRepository;

    @Test
    public void createUser(){
        UserEntity userEntity=new UserEntity(
                "akhil",
                "akhil@gmail.com",
                "akhil@123",
                "akhil is created"
        );
        var user =usersRepository.save(userEntity);
        Assertions.assertNotNull(user.getId());
    }

    @Test
    public void findByUsername(){
        UserEntity userEntity1=new UserEntity(
                "akhil",
                "akhil@gmail.com",
                "akhil@123",
                "akhil is created"
        );
        UserEntity userEntity2=new UserEntity(
                "seeram",
                "seeram@gmail.com",
                "seeram@123",
                "seeram is created"
        );
        usersRepository.save(userEntity1);
        usersRepository.save(userEntity2);

        var user1=usersRepository.findByUsername("akhil");
        var user2=usersRepository.findByUsername("seeram");
        Assertions.assertEquals("akhil@gmail.com",user1.getEmail());
        Assertions.assertEquals("sdada",user2.getEmail());
    }
}
