package com.zaynix.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showLogin();
    }

    private TextView text(String value, float size, int color) {
        TextView t = new TextView(this);
        t.setText(value);
        t.setTextSize(size);
        t.setTextColor(color);
        t.setGravity(Gravity.CENTER);
        t.setPadding(12, 12, 12, 12);
        return t;
    }

    private Button menuButton(String title) {
        Button b = new Button(this);
        b.setText(title);
        b.setTextSize(15);
        b.setTextColor(Color.BLACK);
        b.setAllCaps(false);
        b.setBackgroundColor(Color.rgb(124, 255, 124));

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        60
                );

        p.setMargins(0, 12, 0, 12);
        b.setLayoutParams(p);

        return b;
    }

    private void showLogin() {

        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER_HORIZONTAL);
        root.setPadding(42, 55, 42, 30);
        root.setBackgroundColor(Color.rgb(9, 9, 11));

        ScrollHelper(root);

        TextView title = text("ZAYNIX", 38, Color.WHITE);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

        root.addView(title);

        TextView sub = text("FREE INJECTOR", 25,
                Color.rgb(124, 255, 124));
        sub.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        root.addView(sub);

        root.addView(text("VERSION 5.0", 18,
                Color.rgb(145, 145, 150)));

        addSpace(45);

        EditText username = new EditText(this);
        username.setHint("Username");
        username.setTextColor(Color.WHITE);
        username.setHintTextColor(Color.GRAY);
        username.setSingleLine(true);
        username.setText("zaynix");

        root.addView(username,
                new LinearLayout.LayoutParams(
                        -1, 65));

        addSpace(12);

        EditText password = new EditText(this);
        password.setHint("Password");
        password.setTextColor(Color.WHITE);
        password.setHintTextColor(Color.GRAY);
        password.setSingleLine(true);
        password.setInputType(
                android.text.InputType.TYPE_CLASS_TEXT |
                android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
        );

        root.addView(password,
                new LinearLayout.LayoutParams(
                        -1, 65));

        addSpace(20);

        Button login = menuButton("LOGIN");
        root.addView(login);

        login.setOnClickListener(v -> {

            String user =
                    username.getText().toString().trim();

            String pass =
                    password.getText().toString().trim();

            if (user.isEmpty()) {
                username.setError("Username belum diisi");
                return;
            }

            if (pass.isEmpty()) {
                password.setError("Password belum diisi");
                return;
            }

            Toast.makeText(
                    MainActivity.this,
                    "Login berhasil",
                    Toast.LENGTH_SHORT
            ).show();

            showHome();
        });

        addSpace(15);

        TextView getPass =
                text("GET USER/PASS", 18,
                        Color.rgb(124, 255, 124));

        root.addView(getPass);

        addSpace(55);

        root.addView(
                text("Social Media Zaynix", 18,
                        Color.rgb(145, 145, 150))
        );

        addSpace(40);

        root.addView(
                text("©2026 ZAYNIX. All rights reserved.",
                        14,
                        Color.rgb(90, 90, 95))
        );

        setContentView(root);
    }

    private void showHome() {

        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(28, 35, 28, 25);
        root.setBackgroundColor(Color.rgb(9, 9, 11));

        TextView title =
                text("ZAYNIX", 32, Color.WHITE);

        title.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        root.addView(title);

        root.addView(
                text("FREE VERSION • TOOLS V5.0",
                        15,
                        Color.rgb(124, 255, 124))
        );

        addSpace(25);

        TextView status =
                text("SYSTEM READY", 20,
                        Color.rgb(124, 255, 124));

        status.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        root.addView(status);

        addSpace(20);

        root.addView(
                text("ZAYNIX CONTROL PANEL",
                        18,
                        Color.WHITE)
        );

        Button feature =
                menuButton("⚙  FEATURES");

        root.addView(feature);

        feature.setOnClickListener(v ->
                showFeature()
        );

        Button terminal =
                menuButton("⌘  TERMINAL DEMO");

        root.addView(terminal);

        terminal.setOnClickListener(v ->
                showTerminal()
        );

        Button files =
                menuButton("▣  ZAYNIX FILES");

        root.addView(files);

        files.setOnClickListener(v ->
                showFiles()
        );

        addSpace(25);

        TextView info =
                text(
                        "Local interface • Demo mode\nNo external server required",
                        14,
                        Color.rgb(130, 130, 135)
                );

        root.addView(info);

        addSpace(30);

        Button logout =
                menuButton("← LOGOUT");

        root.addView(logout);

        logout.setOnClickListener(v ->
                showLogin()
        );

        setContentView(root);
    }

    private void showFeature() {

        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(28, 35, 28, 25);
        root.setBackgroundColor(Color.rgb(9, 9, 11));

        root.addView(
                text("ZAYNIX FEATURES",
                        28, Color.WHITE)
        );

        addSpace(25);

        root.addView(
                text("FEATURE PANEL",
                        20,
                        Color.rgb(124, 255, 124))
        );

        addSpace(15);

        root.addView(
                text(
                        "DRAG HS 32%\n\nHEADTRICK\n\nGRAFIK MINECRAFT\n\nHOLOGRAM",
                        18,
                        Color.WHITE
                )
        );

        addSpace(30);

        Button back =
                menuButton("← BACK TO HOME");

        root.addView(back);

        back.setOnClickListener(v ->
                showHome()
        );

        setContentView(root);
    }

    private void showTerminal() {

        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(25, 35, 25, 25);
        root.setBackgroundColor(Color.rgb(5, 5, 7));

        root.addView(
                text("ZAYNIX TERMINAL",
                        28,
                        Color.WHITE)
        );

        addSpace(20);

        root.addView(
                text(
                        "WELCOME TO ZAYNIX TERMINAL\n\n" +
                        "System Demo v5.0\n\n" +
                        "root@zaynix:~$ ./start\n" +
                        "root@zaynix:~$ status\n" +
                        "System ready.\n\n" +
                        "root@zaynix:~$ _",
                        15,
                        Color.rgb(124, 255, 124)
                )
        );

        addSpace(30);

        Button back =
                menuButton("← BACK TO HOME");

        root.addView(back);

        back.setOnClickListener(v ->
                showHome()
        );

        setContentView(root);
    }

    private void showFiles() {

        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(28, 35, 28, 25);
        root.setBackgroundColor(Color.rgb(9, 9, 11));

        root.addView(
                text("ZAYNIX FILES",
                        28,
                        Color.WHITE)
        );

        addSpace(25);

        root.addView(
                text(
                        "LOCAL FILE MANAGER\n\n" +
                        "📁 Config\n" +
                        "📁 Presets\n" +
                        "📄 settings.json\n" +
                        "📄 profile.znx",
                        17,
                        Color.WHITE
                )
        );

        addSpace(30);

        Button back =
                menuButton("← BACK TO HOME");

        root.addView(back);

        back.setOnClickListener(v ->
                showHome()
        );

        setContentView(root);
    }

    private void addSpace(int height) {

        View space = new View(this);

        root.addView(
                space,
                new LinearLayout.LayoutParams(
                        1, height
                )
        );
    }

    private void ScrollHelper(LinearLayout layout) {
        // Placeholder supaya layout tetap sederhana.
    }
}
