package com.example.rytis.customnavigationbuttons;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;

public class BackAction extends AccessibilityService {
    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {

    }

    @Override
    public void onInterrupt() {

    }

    public void Back()
    {
        performGlobalAction(GLOBAL_ACTION_BACK);
    }
}
