/*
* Assignment: InClass02
* Group: A8
* Members:
* Anisha Kakwani
* Hiten Changlani */

package com.example.inclass2a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.buttonMeters).setOnClickListener(this);
        findViewById(R.id.buttonFeet).setOnClickListener(this);
        findViewById(R.id.buttonMiles).setOnClickListener(this);
        findViewById(R.id.buttonClearAll).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText inchText = findViewById(R.id.editTextTextInchValue);
        TextView resultView = findViewById(R.id.resultValue);

        if (inchText.getText().toString().isEmpty()) {
            Toast.makeText(this,getResources().getString(R.string.empty), Toast.LENGTH_SHORT).show();
        } else {

            try {
                double inchValue = parseDouble(inchText.getText().toString());
                switch (v.getId()) {
                    case R.id.buttonMeters:
                        double meterValue = 0.0254 * inchValue;
                        resultView.setText(meterValue + " Meters");
                        break;
                    case R.id.buttonFeet:
                        double feetValue = (inchValue / 12);
                        resultView.setText(feetValue + " Feet");
                        break;
                    case R.id.buttonMiles:
                        double mileValue = (inchValue / 63360);
                        resultView.setText(mileValue + " Miles");
                        break;
                    case R.id.buttonClearAll:
                        inchText.setText("");
                        resultView.setText("");
                        break;

                }
            } catch (NumberFormatException e) {
                Toast.makeText(this,  getResources().getString(R.string.specialCharacters), Toast.LENGTH_SHORT).show();
            }
        }
    }

}