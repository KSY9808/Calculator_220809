package com.example.calculator_220809;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculator_220809.CalculatorAll.AddClass;
import com.example.calculator_220809.CalculatorAll.DivClass;
import com.example.calculator_220809.CalculatorAll.MulClass;
import com.example.calculator_220809.CalculatorAll.SubClass;

import java.nio.BufferUnderflowException;

public class Calculator2 extends AppCompatActivity {

    boolean isFirstInput = true; // 입력 값이 처음 입력되는지 체크
    double resultNumber = 0; // 계산 값 저장
    char operator = '+'; // 연산자 저장

    final String CLEAR_INPUT_TEXT = "0";
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator2);
        setTitle("계산기2");

        resultText = findViewById(R.id.textView);
        resultText.setText("input");

        //AddClass addClass = new AddClass();
        //SubClass subClass = new SubClass();
        //MulClass mulClass = new MulClass();
        //DivClass divClass = new DivClass();

        Button AddClick = findViewById(R.id.button_add);
        AddClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddClass addClass = new AddClass();
                resultText.setText(addClass.text);
            }
        });

    }
/*
    // 사칙연산 값 반환
    public double doubleCal(double result, double lastNum, char operator) {
        if(operator == '+') {
            result += lastNum;
        }
        else if(operator == '-') {
            result -= lastNum;
        }
        else if(operator == '/') {
            result /= lastNum;
        }
        else if(operator == 'x') {
            result *= lastNum;
        }
        return result;
    }
*/
    // 0 ~ 9 버튼 클릭
    public void NumClick(View view) {
        Button getButton = findViewById(view.getId());

        if(isFirstInput) {
            resultText.setText(getButton.getText().toString());
            isFirstInput = false;
        }
        else {
            if(resultText.getText().toString().equals("0")) {
                Toast.makeText(getApplicationContext(), "초기 입력값이 0입니다.", Toast.LENGTH_LONG).show();
                setClearText(CLEAR_INPUT_TEXT);
                return;
            }
            resultText.append(getButton.getText().toString());
        }
    }

    // 입력된 숫자 초기화
    public void setClearText(String clearText) {
        isFirstInput = true;
        resultText.setText(clearText);
    }
/*
    // AC, CE 버튼 클릭
    public void buttonClick(View view) {

        switch(view.getId()) {
            case R.id.button_left_empty:
                resultNumber = 0;
                operator = '+';
                setClearText(CLEAR_INPUT_TEXT);
                break;

            case R.id.button_right_empty:
                if(resultText.getText().toString().length() > 1) {
                    String getResultText = resultText.getText().toString();
                    String subString = getResultText.substring(0,getResultText.length()-1);
                    resultText.setText(subString);
                }
                else {
                    resultText.setText(CLEAR_INPUT_TEXT);
                    isFirstInput = true;
                }
                break;
        }

    }

    // +, -, x, / 버튼 클릭
    public void operatorClick(View view) {
        Button getButton = findViewById(view.getId());

        if(view.getId() == R.id.button_equals) {
            if(isFirstInput) {
                resultNumber = 0;
                setClearText(CLEAR_INPUT_TEXT);
                // =를 두 번 이상 누를 때 처리
            }
            else {
                resultNumber = doubleCal(resultNumber, Double.parseDouble(resultText.getText().toString()), operator);
                resultText.setText(String.valueOf(resultNumber));
                isFirstInput = true;
            }
        }
        else {
            if(isFirstInput) {
                operator = getButton.getText().toString().charAt(0);
            }
            else {
                Double lastNum = Double.parseDouble(resultText.getText().toString());
                resultNumber = doubleCal(resultNumber, lastNum, operator);
                operator = getButton.getText().toString().charAt(0);
                resultText.setText(String.valueOf(resultNumber));
                isFirstInput = true;
            }
        }
    }
*/
}