package com.example.radianceregistration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DateFormat;
import java.util.Calendar;

public class cash extends AppCompatActivity {
    FirebaseAuth mAuth;

    FirebaseUser user;
    Calendar date= Calendar.getInstance();
    String todaydate= DateFormat.getDateInstance().format(date.getTime());
    FirebaseFirestore fb=FirebaseFirestore.getInstance();
   CollectionReference cb= fb.collection(todaydate);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash);
        Intent i = getIntent();
        ParticipantInfo info = (ParticipantInfo) i.getSerializableExtra("Object");
        mAuth=FirebaseAuth.getInstance();
        user=mAuth.getCurrentUser();
        if(user!=null)
        {
            String name=user.getEmail().toString();
            cb.document(name).collection(info.getCollegename().toString()).document().set(info).addOnSuccessListener(
                    new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(cash.this, "Successful", Toast.LENGTH_SHORT).show();

                        }
                    }
            ).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(cash.this, "Sorry", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}
