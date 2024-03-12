package com.example.Coffee.controller;

import com.example.Coffee.entity.MainDish;
import com.example.Coffee.service.GenericService;
import com.sun.tools.javac.Main;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainDishController {
    @Autowired
    GenericService<MainDish> service;
    private final Logger log = LoggerFactory.getLogger(MainDishController.class);

    @GetMapping("/api/maindishes")
    public List<MainDish> findAll() {
        return service.findAll();
    }

    @GetMapping("/api/maindishes/{id}")
    @Operation(summary = "Find maindish", description = "Find a maindish (PK)")
    public ResponseEntity<MainDish> findOneById(@PathVariable Long id) {
        MainDish mainDish = service.findById(id);
        if (mainDish != null) {
            return ResponseEntity.ok(mainDish);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/maindishes")
    public ResponseEntity<MainDish> create(@RequestBody MainDish mainDish) {
        if (mainDish.getIdMainDish() != null) {
            log.warn("Trying to create a MainDish with ID");
            return ResponseEntity.badRequest().build();
        }
        MainDish result = service.save(mainDish);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/api/maindishes")
    public ResponseEntity<MainDish> update(@RequestBody MainDish mainDish) {
        if (mainDish.getIdMainDish() == null) {
            log.warn("Trying to update a non existent maindish");
            return ResponseEntity.badRequest().build();
        }
        if (!service.exist(mainDish.getIdMainDish())) {
            log.warn("Trying to update a non existent maindish");
            return ResponseEntity.notFound().build();
        }

        MainDish result = service.save(mainDish);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/api/maindishes/{id}")
    public ResponseEntity<MainDish> delete(@PathVariable Long id) {
        if (!service.exist(id)) {
            log.warn("Trying to delete a non existent maindish");
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/maindishes")
    public ResponseEntity<MainDish> deleteAll() {
        log.info("REST Request for deleting all maindishes ");
        service.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
