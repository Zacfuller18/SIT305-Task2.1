package com.zfuller.task21_zacharyfuller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner inputSpinner;
    EditText enterValue;

    TextView textOne;
    TextView textTwo;
    TextView textThree;
    TextView resultOne;
    TextView resultTwo;
    TextView resultThree;

    ImageButton metreButton;
    ImageButton tempButton;
    ImageButton weightButton;

    private void addObjects() {
        inputSpinner = findViewById(R.id.inputSpinner);
        enterValue = findViewById(R.id.enterValue);

        textOne = findViewById(R.id.textOne);
        textTwo = findViewById(R.id.textTwo);
        textThree = findViewById(R.id.textThree);

        resultOne = findViewById(R.id.resultOne);
        resultTwo = findViewById(R.id.resultTwo);
        resultThree = findViewById(R.id.resultThree);

        metreButton = findViewById(R.id.metreButton);
        tempButton = findViewById(R.id.tempButton);
        weightButton = findViewById(R.id.weightButton);


        Spinner inputSpinner = (Spinner) findViewById(R.id.inputSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inputSpinner.setAdapter(adapter);

        metreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickAction(view);
            }
        });

        tempButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickAction(view);
            }
        });

        weightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickAction(view);
            }
        });
    }

    private void clickAction(View view) {
        switch (view.getId()) {
            case R.id.metreButton: { //add trim?
                if (inputSpinner.getSelectedItem().toString().trim().equals("Metre")) {
                    DisplayLength();
                } else DisplayError();
            }
            break;
            case R.id.tempButton: {
                if (inputSpinner.getSelectedItem().toString().trim().equals("Celsius")) {
                    DisplayTemp();
                } else DisplayError();
            }
            break;
            case R.id.weightButton: {
                if (inputSpinner.getSelectedItem().toString().trim().equals("Kilograms")) {
                    DisplayWeight();
                } else DisplayError();
            }
            break;
        }
    }

    public void DisplayLength() {
        textOne.setText("Centimeter");
        textTwo.setText("Foot");
        textThree.setText("Inch");

        //centimetres
        double input = Double.valueOf(String.valueOf(enterValue.getText()));
        double result = input * 100;
        String roundedResult = String.format("%.2f", result);
        resultOne.setText(roundedResult);
        //foot
        result = input * 3.281;
        roundedResult = String.format("%.2f", result);
        resultTwo.setText(roundedResult);
        //inch

        //test
        result = input * 39.37;
        roundedResult = String.format("%.2f", result);
        resultThree.setText(roundedResult);
    }

    public void DisplayTemp() {
        textOne.setText("Fahrenheit");
        textTwo.setText("Kelvin");
        textThree.setText("");

        //fahrenheit
        double input = Double.valueOf(String.valueOf(enterValue.getText()));
        double result = input * 9 / 5 + 32;
        String roundedResult = String.format("%.2f", result);
        resultOne.setText(roundedResult);
        //kelvin
        result = input + 273.15;
        roundedResult = String.format("%.2f", result);
        resultTwo.setText(roundedResult);
        //hide third area
        resultThree.setText("");
    }

    public void DisplayWeight() {
        textOne.setText("Gram");
        textTwo.setText("Ounce(Oz)");
        textThree.setText("Pound(lb)");

        //gram
        double input = Double.valueOf(String.valueOf(enterValue.getText()));
        double result = input * 1000;
        String roundedResult = String.format("%.2f", result);
        resultOne.setText(roundedResult);
        //ounce
        result = input * 35.274;
        roundedResult = String.format("%.2f", result);
        resultTwo.setText(roundedResult);
        //pound
        result = input * 2.205;
        roundedResult = String.format("%.2f", result);
        resultThree.setText(roundedResult);
    }

    public void DisplayError() {
        Toast.makeText(MainActivity.this, "Please select the correct conversion button", Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addObjects();
    }
}