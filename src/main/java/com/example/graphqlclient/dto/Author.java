package com.example.graphqlclient.dto;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    private Long id;
    private String firstName;
    private String lastName;

}