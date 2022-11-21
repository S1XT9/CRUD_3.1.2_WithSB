package com.crud.boot.controller;

import com.crud.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.crud.boot.model.User;

@Controller
public class UsersControllerForAll {
    private final UserService userService;
    private final String redirect = "redirect:/";

    @Autowired
    public UsersControllerForAll(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.allUsers());
        return "home";
    }

    @GetMapping(value = "/createNew")
    public String createNewUserPage(Model model) {
        model.addAttribute("user", new User());
        return "createNew";
    }

    @PostMapping(value = "/")
    public String createNewUser(@ModelAttribute("user") User user) {
        userService.create(user);
        return redirect;
    }

    @GetMapping(value = "/{id}")
    public String readUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute(userService.read(id));
        return "readUser";
    }

    @GetMapping(value = "/{id}/updateUser")
    public String updateUserPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.read(id));
        return "updateUser";
    }

    @PatchMapping(value = "/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return redirect;
    }

    @DeleteMapping(value = "/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return redirect;
    }
}

