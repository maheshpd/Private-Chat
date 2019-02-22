package com.arfeenkhan.privatechat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmMobileno extends AppCompatActivity {
    TextView resent_text;
    ImageButton cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_mobileno);

        resent_text = findViewById(R.id.resent_text);
        cancel = findViewById(R.id.confirm_cancel);
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
        startActivity(new Intent(ConfirmMobileno.this,FingerPrint.class));
    }
}
