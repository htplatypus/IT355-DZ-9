package org.example.movies.controller;

import org.example.movies.entity.Country;
import org.example.movies.entity.Department;
import org.example.movies.entity.Language;
import org.example.movies.service.CountryService;
import org.example.movies.service.DepartmentService;
import org.example.movies.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.movies.repository.GenderRepository;
import org.example.movies.repository.GenreRepository;

import java.util.List;

@RestController //umesto @Controller
@RequestMapping("/movies")
public class MovieController {

    // field injection za servise
    @Autowired
    private CountryService countryService;
    @Autowired
    private LanguageService languageService;
    @Autowired
    private DepartmentService departmentService;

    // ne svi entiteti su implementirani
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private GenreRepository genreRepository;

    // CRUD i findBy endpoint-ovi za implementirane servise
    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return countryService.findAll();
    }

    @GetMapping("/countries/{id}")
    public Country getCountryById(@PathVariable Integer id) {
        return countryService.findById(id).orElse(null);
    }

    @GetMapping("/countries/findByName")
    public List<Country> getCountriesByName(@RequestParam String name) {
        return countryService.findByName(name);
    }

    @PostMapping("/countries")
    public Country addCountry(@RequestBody Country country) {
        return countryService.save(country);
    }

    @PutMapping("/countries")
    public Country updateCountry(@RequestBody Country country) {
        return countryService.update(country);
    }

    @DeleteMapping("/countries/{id}")
    public void deleteCountry(@PathVariable Integer id) {
        countryService.deleteById(id);
    }

    @GetMapping("/languages")
    public List<Language> getAllLanguages() {
        return languageService.findAll();
    }

    @GetMapping("/languages/{id}")
    public Language getLanguageById(@PathVariable Integer id) {
        return languageService.findById(id).orElse(null);
    }

    @GetMapping("/languages/findByName")
    public List<Language> getLanguagesByName(@RequestParam String name) {
        return languageService.findByName(name);
    }

    @PostMapping("/languages")
    public Language addLanguage(@RequestBody Language language) {
        return languageService.save(language);
    }

    @PutMapping("/languages")
    public Language updateLanguage(@RequestBody Language language) {
        return languageService.update(language);
    }

    @DeleteMapping("/languages/{id}")
    public void deleteLanguage(@PathVariable Integer id) {
        languageService.deleteById(id);
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentService.findAll();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable Integer id) {
        return departmentService.findById(id).orElse(null);
    }

    @GetMapping("/departments/findByName")
    public List<Department> getDepartmentsByName(@RequestParam String name) {
        return departmentService.findByName(name);
    }

    @PostMapping("/departments")
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.save(department);
    }

    @PutMapping("/departments")
    public Department updateDepartment(@RequestBody Department department) {
        return departmentService.update(department);
    }

    @DeleteMapping("/departments/{id}")
    public void deleteDepartment(@PathVariable Integer id) {
        departmentService.deleteById(id);
    }

}
