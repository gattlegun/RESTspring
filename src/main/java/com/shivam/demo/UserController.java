package com.shivam.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class UserController{

    @RequestMapping("/users")
    // create an array of users and display all of them
    public String getUser(Model model){
        model.addAttribute("user", Arrays.asList(
            new User("Shivam", 18),
            new User("Michael", 18),
            new User("Aldric", 18),
            new User("Ali", 99)
            ));
        return "users";
    }

}

