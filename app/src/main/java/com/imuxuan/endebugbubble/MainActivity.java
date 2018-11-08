package com.imuxuan.endebugbubble;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.imuxuan.enbubble.manager.DebugToolsManager;
import com.imuxuan.endebugbubble.config.DebugConfig;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DebugToolsManager.getInstance().attach(this)
                .fillMenuData(DebugConfig.getList())
                .add();
    }

    @Override
    protected void onStart() {
        super.onStart();
        DebugToolsManager.getInstance().attach(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        DebugToolsManager.getInstance().detach(this);
    }

    @Override
    public void onBackPressed() {
        if (!DebugToolsManager.getInstance().dismissMenu()){
            super.onBackPressed();
        }
    }
}
