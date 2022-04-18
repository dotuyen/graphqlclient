package com.example.graphqlclient.clients;

import com.example.graphqlclient.dto.AuthorDto;
import com.example.graphqlclient.utils.GraphqlRequestBody;
import com.example.graphqlclient.utils.GraphqlSchemaReaderUtil;
import com.example.graphqlclient.dto.CountryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

@Service
@Slf4j
public class CountryClient {

    private final String url = "https://countries.trevorblades.com/";
    private final String url_localhost = "http://localhost:8080/graphql";

    public CountryDto getCountryDetails(final String countryCode) throws IOException {

        WebClient webClient = WebClient.builder().build();

        GraphqlRequestBody graphQLRequestBody = new GraphqlRequestBody();

        final String query = GraphqlSchemaReaderUtil.getSchemaFromFileName("getCountryDetails");
        final String variables = GraphqlSchemaReaderUtil.getSchemaFromFileName("variables");

        graphQLRequestBody.setQuery(query);
        graphQLRequestBody.setVariables(variables.replace("countryCode", countryCode));

        return webClient.post()
                .uri(url)
                .bodyValue(graphQLRequestBody)
                .retrieve()
                .bodyToMono(CountryDto.class)
                .block();
    }

    public AuthorDto getAllBook() throws IOException {

        WebClient webClient = WebClient.builder().build();

        GraphqlRequestBody graphQLRequestBody = new GraphqlRequestBody();

        final String query = GraphqlSchemaReaderUtil.getSchemaFromFileName("getAuthor");
//        final String variables = GraphqlSchemaReaderUtil.getSchemaFromFileName("variables");

        graphQLRequestBody.setQuery(query);
//        graphQLRequestBody.setVariables(variables.replace("countryCode", countryCode));

        return webClient.post()
                .uri(url_localhost)
                .bodyValue(graphQLRequestBody)
                .retrieve()
                .bodyToMono(AuthorDto.class)
                .block();
    }
}

