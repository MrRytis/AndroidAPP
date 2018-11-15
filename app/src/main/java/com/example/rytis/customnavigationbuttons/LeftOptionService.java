package com.example.rytis.customnavigationbuttons;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class LeftOptionService extends Service {

    private WindowManager windowManager;
    private ImageView leftButton;
    WindowManager.LayoutParams params;

    @Override
    public void onCreate() {
        super.onCreate();

        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        leftButton = new ImageView(this);

        Drawable appIcon = null;
        try {
            appIcon = getPackageManager().getApplicationIcon("com.instagram.android");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        appIcon.setBounds(0,0, 42, 42);
        leftButton.setImageDrawable(appIcon);

        params= new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.TOP | Gravity.LEFT;
        params.x = windowManager.getDefaultDisplay().getWidth()/2-300;
        params.y = windowManager.getDefaultDisplay().getHeight()/2-50;

        //this code is for dragging the chat head
        leftButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.instagram.android");
                        if(launchIntent != null)
                        {
                            startActivity(launchIntent);
                        }
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

        windowManager.addView(leftButton, params);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (leftButton != null)
            windowManager.removeView(leftButton);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }
}
