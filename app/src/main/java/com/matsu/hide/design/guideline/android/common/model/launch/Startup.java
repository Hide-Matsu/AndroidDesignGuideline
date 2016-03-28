package com.matsu.hide.design.guideline.android.common.model.launch;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 初期化処理をするふりをするクラス
 */
public class Startup {

    //region const

    /**
     * ファイル展開をするふりをする時間
     */
    private static final int FILE_DEPLOY_TIME = 2000;

    /**
     * ログインチェックをするふりをする時間
     */
    private static final int LOGIN_CHECK_TIME = 2000;

    //endregion

    //region field

    /**
     * タイマー
     */
    private Timer timer = null;

    /**
     * ファイル展開処理タイマータスク
     */
    private TimerTask fileDeployTimerTask = null;

    /**
     * ログイン処理タイマータスク
     */
    private TimerTask loginTimerTask = null;

    /**
     * 受け取ったコールバック
     */
    private StartupCallback callback = null;

    //endregion

    //region interface

    /**
     * 初期化処理コールバック
     */
    public interface StartupCallback {
        void onFileDeployFailed();
        void onFileDeployFinished();
        void onLoginFailed();
        void onLoginFinished();
    }

    //endregion

    //region method

    /**
     * コンストラクタ
     */
    public Startup(StartupCallback callback) {
        this.callback = callback;
        this.init();
    }

    /**
     * 初期化処理
     */
    private void init() {
        this.timer = new Timer();

        // ファイル展開処理
        this.fileDeployTimerTask = new TimerTask() {
            @Override
            public void run() {
                // 通知
                if (callback != null) {
                    callback.onFileDeployFinished();
                }
            }
        };

        // ログイン処理
        this.loginTimerTask = new TimerTask() {
            @Override
            public void run() {
                // 通知
                if (callback != null) {
                    callback.onLoginFinished();
                }
            }
        };
    }

    /**
     * 初期化処理開始
     */
    public void startFileDeployment() {
        // 規定時間後に通知
        timer.schedule(fileDeployTimerTask, FILE_DEPLOY_TIME);
    }

    public void startLoginCheck() {
        // 規定時間後に通知
        timer.schedule(loginTimerTask, LOGIN_CHECK_TIME);
    }

    //endregion
}
