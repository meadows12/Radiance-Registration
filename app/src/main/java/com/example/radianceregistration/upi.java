package com.example.radianceregistration;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.shreyaspatil.EasyUpiPayment.EasyUpiPayment;
import com.shreyaspatil.EasyUpiPayment.listener.PaymentStatusListener;
import com.shreyaspatil.EasyUpiPayment.model.TransactionDetails;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.UUID;
import android.os.Bundle;

public class upi extends AppCompatActivity implements PaymentStatusListener{
    private ImageView imageView;
    private TextView statusView;
    private Button payButton;
    FirebaseAuth mAuth;

    FirebaseUser user;
    Calendar date= Calendar.getInstance();
    String todaydate= DateFormat.getDateInstance().format(date.getTime());
    FirebaseFirestore fb=FirebaseFirestore.getInstance();
    CollectionReference cb= fb.collection(todaydate);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upi);
//        imageView = findViewById(R.id.imageView);

        mAuth=FirebaseAuth.getInstance();
        statusView = findViewById(R.id.textView_status);
        payButton = findViewById(R.id.button_pay);

        String TransRefId=RefIDGen();
        String TransId=IDGen();
        //Create instance of EasyUpiPayment
        final EasyUpiPayment easyUpiPayment = new EasyUpiPayment.Builder()
                .with(this)
                .setPayeeVpa("8793881364@ybl")
                .setPayeeName("Divyank Lunkad")
                .setTransactionId(TransId)
                .setTransactionRefId(TransRefId)
                .setDescription("Trial")
                .setAmount("1.00")
                .build();

        //Register Listener for Events
        easyUpiPayment.setPaymentStatusListener(this);

        //Proceed for Payment on click
        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                easyUpiPayment.startPayment();
            }
        });
    }

    @Override
    public void onTransactionCompleted(TransactionDetails transactionDetails) {
        // Transaction Completed
        Log.d("TransactionDetails", transactionDetails.toString());
        statusView.setText(transactionDetails.toString());
    }

    @Override
    public void onTransactionSuccess() {
        // Payment Success

        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        user=mAuth.getCurrentUser();
        Intent i = getIntent();
        ParticipantInfo info = (ParticipantInfo) i.getSerializableExtra("Object");
        int flag = (int)i.getSerializableExtra("FLAG");
        if(flag==0) {
            if (user != null) {
                String name = user.getEmail().toString();
                cb.document(name).collection(info.getCollegename().toString()).document().set(info).addOnSuccessListener(
                        new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(upi.this, "Successfull", Toast.LENGTH_SHORT).show();
                            }
                        }
                ).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(upi.this, "Sorry", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
        if(flag==1)
        {
            cb.document().set(info).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(upi.this, "DONE  right", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(upi.this, "Done sorry", Toast.LENGTH_SHORT).show();
                }
            });
        }
//        imageView.setImageResource(R.drawable.ic_success);
    }

    @Override
    public void onTransactionSubmitted() {
        // Payment Pending
        Toast.makeText(this, "Pending | Submitted", Toast.LENGTH_SHORT).show();
        Log.d("Hello","Successful2");
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
//        imageView.setImageResource(R.drawable.ic_success);
    }

    @Override
    public void onTransactionFailed() {
        // Payment Failed
        Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
//        imageView.setImageResource(R.drawable.ic_failed);
    }

    @Override
    public void onTransactionCancelled() {
        // Payment Cancelled by User
        Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
//        imageView.setImageResource(R.drawable.ic_failed);
    }

    @Override
    public void onAppNotFound() {

    }

    String RefIDGen()
    {
        StringBuilder RefId= new StringBuilder();
        final int min = 1000;
        final int max = 9999;
        int i=0;
        while(i<3)
        {
            final int random = new Random().nextInt((max - min) + 1) + min;
            RefId.append(random);
            i++;
        }
        return RefId.toString();
    }
    String IDGen()
    {
        int i=0;
        StringBuilder Id= new StringBuilder();
        final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final int N = alphabet.length();
        Random r = new Random();
        Id.append(alphabet.charAt(r.nextInt(N)));
        final int min = 1000;
        final int max = 9999;
        while(i<5)
        {
            final int random = new Random().nextInt((max - min) + 1) + min;
            Id.append(random);
            i++;
        }
        final int min1 = 10;
        final int max1 = 99;
        final int random1 = new Random().nextInt((max1 - min1) + 1) + min1;
        Id.append(random1);
        return Id.toString();
    }

}
