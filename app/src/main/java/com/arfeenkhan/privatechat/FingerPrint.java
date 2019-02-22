package com.arfeenkhan.privatechat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FingerPrint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_print);
    }

    public void MainScreen(View view) {
        startActivity(new Intent(FingerPrint.this, MainActivity.class));
    }
}
