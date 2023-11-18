package com.pictian.controller;

import com.pictian.models.Answer;
import com.pictian.models.Input;
import com.pictian.models.InputML;
import com.pictian.services.Fileorganize;
import com.pictian.services.Mmlprogram;
import com.pictian.services.PortfolioOpt;
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
    @Autowired
    Mmlprogram mmlprogram;
    @Autowired
    PortfolioOpt portfolioOpt;

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

    @PostMapping("/mlmm-program")
    public @ResponseBody Answer mlmm(@RequestBody InputML inputMl){
        List<String[]> inputArray = inputMl.getInputs();
        return mmlprogram.mmlProgram(inputArray);
    }

    @PostMapping("/portfolio-operations")
    public @ResponseBody Answer portfolio(@RequestBody InputML inputMl){
        List<String[]> inputArray = inputMl.getInputs();
        System.out.println(inputArray.get(0)[0]);
        return portfolioOpt.portfolioOperation(inputArray);
    }
}
