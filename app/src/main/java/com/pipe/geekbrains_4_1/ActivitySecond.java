package com.pipe.geekbrains_4_1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class ActivitySecond extends AppCompatActivity implements Constants {

    private int selectThem = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        initView();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        int mySelectThem = selectThem;
        outState.putInt("STATE_THEME", mySelectThem);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    private void initView() {
        initButtonSwitchClickListener();
        initSwitchLightClickListener();
        initSwitchDarkClickListener();
    }

    private void initButtonSwitchClickListener() {
        Button buttonSwitch = findViewById(R.id.ButtonSwitch);
        buttonSwitch.setOnClickListener(onClickListener);
    }

    private void initSwitchLightClickListener() {
        Button buttonSwitch = findViewById(R.id.SwitchLite);
        buttonSwitch.setOnClickListener(radioButtonClickListener);
    }

    private void initSwitchDarkClickListener() {
        Button buttonSwitch = findViewById(R.id.SwitchDark);
        buttonSwitch.setOnClickListener(radioButtonClickListener);
    }

    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ButtonSwitch:
                    finish();
                    break;
            }
        }
    };

    public final View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton rb = (RadioButton) v;
            switch (rb.getId()) {
                case R.id.SwitchLite:
                    selectThem = 1;
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    Log.d("!!radioButtonClickListener", "SwitchLite");
                    break;
                case R.id.SwitchDark:
                    selectThem = 2;
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    Log.d("!!radioButtonClickListener", "SwitchDark");
                    break;
                default:
                    break;
            }
        }
    };
}