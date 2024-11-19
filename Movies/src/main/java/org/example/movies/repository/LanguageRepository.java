package org.example.movies.repository;

import org.example.movies.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
    List<Language> findByLanguageName(String name);
}