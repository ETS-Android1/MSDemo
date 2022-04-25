package com.codechallenge.msdemo.present;

import com.codechallenge.msdemo.util.ErrorType;

public class LoginController implements LoginPresent {

    public LoginController() {
    }
    @Override
    public ErrorType onSubmitted(String email, int PasswordLength) {
        return ErrorType.PASSED;
    }
}
