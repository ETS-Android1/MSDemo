package com.codechallenge.msdemo.present;

import com.codechallenge.msdemo.model.LoginModel;
import com.codechallenge.msdemo.util.InputStatus;

public class LoginController implements LoginPresent {
    private LoginModel loginModel;
    public LoginController() {
        loginModel = new LoginModel();
    }
    @Override
    public InputStatus onSubmitted(String emailAddress, int passwordLength) {
        return loginModel.evaluateInput(emailAddress, passwordLength);
    }
}
