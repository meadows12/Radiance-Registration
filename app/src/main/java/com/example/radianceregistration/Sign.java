package com.example.radianceregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Sign extends AppCompatActivity {
Button signin;
EditText smail,spwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
signin=findViewById(R.id.sign);
smail=findViewById(R.id.Emailsign);
spwd=findViewById(R.id.Pwdsign);
    }
    public void Signclicked(View view)
    {
        startActivity(new Intent(getApplicationContext(),Registration.class));
    }
}
