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

public class MainButtonService extends Service {

    private WindowManager windowManager;
    private ImageView mainButton;
    WindowManager.LayoutParams params;

    @Override
    public void onCreate() {
        super.onCreate();

        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        mainButton = new ImageView(this);
        mainButton.setImageResource(R.drawable.main_icon);

        params= new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.TOP | Gravity.LEFT;
        params.x = 0;
        params.y = 100;

        //this code is for dragging the chat head
        mainButton.setOnTouchListener(new View.OnTouchListener() {
            private int initialX;
            private int initialY;
            private float initialTouchX;
            private float initialTouchY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        initialX = params.x;
                        initialY = params.y;
                        initialTouchX = event.getRawX();
                        initialTouchY = event.getRawY();
                        return true;
                    case MotionEvent.ACTION_UP:
                        if(event.getEventTime() - event.getDownTime() < 100)
                        {
                            startService(new Intent(getApplication(), OptionsService.class));
                            startService(new Intent(getApplication(), TopOptionService.class));
                            startService(new Intent(getApplication(), LeftOptionService.class));
                            startService(new Intent(getApplication(), RightOptionService.class));
                            startService(new Intent(getApplication(), BottomOptionService.class));
                            stopService(new Intent(getApplication(), MainButtonService.class));
                        }
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        params.x = initialX
                                + (int) (event.getRawX() - initialTouchX);
                        params.y = initialY
                                + (int) (event.getRawY() - initialTouchY);
                        windowManager.updateViewLayout(mainButton, params);
                        return true;
                }
                return false;

            }

        });


        windowManager.addView(mainButton, params);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mainButton != null)
            windowManager.removeView(mainButton);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
