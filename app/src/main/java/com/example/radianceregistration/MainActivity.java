package com.example.radianceregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.text.TextUtils.isEmpty;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void RegClicked(View view)
    {
        startActivity(new Intent(getApplicationContext(),Registration.class));
    }
    public void BoomClicked(View view)
    {
        startActivity(new Intent(getApplicationContext(),Boommain.class));
    }
    public void BoomcontentClicked(View view)
    {
        startActivity(new Intent(getApplicationContext(),Cardcontent.class));
    }

}
