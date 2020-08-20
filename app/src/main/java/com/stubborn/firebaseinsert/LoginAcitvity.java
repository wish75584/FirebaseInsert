package com.stubborn.firebaseinsert;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

public class LoginAcitvity extends AppCompatActivity {

    EditText login_email, login_passsword;
    Button btn_login;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_acitvity);

        login_email = findViewById(R.id.login_email);
        login_passsword = findViewById(R.id.login_password);
        btn_login = findViewById(R.id.btn_login);
        mAuth = FirebaseAuth.getInstance();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = login_email.getText().toString().trim();
                String Password = login_passsword.getText().toString().trim();

                mAuth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(LoginAcitvity.this, "Login Successful", Toast.LENGTH_LONG).show();
                            openNavigation();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(LoginAcitvity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }

    private void openNavigation() {
        startActivity(new Intent(LoginAcitvity.this, NavigationExample.class));

    }


}
