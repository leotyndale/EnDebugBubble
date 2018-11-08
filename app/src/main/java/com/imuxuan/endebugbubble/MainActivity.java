package com.imuxuan.endebugbubble;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.imuxuan.enbubble.manager.DebugTools;
import com.imuxuan.endebugbubble.config.DebugConfig;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DebugTools.get().attach(this)
                .fillMenuData(DebugConfig.getList())
                .add();
    }

    @Override
    protected void onStart() {
        super.onStart();
        DebugTools.get().attach(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        DebugTools.get().detach(this);
    }

    @Override
    public void onBackPressed() {
        if (!DebugTools.get().dismissMenu()){
            super.onBackPressed();
        }
    }
}
