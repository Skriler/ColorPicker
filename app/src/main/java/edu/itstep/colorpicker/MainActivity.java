package edu.itstep.colorpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout layoutMain;
    private TextView tvColorPicker;
    private CheckBox cbRed;
    private CheckBox cbGreen;
    private CheckBox cbBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setCheckBoxListeners();
    }

    private void initializeViews() {
        layoutMain = findViewById(R.id.layoutMain);
        tvColorPicker = findViewById(R.id.tvColorPicker);

        cbRed = findViewById(R.id.cbRed);
        cbGreen = findViewById(R.id.cbGreen);
        cbBlue = findViewById(R.id.cbBlue);
    }

    private void setCheckBoxListeners() {
        cbRed.setOnClickListener(this);
        cbGreen.setOnClickListener(this);
        cbBlue.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int colorCodeRed = cbRed.isChecked() ? ColorConstants.MAX_COLOR_CODE : ColorConstants.MIN_COLOR_CODE;
        int colorCodeGreen = cbGreen.isChecked() ? ColorConstants.MAX_COLOR_CODE : ColorConstants.MIN_COLOR_CODE;
        int colorCodeBlue = cbBlue.isChecked() ? ColorConstants.MAX_COLOR_CODE : ColorConstants.MIN_COLOR_CODE;

        int selectedColorCode = Color.rgb(colorCodeRed, colorCodeGreen, colorCodeBlue);

        int invertedColorCode  = Color.rgb(
                ColorConstants.MAX_COLOR_CODE - colorCodeRed,
                ColorConstants.MAX_COLOR_CODE - colorCodeGreen,
                ColorConstants.MAX_COLOR_CODE - colorCodeBlue
        );

        ChangeColors(selectedColorCode, invertedColorCode);
    }

    private void ChangeColors(int backgroundColor, int textColor) {
        layoutMain.setBackgroundColor(backgroundColor);

        tvColorPicker.setTextColor(textColor);
        cbRed.setTextColor(textColor);
        cbGreen.setTextColor(textColor);
        cbBlue.setTextColor(textColor);
    }
}