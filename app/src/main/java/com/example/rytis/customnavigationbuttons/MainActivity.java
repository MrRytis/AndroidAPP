package com.example.rytis.customnavigationbuttons;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton homeSettingsButton = findViewById(R.id.imageButton2);
        homeSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(getApplication(), BackButtonService.class));
                startService(new Intent(getApplication(), HomeButtonService.class));
                startService(new Intent(getApplication(), RecentButtonService.class));
                //startActivity(new Intent(MainActivity.this, HomeButtonSettingsActivity.class));
            }
        });

        ImageButton recentSettingButton = findViewById(R.id.imageButton3);
        recentSettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(getApplication(), BackButtonService.class));
                stopService(new Intent(getApplication(), HomeButtonService.class));
                stopService(new Intent(getApplication(), RecentButtonService.class));
                //startActivity(new Intent(MainActivity.this, RecentButtonSettingActivity.class));
            }
        });

        ImageButton backSettingButton = findViewById(R.id.imageButton4);
        backSettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BackButtonSettingsActivity.class));
            }
        });

        Button homeLongPressButton = findViewById(R.id.button);
        homeLongPressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HomeLongPressActivity.class));
            }
        });

        Button homeDoublePressButton = findViewById(R.id.button2);
        homeDoublePressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HomeDoublePressActivity.class));
            }
        });

        Button recentLongPressButton = findViewById(R.id.button3);
        recentLongPressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RecentLongPressActivity.class));
            }
        });

        Button recentDoublePressButton = findViewById(R.id.button4);
        recentDoublePressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RecentDoublePressActivity.class));
            }
        });

        Button backLongPressButton = findViewById(R.id.button5);
        backLongPressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BackLongPressActivity.class));
            }
        });

        Button backDoublePressButton = findViewById(R.id.button7);
        backDoublePressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BackDoublePressActivity.class));
            }
        });

    }
}
