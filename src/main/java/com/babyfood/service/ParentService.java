package com.babyfood.service;

import com.babyfood.domain.Parent;
import com.babyfood.repo.ParentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParentService {
    @Autowired
    ParentRepo parentRepo;

    public String addParent(Parent parent){
        parentRepo.save(parent);
        return "Parent Added Success";
    }

    public List<Parent.Response> parentList(){
        List<Parent> parent = parentRepo.findAll();
        List<Parent.Response> result = parent.stream().map(p -> new Parent.Response(p)).collect(Collectors.toList());
        return result;
    }

    public List<Parent> list(){
        return parentRepo.findAll();
    }

    public Parent getOne(Long parentId){
        return parentRepo.getById(parentId);
    }

}
