package com.example.Coffee.service;

import com.example.Coffee.entity.Poke;
import com.example.Coffee.repository.PokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokeServiceImpl implements GenericService<Poke> {
    @Autowired
    private PokeRepository repository;

    @Override
    public List<Poke> findAll() {
        return repository.findAll();
    }

    @Override
    public Poke findById(Long id) {
        Poke poke= null;
        Optional<Poke> pokeResult = repository.findById(id);
        if(pokeResult.isPresent()){
            poke= pokeResult.get();
        }
        return poke;
    }

    @Override
    public void save(Poke item) {
        repository.save(item);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
