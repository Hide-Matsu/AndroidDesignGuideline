package com.matsu.hide.design.guideline.android.ui.recycler;

import android.content.Context;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.matsu.hide.design.guideline.android.R;
import com.matsu.hide.design.guideline.android.common.callback.RecyclerMenuItemClickListener;
import com.matsu.hide.design.guideline.android.common.user.User;
import com.matsu.hide.design.guideline.android.databinding.ListItemBinding;
import com.matsu.hide.design.guideline.android.databinding.MenuBinding;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;

/**
 * CustomAdapter
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    //region field

    /**
     * 表示するデータのリスト
     */
    private ArrayList<User> itemList = null;

    /**
     * コンテキスト
     */
    private Context context = null;

    //endregion

    //region method

    /**
     * コンストラクタ
     */
    public CustomAdapter(Context context, ArrayList<User> list) {
        this.itemList = list;
        this.context = context;
    }

    /**
     * ViewHolderの生成
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    /**
     * ViewHolderに対しデータをバインド
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (itemList != null && itemList.size() > position) {
            User user = itemList.get(position);
            holder.itemBinding.setUser(user);
        }
    }

    /**
     * データ数を取得
     */
    @Override
    public int getItemCount() {
        if (itemList != null) {
            return itemList.size();
        } else {
            return 0;
        }
    }

    //endregion

    /**
     * ViewHolder
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, RecyclerMenuItemClickListener {

        //region field

        /**
         * ViewHolderのバインドクラス
         */
        public ListItemBinding itemBinding;

        /**
         * セル内メニューのバインドクラス
         */
        private MenuBinding menuBinding;

        /**
         * セル内メニュー
         */
        private PopupWindow popupWindow;

        //endregion

        //region method

        /**
         * コンストラクタ
         */
        public ViewHolder(View itemView) {
            super(itemView);
            // バインドクラスを保持
            this.itemBinding = DataBindingUtil.bind(itemView);
            this.itemBinding.setOnClickListener(this);

            // PopupWindowのインスタンスを生成
            popupWindow = new PopupWindow(context);

            // PopupWindowに表示するViewを生成
            View contentView = LayoutInflater.from(context).inflate(R.layout.menu, null);
            menuBinding = DataBindingUtil.bind(contentView);
            menuBinding.setOnMenuItemClickListener(this);

            // PopupWindowに表示するViewをセット
            popupWindow.setContentView(contentView);

            // PopupWindowに表示するViewのサイズを設定
            float width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 140, context.getResources().getDisplayMetrics());
            popupWindow.setWidth((int) width);

            // PopupWindowの外をタッチしたらPopupWindowが閉じるように設定
            popupWindow.setOutsideTouchable(true);

            // PopupWindow外のUIのタッチイベントが走らないようにフォーカスを持っておく
            popupWindow.setFocusable(true);

            // PopupWindow内のクリックを可能にしておく
            popupWindow.setTouchable(true);

            // レイアウトファイルで設定した背景のさらに背景(黒とか)が生成される為、ここで好みの背景を設定しておく
            popupWindow.setBackgroundDrawable(new ColorDrawable(ResourcesCompat.getColor(context.getResources(), android.R.color.transparent, context.getTheme())));
        }

        /**
         * OnClickListener.onClick
         */
        @Override
        public void onClick(View v) {
            // メニューを表示
            popupWindow.showAsDropDown(v, 0 - v.getWidth(), 0 - v.getHeight());
        }

        /**
         * RecyclerMenuItemClickListener.onMenuItemClick
         */
        @Override
        public void onMenuItemClick(View view) {
            if (view != null) {
                switch (view.getId()) {
                    case R.id.menu1:
                        Toast.makeText(context, menuBinding.menu1.getText(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu2:
                        Toast.makeText(context, menuBinding.menu2.getText(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu3:
                        Toast.makeText(context, menuBinding.menu3.getText(), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }

        //endregion
    }
}
