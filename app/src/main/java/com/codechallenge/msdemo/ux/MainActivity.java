package com.codechallenge.msdemo.ux;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.codechallenge.msdemo.R;
import com.codechallenge.msdemo.ux.LoginFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginFragment loginFragment = new LoginFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_layout_container, loginFragment).commit();
    }
}