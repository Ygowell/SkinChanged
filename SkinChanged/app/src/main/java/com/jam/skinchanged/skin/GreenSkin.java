package com.jam.skinchanged.skin;

import com.jam.skinchanged.R;

/**
 * Created by jam on 17/9/4.
 */

public class GreenSkin implements ISkin {

    @Override
    public int getTextPrimaryColor() {
        return R.color.colorGreen;
    }

    @Override
    public int getBackgroundPrimaryColor() {
        return R.color.colorGray;
    }
}
