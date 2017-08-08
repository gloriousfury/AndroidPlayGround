package com.taiyeoloriade.androidplayground.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.taiyeoloriade.androidplayground.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private AutoCompleteTextView mEmailView;
    TextView mSwitchViews;
    private EditText mPasswordView, mUsername;
    private View mProgressView;
    private View mLoginFormView;
    FirebaseAuth.AuthStateListener mAuthStateListerner;
    Button btnSignIn, mRegisterButton;
    FirebaseAuth auth;
    String username;
    boolean viewState = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mSwitchViews = (TextView) findViewById(R.id.switch_views);
        mUsername = (EditText) findViewById(R.id.username);
        mPasswordView = (EditText) findViewById(R.id.password);


        mRegisterButton = (Button) findViewById(R.id.email_sign_in_button);
        mRegisterButton.setOnClickListener(this);
        mSwitchViews.setOnClickListener(this);

        btnSignIn = (Button) findViewById(R.id.login_button);
        btnSignIn.setOnClickListener(this);


        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            // Already signed in
            // Do nothing
            Intent startChatRoom = new Intent(LoginActivity.this, ChatRoomActivity.class);
            startActivity(startChatRoom);
            finish();

        }else{
            viewState = false;

            switchViews();


        }


        mAuthStateListerner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    if(!viewState){
                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                            .setDisplayName(username).build();
                    user.updateProfile(profileUpdates);
                    Intent intent = new Intent(LoginActivity.this, ChatRoomActivity.class);
                    startActivity(intent);
                    }else{

                        Intent intent = new Intent(LoginActivity.this, ChatRoomActivity.class);
                        startActivity(intent);


                    }


                }
            }
        };


    }

    private void attemptLogin() {

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        View focusView = null;
        boolean cancel = false;

        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();
        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }
        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
//            showProgress(true);
//            mAuthTask = new LoginActivity2.UserLoginTask(email, password);
//            mAuthTask.execute((Void) null);
            FirebaseAuth auth = FirebaseAuth.getInstance();
            if (auth.getCurrentUser() != null) {
                // Already signed in
                // Do nothing
            } else {
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // User signed in successfully
//                                    Intent intent = new Intent(LoginActivity.this, ChatRoomActivity.class);
//                                    startActivity(intent);
                                }
                            }
                        });
            }
        }


    }

    private void attemptRegistration() {

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        View focusView = null;
        boolean cancel = false;

        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();
        username = mUsername.getText().toString();
        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }
        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        } else if (TextUtils.isEmpty(username)) {
            mUsername.setError(getString(R.string.error_field_required));
            focusView = mUsername;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
//            showProgress(true);
//            mAuthTask = new LoginActivity2.UserLoginTask(email, password);
//            mAuthTask.execute((Void) null);
            FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(email, password)

                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // User registered successfully
//                                Intent startChatRoom =  new Intent(LoginActivity.this, ChatRoomActivity.class);
//                                startActivity(startChatRoom);
//                                Toast.makeText(LoginActivity.this, "Registration successful", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }


    }


    private void switchViews(){
        if(viewState){
            mRegisterButton.setVisibility(View.VISIBLE);
            mUsername.setVisibility(View.VISIBLE);
            btnSignIn.setVisibility(View.GONE);
            mSwitchViews.setText("Login");
            viewState = false;

        }else{

            mRegisterButton.setVisibility(View.GONE);
            mUsername.setVisibility(View.GONE);
            btnSignIn.setVisibility(View.VISIBLE);
            mSwitchViews.setText("Register");
            viewState = true;

        }



    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }


    @Override
    public void onResume() {
        super.onResume();
        auth.addAuthStateListener(mAuthStateListerner);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthStateListerner != null) {
            auth.removeAuthStateListener(mAuthStateListerner);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.email_sign_in_button:
                attemptRegistration();

                break;

            case R.id.switch_views:
                switchViews();


                break;

            case R.id.login_button:

                attemptLogin();
                break;


        }
    }
}
