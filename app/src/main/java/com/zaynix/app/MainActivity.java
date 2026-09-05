package com.zaynix.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends Activity {

    LinearLayout root;
    LinearLayout content;

    int BG = Color.rgb(8, 10, 13);
    int CARD = Color.rgb(18, 21, 26);
    int GREEN = Color.rgb(0, 255, 140);
    int WHITE = Color.WHITE;
    int GRAY = Color.rgb(145, 150, 158);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showLogin();
    }

    TextView text(String value, int size, int color) {
        TextView t = new TextView(this);
        t.setText(value);
        t.setTextSize(size);
        t.setTextColor(color);
        t.setPadding(16, 12, 16, 12);
        return t;
    }

    GradientDrawable bg(int color, float radius) {
        GradientDrawable g = new GradientDrawable();
        g.setColor(color);
        g.setCornerRadius(radius);
        return g;
    }

    Button button(String title) {
        Button b = new Button(this);
        b.setText(title);
        b.setTextColor(Color.BLACK);
        b.setTextSize(14);
        b.setAllCaps(false);
        b.setTypeface(Typeface.DEFAULT_BOLD);
        b.setBackground(bg(GREEN, 30));
        return b;
    }

    LinearLayout card() {
        LinearLayout c = new LinearLayout(this);
        c.setOrientation(LinearLayout.VERTICAL);
        c.setPadding(18, 18, 18, 18);
        c.setBackground(bg(CARD, 28));

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        p.setMargins(12, 10, 12, 10);
        c.setLayoutParams(p);

        return c;
    }

    void base() {
        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(BG);

        ScrollView scroll = new ScrollView(this);
        content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(8, 12, 8, 20);

        scroll.addView(content);

        root.addView(
                scroll,
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        0,
                        1
                )
        );

        setContentView(root);
    }

    void showLogin() {

        base();

        Space top = new Space(this);
        content.addView(top,
                new LinearLayout.LayoutParams(1, 110));

        TextView logo = text("ZAYNIX", 34, GREEN);
        logo.setGravity(Gravity.CENTER);
        logo.setTypeface(Typeface.DEFAULT_BOLD);
        content.addView(logo);

        TextView title = text(
                "FREE INJECTOR\nVERSION 5.0",
                20,
                WHITE
        );

        title.setGravity(Gravity.CENTER);
        title.setTypeface(Typeface.DEFAULT_BOLD);
        content.addView(title);

        TextView sub = text(
                "ZAYNIX SYSTEM • LOCAL UI",
                12,
                GRAY
        );

        sub.setGravity(Gravity.CENTER);
        content.addView(sub);

        LinearLayout login = card();

        EditText username = new EditText(this);
        username.setHint("Username");
        username.setHintTextColor(GRAY);
        username.setTextColor(WHITE);
        username.setSingleLine(true);
        username.setBackground(bg(Color.rgb(28, 31, 37), 20));

        EditText password = new EditText(this);
        password.setHint("Password");
        password.setHintTextColor(GRAY);
        password.setTextColor(WHITE);
        password.setSingleLine(true);
        password.setInputType(0x81);
        password.setBackground(bg(Color.rgb(28, 31, 37), 20));

        Button loginBtn = button("LOGIN");

        login.addView(username);
        login.addView(password);

        LinearLayout.LayoutParams bp =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        60
                );
        bp.setMargins(0, 18, 0, 0);
        login.addView(loginBtn, bp);

        content.addView(login);

        TextView info = text(
                "Local demo • No server required",
                11,
                GRAY
        );
        info.setGravity(Gravity.CENTER);
        content.addView(info);

        loginBtn.setOnClickListener(v -> {

            if (username.getText().toString().trim().isEmpty()) {
                username.setError("Isi username");
                return;
            }

            if (password.getText().toString().trim().isEmpty()) {
                password.setError("Isi password");
                return;
            }

            showHome();
        });
    }

    void header(String title, String subtitle) {

        TextView h = text(title, 25, WHITE);
        h.setTypeface(Typeface.DEFAULT_BOLD);
        content.addView(h);

        TextView s = text(subtitle, 12, GREEN);
        content.addView(s);
    }

    void showHome() {

        base();

        header(
                "ZAYNIX",
                "System Interface • Version 5.0"
        );

        LinearLayout status = card();

        TextView st = text(
                "● SYSTEM ONLINE",
                16,
                GREEN
        );

        st.setTypeface(Typeface.DEFAULT_BOLD);

        status.addView(st);

        status.addView(
                text(
                        "Device interface ready\n" +
                        "Local configuration mode active",
                        13,
                        GRAY
                )
        );

        content.addView(status);

        LinearLayout game = card();

        game.addView(
                text("FREE FIRE", 20, WHITE)
        );

        game.addView(
                text(
                        "Package: com.dts.freefireth",
                        12,
                        GRAY
                )
        );

        game.addView(
                text(
                        "App Status: Interface Demo",
                        13,
                        GREEN
                )
        );

        content.addView(game);

        LinearLayout actions = card();

        Button feature = button("OPEN FEATURE");
        Button terminal = button("OPEN TERMINAL");
        Button files = button("ZAYNIX FILES");

        actions.addView(feature);
        actions.addView(terminal);
        actions.addView(files);

        content.addView(actions);

        feature.setOnClickListener(v -> showFeature());
        terminal.setOnClickListener(v -> showTerminal());
        files.setOnClickListener(v -> showFiles());

        addBottomNavigation();
    }

    void addBottomNavigation() {

        LinearLayout nav = new LinearLayout(this);
        nav.setGravity(Gravity.CENTER);
        nav.setPadding(8, 8, 8, 8);
        nav.setBackgroundColor(Color.rgb(13, 15, 19));

        Button home = button("HOME");
        Button feature = button("FEATURE");
        Button terminal = button("TERMINAL");

        nav.addView(home,
                new LinearLayout.LayoutParams(0, 58, 1));

        nav.addView(feature,
                new LinearLayout.LayoutParams(0, 58, 1));

        nav.addView(terminal,
                new LinearLayout.LayoutParams(0, 58, 1));

        root.addView(nav);

        home.setOnClickListener(v -> showHome());
        feature.setOnClickListener(v -> showFeature());
        terminal.setOnClickListener(v -> showTerminal());
    }

    void showFeature() {

        base();

        header(
                "ZAYNIX FEATURE",
                "FreeVersion • Tools Interface V5.0"
        );

        LinearLayout game = card();

        game.addView(
                text("FREE FIRE", 20, WHITE)
        );

        game.addView(
                text(
                        "com.dts.freefireth",
                        12,
                        GRAY
                )
        );

        game.addView(
                text(
                        "STATUS: INTERFACE DEMO",
                        12,
                        GREEN
                )
        );

        content.addView(game);

        addFeatureCard(
                "DRAG HS",
                "32%",
                "Local profile preset"
        );

        addFeatureCard(
                "HEADTRICK",
                "READY",
                "Visual configuration preset"
        );

        addFeatureCard(
                "GRAFIK MINECRAFT FFTH",
                "READY",
                "Graphics profile interface"
        );

        LinearLayout holo = card();

        holo.addView(
                text("HOLOGRAM PROFILE", 18, WHITE)
        );

        TextView hstatus =
                text("● HOLOGRAM ACTIVE", 13, GREEN);

        holo.addView(hstatus);

        Button remove = button("HAPUS HOLOGRAM");
        Button shizuku = button("HUBUNGKAN SHIZUKU");

        holo.addView(remove);
        holo.addView(shizuku);

        content.addView(holo);

        remove.setOnClickListener(v -> {
            hstatus.setText("○ HOLOGRAM HIDDEN");
            hstatus.setTextColor(GRAY);
        });

        shizuku.setOnClickListener(v -> {
            hstatus.setText(
                    "● SHIZUKU STATUS: UI DEMO"
            );
            hstatus.setTextColor(GREEN);
        });

        Button simulate = button("RUN LOCAL PREPARATION");

        content.addView(simulate);

        simulate.setOnClickListener(
                v -> showProgress()
        );

        addBottomNavigation();
    }

    void addFeatureCard(
            String name,
            String value,
            String description
    ) {

        LinearLayout c = card();

        TextView title = text(name, 18, WHITE);
        title.setTypeface(Typeface.DEFAULT_BOLD);

        TextView val = text(value, 27, GREEN);
        val.setTypeface(Typeface.DEFAULT_BOLD);

        c.addView(title);
        c.addView(val);
        c.addView(text(description, 12, GRAY));

        content.addView(c);
    }

    void showProgress() {

        final PopupWindow popup = new PopupWindow(
                this
        );

        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        box.setPadding(28, 25, 28, 25);
        box.setBackground(bg(Color.rgb(16, 19, 24), 30));

        TextView title =
                text("INJECTED LIBRARY", 20, WHITE);

        title.setGravity(Gravity.CENTER);

        TextView percent =
                text("0%", 28, GREEN);

        percent.setGravity(Gravity.CENTER);

        ProgressBar bar =
                new ProgressBar(
                        this,
                        null,
                        android.R.attr.progressBarStyleHorizontal
                );

        bar.setMax(100);
        bar.setProgress(0);

        TextView desc =
                text(
                        "Preparing local configuration...",
                        12,
                        GRAY
                );

        desc.setGravity(Gravity.CENTER);

        box.addView(title);
        box.addView(percent);
        box.addView(bar);
        box.addView(desc);

        popup.setContentView(box);
        popup.setWidth(300);
        popup.setHeight(
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        popup.setFocusable(true);

        popup.setBackgroundDrawable(
                bg(Color.rgb(16, 19, 24), 30)
        );

        popup.showAtLocation(
                root,
                Gravity.CENTER,
                0,
                0
        );

        final int[] p = {0};

        android.os.Handler handler =
                new android.os.Handler();

        Runnable run = new Runnable() {

            @Override
            public void run() {

                p[0] += 7;

                if (p[0] > 100)
                    p[0] = 100;

                bar.setProgress(p[0]);
                percent.setText(p[0] + "%");

                if (p[0] < 100) {
                    handler.postDelayed(
                            this,
                            180
                    );
                } else {

                    desc.setText(
                            "Local preparation completed."
                    );

                    handler.postDelayed(
                            popup::dismiss,
                            900
                    );
                }
            }
        };

        handler.post(run);
    }

    void showTerminal() {

        base();

        header(
                "ZAYNIX TERMINAL",
                "System Interface V5.0"
        );

        LinearLayout terminal = card();

        TextView output = text(
                "WELCOME TO ZAYNIX TERMINAL\n\n" +
                "System Interface v5.0\n" +
                "Type a command below.\n\n" +
                "root@zaynix:~$ ",
                13,
                GREEN
        );

        output.setTypeface(
                Typeface.MONOSPACE
        );

        terminal.addView(output);

        EditText command = new EditText(this);
        command.setHint("command");
        command.setHintTextColor(GRAY);
        command.setTextColor(WHITE);
        command.setSingleLine(true);
        command.setTypeface(
                Typeface.MONOSPACE
        );

        command.setBackground(
                bg(Color.rgb(25, 28, 34), 18)
        );

        terminal.addView(command);

        Button run = button("RUN COMMAND");

        terminal.addView(run);

        content.addView(terminal);

        run.setOnClickListener(v -> {

            String cmd =
                    command.getText()
                            .toString()
                            .trim();

            if (cmd.isEmpty())
                return;

            String result;

            if (cmd.equals("help")) {

                result =
                        "\nhelp\n" +
                        "info\n" +
                        "clear\n" +
                        "status\n" +
                        "files";

            } else if (cmd.equals("info")) {

                result =
                        "\nZAYNIX SYSTEM\n" +
                        "Version: 5.0\n" +
                        "Mode: Local";

            } else if (cmd.equals("status")) {

                result =
                        "\nSYSTEM ONLINE\n" +
                        "Local interface ready";

            } else if (cmd.equals("files")) {

                result =
                        "\nZAYNIX FILES\n" +
                        "settings.zx\n" +
                        "profile.zx\n" +
                        "backup.zx";

            } else if (cmd.equals("clear")) {

                output.setText(
                        "root@zaynix:~$ "
                );
                return;

            } else {

                result =
                        "\nCommand received: " +
                        cmd +
                        "\nSimulation only.";

            }

            output.append(
                    result +
                    "\n\nroot@zaynix:~$ "
            );

            command.setText("");
        });

        addBottomNavigation();
    }

    void showFiles() {

        base();

        header(
                "ZAYNIX FILES",
                "Local Configuration Manager"
        );

        addFile(
                "settings.zx",
                "Main configuration"
        );

        addFile(
                "profile.zx",
                "User profile"
        );

        addFile(
                "backup.zx",
                "Local backup"
        );

        addFile(
                "README.txt",
                "Information"
        );

        Button back = button("BACK HOME");

        content.addView(back);

        back.setOnClickListener(
                v -> showHome()
        );

        addBottomNavigation();
    }

    void addFile(
            String filename,
            String description
    ) {

        LinearLayout c = card();

        c.addView(
                text(filename, 17, WHITE)
        );

        c.addView(
                text(description, 12, GRAY)
        );

        Button open = button("OPEN");

        c.addView(open);

        open.setOnClickListener(v -> {

            Toast.makeText(
                    this,
                    filename +
                    " • Local demo",
                    Toast.LENGTH_SHORT
            ).show();

        });

        content.addView(c);
    }
          }
