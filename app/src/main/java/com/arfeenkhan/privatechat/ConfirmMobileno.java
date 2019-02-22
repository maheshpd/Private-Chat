package com.arfeenkhan.privatechat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmMobileno extends AppCompatActivity {
    TextView resent_text;
    ImageButton cancel;
    EditText first_edt, second_edt, third_edt, fourth_edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_mobileno);

        resent_text = findViewById(R.id.resent_text);
        cancel = findViewById(R.id.confirm_cancel);
        first_edt = findViewById(R.id.edt1);
        second_edt = findViewById(R.id.edt2);
        third_edt = findViewById(R.id.edt3);
        fourth_edt = findViewById(R.id.edt4);

        first_edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (first_edt.getText().toString().length() == 1) {
                    second_edt.requestFocus();
                }
            }
        });

        second_edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (second_edt.getText().toString().length() == 1) {
                    third_edt.requestFocus();
                }
            }
        });

        third_edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (third_edt.getText().toString().length() == 1) {
                    fourth_edt.requestFocus();
                }
            }
        });

        fourth_edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (fourth_edt.getText().toString().length() == 0) {
                    third_edt.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        String text1Color = "<font color='#9DAAEA'> We sent you code to SMS. Please tap</font>";
        String resentText = "<font color='#4FDD8E'> Resend </font>";
        String text2Color = "<font color='#9DAAEA'>if you not get within</font>";
        resent_text.setText(Html.fromHtml(text1Color + resentText + text2Color));

        resent_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ConfirmMobileno.this, "Please wait...", Toast.LENGTH_SHORT).show();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void ConfirmBtn(View view) {
        startActivity(new Intent(ConfirmMobileno.this, FingerPrint.class));
    }
}
