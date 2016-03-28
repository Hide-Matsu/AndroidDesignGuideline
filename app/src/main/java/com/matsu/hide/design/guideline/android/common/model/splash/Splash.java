package com.matsu.hide.design.guideline.android.common.model.splash;

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
     * タイマー
     */
    private Timer timer = null;

    /**
     * タイマータスク
     */
    private TimerTask timerTask = null;

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
    public Splash(SplashCallback callback) {
        this.callback = callback;
        this.init();
    }

    /**
     * 初期化処理
     */
    private void init() {
        this.timer = new Timer();
        this.timerTask = new TimerTask() {
            @Override
            public void run() {
                // 通知
                if (callback != null) {
                    callback.onSplashFinished();
                }
            }
        };
    }

    /**
     * スプラッシュ処理開始
     */
    public void start() {
        // 規定時間後に通知
        timer.schedule(timerTask, SPLASH_TIME);
    }

    //endregion
}
