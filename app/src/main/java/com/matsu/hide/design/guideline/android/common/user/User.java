package com.matsu.hide.design.guideline.android.common.user;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.matsu.hide.design.guideline.android.BR;

/**
 * ユーザ情報
 */
public class User extends BaseObservable {

    //region field

    /**
     * TAG
     */
    public static final String TAG = User.class.getSimpleName();

    /**
     * 名前
     */
    private String name = null;

    /**
     * 年齢
     */
    private String old = null;

    /**
     * ユーザ番号
     */
    private String no = null;

    //endregion

    //region method

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
        notifyPropertyChanged(BR.old);
    }

    @Bindable
    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
        notifyPropertyChanged(BR.no);
    }

    //endregion


}
