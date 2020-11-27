package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import org.mariuszgromada.math.mxparser.*;


public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.calcScreen);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }

            }
        });

    }

    private void updateText(String strToAdd) {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        }
        else{
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }

    }

    public void n0Btn(View view) {
        updateText("0");
    }

    public void n1Btn(View view) {
        updateText("1");
    }

    public void n2Btn(View view) {
        updateText("2");
    }

    public void n3Btn(View view) {
        updateText("3");
    }

    public void n4Btn(View view) {
        updateText("4");
    }

    public void n5Btn(View view) {
        updateText("5");
    }

    public void n6Btn(View view) {
        updateText("6");
    }

    public void n7Btn(View view) {
        updateText("7");
    }

    public void n8Btn(View view) {
        updateText("8");
    }

    public void n9Btn(View view) {
        updateText("9");
    }

    public void equalsBtn(View view) {
        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("×", "*");
        userExp = userExp.replaceAll("√", "^0.5");

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());
    }

    public void pointBtn(View view) {
        updateText(".");
    }

    public void addBtn(View view) {
        updateText("+");
    }

    public void subtractBtn(View view) {
        updateText("-");
    }

    public void multipyBtn(View view) {
        updateText("×");
    }

    public void divideBtn(View view) {
        updateText("÷");
    }

    public void ExpBtn(View view) {
        updateText("^");
    }

    public void sqrtBtn(View view) {
        updateText("√");
    }

    public void plusMinusBtn(View view) {
        updateText("-");

    }

    public void DELBtn(View view) {
        int cursorPos = display.getSelectionStart();
        int textLength = display.getText().length();

        if(cursorPos != 0 && textLength != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1,cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
    }

    public void CEBtn(View view) {
        display.setText("");
    }

}