package com.matsu.hide.design.guideline.android.ui.top;

import android.content.Context;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.PopupWindow;

import com.matsu.hide.design.guideline.android.BuildConfig;
import com.matsu.hide.design.guideline.android.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * CustomAdapter
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<String> itemList = null;
    private Context context = null;

    public CustomAdapter(Context context, ArrayList<String> list) {
        this.itemList = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view, parent);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (itemList != null) {
            return itemList.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageButton button;
        public PopupWindow popupWindow;

        public ViewHolder(View itemView, ViewGroup parent) {
            super(itemView);

            // 生成
            popupWindow = new PopupWindow(context);

            // 表示するViewを生成
            View contentView = LayoutInflater.from(context).inflate(R.layout.menu, null);
            ((Button)contentView.findViewById(R.id.menu1)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            ((Button)contentView.findViewById(R.id.menu2)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            ((Button)contentView.findViewById(R.id.menu3)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            popupWindow.setContentView(contentView);
            float width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 180, context.getResources().getDisplayMetrics());
            popupWindow.setWidth((int) width);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setTouchable(true);
            popupWindow.setFocusable(true);
            popupWindow.setBackgroundDrawable(context.getDrawable(R.drawable.menu_background));
            popupWindow.setElevation(8.0f);

            button = (ImageButton) itemView.findViewById(R.id.menu_btn);
            button.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            popupWindow.showAsDropDown(v, 0 - v.getWidth(), 0 - v.getHeight());
        }
    }

}
