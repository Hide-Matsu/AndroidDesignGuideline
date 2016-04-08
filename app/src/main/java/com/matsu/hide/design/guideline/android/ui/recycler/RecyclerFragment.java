package com.matsu.hide.design.guideline.android.ui.recycler;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.matsu.hide.design.guideline.android.R;
import com.matsu.hide.design.guideline.android.common.user.User;
import com.matsu.hide.design.guideline.android.databinding.FragmentRecyclerBinding;

import java.util.ArrayList;

/**
 * RecyclerViewを表示するFragment
 */
public class RecyclerFragment extends Fragment {

    //region field

    /**
     * TAG
     */
    public static final String TAG = RecyclerFragment.class.getSimpleName();

    /**
     * Context
     */
    private Context context = null;

    /**
     * FragmentListener
     */
    private RecyclerFragmentListener listener = null;

    /**
     * データバインドクラス
     */
    private FragmentRecyclerBinding binding = null;

    //endregion

    //region interface

    /**
     * FragmentListener
     */
    public interface RecyclerFragmentListener {
    }

    //endregion

    //region method

    public static RecyclerFragment newInstance() {
        return new RecyclerFragment();
    }

    /**
     * FragmentがFragmentManagerに追加された
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // FragmentListenerの受取
        if (!(context instanceof RecyclerFragmentListener)) {
            throw new UnsupportedOperationException(
                    "FragmentListener is not Implementation.");
        } else {
            listener = (RecyclerFragmentListener) context;
        }
        // Contextの保持
        this.context = context;
    }

    /**
     * FragmentのViewを生成する
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // View生成
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        binding = DataBindingUtil.bind(view);

        // RecyclerViewにレイアウトマネージャを設定
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.recyclerList.setLayoutManager(manager);
        return view;
    }

    /**
     * Fragmentが開始した
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // 仮データ作成
        ArrayList<User> items = new ArrayList<>();
        User user;
        for (int i = 0; i < 10; i++) {
            user = new User();
            user.setName(String.format("Sample Name %d", i));
            user.setNo(String.format("%d", 10000 + i));
            user.setOld(String.format("%d", 20 + i));
            items.add(user);
        }

        // 仮データセット
        CustomAdapter adapter = new CustomAdapter(context, items);
        binding.recyclerList.setAdapter(adapter);
    }

    //endregion
}
