package com.example.checkpoint4.activitity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.checkpoint4.R;
import com.example.checkpoint4.model.Authentication;
import com.example.checkpoint4.model.User;
import com.example.checkpoint4.model.UserSingleton;
import com.example.checkpoint4.model.VolleySingleton;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

public class CreateAccountActivity extends AppCompatActivity {

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        Button btCreateAccount = findViewById(R.id.btCreateAccount);
        btCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText etEmail = findViewById(R.id.etEmailCreate);
                final EditText etPwd = findViewById(R.id.etPasswordCreate);
                final User user = new User();
                user.setEmail(etEmail.getText().toString());
                user.setPassword(etPwd.getText().toString());

                if (!etEmail.getText().toString().isEmpty()
                && !etPwd.getText().toString().isEmpty()) {
                    final String emailVerification = etEmail.getText().toString().trim();

                    if (emailVerification.matches(emailPattern)) {
                        HashCode hashCode = Hashing.sha256().hashString(etPwd.getText().toString(), Charset.defaultCharset());
                        user.setPassword(hashCode.toString());
                        user.setEmail(emailVerification);
                        VolleySingleton.getInstance(CreateAccountActivity.this).getUserByEmail(user, new Consumer<Authentication>() {
                            @Override
                            public void accept(Authentication authentication) {
                                if (authentication.getError() != null && authentication.getError().equals("ERROR_EMAIL")) {
                                    user.setEmail(etEmail.getText().toString());
                                    String password = etPwd.getText().toString();
                                    HashCode hashCode = Hashing.sha256().hashString(password, Charset.defaultCharset());
                                    user.setPassword(hashCode.toString());
                                    VolleySingleton.getInstance(CreateAccountActivity.this).createUser(user, new Consumer<User>() {
                                        @Override
                                        public void accept(User user) {
                                            UserSingleton.getInstance().setUser(user);
                                            startActivity(new Intent(CreateAccountActivity.this, EventActivity.class));
                                        }
                                    });
                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(CreateAccountActivity.this);
                                    builder.setTitle("Compte existant");
                                    builder.setMessage("Voulez vous vous connecter?");
                                    builder.setNegativeButton(getString(R.string.non), new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.cancel();
                                        }
                                    });
                                    builder.setPositiveButton(getString(R.string.oui), new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent intentGoSignIn = new Intent(CreateAccountActivity.this, ConnexionActivity.class);

                                            startActivity(intentGoSignIn);
                                        }
                                    });
                                    AlertDialog dialog = builder.create();
                                    dialog.show();
                                }
                            }
                        });
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(CreateAccountActivity.this);
                        builder.setTitle(getString(R.string.formatEmailInvalide));
                        builder.setMessage(getString(R.string.adresseEmailPasCorrectementFormatee));
                        builder.setPositiveButton(getString(R.string.ok), null);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }

                }
            }
        });
    }
}
