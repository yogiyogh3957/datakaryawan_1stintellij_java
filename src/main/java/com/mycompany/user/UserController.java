package com.mycompany.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/")
    public String showUserList(Model model) {
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);
        return "index";
    }

    @GetMapping("users/new")
    public String showNewForm(Model model) {
        model.addAttribute("user", new User());
        return "users-form";
    }

    @PostMapping("/save")
    public String saveUser(User user) {
        service.save(user);
        return "redirect:";
    }
    //nananinaaaas
    @GetMapping("users/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {

        User user = service.get(id);
        model.addAttribute("user", user);
        return "users-form";

    }

    @GetMapping("users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        service.delete(id);
        return "redirect:/";
    }

}
