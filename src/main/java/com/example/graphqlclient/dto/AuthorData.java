package com.example.graphqlclient.dto;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorData {
    public ArrayList<Author> findAllAuthors;

//    public ArrayList<Author> getFindAllAuthors() {
//        return findAllAuthors;
//    }
//
//    public void setFindAllAuthors(ArrayList<Author> findAllAuthors) {
//        this.findAllAuthors = findAllAuthors;
//    }
}
