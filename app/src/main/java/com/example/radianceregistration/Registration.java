package com.example.radianceregistration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;
import java.util.Map;

import static android.text.TextUtils.isEmpty;

public class Registration extends AppCompatActivity {
    private Button pay;
    private CheckBox FE,SE,TE,BE,Codewars,Recodeit,Shutterup,Quizmaster;
    private EditText Participant1,Participant2,Contact,Email,College,Date;
    private String name1,name2,contact1,mail1,college1,team1,team2;
    private String year,eventcodewars,eventrecodeit,eventshutterup,eventquizmaster;
    private RadioGroup radioGroup1,radioGroup2,radioGroup3;
    private RadioButton radio1,radio2,radio3,radio4,one,two,three,upinew,cashnew;
    private   EditText editText2,editText3;
    private TextView result;
    private FirebaseAuth mAuth;
    int sum=0;
    private Toolbar stool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        FE=(CheckBox)findViewById(R.id.FE);
        stool =  findViewById(R.id.stool);
        mAuth = FirebaseAuth.getInstance();
        SE=(CheckBox)findViewById(R.id.SE);
        TE=(CheckBox)findViewById(R.id.TE);
        BE=(CheckBox)findViewById(R.id.BE);
        pay=(Button)findViewById(R.id.pay);
        upinew =  findViewById(R.id.upinew);
        cashnew = findViewById(R.id.cashnew);
        Participant1=(EditText)findViewById(R.id.Participant1);
//        Participant2=(EditText)findViewById(R.id.Participant2);
        Contact=(EditText)findViewById(R.id.Contact);
        Email=(EditText)findViewById(R.id.Email);
        College=(EditText)findViewById(R.id.College);
        Codewars=(CheckBox)findViewById(R.id.Codewars);
        Recodeit=(CheckBox)findViewById(R.id.Recodeit);
        Quizmaster=(CheckBox)findViewById(R.id.Quizmaster);
        Shutterup=(CheckBox)findViewById(R.id.Shutterup);
        editText2 = findViewById(R.id.name3);
        editText3 = findViewById(R.id.name4);
        radioGroup1 = findViewById(R.id.rg1);
        radioGroup2 = findViewById(R.id.rg2);
        radioGroup3 = findViewById(R.id.rg3);
        radio1 = findViewById(R.id.ind1);
        radio2 = findViewById(R.id.team1);
        radio3 = findViewById(R.id.ind2);
        radio4 = findViewById(R.id.team2);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        result=findViewById(R.id.result);
      setSupportActionBar(stool);
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
                    if(radio1.isChecked())
                    {
                        radio1.setChecked(false);
                    }
                    else
                        radio2.setChecked(false);
                    editText2.setText(" ");
                    radioGroup1.setVisibility(View.INVISIBLE);
                    editText2.setVisibility(View.INVISIBLE);
                    radioGroup1.setVisibility(View.GONE);
                    editText2.setVisibility(View.GONE);
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
                   if(radio3.isChecked())
                    {
                        radio3.setChecked(false);
                    }
                   else
                   {
                       radio4.setChecked(false);
                   }
                   editText3.setText(" ");
                    radioGroup2.setVisibility(View.INVISIBLE);
                    editText3.setVisibility(View.INVISIBLE);
                    radioGroup2.setVisibility(View.GONE);
                    editText3.setVisibility(View.GONE);
                }
            }
        });
        Shutterup.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    radioGroup3.setVisibility(View.VISIBLE);
                }
                else
                {
                     if(one.isChecked()) {one.setChecked(false);}
                     else if(two.isChecked()){
                         two.setChecked(false);
                     }
                     else
                         three.setChecked(false);
                    radioGroup3.setVisibility(View.INVISIBLE);
                    radioGroup3.setVisibility(View.GONE);
                }
            }
        });
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name1 = Participant1.getText().toString().trim();
                contact1 = Contact.getText().toString().trim();
                mail1 = Email.getText().toString().trim();
                college1 = College.getText().toString().trim();
                team1 = editText2.getText().toString().trim();
                team2 =editText3.getText().toString().trim();

                if (isEmpty(name1)) {
                    Participant1.setError("This field cannot be empty.");
                    Participant1.requestFocus();
                }
                if (isEmpty(contact1)) {
                    Contact.setError("This field cannot be empty.");
                    Contact.requestFocus();
                } else if (!isContactValid(contact1)) {
                    Contact.setError("Mobile no. is incorrect.");
                    Contact.requestFocus();
                }
                if (isEmpty(mail1)) {
                    Email.setError("This field cannot be empty.");
                    Email.requestFocus();
                } else if (!isEmailValid(mail1)) {
                    Email.setError("Email is incorrect.");
                    Email.requestFocus();
                }
                if (isEmpty(college1)) {
                    College.setError("This field cannot be empty.");
                    College.requestFocus();
                }
                if(Codewars.isChecked())
                {
                    if(radio2.isChecked())
                    {
                        if (isEmpty(team1)) {
                            editText2.setError("This field cannot be empty.");
                            editText2.requestFocus();
                        }
                    }
                }
                if(Recodeit.isChecked())
                {
                    if(radio4.isChecked())
                    {
                        if (isEmpty(team2)) {
                            editText3.setError("This field cannot be empty.");
                            editText3.requestFocus();
                        }
                    }
                }
                amo();
                if(!isEmpty(name1)&&!isEmpty(contact1)&&!isEmpty(mail1)&&!isEmpty(college1)&&isContactValid(contact1)&&isEmailValid(mail1)) {
                    ParticipantInfo info = new ParticipantInfo();
                    info.setParticipant1(name1);
                    info.setCollegename(college1);
                    info.setContactno(contact1);
                    info.setEmail(mail1);
                    info.setYear(year);
                    info.setAmount(sum);
                    Map<String,String> ev = new HashMap<String,String>();
                    if (Codewars.isChecked()) {
                        if (team1 != null) {
                            ev.put("Code Wars", team1);
                        } else
                            ev.put("Code Wars", " ");
                    }
                    if (Recodeit.isChecked()) {
                        if (team2 != null) {
                            ev.put("Recode It", team2);
                        } else
                            ev.put("Recode It", " ");
                    }
                    if (Shutterup.isChecked()) {
                        if (one.isChecked()) {
                            ev.put("Shutter UP", "one");
                        } else if (two.isChecked()) {
                            ev.put("Shutter Up", "two");
                        } else {
                            ev.put("Shutter Up", "three");
                        }
                    }
                    if (Quizmaster.isChecked()) {
                        ev.put("QuizMaster", " ");
                    }
                    info.setMapi(ev);
                    if (cashnew.isChecked()) {
                        /* startActivity(new Intent(getApplicationContext(),cash.class));*/
                        Intent intent = new Intent(getApplicationContext(), cash.class);
                        intent.putExtra("Object", info);
                        startActivity(intent);
                    } else if (upinew.isChecked()) {
                        Intent intent =  new Intent(getApplicationContext(),upi.class);
                        intent.putExtra("Object",info);
                        intent.putExtra("FLAG",0);
                        startActivity(intent);
                    }
                }
            }
        });

    }
    public void amo()
    {
        int sum1=0;
        int sum2=0;
        int sum3=0;
        int sum4=0;

        if(Codewars.isChecked())
        {
            eventcodewars="Codewars";
//        int sum1=0;
            if(radio1.isChecked()) {
                sum1 = sum1 + 80;
            }
            result.setText(String.valueOf(sum1));
            if(radio2.isChecked()) {
                sum1 = sum1 + 100;
            }
            result.setText(String.valueOf(sum1));
        }
        if(Recodeit.isChecked())
        {
            eventrecodeit="RecodeIt";
//        int sum2=0;
            if(radio3.isChecked())
                sum2=sum2+80;
            result.setText(String.valueOf(sum2));
            if(radio4.isChecked())
                sum2=sum2+100;
            result.setText(String.valueOf(sum2));
        }
        if(Quizmaster.isChecked()){
            eventquizmaster="Quiz Master";
//        int sum3=0;
            sum3=sum3+80;
            result.setText(String.valueOf(sum3));
        }

        if(Shutterup.isChecked())
        {
            eventshutterup="ShutterUp";
//        int sum4=0;
            if(one.isChecked())
                sum4=sum4+50;
            if(two.isChecked())
                sum4=sum4+80;
            if(three.isChecked()) {
                sum4 = sum4 + 100;
            }
            result.setText(String.valueOf(sum4));
        }
        sum=sum1+sum2+sum3+sum4;
        result.setText(String.valueOf(sum));


    }
    public void onYearClicked(View view)
    {
        switch(view.getId()) {

            case R.id.FE:


                SE.setChecked(false);
                TE.setChecked(false);
                BE.setChecked(false);
                year="FE";

                break;
            case R.id.BE:

                SE.setChecked(false);
                TE.setChecked(false);
                FE.setChecked(false);
                year = "BE";

                break;
            case R.id.SE:

                FE.setChecked(false);
                TE.setChecked(false);
                BE.setChecked(false);
                year = "SE";

                break;
            case R.id.TE:

                SE.setChecked(false);
                FE.setChecked(false);
                BE.setChecked(false);
                year = "TE";

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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    /* public void openDialog()
    {

        Dialog d = new Dialog();
        d.show(getSupportFragmentManager(),"payment");


    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_nav_menu,menu);
        return true;
    }

    /*public void Signout(View view)
    {
        mAuth.signOut();
        Toast.makeText(this, "u  have signed out", Toast.LENGTH_SHORT).show();
    }
*/
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        /*switch ((item.getItemId())){
            case  R.id.action_recents:
                mAuth.signOut();

        }*/
        Toast.makeText(this, "u  have signed out", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
