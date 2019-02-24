package com.example.administrator.smartcity.utils.net;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Create by SunnyDay on 2019/02/24
 */
public abstract class ICallBack implements Callback {

    private MyHandler handler = null;
    public abstract void onFailure(Call call, IOException e);

    public abstract void onSuccess(Call call, Response response) throws IOException;


}
