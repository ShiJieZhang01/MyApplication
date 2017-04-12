package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by 蜗牛 on 2017-03-17.
 */
public class IRemoteService extends Service {

    /**
     * 档客户端绑定服务的时候会调用
     * @param intent
     * @return
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    private IBinder iBinder = new IMyAidlInterface.Stub(){

        @Override
        public int add(int num1, int num2) throws RemoteException {
            Log.d("TAG","收到了远程的请求  参数是"+num1+"--"+num2);
            return num1+num2;
        }
    };
}
