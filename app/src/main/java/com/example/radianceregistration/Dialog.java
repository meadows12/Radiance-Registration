package com.example.radianceregistration;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Dialog extends AppCompatDialogFragment {
    private String selection;
    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        final String[] payment=getActivity().getResources().getStringArray(R.array.payment);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Modes of payment");
        builder.setSingleChoiceItems(R.array.payment, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
selection=payment[which];



            }
        });
/*
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                selection=payment[which];

            }
        });
*/
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                Toast.makeText(getActivity(),"Selected option:"+selection,Toast.LENGTH_SHORT).show();
                if(selection==payment[0])
                {
                    startActivity(new Intent(getActivity(),cash.class));
                }
                if(selection==payment[1])
                {
                    startActivity(new Intent(getActivity(),upi.class));
                }
            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        return builder.create();
    }
}
