package com.example.Coffee.service;

import com.example.Coffee.entity.Ingredient;
import com.example.Coffee.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements GenericService<Ingredient> {
    @Autowired
    private IngredientRepository repository;
    @Override
    public List<Ingredient> findAll() {
        return repository.findAll();
    }

    @Override
    public Ingredient findById(Long id) {
        Ingredient ingredient = null;
        Optional<Ingredient> ingredientResult = repository.findById(id);
        if(ingredientResult.isPresent()){
            ingredient = ingredientResult.get();
        }
        return ingredient;
    }

    @Override
    public void save(Ingredient item) {
        repository.save(item);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
