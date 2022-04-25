package com.codechallenge.msdemo.util;

public enum InputStatus {
    EMAIL_ERROR, // Email address is not valid format or empty
    PASSWORD_ERROR, // Password length is not meet length required or empty
    EMAIL_PASSWORD_ERROR, // Email address and password both are invalid
    PASSED, //Email address and password both are valid
}
