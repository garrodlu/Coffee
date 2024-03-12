package com.example.Coffee.service;

import com.example.Coffee.entity.MainDish;
import com.example.Coffee.repository.MainDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MainDishServiceImpl implements GenericService<MainDish> {

    @Autowired
    private MainDishRepository repository;

    @Override
    public List<MainDish> findAll() {
        return repository.findAll();
    }

    @Override
    public MainDish findById(Long id) {
        MainDish mainDish= null;
        Optional<MainDish> mainDishResult = repository.findById(id);
        if(mainDishResult.isPresent()){
            mainDish = mainDishResult.get();
        }
        return mainDish;
    }

    @Override
    public void save(MainDish item) {
        repository.save(item);
    }

    @Override
    public void delete(Long id) {
            repository.deleteById(id);
    }
}
