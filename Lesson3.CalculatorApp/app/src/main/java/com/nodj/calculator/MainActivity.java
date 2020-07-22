package com.nodj.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView resultField;
    TextView numberField1;
    TextView numberField2;
    TextView textNumber1;
    TextView textNumber2;
    TextView actionField;
    TextView curNumberField;
    double res = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultField = findViewById(R.id.resNumber);
        numberField1 = findViewById(R.id.number1);
        numberField2 = findViewById(R.id.number2);
        textNumber1 = findViewById(R.id.textNumber1);
        textNumber2 = findViewById(R.id.textNumber2);
        actionField = findViewById(R.id.action);
        curNumberField = numberField1;
    }

    public void onNumberClick(View view){
        Button button = (Button)view;
        curNumberField.append(button.getText());

        removeZeros(numberField1);
        removeZeros(numberField2);
    }

    private void removeZeros(TextView field) {
        if(field.length() > 1 && field.getText().charAt(0) == '0' && field.getText().charAt(1) != '.'){
            char num = field.getText().charAt(0);
            int i = 1;
            while (num == '0' && i < field.length()){
                num = field.getText().charAt(i);
                i++;
            }
            if(i == field.length()){
                field.setText(field.getText().toString().substring(field.length()-1, field.length()));
            }
            else{
                field.setText(field.getText().toString().substring(i-1, field.length()));
            }
        }
    }

    public void onDeleteClick(View view){
        if(curNumberField.length() != 0)
            curNumberField.setText(curNumberField.getText().toString().substring(0, curNumberField.length() - 1));
    }

    public void onActionClick(View view){
        Button button = (Button)view;
        actionField.setText(button.getText().toString());
    }

    public void onFirstNumClick(View view){
        numberField2.setBackgroundColor(Color.parseColor("#FFFFFF"));
        textNumber2.setBackgroundColor(Color.parseColor("#FFFFFF"));
        curNumberField = numberField1;
        curNumberField.setBackgroundColor(Color.parseColor("#FFEB3B"));
        textNumber1.setBackgroundColor(Color.parseColor("#FFEB3B"));
    }

    public void onSecondNumClick(View view){
        numberField1.setBackgroundColor(Color.parseColor("#FFFFFF"));
        textNumber1.setBackgroundColor(Color.parseColor("#FFFFFF"));
        curNumberField = numberField2;
        curNumberField.setBackgroundColor(Color.parseColor("#FFEB3B"));
        textNumber2.setBackgroundColor(Color.parseColor("#FFEB3B"));
    }

    @SuppressLint("DefaultLocale")
    public void onEqualClick(View view){
        double num1;
        double num2;
        try {
            num1 = Double.parseDouble(numberField1.getText().toString());
            num2 = Double.parseDouble(numberField2.getText().toString());
        }
        catch (Exception e){
            resultField.setText("Одно из чисел введено неверно");
            return;
        }

        switch(actionField.getText().toString())
        {
            case "+":
                res = num1 + num2;
                resultField.setText(String.format("%.2f", res));
                break;
            case "-":
                res = num1 - num2;
                resultField.setText(String.format("%.2f", res));
                break;
            case "*":
                res = num1 * num2;
                resultField.setText(String.format("%.2f", res));
                break;
            case "/":
                if(num2 == 0){
                    resultField.setText("Делить на 0 нельзя");
                }
                else{
                    res = num1 / num2;
                    resultField.setText(String.format("%.2f", res));
                }
                break;
        }
    }
}