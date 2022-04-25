package com.codechallenge.msdemo.model;

import com.codechallenge.msdemo.util.InputStatus;

public class LoginModel {
    // Pattern use to check email
    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"; // email address format

    public LoginModel() {

    }

    /**
     * evaluateInput is used to check the email address and password are valid or invalid
     * @param emailAddress String email address
     * @param passwordLength Integer password length
     * @return
     */
    public InputStatus evaluateInput(String emailAddress, int passwordLength) {
        boolean emailAddressCheck = (emailAddress == null || emailAddress.length() == 0 || !emailAddress.matches(emailPattern)) ? false : true;
        boolean passwordCheck = (passwordLength >= 8 && passwordLength <= 16) ? true : false;
        // return Input status base on emailAddressCheck and passwordCheck boolean value
        if (!emailAddressCheck && !passwordCheck) return InputStatus.EMAIL_PASSWORD_ERROR;
        if (!emailAddressCheck) return InputStatus.EMAIL_ERROR;
        if (!passwordCheck) return InputStatus.PASSWORD_ERROR;
        return InputStatus.PASSED;
    }
}
