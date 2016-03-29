package com.matsu.hide.design.guideline.android.common.model.splash;

import android.content.Context;
import android.os.Handler;
import android.view.ContextMenu;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Splash処理を実行するクラス
 */
public class Splash {

    //region const

    /**
     * スプラッシュ時間（ミリ秒）
     */
    private static final int SPLASH_TIME = 2000;

    //endregion

    //region field

    /**
     * 受け取ったコールバックインスタンス
     */
    private SplashCallback callback = null;

    /**
     * ハンドラ
     */
    private Handler handler = null;

    //endregion

    //region interface

    /**
     * スプラッシュ完了通知を受け取るためのコールバック
     */
    public interface SplashCallback {
        void onSplashFinished();
    }

    //endregion

    //region method

    /**
     * コンストラクタ
     */
    public Splash(SplashCallback callback, Handler handler) {
        this.callback = callback;
        this.handler = handler;
    }

    /**
     * スプラッシュ処理開始
     */
    public void start() {
        // 規定時間後に通知
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // 通知
                if (callback != null) {
                    callback.onSplashFinished();
                }
            }
        }, SPLASH_TIME);
    }

    //endregion
}
