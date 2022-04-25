package com.codechallenge.msdemo.ux;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.codechallenge.msdemo.R;
import com.codechallenge.msdemo.present.LoginController;
import com.codechallenge.msdemo.present.LoginPresent;
import com.codechallenge.msdemo.util.ErrorType;

public class LoginFragment extends Fragment {

    private LoginController loginController;

    // UI contents
    private EditText editTextFirstName;
    private EditText editTextPassword;
    private EditText editTextEmailAddress;
    private EditText editTextWebSiteAddress;
    private GradientDrawable gradientDrawableRed;
    private GradientDrawable gradientDrawableDefault;
    private Button buttonSubmit;
    public LoginFragment() {
        // Required empty public constructor
        loginController = new LoginController();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentRootView = inflater.inflate(R.layout.fragment_login, container, false);
        initUI(fragmentRootView);
        return fragmentRootView;
    }

    /**
     *
     * @param view Fragment root view.
     */

    private void initUI(View view){
        editTextFirstName = view.findViewById(R.id.edit_text_first_name);
        editTextEmailAddress = view.findViewById(R.id.edit_text_email_address);
        editTextPassword = view.findViewById(R.id.edit_text_password);
        editTextWebSiteAddress = view.findViewById(R.id.edit_text_website_address);
        buttonSubmit = view.findViewById(R.id.button_submit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmailAddress.getText().toString().trim();
                int passwordLength = editTextPassword.getText().toString().trim().length();
                changeEditTextStyle(loginController.onSubmitted(email, passwordLength));
            }
        });
        initUIStyle();
    }

    /**
     * EditText view styles
     * Warming: gradientDrawableRed
     * Default: gradientDrawableDefault
     */
    private void initUIStyle() {
        gradientDrawableRed = new GradientDrawable();
        gradientDrawableRed.setCornerRadius(30);
        gradientDrawableRed.setColor(Color.WHITE);
        gradientDrawableRed.setStroke(8, Color.RED);
        gradientDrawableDefault = new GradientDrawable();
        gradientDrawableDefault.setCornerRadius(30);
        gradientDrawableDefault.setColor(Color.WHITE);
        gradientDrawableDefault.setStroke(8, Color.rgb(236, 236, 236));
    }

    private void changeEditTextStyle(ErrorType errorType){
        // reset
        editTextEmailAddress.setBackground(gradientDrawableDefault);
        editTextPassword.setBackground(gradientDrawableRed);
        switch (errorType) {
            case EMAIL_ERROR:
                editTextEmailAddress.setBackground(gradientDrawableRed);
                break;
            case PASSWORD_ERROR:
                editTextPassword.setBackground(gradientDrawableRed);
                break;
            case EMAIL_PASSWORD_ERROR:
                editTextEmailAddress.setBackground(gradientDrawableRed);
                editTextPassword.setBackground(gradientDrawableRed);
                break;
            default:
                break;
        }
    }


}