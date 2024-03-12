package com.example.Coffee.controller;

import com.example.Coffee.entity.Ingredient;
import com.example.Coffee.service.GenericService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientController {
    @Autowired
    GenericService<Ingredient> service;
    private final Logger log = LoggerFactory.getLogger(IngredientController.class);

    @GetMapping("/api/ingredients")
    public List<Ingredient> findAll() {
        return service.findAll();
    }

    @GetMapping("/api/ingredients/{id}")
    @Operation(summary = "Find ingredient", description = "Find a ingredient (PK)")
    public ResponseEntity<Ingredient> findOneById(@PathVariable Long id) {
        Ingredient ingredient = service.findById(id);
        if (ingredient != null) {
            return ResponseEntity.ok(ingredient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/ingredients")
    public ResponseEntity<Ingredient> create(@RequestBody Ingredient ingredient) {
        if (ingredient.getIdIngredient() != null) {
            log.warn("Trying to create a Ingredient with ID");
            return ResponseEntity.badRequest().build();
        }
        Ingredient result = service.save(ingredient);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/api/ingredients")
    public ResponseEntity<Ingredient> update(@RequestBody Ingredient ingredient) {
        if (ingredient.getIdIngredient() == null) {
            log.warn("Trying to update a non existent ingredient");
            return ResponseEntity.badRequest().build();
        }
        if (!service.exist(ingredient.getIdIngredient())) {
            log.warn("Trying to update a non existent ingredient");
            return ResponseEntity.notFound().build();
        }

        //El proceso de actualización
        Ingredient result = service.save(ingredient);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/api/ingredients/{id}")
    public ResponseEntity<Ingredient> delete(@PathVariable Long id) {
        if (!service.exist(id)) {
            log.warn("Trying to delete a non existent ingredient");
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/ingredients")
    public ResponseEntity<Ingredient> deleteAll() {
        log.info("REST Request for deleting all ingredients ");
        service.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
