package com.thundercsun.lomonosovv.presentation.base.output;

public class NoValueException extends Error {

    public NoValueException() {
        super("ViewModelOutput has no value");
    }
}
