package com.pictian.controller;

import com.pictian.models.Answer;
import com.pictian.models.Input;
import com.pictian.services.Fileorganize;
import com.pictian.services.Profitmax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

@RestController
public class Controller {
    @Autowired
    Profitmax profitmax;
    @Autowired
    Fileorganize fileorganize;

    @RequestMapping("/")
    public String hello(){
      return "hello !";
    }

    @PostMapping("/profit-maximization")
    public @ResponseBody Answer profit(@RequestBody Input input){
        String[] inputArray = input.getInputs();
        return profitmax.profitMaximization(inputArray);
    }

    @PostMapping("/file-reorganization")
    public @ResponseBody Answer file(@RequestBody Input input){
        String[] inputArray = input.getInputs();
        return fileorganize.fileReorganization(inputArray);
    }
}
