package com.danielandres.demoapirest.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ResponseUtil {

    public static final int NO_ERROR = 0;
    public static final int NOT_FOUND = 101;
    public static final int NOT_CONTENT = 201;
    public static final int OBJECTS_EXISTS = 404;
    public static final String NO_MESSAGE = "";

    private long errorCode;
    private String message;
}
