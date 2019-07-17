package com.example.checkpoint4.activitity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.checkpoint4.R;
import com.example.checkpoint4.model.Authentication;
import com.example.checkpoint4.model.User;
import com.example.checkpoint4.model.UserSingleton;
import com.example.checkpoint4.model.VolleySingleton;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

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

                final UserSingleton userSingleton = UserSingleton.getInstance();
                User user = new User();

                if (!email.getText().toString().isEmpty() && !pwd.getText().toString().isEmpty()) {
                    HashCode hashCode = Hashing.sha256().hashString(pwd.getText().toString(), Charset.defaultCharset());
                    user.setEmail(email.getText().toString());
                    user.setPassword(pwd.getText().toString());
                    user.setPassword(hashCode.toString());
                    VolleySingleton.getInstance(ConnexionActivity.this).getUserByEmail(user, new Consumer<Authentication>() {
                        @Override
                        public void accept(Authentication authentication) {
                            if (authentication == null) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(ConnexionActivity.this);
                                builder.setTitle(getString(R.string.vérifier_connexion));
                                builder.setMessage(getString(R.string.veuillez_verifier_connexion));
                                builder.setPositiveButton(getString(R.string.ok), null);
                                AlertDialog dialog = builder.create();
                                dialog.show();

                            } else if (authentication.getError() != null) {
                                String error = getString(R.string.error_password);
                                if (authentication.getError().equals("ERROR_EMAIL")) {
                                    error = getString(R.string.error_email);
                                }
                                AlertDialog.Builder builder = new AlertDialog.Builder(ConnexionActivity.this);
                                builder.setTitle(getString(R.string.erreurEmail));
                                builder.setMessage(error);
                                builder.setPositiveButton(getString(R.string.ok), null);
                                AlertDialog dialog = builder.create();
                                dialog.show();

                            } else if (authentication.getUser() == null) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(ConnexionActivity.this);
                                builder.setTitle(getString(R.string.warning));
                                builder.setMessage(getString(R.string.veuillezRenseigner));
                                builder.setPositiveButton(getString(R.string.ok), null);
                                AlertDialog dialog = builder.create();
                                dialog.show();

                            } else {
                                userSingleton.setUser(authentication.getUser());
                                Toast.makeText(ConnexionActivity.this, authentication.getUser().getEmail(), Toast.LENGTH_LONG).show();
                                startActivity(new Intent(ConnexionActivity.this, EventActivity.class));
                            }

                        }
                    });

                }
            }
        });

        TextView tvGoCreate = findViewById(R.id.tvGoCreateAccount);
        tvGoCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConnexionActivity.this, CreateAccountActivity.class));
            }
        });
    }
}
