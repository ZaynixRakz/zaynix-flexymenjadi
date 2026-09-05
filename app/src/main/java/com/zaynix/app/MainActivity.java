package com.zaynix.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(v -> {

            String user = username.getText().toString().trim();
            String pass = password.getText().toString().trim();

            if (user.isEmpty()) {
                username.setError("Username belum diisi");
                username.requestFocus();
                return;
            }

            if (pass.isEmpty()) {
                password.setError("Password belum diisi");
                password.requestFocus();
                return;
            }

            Toast.makeText(
                    MainActivity.this,
                    "Login berhasil",
                    Toast.LENGTH_SHORT
            ).show();

            showHome();
        });
    }

    private void showHome() {
        Toast.makeText(
                this,
                "ZAYNIX HOME",
                Toast.LENGTH_SHORT
        ).show();
    }
}
