package org.example.movies.repository;

import org.example.movies.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    List<Country> findByCountryName(String name);
}