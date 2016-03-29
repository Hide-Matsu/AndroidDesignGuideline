package com.matsu.hide.design.guideline.android.common.model.launch;

import android.os.Handler;

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
     * ハンドラ
     */
    private Handler handler = null;

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
    public Startup(StartupCallback callback, Handler handler) {
        this.callback = callback;
        this.handler = handler;
    }

    /**
     * 初期化処理開始
     */
    public void startFileDeployment() {
        // 規定時間後に通知
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // 通知
                if (callback != null) {
                    callback.onFileDeployFinished();
                }
            }
        }, FILE_DEPLOY_TIME);
    }

    public void startLoginCheck() {
        // 規定時間後に通知
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // 通知
                if (callback != null) {
                    callback.onLoginFinished();
                }
            }
        }, LOGIN_CHECK_TIME);
    }

    //endregion
}
