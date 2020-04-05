package com.example.myandroidupway.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * 使用后台服务
 */
public class MyService extends Service {

    /**
    假如希望提供一个下载功能，在活动中决定何时下载，以及查看下载进度，可以创建一个专门的Binder对象来对下载功能进行管理
     *
      */
    private DownLoadBinder binder = new DownLoadBinder();

    public class DownLoadBinder extends Binder{

        public void startDownload(){

            Log.d("MyService",
                    "startDownload  executed");
        }

        public int getProgress(){
            Log.d("MyService",
                    "getProgress  executed");
            return 0;
        }


    }



    public MyService() {
    }

    /**
     * Service中唯一的一个抽象方法,在这个方法中可以服务与活动通信
     * @param intent
     * @return
     */
    @Override
    public IBinder onBind(Intent intent) {
//        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return binder;
    }


    /**处理事情的逻辑在这部分   服务创建的时候调用*/
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("shaoronggang======>","onCreate() 创建服务");
    }

    /**
     * 每次服务启动的时候调用
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("shaoronggang======>","onStartCommand() 服务已经开始" + "  intent:" + intent.toString() + "  flags:" + flags + "  startId:" + startId);



        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 服务销毁的时候调用
     */
    @Override
    public void onDestroy() {
        Log.e("shaoronggang======>","onDestroy() 服务已经停止");
        super.onDestroy();
    }
}
