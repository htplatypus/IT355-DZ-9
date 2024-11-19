package org.example.consumerdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private final CountryRepository countryRepository;

    public ConsumerService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @JmsListener(destination = "queue")
    public void receiveEntity(String entity) throws JsonProcessingException {
        Country country = new ObjectMapper().readValue(entity, Country.class);
        countryRepository.save(country);
        System.out.println("received entity: " + entity);
    }
}
