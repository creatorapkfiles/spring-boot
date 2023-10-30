package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/create")
    public String createUser(User user) {
        return "create";
    }
    @PostMapping("/create")
    public String create(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
    @GetMapping("/update")
    public String updateUser(Model model, @RequestParam("id") Long id) {
        model.addAttribute("user", userService.findById(id));
        return "update";
    }
    @PostMapping("/update")
    public String update (@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

}
