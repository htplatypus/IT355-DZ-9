package org.example.movies;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.example.movies.entity.Country;

@Service
public class ProducerService {

    private final JmsTemplate jmsTemplate;

    public ProducerService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendEntity(Country entity) throws JsonProcessingException {
        String countryJson = new ObjectMapper().writeValueAsString(entity);
        jmsTemplate.convertAndSend("queue", countryJson);
        System.out.println("sent: " + countryJson);
    }

    public void sendTest() {
        jmsTemplate.convertAndSend("queue", "TEST");
        System.out.println("sent");
    }
}
