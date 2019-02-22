package com.arfeenkhan.privatechat;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FingerPrint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_print);

        CreateAlertDialog();
    }

    private void CreateAlertDialog() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Finger Print");
        dialog.setMessage("Please place your fingertip on the scanner to verify your identity");
        dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.create().show();


//        new AlertDialog.Builder(this)
//                .setTitle("Finger Print")
//                .setMessage("Please place your fingertip on the scanner to verify your identity")
//                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//        .create()

    }

    public void MainScreen(View view) {
        startActivity(new Intent(FingerPrint.this, MainActivity.class));
    }
}
