package com.example.zakatestimator;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {
    private android.util.Log Log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Log.d("MainActivity", "Navigated to AboutActivity");

        TextView githubLink = findViewById(R.id.textGitHub);
        githubLink.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
