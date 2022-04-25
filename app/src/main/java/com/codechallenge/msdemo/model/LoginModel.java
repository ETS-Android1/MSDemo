package com.codechallenge.msdemo.model;

import android.util.Log;

import com.codechallenge.msdemo.util.ErrorType;

public class LoginModel {
    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    public LoginModel() {

    }

    public ErrorType evaluateInput(String emailAddress, int passwordLength) {
        boolean emailAddressCheck = (emailAddress == null || emailAddress.length() == 0 || !emailAddress.matches(emailPattern)) ? false : true;
        boolean passwordCheck = (passwordLength >= 8 && passwordLength <= 16) ? true : false;

        if (!emailAddressCheck && !passwordCheck) return ErrorType.EMAIL_PASSWORD_ERROR;
        if (!emailAddressCheck) return ErrorType.EMAIL_ERROR;
        if (!passwordCheck) return ErrorType.PASSWORD_ERROR;
        return ErrorType.PASSED;
    }
}
