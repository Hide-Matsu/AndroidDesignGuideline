package com.matsu.hide.design.guideline.android.ui.common;

import android.app.Fragment;
import android.content.Context;

/**
 * Fragment基底クラス
 */
public class BaseFragment extends Fragment {

    //region field

    /**
     * Context
     */
    protected Context context = null;

    /**
     * FragmentListener
     */
    protected FragmentListener listener = null;

    //endregion

    //region enum

    /**
     * Fragmentのイベント種別
     */
    public enum FragmentEvent {
        StartupFinished,
    }

    //endregion

    //region interface

    /**
     * FragmentListener
     */
    public interface FragmentListener {
        void onFragmentInteraction(FragmentEvent event);
    }

    //endregion

    //region method

    /**
     * FragmentがFragmentManagerに追加された
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // FragmentListenerの受取
        if (!(context instanceof FragmentListener)) {
            throw new UnsupportedOperationException(
                    "FragmentListener is not Implementation.");
        } else {
            listener = (FragmentListener) context;
        }
        // Contextの保持
        this.context = context;
    }

    //endregion
}
