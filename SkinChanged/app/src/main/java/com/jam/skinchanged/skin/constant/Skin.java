package com.jam.skinchanged.skin.constant;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by jam on 17/9/4.
 */

public class Skin {
    public static final int TYPE_RED = 0;
    public static final int TYPE_GREEN = 1;

    @IntDef({TYPE_RED, TYPE_GREEN})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SkinType {
    }

    public static final int VIEW_BACKGROUND = 0;
    public static final int VIEW_TEXTCOLOR = 1;
    public static final int VIEW_DRAWABLE = 2;

    @IntDef({VIEW_BACKGROUND, VIEW_TEXTCOLOR, VIEW_DRAWABLE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewChangedAttr {
    }
}
