package com.a1yama.okhttpsample;

import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class AsyncJob extends AsyncTask<String,String,String> {

    private MainActivity _main;

    public AsyncJob(MainActivity main) {
        super();
        _main = main;
    }


    @Override
    protected String doInBackground(String...value) {
        String result = null;

        RequestBody body = new FormEncodingBuilder()
                .add("foo", "bar")
                .add("baz", "qux")
                .build();

        // リクエストオブジェクトを作って
        Request request = new Request.Builder()
                .url("http://dev-env.a1yama.com/android_post.php")
                .post(body)
                .build();

        // クライアントオブジェクトを作って
        OkHttpClient client = new OkHttpClient();

        // リクエストして結果を受け取って
        try {
            Log.d("hoge", String.valueOf(request));
            Log.i("OSA030", "doPost start.:" + client.toString());
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()){
                result = response.body().string();
                Log.d("hoge", "doPost success");
            }
            Log.d("hoge", String.valueOf(response.code()));
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("hoge", "error orz:" + e.getMessage(), e);
        }

        // 返す
        return result;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        //

    }

    @Override
    protected void onPostExecute(String result) {
        _main.result_job(result);
    }


}