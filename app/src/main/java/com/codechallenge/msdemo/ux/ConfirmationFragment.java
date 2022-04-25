package com.codechallenge.msdemo.ux;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codechallenge.msdemo.R;

/**
 * ConfirmationFragment is used to confirm user input information, it obtains the bundle object from LoginFragment,
 * obtains the corresponding user input content from it, and presents it on the corresponding UI component.
 */
public class ConfirmationFragment extends Fragment {
    // Data
    private String firstName;
    private String emailAddress;
    private String websiteAddress;

    // UI
    private TextView textViewTitle;
    private TextView textViewFirstName;
    private TextView textViewEmail;
    private TextView textViewWebsite;
    public ConfirmationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firstName = "Anonymous";
        // Get user data from Bundle
        // if bundle no contain 'name' key, use "Anonymous" as user first name
        // if bundle no contain 'email' key, leave related string as empty
        // if bundle no contain 'website' key, leave related string as empty
        // if bundle no contain 'uri', image avatar path equal null
        if (getArguments() != null) {
            firstName = getArguments().containsKey("name") ? getArguments().getString("name") : firstName;
            emailAddress = getArguments().containsKey("email") ? getArguments().getString("email") : "";
            websiteAddress = getArguments().containsKey("website") ? getArguments().getString("website") : "";
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_confirmation, container, false);
        initUi(view);
        return view;
    }
    /**
     * Initialize fragment related UI.
     * @param view Fragment root view.
     */
    private void initUi(View view){
        textViewTitle = view.findViewById(R.id.text_view_title_name);
        textViewEmail = view.findViewById(R.id.text_view_email_address);
        textViewFirstName = view.findViewById(R.id.text_view_name);
        textViewWebsite = view.findViewById(R.id.text_view_website_address);
        textViewTitle.setText("Hello, " + firstName);
        textViewEmail.setText(emailAddress);
        textViewFirstName.setText(firstName);
        textViewWebsite.setText(websiteAddress);
    }
}