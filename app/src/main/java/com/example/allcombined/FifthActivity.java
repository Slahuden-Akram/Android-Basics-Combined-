package com.example.allcombined;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.NotificationManager;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class FifthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        ConstraintLayout cl = (ConstraintLayout) findViewById(R.id.constraintLayout);
        Button btn = (Button) findViewById(R.id.btnSnackbar);


        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar sb = Snackbar.make(cl, "SnackBar Generated", Snackbar.LENGTH_LONG);
                sb.setAction("Click Me", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder b = new AlertDialog.Builder(FifthActivity.this);
                        b.setTitle("Alert Dialog");
                        b.setMessage("Here is the Alert Dialog Message");
                        b.setCancelable(false);

                        b.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                        b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });

                        b.show();
                    }
                }).show();
            }
        });
    }
}