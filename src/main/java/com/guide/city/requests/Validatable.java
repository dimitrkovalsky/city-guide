package com.guide.city.requests;


import com.guide.city.exceptions.ValidationException;

public interface Validatable {
    public void validate() throws ValidationException;
}
