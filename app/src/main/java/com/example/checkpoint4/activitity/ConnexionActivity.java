package com.example.checkpoint4.activitity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.checkpoint4.R;
import com.example.checkpoint4.model.User;
import com.example.checkpoint4.model.UserSingleton;
import com.example.checkpoint4.model.VolleySingleton;

public class ConnexionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);


        Button btConnect = findViewById(R.id.btConnect);
        btConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText email = findViewById(R.id.etEmail);
                EditText pwd = findViewById(R.id.etPassword);

                UserSingleton userSingleton = UserSingleton.getInstance();
                User user = userSingleton.getUser();

                user.setEmail(email.getText().toString());
                user.setPassword(pwd.getText().toString());

                VolleySingleton.getInstance(ConnexionActivity.this).signIn(user, new VolleySingleton.VolleyListener<User>() {
                    @Override
                    public void accept(User user) {

                        Toast.makeText(ConnexionActivity.this, user.getEmail(), Toast.LENGTH_LONG).show();
                        startActivity(new Intent(ConnexionActivity.this,EventActivity.class));

                    }
                });
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
