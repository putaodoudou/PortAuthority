package com.aaronjwood.portauthority;

import android.app.Application;
import android.os.Process;

public class PortAuthority extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        checkReplacingState(); // Workaround for https://issuetracker.google.com/issues/36972466
    }

    /**
     * Kills the process if we can't get our own resources.
     */
    private void checkReplacingState() {
        if (getResources() == null) {
            Process.killProcess(Process.myPid());
        }
    }

}
