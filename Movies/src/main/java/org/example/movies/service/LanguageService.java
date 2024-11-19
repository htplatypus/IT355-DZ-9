package org.example.movies.service;
import org.example.movies.entity.Language;

import java.util.List;
import java.util.Optional;

public interface LanguageService {
    List<Language> findAll();
    Optional<Language> findById(Integer languageId);
    Language save(Language language);
    Language update(Language language);
    void deleteById(Integer languageId);
    List<Language> findByName(String name);
}
