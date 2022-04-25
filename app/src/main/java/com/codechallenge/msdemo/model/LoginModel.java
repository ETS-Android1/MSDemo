package com.codechallenge.msdemo.model;

import com.codechallenge.msdemo.util.InputStatus;

public class LoginModel {
    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    public LoginModel() {

    }

    public InputStatus evaluateInput(String emailAddress, int passwordLength) {
        boolean emailAddressCheck = (emailAddress == null || emailAddress.length() == 0 || !emailAddress.matches(emailPattern)) ? false : true;
        boolean passwordCheck = (passwordLength >= 8 && passwordLength <= 16) ? true : false;

        if (!emailAddressCheck && !passwordCheck) return InputStatus.EMAIL_PASSWORD_ERROR;
        if (!emailAddressCheck) return InputStatus.EMAIL_ERROR;
        if (!passwordCheck) return InputStatus.PASSWORD_ERROR;
        return InputStatus.PASSED;
    }
}
