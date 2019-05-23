package com.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;

//https://www.baeldung.com/jackson-annotations
public class UserWrapper {

    @JsonProperty
    private int id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String email;
}
