package com.matsu.hide.design.guideline.android.ui.splash;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.matsu.hide.design.guideline.android.R;
import com.matsu.hide.design.guideline.android.common.model.launch.Startup;
import com.matsu.hide.design.guideline.android.common.model.splash.Splash;
import com.matsu.hide.design.guideline.android.ui.common.BaseFragment;

/**
 * Splash画面
 */
public class SplashFragment extends Fragment implements Splash.SplashCallback, Startup.StartupCallback {

    //region field

    /**
     * TAG
     */
    public static final String TAG = SplashFragment.class.getSimpleName();

    /**
     * Context
     */
    protected Context context = null;

    /**
     * FragmentListener
     */
    protected SplashFragmentListener listener = null;

    /**
     * スプラッシュ処理クラス
     */
    private Splash splash = null;

    /**
     * 初期化処理クラス
     */
    private Startup startup = null;

    //endregion

    //region interface

    /**
     * FragmentListener
     */
    public interface SplashFragmentListener {
        void onStartupFinished();
    }

    //endregion

    //region method

    /**
     * インスタンス取得
     */
    public static SplashFragment newInstance() {
        return new SplashFragment();
    }

    /**
     * コンストラクタ
     */
    public SplashFragment() {
        this.splash = new Splash(this);
        this.startup = new Startup(this);
    }

    /**
     * FragmentがFragmentManagerに追加された
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // FragmentListenerの受取
        if (!(context instanceof SplashFragmentListener)) {
            throw new UnsupportedOperationException(
                    "FragmentListener is not Implementation.");
        } else {
            listener = (SplashFragmentListener) context;
        }
        // Contextの保持
        this.context = context;
    }

    /**
     * FragmentのViewを生成する
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    /**
     * Fragmentが開始した
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated");
        splash.start();
    }

    /**
     * Splash処理終了
     */
    @Override
    public void onSplashFinished() {
        startup.startFileDeployment();
    }

    /**
     * ファイル展開失敗時の処理
     */
    @Override
    public void onFileDeployFailed() {
        // TODO 失敗時の処理
    }

    /**
     * ファイル展開成功時の処理
     */
    @Override
    public void onFileDeployFinished() {
        startup.startLoginCheck();
    }

    /**
     * ログイン失敗時の処理
     */
    @Override
    public void onLoginFailed() {
        // TODO 失敗時の処理
    }

    /**
     * ログイン成功時の処理
     */
    @Override
    public void onLoginFinished() {
        if (listener != null) {
            listener.onStartupFinished();
        }
    }

    //endregion
}
