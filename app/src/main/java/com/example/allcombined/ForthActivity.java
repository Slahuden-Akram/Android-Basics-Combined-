package com.example.allcombined;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class ForthActivity extends AppCompatActivity {

    private Integer NOTIFY_ID= 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);

        Button btn = (Button) findViewById(R.id.btnInflator);
        Button btn1 = (Button) findViewById(R.id.btnNotify
        );


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();
                View v=inflater.inflate(R.layout.new_activity, null);

                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
                linearLayout.addView(v);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(ForthActivity.this, "0").setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentTitle("Notification")
                        .setContentText("Notification Generated");

                if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
                {
                    NotificationChannel chennel = new NotificationChannel("0","Notification Channel",NotificationManager.IMPORTANCE_DEFAULT);
                    chennel.setDescription("This is Notification Channel");
                    notificationManager.createNotificationChannel(chennel);
                }

                Intent intent = new Intent(getApplicationContext(),FifthActivity.class);
                intent.putExtra("Key",NOTIFY_ID);
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),123,intent, PendingIntent.FLAG_CANCEL_CURRENT);
                builder.setContentIntent(pendingIntent);
                notificationManager.notify(NOTIFY_ID,builder.build());
            }
        });
    }
}