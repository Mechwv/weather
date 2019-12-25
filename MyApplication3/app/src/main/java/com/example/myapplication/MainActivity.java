package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;



public class MainActivity extends AppCompatActivity {

    Button btn;
    Button trans;
    EditText tv;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        trans = findViewById(R.id.translate);
        tv = findViewById(R.id.editText);
        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDownload weather = new MyDownload();
                text = tv.getText().toString();
                weather.execute();
            }
        });
    }


    private class MyDownload extends AsyncTask<Void,Void,String> {

        HttpURLConnection httpurl;
        @Override
        protected String doInBackground(Void... voids) {

            String a = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20191225T105039Z.94360703031b8ce7.4520056b3c021dd82d6d2af49538aa2ac41e7b97&lang=ru&text=";
            a = a + text;
            try {
                URL url = new URL(a);
                httpurl = (HttpURLConnection) url.openConnection();
                httpurl.setRequestMethod("GET");
                httpurl.connect();
                InputStream inputStream = httpurl.getInputStream();
                Scanner scan = new Scanner(inputStream);
                StringBuffer buffer = new StringBuffer();
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
            Gson gson = new Gson();
            Translate t = gson.fromJson(s,Translate.class);
            tv.setText(t.getText().get(0).toString());
        }
    }
}
