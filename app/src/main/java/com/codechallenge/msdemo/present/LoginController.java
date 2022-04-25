package com.codechallenge.msdemo.present;

import com.codechallenge.msdemo.model.LoginModel;
import com.codechallenge.msdemo.util.ErrorType;

public class LoginController implements LoginPresent {
    private LoginModel loginModel;
    public LoginController() {
        loginModel = new LoginModel();
    }
    @Override
    public ErrorType onSubmitted(String emailAddress, int passwordLength) {
        return loginModel.evaluateInput(emailAddress, passwordLength);
    }
}
