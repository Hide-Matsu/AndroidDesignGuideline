package com.matsu.hide.design.guideline.android.ui.top;

import android.app.Fragment;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.matsu.hide.design.guideline.android.R;
import com.matsu.hide.design.guideline.android.ui.common.BaseFragment;

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
    protected Context context = null;

    /**
     * FragmentListener
     */
    protected RecyclerFragmentListener listener = null;

    private RecyclerView recycler = null;

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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        recycler = (RecyclerView)view.findViewById(R.id.list_view);
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(manager);
        return view;
    }

    /**
     * Fragmentが開始した
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<String> items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            items.add("");
        }

        CustomAdapter adapter = new CustomAdapter(context, items);
        recycler.setAdapter(adapter);
    }

    //endregion
}
