package com.example.Coffee.repository;

import com.example.Coffee.entity.SideDish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SideDishRepository extends JpaRepository<SideDish, Long> {
}
