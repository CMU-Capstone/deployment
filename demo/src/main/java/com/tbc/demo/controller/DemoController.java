package com.tbc.demo.controller;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("demo_controller/api")
public class DemoController {

    @Autowired
    ServiceController service;

    @CrossOrigin(origins = "*")
    @GetMapping("/getQuestionsByProblems")
    public Document searchQuestionsByProblems(@RequestParam String problem){
        try {
            return service.getGitByProblem(problem);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // Handle the error - this error should never occur but if it does, the server should be in some serious trouble
        return new Document("Error", "An Error was found when fetching your request. " +
                "This error is an internal one and has to do with server encoding. Please " +
                "contact your administrator for assistance.");
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getTechByProblems")
    public Document searchTechByProblems(@RequestParam String problem){
        try {
            return service.getTechByProblem(problem);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // Handle the error - this error should never occur but if it does, the server should be in some serious trouble
        return new Document("Error", "An Error was found when fetching your request. " +
                "This error is an internal one and has to do with server encoding. Please " +
                "contact your administrator for assistance.");
    }
}
