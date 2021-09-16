package com.example.allcombined;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        TextView txt = (TextView) findViewById(R.id.textView3);
        EditText edt = (EditText) findViewById(R.id.edit3);
        Button btn = (Button) findViewById(R.id.btn3);
        Button btn1 = (Button) findViewById(R.id.btnWeb);
        Button btn2 = (Button) findViewById(R.id.btnSms);
        Button btn3 = (Button) findViewById(R.id.btnCall);
        Button btn4 = (Button) findViewById(R.id.btnNext);


        String data = getIntent().getStringExtra("key");
        txt.setText("Data From Second Activity: "+data);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SecondActivity.class);
                intent.putExtra("fromChild","nothing");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri a = Uri.parse("https://www.google.com");
                Intent intent = new Intent(Intent.ACTION_VIEW,a);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edt = (EditText) findViewById(R.id.edit3);
                String c = edt.getText().toString();
                Uri b= Uri.parse("smsto:03036323423");
                Intent intent = new Intent(Intent.ACTION_SENDTO,b);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edt = (EditText) findViewById(R.id.edit3);
                String c = edt.getText().toString();
                Uri b= Uri.parse("tel:"+edt);
                Intent intent = new Intent(Intent.ACTION_DIAL,b);
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThirdActivity.this, ForthActivity.class);
                startActivity(intent);
            }
        });

    }
}