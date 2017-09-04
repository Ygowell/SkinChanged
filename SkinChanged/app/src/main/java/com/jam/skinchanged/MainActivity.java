package com.jam.skinchanged;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jam.skinchanged.skin.SkinManager;
import com.jam.skinchanged.skin.constant.Skin;

public class MainActivity extends AppCompatActivity {

    private TextView mWelcomeTv;
    private int mSkinType = Skin.TYPE_RED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWelcomeTv = (TextView) findViewById(R.id.welcomeTv);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSkinType == Skin.TYPE_RED) {
                    mSkinType = Skin.TYPE_GREEN;
                } else {
                    mSkinType = Skin.TYPE_RED;
                }
                SkinManager.getInstance(MainActivity.this).changeSkin(mSkinType);
            }
        });

        SkinManager.getInstance(this).addChangedView(mWelcomeTv, Skin.VIEW_BACKGROUND);
        SkinManager.getInstance(this).addChangedView(mWelcomeTv, Skin.VIEW_TEXTCOLOR);
        SkinManager.getInstance(this).changeSkin(mSkinType);
    }
}
