package com.pipe.geekbrains_4_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView numberFieldWindow;
    private Counters counters;
    private TextView numberViewWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        counters = new Counters();
        initView();
    }

    private void initView() {
        // Получить пользовательские элементы по идентификатору
        numberFieldWindow = findViewById(R.id.numberFieldWindow);
        numberViewWindow = findViewById(R.id.numberViewWindow);
        initButtonZeroClickListener();
        initButtonOneClickListener();
        initButtonTwoClickListener();
        initButtonThreeClickListener();
        initButtonFourClickListener();
        initButtonSixClickListener();
        initButtonFiveClickListener();
        initButtonSevenClickListener();
        initButtonEightClickListener();
        initButtonNineClickListener();
        initButtonSquaringClickListener();
        initButtonClearClickListener();
        initButtonWipeClickListener();
        initButtonSplitClickListener();
        initButtonPlusClickListener();
        initButtonEqualToClickListener();
        initButtonDotClickListener();
        initButtonMinusClickListener();
        initButtonMultiplyClickListener();
        initButtonRootClickListener();
    }

    private void initButtonZeroClickListener() {
        Button buttonZero = findViewById(R.id.ButtonZero);
        buttonZero.setOnClickListener(onClickListener);
    }

    private void initButtonOneClickListener() {
        Button buttonOne = findViewById(R.id.ButtonOne);
        buttonOne.setOnClickListener(onClickListener);
    }

    private void initButtonTwoClickListener() {
        Button buttonTwo = findViewById(R.id.ButtonTwo);
        buttonTwo.setOnClickListener(onClickListener);
    }

    private void initButtonThreeClickListener() {
        Button buttonThree = findViewById(R.id.ButtonThree);
        buttonThree.setOnClickListener(onClickListener);
    }

    private void initButtonFourClickListener() {
        Button buttonFour = findViewById(R.id.ButtonFour);
        buttonFour.setOnClickListener(onClickListener);
    }

    private void initButtonFiveClickListener() {
        Button buttonFive = findViewById(R.id.ButtonFive);
        buttonFive.setOnClickListener(onClickListener);
    }

    private void initButtonSixClickListener() {
        Button buttonSix = findViewById(R.id.ButtonSix);
        buttonSix.setOnClickListener(onClickListener);
    }

    private void initButtonSevenClickListener() {
        Button buttonSeven = findViewById(R.id.ButtonSeven);
        buttonSeven.setOnClickListener(onClickListener);
    }

    private void initButtonEightClickListener() {
        Button buttonEight = findViewById(R.id.ButtonEight);
        buttonEight.setOnClickListener(onClickListener);
    }

    private void initButtonNineClickListener() {
        Button buttonNine = findViewById(R.id.ButtonNine);
        buttonNine.setOnClickListener(onClickListener);
    }

    private void initButtonSquaringClickListener() {
        Button buttonSquaring = findViewById(R.id.ButtonSquaring);
        buttonSquaring.setOnClickListener(onClickListener);
    }

    private void initButtonClearClickListener() {
        Button buttonClear = findViewById(R.id.ButtonClear);
        buttonClear.setOnClickListener(onClickListener);
    }

    private void initButtonWipeClickListener() {
        Button buttonWipe = findViewById(R.id.ButtonWipe);
        buttonWipe.setOnClickListener(onClickListener);
    }

    private void initButtonSplitClickListener() {
        Button buttonSplit = findViewById(R.id.ButtonSplit);
        buttonSplit.setOnClickListener(onClickListener);
    }

    private void initButtonPlusClickListener() {
        Button buttonPlus = findViewById(R.id.ButtonPlus);
        buttonPlus.setOnClickListener(onClickListener);
    }

    private void initButtonEqualToClickListener() {
        Button buttonEqualTo = findViewById(R.id.ButtonEqualTo);
        buttonEqualTo.setOnClickListener(onClickListener);
    }

    private void initButtonDotClickListener() {
        Button buttonDot = findViewById(R.id.ButtonDot);
        buttonDot.setOnClickListener(onClickListener);
    }

    private void initButtonMinusClickListener() {
        Button buttonMinus = findViewById(R.id.ButtonMinus);
        buttonMinus.setOnClickListener(onClickListener);
    }

    private void initButtonMultiplyClickListener() {
        Button buttonMultiply = findViewById(R.id.ButtonMultiply);
        buttonMultiply.setOnClickListener(onClickListener);
    }

    private void initButtonRootClickListener() {
        Button buttonRoot = findViewById(R.id.ButtonRoot);
        buttonRoot.setOnClickListener(onClickListener);
    }

    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ButtonOne:
                    setNumberFieldWindow("1");
                    break;
                case R.id.ButtonTwo:
                    setNumberFieldWindow("2");
                    break;
                case R.id.ButtonThree:
                    setNumberFieldWindow("3");
                    break;
                case R.id.ButtonFour:
                    setNumberFieldWindow("4");
                    break;
                case R.id.ButtonFive:
                    setNumberFieldWindow("5");
                    break;
                case R.id.ButtonSix:
                    setNumberFieldWindow("6");
                    break;
                case R.id.ButtonSeven:
                    setNumberFieldWindow("7");
                    break;
                case R.id.ButtonEight:
                    setNumberFieldWindow("8");
                    break;
                case R.id.ButtonNine:
                    setNumberFieldWindow("9");
                    break;
                case R.id.ButtonPlus:
                    setSymbolCounter("+");
                    break;
                case R.id.ButtonMinus:
                    setSymbolCounter("-");
                    break;
                case R.id.ButtonSplit:
                    setSymbolCounter("\u00F7");
                    break;
                case R.id.ButtonMultiply:
                    setSymbolCounter("\u00D7");
                    break;
                case R.id.ButtonSquaring:
                    setSymbolCounter("x\u00B2");
                    break;
                case R.id.ButtonRoot:
                    setSymbolCounter("\u221a");
                    break;
                case R.id.ButtonDot:
                    setNumberFieldWindow(".");
                    break;
                case R.id.ButtonEqualTo:
                    setEqualToCounter();
                    break;
                case R.id.ButtonWipe:
                    clearNumberFieldWindow();
                    break;
                case R.id.ButtonClear:
                    deleteNumberFieldWindow();
                    break;
                case R.id.ButtonZero:
                    setNumberFieldWindow("0");
                    break;
            }
        }
    };

    private void setNumberFieldWindow(String arithmetic) {
        counters.setCounter(arithmetic);
        setTextCounter(numberFieldWindow, counters.getCounter());
        setTextCounter(numberViewWindow, counters.getNumberViewWindow());
    }

    private void setSymbolCounter(String arithmetic) {
        counters.setSymbolCounter(arithmetic);
        setEqualToCounter();
    }

    private void setEqualToCounter() {
        counters.setEqualTo();
        setTextCounter(numberFieldWindow, counters.getCounter());
        setTextCounter(numberViewWindow, counters.getNumberViewWindow());
    }

    private void clearNumberFieldWindow() {
        counters.clearCounter();
        setTextCounter(numberFieldWindow, counters.getCounter());
        setTextCounter(numberViewWindow, counters.getNumberViewWindow());
    }

    private void deleteNumberFieldWindow() {
        counters.deleteAllCounter();
        setTextCounter(numberFieldWindow, counters.getCounter());
        setTextCounter(numberViewWindow, counters.getNumberViewWindow());
    }

    // Установить текст на TextView
    private void setTextCounter(TextView textCounter, String counter) {
        textCounter.setText(String.format(Locale.getDefault(), "%s", counter));
    }
}