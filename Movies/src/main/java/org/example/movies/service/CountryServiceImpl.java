package org.example.movies.service;

import org.example.movies.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.movies.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Integer countryId) {
        return countryRepository.findById(countryId);
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country update(Country country) {
        if (countryRepository.existsById(country.getId())) {
            return countryRepository.save(country);
        }
        throw new IllegalArgumentException("Country with ID " + country.getId() + " does not exist.");
    }

    @Override
    public void deleteById(Integer countryId) {
        countryRepository.deleteById(countryId);
    }

    @Override
    public List<Country> findByName(String name) {
        return countryRepository.findByCountryName(name); // Assumes this method exists in the repository.
    }
}
