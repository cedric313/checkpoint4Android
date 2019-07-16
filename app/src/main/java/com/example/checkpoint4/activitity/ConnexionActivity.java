package com.example.checkpoint4.activitity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.checkpoint4.R;

public class ConnexionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        Button btConnect = findViewById(R.id.btConnect);
        btConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConnexionActivity.this,EventActivity.class));
            }
        });

        TextView tvGoCreate = findViewById(R.id.tvGoCreateAccount);
        tvGoCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConnexionActivity.this,CreateAccountActivity.class));
            }
        });
    }
}
