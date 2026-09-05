package com.zaynix.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

public class MainActivity extends Activity {

    private LinearLayout root;
    private final Handler handler = new Handler();

    private final int BG = Color.rgb(8, 8, 11);
    private final int CARD = Color.rgb(20, 19, 24);
    private final int CARD2 = Color.rgb(25, 24, 31);
    private final int GREEN = Color.rgb(124, 255, 124);
    private final int WHITE = Color.WHITE;
    private final int GRAY = Color.rgb(145, 145, 152);
    private final int DARK = Color.rgb(12, 12, 15);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window w = getWindow();
        w.setStatusBarColor(BG);
        w.setNavigationBarColor(BG);

        showLogin();
    }

    private int dp(int v) {
        return (int)(v * getResources()
                .getDisplayMetrics().density + 0.5f);
    }

    private GradientDrawable bg(
            int color,
            int radius,
            int strokeColor,
            int stroke
    ) {
        GradientDrawable g = new GradientDrawable();
        g.setColor(color);
        g.setCornerRadius(dp(radius));

        if (stroke > 0) {
            g.setStroke(dp(stroke), strokeColor);
        }

        return g;
    }

    private TextView label(
            String text,
            float size,
            int color
    ) {
        TextView t = new TextView(this);
        t.setText(text);
        t.setTextSize(size);
        t.setTextColor(color);
        t.setGravity(Gravity.CENTER);
        t.setIncludeFontPadding(true);
        return t;
    }

    private void addSpace(
            LinearLayout layout,
            int height
    ) {
        View v = new View(this);

        layout.addView(
                v,
                new LinearLayout.LayoutParams(
                        1,
                        dp(height)
                )
        );
    }

    private Button button(String title) {

        Button b = new Button(this);

        b.setText(title);
        b.setTextSize(15);
        b.setTextColor(Color.BLACK);
        b.setGravity(Gravity.CENTER);
        b.setAllCaps(false);
        b.setPadding(
                dp(12),
                0,
                dp(12),
                0
        );

        b.setBackground(
                bg(GREEN, 14, GREEN, 0)
        );

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(
                        -1,
                        dp(58)
                );

        p.setMargins(
                0,
                dp(7),
                0,
                dp(7)
        );

        b.setLayoutParams(p);

        return b;
    }

    private TextView card(
            String title,
            String description
    ) {

        LinearLayout box =
                new LinearLayout(this);

        box.setOrientation(
                LinearLayout.VERTICAL
        );

        box.setPadding(
                dp(18),
                dp(16),
                dp(18),
                dp(16)
        );

        box.setBackground(
                bg(CARD, 18, Color.rgb(42, 41, 48), 1)
        );

        TextView a =
                label(title, 19, WHITE);

        a.setGravity(Gravity.LEFT);
        a.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        box.addView(a);

        addSpace(box, 6);

        TextView c =
                label(description, 14, GRAY);

        c.setGravity(Gravity.LEFT);

        box.addView(c);

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(
                        -1,
                        -2
                );

        p.setMargins(
                0,
                dp(8),
                0,
                dp(8)
        );

        box.setLayoutParams(p);

        return box;
    }

    private EditText input(
            String hint
    ) {

        EditText e =
                new EditText(this);

        e.setHint(hint);
        e.setHintTextColor(
                Color.rgb(115, 115, 122)
        );

        e.setTextColor(WHITE);
        e.setTextSize(17);
        e.setSingleLine(true);

        e.setPadding(
                dp(17),
                0,
                dp(17),
                0
        );

        e.setBackground(
                bg(DARK, 12,
                        Color.rgb(50, 50, 57), 1)
        );

        e.setLayoutParams(
                new LinearLayout.LayoutParams(
                        -1,
                        dp(60)
                )
        );

        return e;
    }

    private ScrollView page() {

        ScrollView scroll =
                new ScrollView(this);

        scroll.setFillViewport(true);
        scroll.setBackgroundColor(BG);

        root =
                new LinearLayout(this);

        root.setOrientation(
                LinearLayout.VERTICAL
        );

        root.setPadding(
                dp(20),
                dp(24),
                dp(20),
                dp(30)
        );

        root.setBackgroundColor(BG);

        scroll.addView(root);

        return scroll;
    }

    private void header(
            String title,
            String subtitle
    ) {

        TextView t =
                label(title, 31, WHITE);

        t.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        root.addView(t);

        addSpace(root, 3);

        root.addView(
                label(subtitle, 16, GREEN)
        );
    }

    // =========================
    // LOGIN
    // =========================

    private void showLogin() {

        ScrollView scroll = page();

        addSpace(root, 18);

        TextView title =
                label("ZAYNIX", 40, WHITE);

        title.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        root.addView(title);

        addSpace(root, 5);

        TextView sub =
                label("FREE INJECTOR", 27, GREEN);

        sub.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        root.addView(sub);

        root.addView(
                label("VERSION 5.0", 18, GRAY)
        );

        addSpace(root, 42);

        LinearLayout box =
                new LinearLayout(this);

        box.setOrientation(
                LinearLayout.VERTICAL
        );

        box.setPadding(
                dp(18),
                dp(20),
                dp(18),
                dp(20)
        );

        box.setBackground(
                bg(CARD, 4,
                        Color.rgb(25, 24, 29), 1)
        );

        TextView uLabel =
                label("Username", 17, WHITE);

        uLabel.setGravity(Gravity.LEFT);

        box.addView(uLabel);

        addSpace(box, 8);

        EditText username =
                input("Username");

        username.setText("zaynix");

        box.addView(username);

        addSpace(box, 18);

        TextView pLabel =
                label("Password", 17, WHITE);

        pLabel.setGravity(Gravity.LEFT);

        box.addView(pLabel);

        addSpace(box, 8);

        EditText password =
                input("Password");

        password.setInputType(
                android.text.InputType.TYPE_CLASS_TEXT |
                android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
        );

        box.addView(password);

        addSpace(box, 22);

        Button login =
                button("LOGIN");

        box.addView(login);

        addSpace(box, 12);

        TextView get =
                label(
                        "GET USER/PASS",
                        17,
                        GREEN
                );

        box.addView(get);

        root.addView(box);

        login.setOnClickListener(v -> {

            String user =
                    username.getText()
                            .toString()
                            .trim();

            String pass =
                    password.getText()
                            .toString()
                            .trim();

            if (user.length() == 0) {
                username.setError(
                        "Username belum diisi"
                );
                return;
            }

            if (pass.length() == 0) {
                password.setError(
                        "Password belum diisi"
                );
                return;
            }

            Toast.makeText(
                    this,
                    "Login berhasil",
                    Toast.LENGTH_SHORT
            ).show();

            handler.postDelayed(
                    () -> showHome(),
                    250
            );
        });

        addSpace(root, 45);

        root.addView(
                label(
                        "Social Media Zaynix",
                        18,
                        GRAY
                )
        );

        addSpace(root, 40);

        root.addView(
                label(
                        "©2026 ZAYNIX. All rights reserved.",
                        14,
                        Color.rgb(85, 85, 91)
                )
        );

        setContentView(scroll);
    }

    // =========================
    // HOME
    // =========================

    private void showHome() {

        ScrollView scroll = page();

        header(
                "ZAYNIX",
                "FREE VERSION • TOOLS V5.0"
        );

        addSpace(root, 22);

        TextView ready =
                label(
                        "SYSTEM READY",
                        23,
                        GREEN
                );

        ready.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        root.addView(ready);

        addSpace(root, 6);

        root.addView(
                label(
                        "ZAYNIX CONTROL PANEL",
                        20,
                        WHITE
                )
        );

        addSpace(root, 18);

        LinearLayout game =
                new LinearLayout(this);

        game.setOrientation(
                LinearLayout.HORIZONTAL
        );

        game.setPadding(
                dp(16),
                dp(14),
                dp(16),
                dp(14)
        );

        game.setGravity(
                Gravity.CENTER_VERTICAL
        );

        game.setBackground(
                bg(CARD, 16,
                        Color.rgb(45, 44, 52), 1)
        );

        TextView gameName =
                label(
                        "FREE FIRE",
                        18,
                        WHITE
                );

        gameName.setGravity(Gravity.LEFT);

        gameName.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        game.addView(
                gameName,
                new LinearLayout.LayoutParams(
                        0,
                        -2,
                        1
                )
        );

        TextView installed =
                label(
                        "READY",
                        13,
                        GREEN
                );

        game.addView(installed);

        root.addView(game);

        addSpace(root, 15);

        root.addView(
                card(
                        "AIM FEATURES",
                        "Local interface for ZAYNIX tools"
                )
        );

        root.addView(
                card(
                        "HOLOGRAM",
                        "Visual settings and local controls"
                )
        );

        addSpace(root, 12);

        Button features =
                button("⚙  FEATURES");

        root.addView(features);

        features.setOnClickListener(
                v -> showFeature()
        );

        Button terminal =
                button("⌘  TERMINAL");

        root.addView(terminal);

        terminal.setOnClickListener(
                v -> showTerminal()
        );

        Button files =
                button("▣  ZAYNIX FILES");

        root.addView(files);

        files.setOnClickListener(
                v -> showFiles()
        );

        addSpace(root, 20);

        root.addView(
                label(
                        "Local interface • Demo mode\n" +
                        "No external server required",
                        14,
                        GRAY
                )
        );

        addSpace(root, 20);

        Button logout =
                button("←  LOGOUT");

        root.addView(logout);

        logout.setOnClickListener(
                v -> showLogin()
        );

        setContentView(scroll);
    }

    // =========================
    // FEATURES
    // =========================

    private void showFeature() {

        ScrollView scroll = page();

        header(
                "ZAYNIX FEATURES",
                "FreeVersion • Tools V5.0"
        );

        addSpace(root, 25);

        root.addView(
                card(
                        "DRAG HS 32%",
                        "Local visual preset"
                )
        );

        root.addView(
                card(
                        "HEADTRICK",
                        "Local feature interface"
                )
        );

        root.addView(
                card(
                        "GRAFIK MINECRAFT",
                        "Visual graphics preset"
                )
        );

        root.addView(
                card(
                        "SMOOTH TOUCH",
                        "Local UI setting"
                )
        );

        addSpace(root, 15);

        TextView holo =
                label(
                        "HOLOGRAM",
                        21,
                        GREEN
                );

        holo.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        root.addView(holo);

        addSpace(root, 10);

        root.addView(
                card(
                        "HAPUS HOLOGRAM",
                        "Visual demo control"
                )
        );

        addSpace(root, 15);

        Button demo =
                button("RUN DEMO");

        root.addView(demo);

        demo.setOnClickListener(
                v -> showProgress()
        );

        addSpace(root, 10);

        Button back =
                button("←  BACK TO HOME");

        root.addView(back);

        back.setOnClickListener(
                v -> showHome()
        );

        setContentView(scroll);
    }

    // =========================
    // PROGRESS DEMO
    // =========================

    private void showProgress() {

        ScrollView scroll = page();

        header(
                "ZAYNIX",
                "PROCESS DEMO"
        );

        addSpace(root, 35);

        TextView title =
                label(
                        "Injected Library",
                        25,
                        WHITE
                );

        title.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        root.addView(title);

        addSpace(root, 20);

        TextView percent =
                label(
                        "0%",
                        42,
                        GREEN
                );

        percent.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        root.addView(percent);

        addSpace(root, 20);

        ProgressBar progress =
                new ProgressBar(
                        this,
                        null,
                        android.R.attr.progressBarStyleHorizontal
                );

        progress.setMax(100);
        progress.setProgress(0);

        root.addView(
                progress,
                new LinearLayout.LayoutParams(
                        -1,
                        dp(10)
                )
        );

        addSpace(root, 20);

        root.addView(
                label(
                        "Running local interface demo...\n" +
                        "No game modification is performed.",
                        15,
                        GRAY
                )
        );

        setContentView(scroll);

        final int[] value = {0};

        Runnable run =
                new Runnable() {

                    @Override
                    public void run() {

                        value[0] += 4;

                        if (value[0] > 100)
                            value[0] = 100;

                        progress.setProgress(
                                value[0]
                        );

                        percent.setText(
                                value[0] + "%"
                        );

                        if (value[0] < 100) {

                            handler.postDelayed(
                                    this,
                                    80
                            );

                        } else {

                            handler.postDelayed(
                                    () -> showFeature(),
                                    700
                            );
                        }
                    }
                };

        handler.post(run);
    }

    // =========================
    // TERMINAL
    // =========================

    private void showTerminal() {

        ScrollView scroll = page();

        header(
                "ZAYNIX TERMINAL",
                "System Demo V5.0"
        );

        addSpace(root, 25);

        LinearLayout terminal =
                new LinearLayout(this);

        terminal.setOrientation(
                LinearLayout.VERTICAL
        );

        terminal.setPadding(
                dp(18),
                dp(18),
                dp(18),
                dp(18)
        );

        terminal.setBackground(
                bg(
                        Color.rgb(3, 3, 5),
                        14,
                        Color.rgb(45, 45, 50),
                        1
                )
        );

        TextView output =
                label(
                        "WELCOME TO ZAYNIX TERMINAL\n\n" +
                        "System Injector v5.0\n\n" +
                        "root@zaynix:~$ ./start\n" +
                        "root@zaynix:~$ status\n\n" +
                        "SYSTEM READY\n\n" +
                        "root@zaynix:~$ help\n" +
                        "./start\n" +
                        "./install\n" +
                        "./delete\n" +
                        "help\n\n" +
                        "root@zaynix:~$ _",
                        14,
                        GREEN
                );

        output.setGravity(Gravity.LEFT);

        terminal.addView(output);

        root.addView(terminal);

        addSpace(root, 25);

        Button back =
                button("←  BACK TO HOME");

        root.addView(back);

        back.setOnClickListener(
                v -> showHome()
        );

        setContentView(scroll);
    }

    // =========================
    // FILES
    // =========================

    private void showFiles() {

        ScrollView scroll = page();

        header(
                "ZAYNIX FILES",
                "Local File Explorer"
        );

        addSpace(root, 25);

        root.addView(
                            card(
                        "📁 CONFIG",
                        "Local configuration folder"
                )
        );

        root.addView(
                card(
                        "📁 PRESETS",
                        "Local preset folder"
                )
        );

        root.addView(
                card(
                        "📄 settings.json",
                        "Local settings file"
                )
        );

        root.addView(
                card(
                        "📄 profile.znx",
                        "Local profile file"
                )
        );

        addSpace(root, 20);

        root.addView(
                label(
                        "ZAYNIX FILES • LOCAL ONLY",
                        13,
                        GRAY
                )
        );

        addSpace(root, 25);

        Button back =
                button("←  BACK TO HOME");

        root.addView(back);

        back.setOnClickListener(
                v -> showHome()
        );

        setContentView(scroll);
    }
}
            
