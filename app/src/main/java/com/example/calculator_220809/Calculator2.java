package com.example.calculator_220809;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculator_220809.CalculatorAll.AddClass;
import com.example.calculator_220809.CalculatorAll.DivClass;
import com.example.calculator_220809.CalculatorAll.MulClass;
import com.example.calculator_220809.CalculatorAll.SubClass;

public class Calculator2 extends AppCompatActivity {

    //boolean isFirstInput = true; // 입력 값이 처음 입력되는지 체크
    double num1, num2; // 처음 수와 다음 수 저장
    TextView resultText; // 계산 값 출력
    char operator = '+'; // 연산자 저장

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator2);
        setTitle("계산기2");

        resultText = findViewById(R.id.textView);

        AddClass addClass;
        SubClass subClass;
        MulClass mulClass;
        DivClass divClass;
    }

    public void onClick(View view) {
        String num = resultText.getText().toString();

        switch (view.getId()) {
            case R.id.button_right_empty:
                resultText.setText("");
                break;
            case R.id.button_add: case R.id.button_sub: case R.id.button_mul: case R.id.button_div: // 연산자 버튼 눌렀을 때 operator 지정
                if(num.equals("")) {
                    Toast.makeText(getApplicationContext(), "숫자를 먼저 입력하세요", Toast.LENGTH_SHORT).show();
                } else {
                    num1 = Double.parseDouble(num);
                    num = "";
                    resultText.setText(num);
                    if(view.getId() == R.id.button_add)
                        operator = '+';
                    else if(view.getId() == R.id.button_sub)
                        operator = '-';
                    else if(view.getId() == R.id.button_mul)
                        operator = '*';
                    else if(view.getId() == R.id.button_div)
                        operator = '/';
                }
                break;
            case R.id.button_equals:
                if(num.equals("")) {
                    Toast.makeText(getApplicationContext(), "숫자를 먼저 입력하세요", Toast.LENGTH_SHORT).show();
                } else {
                    num2 = Double.parseDouble(num);
                    //if를 사용하여 operator 연산 수행
                    if (operator == '+') {
                        AddClass addClass = new AddClass(num1, num2);
                        resultText.setText(addClass.text1);
                    } else if (operator == '-') {
                        SubClass subClass = new SubClass(num1, num2);
                        resultText.setText(subClass.text2);
                    } else if (operator == '/') {
                        if (num2 == 0) {
                            Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다 다시 입력하세요", Toast.LENGTH_SHORT).show();
                            resultText.setText("");
                        } else {
                            DivClass divClass = new DivClass(num1, num2);
                            resultText.setText(divClass.text3);
                        }
                    } else if (operator == '*') {
                        MulClass mulClass = new MulClass(num1, num2);
                        resultText.setText(mulClass.text4);
                    }
                }
                break;
            case R.id.button_0: case R.id.button_1: case R.id.button_2: case R.id.button_3:
            case R.id.button_4: case R.id.button_5: case R.id.button_6: case R.id.button_7:
            case R.id.button_8: case R.id.button_9:
                if(view.getId() == R.id.button_0) {
                    num += "0";
                } else if (view.getId() == R.id.button_1) {
                    num += "1";
                } else if (view.getId() == R.id.button_2) {
                    num += "2";
                } else if (view.getId() == R.id.button_3) {
                    num += "3";
                } else if (view.getId() == R.id.button_4) {
                    num += "4";
                } else if (view.getId() == R.id.button_5) {
                    num += "5";
                } else if (view.getId() == R.id.button_6) {
                    num += "6";
                } else if (view.getId() == R.id.button_7) {
                    num += "7";
                } else if (view.getId() == R.id.button_8) {
                    num += "8";
                } else if (view.getId() == R.id.button_9) {
                    num += "9";
                }
                resultText.setText(num);
                break;
        }
    }

}