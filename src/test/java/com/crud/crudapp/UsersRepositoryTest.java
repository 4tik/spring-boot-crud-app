package com.crud.crudapp;

import com.crud.crudapp.model.Users;
import com.crud.crudapp.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UsersRepositoryTest {
    @Autowired
    private UsersRepository usersRepository;

    @Test
    public void addTestUser(){
        Users users = Users.builder()
                .firstName("Jhon")
                .lastName("Doe")
                .email("jhon_doe@crud.app")
                .password("password")
                .build();
        usersRepository.save(users);

        Assertions.assertThat(users).isNotNull();
        Assertions.assertThat(users.getId()).isGreaterThan(0);
    }
}
