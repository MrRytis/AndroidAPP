package com.example.rytis.customnavigationbuttons;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class BottomOptionService extends Service {

    private WindowManager windowManager;
    private ImageView bottomButton;
    WindowManager.LayoutParams params;


    @Override
    public void onCreate() {
        super.onCreate();

        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        bottomButton = new ImageView(this);

        bottomButton.setImageResource(R.drawable.power);

        params= new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);



        params.gravity = Gravity.TOP | Gravity.LEFT;
        params.x = windowManager.getDefaultDisplay().getWidth()/2-24;
        params.y = windowManager.getDefaultDisplay().getHeight()/2+200;


        //this code is for dragging the chat head

        bottomButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        stopService(new Intent(getApplication(), OptionsService.class));
                        stopService(new Intent(getApplication(), TopOptionService.class));
                        stopService(new Intent(getApplication(), LeftOptionService.class));
                        stopService(new Intent(getApplication(), RightOptionService.class));
                        stopService(new Intent(getApplication(), BottomOptionService.class));
                        return true;
                }
                return false;
            }
        });

        windowManager.addView(bottomButton, params);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (bottomButton != null)
            windowManager.removeView(bottomButton);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }
}
