package com.crud.crudapp.controller;

import com.crud.crudapp.model.Users;
import com.crud.crudapp.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("user", new Users());
        return "users/create";
    }

    @PostMapping("/store")
    public String store(Users users){
        System.out.println(users);
        if(users.getId()==null){
            usersService.store(users);
        }
        else {
            usersService.update(users);
        }
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String get(@PathVariable Long id, Model model){
        model.addAttribute("user", usersService.getById(id));
        return "users/create";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){
        usersService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "The user ID " + id + " has been deleted.");
        return "redirect:/users";
    }

}
