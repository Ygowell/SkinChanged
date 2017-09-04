package com.jam.skinchanged;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jam.skinchanged.skin.SkinChangedListener;
import com.jam.skinchanged.skin.SkinManager;

public class MainActivity extends AppCompatActivity {

    private TextView mWelcomeTv;
    private SkinManager mSkinManager;
    private int mSkinType = SkinManager.TYPE_RED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWelcomeTv = (TextView) findViewById(R.id.welcomeTv);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSkinType == SkinManager.TYPE_RED) {
                    mSkinType = SkinManager.TYPE_GREEN;
                } else {
                    mSkinType = SkinManager.TYPE_RED;
                }
                mSkinManager.changeSkin(mSkinType);
            }
        });

        mSkinManager = new SkinManager();
        mSkinManager.setSkinChangedListener(new SkinChangedListener() {
            @Override
            public void onSkinChanged() {
                updateUI();
            }
        });

        updateUI();
    }

    private void updateUI() {
        mWelcomeTv.setTextColor(getResources().getColor(mSkinManager.getSkin().getTextPrimaryColor()));
        mWelcomeTv.setBackgroundColor(getResources().getColor(mSkinManager.getSkin().getBackgroundPrimaryColor()));
    }
}
