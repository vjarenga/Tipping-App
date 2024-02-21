package com.example.tippify;

import static android.app.ProgressDialog.show;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class RegisterCustomer extends AppCompatActivity {
    EditText EditTextEmail, EditTextPassword;
    Button button2;
    TextView TextView5;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_customer);
        mAuth = FirebaseAuth.getInstance();
        EditTextEmail = findViewById(R.id.editTextEmpEmailReg);
        EditTextPassword = findViewById(R.id.editTextEmpPasswordReg);
        button2 = findViewById(R.id.buttonEmpReg);
        TextView5 = findViewById(R.id.textViewEmpReg);


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password;
                email = String.valueOf(EditTextEmail.getText());
                password = String.valueOf(EditTextPassword.getText());

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(), "enter email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(), "enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "Account created", Toast.LENGTH_SHORT).show();

                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(getApplicationContext(), "Authentication failed", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        });
    }
}