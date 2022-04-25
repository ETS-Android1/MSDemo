package com.codechallenge.msdemo.present;

import com.codechallenge.msdemo.util.InputStatus;

public interface LoginPresent {
    InputStatus onSubmitted(String email, int passwordLength);
}
