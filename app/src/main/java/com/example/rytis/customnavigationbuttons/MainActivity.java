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

        //requestPermissions(new String[]{Manifest.permission.BIND_ACCESSIBILITY_SERVICE}, Integer.parseInt(ACCESSIBILITY_SERVICE));

        Button turnOn = findViewById(R.id.turnOn);
        turnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(getApplication(), MainButtonService.class));
            }
        });

        Button topButtonSetup = findViewById(R.id.topButton);
        topButtonSetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TopButtonSettingsActivity.class));
            }
        });

        Button leftButtonSetup = findViewById(R.id.leftButton);
        leftButtonSetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LeftButtonSettingsActivity.class));
            }
        });

        Button rightButtonSetup = findViewById(R.id.rightButton);
        rightButtonSetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RightButtonSettingActivity.class));
            }
        });
    }
}
