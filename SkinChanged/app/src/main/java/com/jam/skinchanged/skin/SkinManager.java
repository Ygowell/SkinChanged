package com.jam.skinchanged.skin;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.jam.skinchanged.skin.constant.Skin;

import java.util.ArrayList;
import java.util.List;

import static com.jam.skinchanged.skin.constant.Skin.TYPE_GREEN;
import static com.jam.skinchanged.skin.constant.Skin.TYPE_RED;

/**
 * Created by jam on 17/9/4.
 */

public class SkinManager {

    private static SkinManager mInstance;
    private ISkin mISkin;
    private List<ViewAttr> mViewAttrList;
    private Context mContext;

    public static synchronized SkinManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SkinManager(context);
        }

        return mInstance;
    }

    private SkinManager(Context context) {
        mISkin = new RedSkin();
        mViewAttrList = new ArrayList<>();
        mContext = context;
    }

    public void addChangedView(View view, @Skin.ViewChangedAttr int viewType) {
        ViewAttr viewAttr = new ViewAttr();
        viewAttr.view = view;
        viewAttr.attr = viewType;
        mViewAttrList.add(viewAttr);
    }

    private void updateView() {
        for (ViewAttr viewAttr : mViewAttrList) {
            switch (viewAttr.attr) {
                case Skin.VIEW_BACKGROUND:
                    viewAttr.view.setBackgroundResource(mISkin.getBackgroundPrimaryColor());
                    break;
                case Skin.VIEW_TEXTCOLOR:
                    ((TextView) viewAttr.view).setTextColor(mContext.getResources()
                            .getColor(mISkin.getTextPrimaryColor()));
                    break;
            }
        }
    }

    public void changeSkin(@Skin.SkinType int skinType) {
        switch (skinType) {
            case TYPE_RED:
                mISkin = new RedSkin();
                break;
            case TYPE_GREEN:
                mISkin = new GreenSkin();
                break;
        }
        updateView();
    }

}
