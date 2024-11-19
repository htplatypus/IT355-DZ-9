package org.example.movies.service;
import org.example.movies.entity.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> findById(Integer countryId);
    Country save(Country country);
    Country update(Country country);
    void deleteById(Integer countryId);
    List<Country> findByName(String name);
}
