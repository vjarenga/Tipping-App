package com.example.tippify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class EmployeeLogIn extends AppCompatActivity {
    EditText EditTextEmpEmailLogin, EditTextEmpPasswordLogin;
    Button buttonEmpLogin;
    TextView textViewEmpLogin;
    FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), EmployeeInterfaceOne.class);
            startActivity(intent);
            finish();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_employee);
        mAuth = FirebaseAuth.getInstance();
        EditTextEmpEmailLogin = findViewById(R.id.editTextEmpEmailLogin);
        EditTextEmpPasswordLogin = findViewById(R.id.editTextEmpPasswordLogin);
        buttonEmpLogin = findViewById(R.id.buttonEmpLogin);
        textViewEmpLogin = findViewById(R.id.textViewEmpLogin);

        textViewEmpLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterEmployee.class);
                startActivity(intent);
                finish();
            }
        });

        buttonEmpLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password;
                email = String.valueOf(EditTextEmpEmailLogin.getText());
                password = String.valueOf(EditTextEmpPasswordLogin.getText());

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "enter email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "Log in successful", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), EmployeeInterfaceOne.class);
                                    startActivity(intent);
                                    finish();

                                } else {

                                    Toast.makeText(EmployeeLogIn.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });


            }
        });
    }
}
