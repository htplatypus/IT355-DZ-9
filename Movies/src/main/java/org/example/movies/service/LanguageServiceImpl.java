package org.example.movies.service;
import org.example.movies.entity.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.movies.repository.LanguageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    @Override
    public Optional<Language> findById(Integer languageId) {
        return languageRepository.findById(languageId);
    }

    @Override
    public Language save(Language language) {
        return languageRepository.save(language);
    }

    @Override
    public Language update(Language language) {
        if (languageRepository.existsById(language.getId())) {
            return languageRepository.save(language);
        }
        return language;
    }

    @Override
    public void deleteById(Integer languageId) {
        languageRepository.deleteById(languageId);
    }

    @Override
    public List<Language> findByName(String name) {
        return languageRepository.findByLanguageName(name);
    }
}
