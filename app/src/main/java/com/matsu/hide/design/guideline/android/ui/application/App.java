package com.matsu.hide.design.guideline.android.ui.application;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * Applicationクラス
 */
public class App extends Application implements Application.ActivityLifecycleCallbacks {

    //region field

    /**
     * TAG
     */
    public static final String TAG = App.class.getSimpleName();

    //endregion

    //region method

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(this);
    }

    @Override
    public void onTerminate() {
        unregisterActivityLifecycleCallbacks(this);
        super.onTerminate();
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }

    //endregion

}
