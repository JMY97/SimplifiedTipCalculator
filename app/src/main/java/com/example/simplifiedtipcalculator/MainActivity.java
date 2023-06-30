package com.example.simplifiedtipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView textView2, textView3, textView4, textView5;
    EditText editText1, editText2, editText3, editText4;
    Button Button3, Button4;

    double billEnt = 150;
    double tipOutput;

    double tipPercent = 15;
    double tipAmount;

    double totalOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        Button3 = findViewById(R.id.button3);
        Button4 = findViewById(R.id.button4);

        billEnt = Double.parseDouble(df.format(billEnt));
        tipPercent = Double.parseDouble(String.format("%.2f",tipPercent));

        editText1.setText(Double.toString(billEnt));
        editText2.setText(Double.toString(tipPercent));
        billEntry();

        //editText3.setText(Double.toString(tipAmount));
        //editText4.setText(Double.toString(totalOutput));

        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(tipPercent > 0){
                    tipPercent--;
                    editText2.setText(Double.toString(tipPercent));
                }
                billEntry();
            }
        });

        Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tipPercent > 0){
                    tipPercent++;
                    editText2.setText(Double.toString(tipPercent));
                }
                billEntry();
            }
        });
    }
    private static DecimalFormat df = new DecimalFormat("0.00");
    private void billEntry(){

        //EditText editText1 = findViewById(R.id.editText1);
        //TextView textView2 = findViewById(R.id.textView2);

        String billString = editText1.getText().toString();
        //String tipString = editText3.getText().toString();

            //Initial Bill
            billEnt = Double.valueOf(billString);

            //Calculate Tip
            tipOutput = (billEnt * (tipPercent/100));

            //Show Total Bill
            totalOutput = billEnt + tipOutput;

            tipOutput = Double.parseDouble(df.format(tipOutput));
            totalOutput = Double.parseDouble(String.format("%.2f",totalOutput));

            editText3.setText(Double.toString(tipOutput));
            editText4.setText(Double.toString(totalOutput));

        }
}