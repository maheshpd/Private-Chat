package com.arfeenkhan.privatechat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
    }

    public void SignUp(View view) {
        startActivity(new Intent(OptionActivity.this,SignUp.class));
    }

    public void Login(View view) {
        startActivity(new Intent(OptionActivity.this,Login.class));
    }
}
