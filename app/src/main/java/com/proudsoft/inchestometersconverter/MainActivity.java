package com.proudsoft.inchestometersconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.DisplayCutout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText inchesEditText;
    private Button calculateButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setUpButtonClickListener();
    }

    private void setUpButtonClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String inchesString = inchesEditText.getText().toString();
                if (inchesString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter data", Toast.LENGTH_LONG).show();
                    return;
                }

                double metersResult = convertToMeters();
                displayResult(metersResult);
            }
        });
    }

    private void findViews() {
        inchesEditText = findViewById(R.id.edit_text_inches);
        calculateButton = findViewById(R.id.button_calculate);
        resultText = findViewById(R.id.text_view_result);
    }

    private double convertToMeters() {
        String inchesText = inchesEditText.getText().toString();
        int inches = Integer.parseInt(inchesText);

        return inches * 0.0254;
    }

    private void displayResult(double meters) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String metersResult = myDecimalFormatter.format(meters);
        String fullResultString;

        fullResultString = "-- " + metersResult + " meters --";

        resultText.setText(fullResultString);
    }
}