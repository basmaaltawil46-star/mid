package com.example.mid_exam_basmsaltaweel;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mid_exam_basmsaltaweel.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;

    boolean back = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        TextWatcher watcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = mainBinding.email.getText().toString().trim();

                String password = mainBinding.password.getText().toString();

                if (Patterns.EMAIL_ADDRESS.matcher(email).matches()
                        && password.length() >= 6) {

                    mainBinding.btnLogin.setEnabled(true);

                } else {

                    mainBinding.btnLogin.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        mainBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ModeActivity.class);
                startActivity(intent);

            }
        });

        mainBinding.email.addTextChangedListener(watcher);
        mainBinding.password.addTextChangedListener(watcher);
    }
    @Override
    public void onBackPressed() {

        if (back == false) {

            Snackbar.make(mainBinding.getRoot(),
                    "Press back again to exit",
                    Snackbar.LENGTH_LONG).show();

            back = true;

        } else {

            finish();
        }
    }
}