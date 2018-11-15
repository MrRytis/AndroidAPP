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

public class OptionsService extends Service {

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
        params.x = windowManager.getDefaultDisplay().getWidth()/2-24;
        params.y = windowManager.getDefaultDisplay().getHeight()/2-24;


        //this code is for dragging the chat head
        mainButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startService(new Intent(getApplication(), MainButtonService.class));
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
        // TODO Auto-generated method stub
        return null;
    }
}
