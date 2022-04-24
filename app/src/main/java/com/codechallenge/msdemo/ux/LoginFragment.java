package com.codechallenge.msdemo.ux;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codechallenge.msdemo.R;
import com.codechallenge.msdemo.ux.LoginUIController;

public class LoginFragment extends Fragment {

    private LoginUIController loginUIController;
    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginUIController = new LoginUIController(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        loginUIController.initUI(view);
        return view;
    }
}