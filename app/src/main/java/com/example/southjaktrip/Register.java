package com.example.southjaktrip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class Register extends AppCompatActivity {
    private EditText emailId, password, Username;
    private Button btnSignUp;
    private FirebaseAuth mFirebaseAuth;
    private ProgressBar loadingProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       emailId = findViewById(R.id.edtxtemail);
        password = findViewById(R.id.editPass);
        Username = findViewById(R.id.editName);
        btnSignUp = findViewById(R.id.btnregister);
        loadingProgress = findViewById(R.id.loadingbar);
        loadingProgress.setVisibility(View.VISIBLE);;

        mFirebaseAuth = FirebaseAuth.getInstance();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnSignUp.setVisibility(View.INVISIBLE);
                loadingProgress.setVisibility(View.VISIBLE);
                final String email = emailId.getText().toString();
                final String passwordreg = password.getText().toString();
                final String name = Username.getText().toString();

                if (email.isEmpty() || name.isEmpty() || passwordreg.isEmpty()) {

                    showMessage("Please verify all form");
                    btnSignUp.setVisibility(View.VISIBLE);
                    loadingProgress.setVisibility(View.VISIBLE);

                } else {

                    CreateUserAccount(email, name, passwordreg);
                }


            }

    });


    }

    private void CreateUserAccount(String email, final String name, String passwordreg) {
        mFirebaseAuth.createUserWithEmailAndPassword(email,passwordreg)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            showMessage("Account created");

                            updateUserInfo(name,mFirebaseAuth.getCurrentUser());

                        }
                        else {
                            showMessage("account creation failed" + task.getException().getMessage());
                            btnSignUp.setVisibility(View.VISIBLE);
                            loadingProgress.setVisibility(View.VISIBLE);

                        }
                    }
                });
    }

    private void updateUserInfo(final String name, final FirebaseUser currentUser) {

        UserProfileChangeRequest profileUpdate = new UserProfileChangeRequest.Builder()
                .setDisplayName(name).build();

        currentUser.updateProfile(profileUpdate)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            showMessage("Register Complete");
                            updateUi();


                        }
                    }
                });
    }

    private void updateUi() {

        Intent accountActivity = new Intent(getApplicationContext(), Account.class);
        startActivity(accountActivity);
        finish();
    }

    private void showMessage(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();



    }
}
