package com.example.Coffee.controller;

import com.example.Coffee.entity.Menu;
import com.example.Coffee.service.MenuService;
import com.sun.tools.javac.Main;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {
    @Autowired
    MenuService<Menu> service;
    private final Logger log = LoggerFactory.getLogger(MenuController.class);

    @GetMapping("/api/menus")
    public List<Menu> findAll() {
        return service.findAll();
    }

    @GetMapping("/api/menus/{id}")
    @Operation(summary = "Find menu", description = "Find a menu (PK)")
    public ResponseEntity<Menu> findOneById(@PathVariable Long id) {
        Menu menu = service.findById(id);
        if (menu != null) {
            return ResponseEntity.ok(menu);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/menus")
    public ResponseEntity<Menu> create(@RequestBody Menu menu) {
        if (menu.getIdMenu() != null) {
            log.warn("Trying to create a Menu with ID");
            return ResponseEntity.badRequest().build();
        }
        Menu result = service.save(menu);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/api/menus")
    public ResponseEntity<Menu> update(@RequestBody Menu menu) {
        if (menu.getIdMenu() == null) {
            log.warn("Trying to update a non existent menu");
            return ResponseEntity.badRequest().build();
        }
        if (!service.exist(menu.getIdMenu())) {
            log.warn("Trying to update a non existent menu");
            return ResponseEntity.notFound().build();
        }

        Menu result = service.save(menu);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/api/menus/{id}")
    public ResponseEntity<Menu> delete(@PathVariable Long id) {
        if (!service.exist(id)) {
            log.warn("Trying to delete a non existent menu");
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/menus")
    public ResponseEntity<Menu> deleteAll() {
        log.info("REST Request for deleting all menus ");
        service.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
