package com.jam.skinchanged.skin;

/**
 * Created by jam on 17/9/4.
 */

public class SkinManager {

    private ISkin mISkin;
    private SkinChangedListener mSkinChangedListener;

    public static final int TYPE_RED = 0;
    public static final int TYPE_GREEN = 1;

    public SkinManager() {
        mISkin = new RedSkin();
    }

    public void setSkinChangedListener(SkinChangedListener listener) {
        mSkinChangedListener = listener;
    }

    public void changeSkin(int skinType) {
        switch (skinType) {
            case TYPE_RED:
                mISkin = new RedSkin();
                break;
            case TYPE_GREEN:
                mISkin = new GreenSkin();
                break;
        }
        if (mSkinChangedListener != null) {
            mSkinChangedListener.onSkinChanged();
        }
    }

    public ISkin getSkin() {
        return mISkin;
    }
}
