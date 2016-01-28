package com.a1yama.okhttpsample;

import android.app.Activity;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        asynctask_job();

    }
    // 非同期処理を開始する
    private void asynctask_job(){

        //非同期タスクの生成
        final AsyncJob asynctask = new AsyncJob(this);
        //実行
        asynctask.execute();
    }

    //onPostExecuteで実行される関数
    public void result_job(String result){
        if (result != null) {
            TextView textView = (TextView) findViewById(R.id.hello);
            textView.setText(result);
            Log.e("RES", result);
        }

    }
}
