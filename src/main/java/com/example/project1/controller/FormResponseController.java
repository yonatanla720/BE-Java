package com.example.project1.controller;

import com.example.project1.model.FormResponse;
import com.example.project1.repository.FormResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/form-response")
public class FormResponseController {

    private FormResponseRepository formResponseRepository;

    @Autowired
    public FormResponseController(FormResponseRepository formResponseRepository){
        this.formResponseRepository = formResponseRepository;
    }

    @PostMapping
    public ResponseEntity<FormResponse> createFormResponse(@RequestBody FormResponse formResponse) {
        FormResponse savedFormResponse = formResponseRepository.save(formResponse);
        return new ResponseEntity<>(savedFormResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FormResponse>> getAllFormResponses() {
        List<FormResponse> formResponses = formResponseRepository.findAll();
        return new ResponseEntity<>(formResponses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormResponse> getFormResponseById(@PathVariable Long id) {
        Optional<FormResponse> formResponse = formResponseRepository.findById(id);
        return formResponse.map(response -> new ResponseEntity<>(response, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



}
