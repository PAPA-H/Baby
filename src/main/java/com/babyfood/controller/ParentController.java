package com.babyfood.controller;

import com.babyfood.domain.Parent;
import com.babyfood.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParentController {
    @Autowired
    ParentService parentService;

    @PostMapping("/api/prentAdd")
    public String addParent(String name, String nick){
        Parent parent = new Parent();
        parent.setName(name);
        parent.setNick(nick);
        return parentService.addParent(parent);
    }

    @GetMapping("/api/parents")
    public List<Parent.Response> parentList(){
        return parentService.parentList();
    }

    @GetMapping("/api/parents2")
    public List<Parent> parentList2(){
        return parentService.list();
    }

}
