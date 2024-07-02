package com.crud.crudapp.controller;

import com.crud.crudapp.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("users")
public class UsersController {

    private final UsersService usersService;

    @GetMapping
    public String index(Model model){
        model.addAttribute("users", usersService.getUsers());
        return "users/index";
    }
}
