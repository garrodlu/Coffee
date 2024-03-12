package com.example.Coffee.repository;

import com.example.Coffee.entity.MainDish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainDishRepository extends JpaRepository<MainDish, Long> {
}
