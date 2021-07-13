package com.example.myandroidupway;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myandroidupway.service.MyService;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;


public class ServiceActivity extends AppCompatActivity {

    private MyService.DownLoadBinder downLoadBinder;

    /**
     * 创建一个ServiceConnection匿名类
     */
    private ServiceConnection connection = new ServiceConnection() {
        /**
         * 绑定成功后，进行的一些操作
         * @param componentName
         * @param iBinder
         */
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            downLoadBinder = (MyService.DownLoadBinder) iBinder;
            downLoadBinder.startDownload();
            downLoadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {


        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        ButterKnife.bind(this);

        getDataFromNet();
    }

    private void getDataFromNet() {
        OkHttpClient client = new OkHttpClient();


    }

    @OnClick({R.id.start_service, R.id.stop_service, R.id.bind_service, R.id.unbind_service})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            // 开启第一个服务
            case R.id.start_service:
                Intent startIntent = new Intent(this, MyService.class);
                startService(startIntent);

                break;

            // 停止一个服务
            case R.id.stop_service:
                Intent stopService = new Intent(this, MyService.class);
                stopService(stopService);
                break;

            /**
             *
             绑定第一个服务，当服务与活动绑定后，就可以调用该服务的Binder提供的方法
             */
            case R.id.bind_service:
                Intent bindIntent = new Intent(this, MyService.class);
                // 绑定服务
                bindService(bindIntent,connection,BIND_AUTO_CREATE);

                break;

            // 解绑一个服务
            case R.id.unbind_service:
                unbindService(connection);
                break;
            default:
        }
    }
}
