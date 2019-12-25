package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        tv = findViewById(R.id.textView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDownload weather = new MyDownload();
                weather.execute();
            }
        });
    }


    private class MyDownload extends AsyncTask<Void,Void,String> {

        HttpURLConnection httpurl;

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL("http://api.weatherstack.com/current?access_key=ba0850a0e6f20a7100155aed02a1cf12&query=Moscow");
                httpurl = (HttpURLConnection) url.openConnection();
                httpurl.setRequestMethod("GET");
                httpurl.connect();
                InputStream inputStream = httpurl.getInputStream();
                Scanner scan = new Scanner(inputStream);
                StringBuffer buffer = new StringBuffer();
                //Gson gson = new Gson();
                while (scan.hasNextLine()) {
                    buffer.append(scan.nextLine());
                }
                return buffer.toString();

            } catch (IOException e) {
                Log.e("RRR",e.toString());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tv.setText(s);
        }
    }
}
