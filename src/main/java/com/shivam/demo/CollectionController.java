package com.shivam.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class CollectionController{
    @RequestMapping("/todo")

    

    // create an array of users and display all of them
    public String getUser(Model model){
        model.addAttribute("column", Arrays.asList(
            new Collection("section A", 
                new String[]{"item 1", "item 2", "item 3", "item 4"}),
            new Collection("section B", 
                new String[]{"item 4", "item 5", "item 6"}),
            new Collection("section C", 
                new String[]{"item 7", "item 8", "item 9"})
            ));
        return "todo";
    }

}

