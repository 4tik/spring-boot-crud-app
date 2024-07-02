package com.crud.crudapp.service.impl;

import com.crud.crudapp.model.Users;
import com.crud.crudapp.repository.UsersRepository;
import com.crud.crudapp.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;

    @Override
    public List<Users> getUsers() {
        return usersRepository.findAll();
    }

    @Override
    public void store(Users users) {
        users.setCreatedOn(new Date(System.currentTimeMillis()));
        usersRepository.save(users);
    }

    @Override
    public Users getById(Long id) {
        return usersRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("user not found"));
    }

    @Override
    public void update(Users users) {
        usersRepository.save(users);
    }

    @Override
    public void deleteById(Long id) {
        usersRepository.deleteById(id);
    }
}
