package com.example.radianceregistration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Sign extends AppCompatActivity {
Button signin;
EditText smail,password;
    private static final String TAG="MainActivity";
    private Button login;
    private FirebaseAuth mAuth;

    private ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
          signin=findViewById(R.id.signin);
          smail=findViewById(R.id.Emailsign);
          password=findViewById(R.id.Pwdsign);
        mAuth = FirebaseAuth.getInstance();
        mProgressBar=findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.GONE);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = smail.getText().toString().trim();
                String passwords = password.getText().toString().trim();

                if (email.isEmpty()) {
                    smail.setError("Email required");
                    smail.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    smail.setError("Email incorrect");
                   smail.requestFocus();
                    return;
                }

                if (passwords.isEmpty()) {
                    password.setError("Wrong Password");
                    password.requestFocus();
                    return;
                }

                SignIn(email,passwords);

            }

        });

    }

    public void SignIn(String email, String password){

        mProgressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        mProgressBar.setVisibility(View.GONE);
                        if(task.isSuccessful())
                        {
                            Intent intent = new Intent(Sign.this,Registration.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        }
                        else
                        {
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(Sign.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                //.addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                /*    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        mProgressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {

                            Intent i = new Intent(MainActivity.this, Register.class);
                            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //    updateUI(null);
                        }

                        // ...
                    }
                });*/
    }

}
