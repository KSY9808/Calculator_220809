package com.example.calculator_220809.CalculatorAll;

public class MulClass {

    public String text4;

    public MulClass(double n1, double n2) {
        int mul = (int)(n1 * n2);
        text4 = Integer.toString(mul);
    }

    void mul(double n1, double n2) {
        int result = (int)(n1 * n2);
    }

}
