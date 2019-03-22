package com.mifeng.us.changescreen;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mLandClick;
    private TextView mPortClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        String resultData = (String) getLastNonConfigurationInstance();
        if (resultData == null){
            //去请求数据
        }

    }

    private void initView() {
        mLandClick = findViewById(R.id.mLandClick);
        mPortClick = findViewById(R.id.mPortClick);
        click();
    }

    private void click() {

        mLandClick.setOnClickListener(v->{
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        });
        mPortClick.setOnClickListener(v -> {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        String message = newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE?"横屏显示了":"竖屏显示";
        Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        //用户横竖屏切换保存数据
        String resultData = "我是在切换时候保存的数据";
        return resultData;
    }
}
