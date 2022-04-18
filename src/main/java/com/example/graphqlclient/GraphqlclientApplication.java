package com.example.graphqlclient;

import com.example.graphqlclient.clients.CountryClient;
import com.example.graphqlclient.dto.AuthorDto;
import com.example.graphqlclient.dto.CountryDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@Slf4j
@SpringBootApplication
public class GraphqlclientApplication {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(GraphqlclientApplication.class, args);
        CountryClient client = (CountryClient) context.getBean("countryClient");
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        CountryDto countryDto = client.getCountryDetails("BE");
        AuthorDto authorData = client.getAllBook();
        log.info(ow.writeValueAsString(countryDto));
        log.info(ow.writeValueAsString(authorData));
    }

}
