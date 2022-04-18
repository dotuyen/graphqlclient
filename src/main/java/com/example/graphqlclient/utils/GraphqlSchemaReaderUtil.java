package com.example.graphqlclient.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Objects;

/**
 * Class Read file .graphql in resources/graphql folder
 */
@Slf4j
public final class GraphqlSchemaReaderUtil {

    public static String getSchemaFromFileName(final String filename) throws IOException {
        return new String(
                Objects.requireNonNull(GraphqlSchemaReaderUtil.class.getClassLoader()
                                .getResourceAsStream("graphql/" + filename + ".graphql"))
                        .readAllBytes());
    }
}
