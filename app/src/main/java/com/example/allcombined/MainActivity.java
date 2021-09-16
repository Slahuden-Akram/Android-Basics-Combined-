package com.example.allcombined;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] data = {"ListView","ListView","ListView","ListView","ListView","ListView","ListView",
                "ListView","ListView","ListView","ListView","ListView","ListView","ListView",
                "ListView","ListView","ListView","ListView","ListView","ListView","ListView",
                "ListView","ListView","ListView","ListView","ListView","ListView","ListView",
                "ListView","ListView","ListView","ListView","ListView","ListView","ListView",};

        TextView txt = (TextView) findViewById(R.id.txtLayout1);
        Button btn = (Button) findViewById(R.id.btn1);
        ListView ls = (ListView) findViewById(R.id.listView1);
        ImageView img = (ImageView) findViewById(R.id.imageView1);


        txt.setText("This is the 1st Activity of this Application, Text Set from the Java Code.");

        img.setImageResource(R.drawable.image);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, data);
        ls.setAdapter(adapter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Item Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}