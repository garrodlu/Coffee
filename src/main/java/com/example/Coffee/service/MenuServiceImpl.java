package com.example.Coffee.service;

import com.example.Coffee.entity.Menu;
import com.example.Coffee.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements GenericService<Menu> {

    @Autowired
    private MenuRepository repository;

    @Override
    public List<Menu> findAll() {
       return repository.findAll();
    }

    @Override
    public Menu findById(Long id) {
        Menu menu= null;
        Optional<Menu> menuResult= repository.findById(id);
        if(menuResult.isPresent()){
            menu = menuResult.get();
        }
        return menu;
    }

    @Override
    public Menu save(Menu item) {
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
