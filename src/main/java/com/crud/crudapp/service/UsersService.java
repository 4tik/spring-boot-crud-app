package com.crud.crudapp.service;

import com.crud.crudapp.model.Users;
import java.util.List;

public interface UsersService {
    public List<Users> getUsers();
    public void store(Users users);
    public Users getById(Long id);
    public void update(Users users);
    public void deleteById(Long id);
}
