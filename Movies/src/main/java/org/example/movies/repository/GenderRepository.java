package org.example.movies.repository;

import org.example.movies.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, Integer> {
}