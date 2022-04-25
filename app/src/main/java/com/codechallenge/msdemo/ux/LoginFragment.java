package com.codechallenge.msdemo.ux;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.codechallenge.msdemo.R;
import com.codechallenge.msdemo.present.LoginController;
import com.codechallenge.msdemo.util.InputStatus;

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
                String emailAddress = editTextEmailAddress.getText().toString().trim();
                int passwordLength = editTextPassword.getText().toString().trim().length();
                InputStatus inputStatus= loginController.onSubmitted(emailAddress, passwordLength);
                changeEditTextStyle(inputStatus);
                if (inputStatus == InputStatus.PASSED) {
                    String firstName = editTextFirstName.getText().toString();
                    String password = editTextPassword.getText().toString().trim();
                    String websiteAddress = editTextWebSiteAddress.getText().toString().trim();
                    jumpNextFragment(firstName, emailAddress, password, websiteAddress);
                }
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

    private void changeEditTextStyle(InputStatus inputStatus){
        editTextEmailAddress.setBackground(gradientDrawableDefault);
        editTextPassword.setBackground(gradientDrawableDefault);
        switch (inputStatus) {
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

    private void jumpNextFragment(String firstName, String emailAddress, String password, String websiteAddress){
        // Send user input data to next fragment via Bundle
        Bundle bundle = new Bundle();
        if (firstName.length() > 0) bundle.putString("name", firstName);
        bundle.putString("email", emailAddress);
        bundle.putString("password", password);
        if (websiteAddress.length() > 0) bundle.putString("website", websiteAddress);

        //Jump next fragment
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ConfirmationFragment confirmationFragment = new ConfirmationFragment();
        confirmationFragment.setArguments(bundle);
        // fragment switch to next fragment and switch back from next fragment animation effect
        fragmentTransaction.setCustomAnimations(R.anim.buttom_in, R.anim.buttom_out, R.anim.buttom_in, R.anim.buttom_out);
        fragmentTransaction.replace(R.id.fragment_layout_container, confirmationFragment);
        // Push current fragment to task stack, when user press back on navigation bar will pop current fragment
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


}