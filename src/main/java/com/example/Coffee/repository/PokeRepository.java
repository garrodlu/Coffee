package com.example.Coffee.repository;

import com.example.Coffee.entity.Poke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokeRepository extends JpaRepository<Poke,Long> {
}
