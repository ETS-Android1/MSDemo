package com.codechallenge.msdemo.present;

import com.codechallenge.msdemo.util.ErrorType;

public interface LoginPresent {
    ErrorType onSubmitted(String email, int passwordLength);
}
