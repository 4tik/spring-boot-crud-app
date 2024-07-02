package com.crud.crudapp.service.impl;

import com.crud.crudapp.model.Users;
import com.crud.crudapp.repository.UsersRepository;
import com.crud.crudapp.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;

    @Override
    public List<Users> getUsers() {
        return usersRepository.findAll();
    }
}
