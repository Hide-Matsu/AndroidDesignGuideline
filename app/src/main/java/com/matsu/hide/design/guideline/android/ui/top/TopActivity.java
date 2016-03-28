package com.matsu.hide.design.guideline.android.ui.top;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.matsu.hide.design.guideline.android.R;
import com.matsu.hide.design.guideline.android.ui.common.BaseFragment;
import com.matsu.hide.design.guideline.android.ui.splash.SplashFragment;

/**
 * 起動時の画面
 */
public class TopActivity extends AppCompatActivity implements BaseFragment.FragmentListener {

    //region field

    /**
     * FragmentManager
     */
    private FragmentManager fragmentManager = null;

    //endregion

    //region method

    /**
     * 画面を開始する処理
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        // FragmentManagerを保持
        this.fragmentManager = getFragmentManager();

        // 初期表示Fragmentをセット
        this.changeContent(SplashFragment.newInstance(), SplashFragment.TAG);
    }

    /**
     * Fragmentから通知されたイベント
     */
    @Override
    public void onFragmentInteraction(BaseFragment.FragmentEvent event) {
        switch (event) {

            // スプラッシュ終了イベント
            case StartupFinished:
                this.changeContent(RecyclerFragment.newInstance(), RecyclerFragment.TAG);
                break;
        }
    }

    /**
     * 画面切り替え
     */
    private void changeContent(BaseFragment fragment, String tag) {
        this.fragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment, tag)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

    //endregion
}
