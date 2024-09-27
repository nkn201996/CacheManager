package com.licious.cache.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Error {
    @JsonProperty("errorCode")
    public String errorCode;
    @JsonProperty("errorMessage")
    public String errorMessage;

    public Error(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
