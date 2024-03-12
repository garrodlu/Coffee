package com.example.Coffee.service;

import com.example.Coffee.entity.SideDish;
import com.example.Coffee.repository.SideDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SideDishServiceImpl implements GenericService<SideDish> {
    @Autowired
    private SideDishRepository repository;

    @Override
    public List<SideDish> findAll() {
        return repository.findAll();
    }

    @Override
    public SideDish findById(Long id) {
        SideDish sideDish = null;
        Optional<SideDish> sideDishResult = repository.findById(id);
        if(sideDishResult.isPresent()){
            sideDish = sideDishResult.get();
        }
        return sideDish;
    }

    @Override
    public SideDish save(SideDish item) {
       return repository.save(item);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
    @Override
    public boolean exist(Long id) {
        return repository.existsById(id);
    }
    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
