package com.matsu.hide.design.guideline.android.ui.top;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.matsu.hide.design.guideline.android.R;
import com.matsu.hide.design.guideline.android.ui.recycler.RecyclerFragment;
import com.matsu.hide.design.guideline.android.ui.splash.SplashFragment;

/**
 * 起動時の画面
 */
public class TopActivity extends AppCompatActivity implements SplashFragment.SplashFragmentListener, RecyclerFragment.RecyclerFragmentListener {

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
     * 画面切り替え
     */
    private void changeContent(Fragment fragment, String tag) {
        this.fragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment, tag)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

    //region FragmentListener

    @Override
    public void onStartupFinished() {
        this.changeContent(RecyclerFragment.newInstance(), RecyclerFragment.TAG);
    }

    //endregion

    //endregion
}
