package com.example.rytis.customnavigationbuttons;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;

public class HomeAction extends AccessibilityService {
    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {

    }

    @Override
    public void onInterrupt() {

    }

    public void Home()
    {
        performGlobalAction(GLOBAL_ACTION_HOME);
    }
}
