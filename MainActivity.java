package com.example.zakatestimator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText goldWeight, goldValue;
    RadioGroup goldType;
    TextView totalValue, zakatPayable, totalZakat;
    Button calculateButton, aboutButton;
    private android.util.Log Log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "Navigated to AboutActivity");

        goldWeight = findViewById(R.id.editGoldWeight);
        goldValue = findViewById(R.id.editGoldValue);
        goldType = findViewById(R.id.radioGroupGoldType);
        totalValue = findViewById(R.id.textTotalValue);
        zakatPayable = findViewById(R.id.textZakatPayable);
        totalZakat = findViewById(R.id.textTotalZakat);
        calculateButton = findViewById(R.id.buttonCalculate);
        aboutButton = findViewById(R.id.buttonAbout);

        calculateButton.setOnClickListener(view -> calculateZakat());

        aboutButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        });
    }

    private void calculateZakat() {
        try {
            double weight = Double.parseDouble(goldWeight.getText().toString());
            double valuePerGram = Double.parseDouble(goldValue.getText().toString());
            int selectedId = goldType.getCheckedRadioButtonId();
            double threshold = (selectedId == R.id.radioKeep) ? 85 : 200;

            double totalGoldValue = weight * valuePerGram;
            double zakatWeight = Math.max(0, weight - threshold);
            double zakatPayableValue = zakatWeight * valuePerGram;
            double totalZakatValue = zakatPayableValue * 0.025;

            totalValue.setText(String.format("RM %.2f", totalGoldValue));
            zakatPayable.setText(String.format("RM %.2f", zakatPayableValue));
            totalZakat.setText(String.format("RM %.2f", totalZakatValue));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
        }
    }
}
