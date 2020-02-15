package com.example.radianceregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
import android.widget.Toast;

import static android.text.TextUtils.isEmpty;

public class MainActivity extends AppCompatActivity {
private Button pay;
private CheckBox FE,SE,TE,BE,Codewars,Recodeit,Shutterup,Quizmaster;
private EditText Participant1,Participant2,Contact,Email,College,Date;
private String name1,name2,contact1,mail1,college1;
private RadioGroup radioGroup1,radioGroup2;
 private RadioButton radio1,radio2,radio3,radio4;
 private   EditText editText2,editText3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FE=(CheckBox)findViewById(R.id.FE);
        SE=(CheckBox)findViewById(R.id.SE);
        TE=(CheckBox)findViewById(R.id.TE);
        BE=(CheckBox)findViewById(R.id.BE);
        pay=(Button)findViewById(R.id.pay);
        Participant1=(EditText)findViewById(R.id.Participant1);
//        Participant2=(EditText)findViewById(R.id.Participant2);
        Contact=(EditText)findViewById(R.id.Contact);
        Email=(EditText)findViewById(R.id.Email);
        College=(EditText)findViewById(R.id.College);
        Date=(EditText)findViewById(R.id.Date);
        Codewars=(CheckBox)findViewById(R.id.Codewars);
        Recodeit=(CheckBox)findViewById(R.id.Recodeit);
      Quizmaster=(CheckBox)findViewById(R.id.Quizmaster);
     Shutterup=(CheckBox)findViewById(R.id.Shutterup);
        editText2 = findViewById(R.id.name2);
        editText3 = findViewById(R.id.name3);
        radioGroup1 = findViewById(R.id.rg1);
        radioGroup2 = findViewById(R.id.rg2);
        radio1 = findViewById(R.id.ind1);
        radio2 = findViewById(R.id.team1);
        radio3 = findViewById(R.id.ind2);
        radio4 = findViewById(R.id.team2);
        Codewars.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b)
                {
                    radioGroup1.setVisibility(View.VISIBLE);
                    radio2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                            if(b)
                            {
                                editText2.setVisibility(View.VISIBLE);
                            }
                            else
                            {
                                editText2.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                }
                else
                {
                    radioGroup1.setVisibility(View.INVISIBLE);
                    editText2.setVisibility(View.INVISIBLE);
                }
            }
        });

        Recodeit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    radioGroup2.setVisibility(View.VISIBLE);
                    radio4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                            if(b)
                            {
                                editText3.setVisibility(View.VISIBLE);
                            }
                            else
                            {
                                editText3.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                }
                else
                {
                    radioGroup2.setVisibility(View.INVISIBLE);
                    editText3.setVisibility(View.INVISIBLE);
                }
            }
        });
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name1 = Participant1.getText().toString().trim();
                name2 = Participant2.getText().toString().trim();
                contact1 = Contact.getText().toString().trim();
             mail1 = Email.getText().toString().trim();
                college1 = College.getText().toString().trim();
                if (isEmpty(name1)) {
                    Participant1.setError("This field cannot be empty.");
                }
                if (isEmpty(name2)) {
                    Participant2.setError("This field cannot be empty.");
                }
                if (isEmpty(contact1)) {
                   Contact.setError("This field cannot be empty.");
                } else if (!isContactValid(contact1)) {
                    Contact.setError("Mobile no. is incorrect.");
                }
                if (isEmpty(mail1)) {
                    Email.setError("This field cannot be empty.");
                } else if (!isEmailValid(mail1)) {
                    Email.setError("Email is incorrect.");
                }
                if (isEmpty(college1)) {
                 College.setError("This field cannot be empty.");
                }
          if(!isEmpty(name1)&&!isEmpty(name2)&&!isEmpty(contact1)&&!isEmpty(mail1)&&!isEmpty(college1)&&isContactValid(contact1)&&isEmailValid(mail1))
                openDialog();
            }
        });
    }

    public void onYearClicked(View view)
    {
        switch(view.getId()) {

            case R.id.FE:

                SE.setChecked(false);
                TE.setChecked(false);
                BE.setChecked(false);

                break;
            case R.id.BE:

                SE.setChecked(false);
                TE.setChecked(false);
                FE.setChecked(false);

                break;
            case R.id.SE:

                FE.setChecked(false);
                TE.setChecked(false);
                BE.setChecked(false);

                break;
            case R.id.TE:

                SE.setChecked(false);
                FE.setChecked(false);
                BE.setChecked(false);

                break;


        }
    }

    boolean isEmailValid(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    boolean isContactValid(String contact) {
        if (contact.length() == 10)
            return true;
        else
            return false;
    }
    public void openDialog()
    {

        Dialog d=new Dialog();
        d.show(getSupportFragmentManager(),"payment");



    }
}
