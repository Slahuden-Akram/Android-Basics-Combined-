package com.example.allcombined;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private static final int REQ_CODE = 1000 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView txt = (TextView) findViewById(R.id.textView2);
        EditText et = (EditText) findViewById(R.id.edit1);
        Button btn = (Button) findViewById(R.id.btnSendData);


        txt.setText("2nd Activity");
//        String dataToSend = et.getText().toString();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a= et.getText().toString();
                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                intent.putExtra("key",a);
                startActivityIfNeeded(intent, REQ_CODE);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ_CODE && resultCode == RESULT_OK){
            String a = data.getStringExtra("fromChild").toString();
            TextView txt = (TextView) findViewById(R.id.textView2);
            txt.setText(a);
        }

    }
}