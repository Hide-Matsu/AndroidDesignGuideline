package com.matsu.hide.design.guideline.android.ui.top;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.matsu.hide.design.guideline.android.R;
import com.matsu.hide.design.guideline.android.ui.common.BaseFragment;

import java.util.ArrayList;

public class RecyclerFragment extends BaseFragment {
    public static final String TAG = RecyclerFragment.class.getName();

    private RecyclerView recycler = null;

    public static RecyclerFragment newInstance() {
        return new RecyclerFragment();
    }

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

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<String> items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            items.add("");
        }

        CustomAdapter adapter = new CustomAdapter(getContext(), items);
        recycler.setAdapter(adapter);
    }
}
