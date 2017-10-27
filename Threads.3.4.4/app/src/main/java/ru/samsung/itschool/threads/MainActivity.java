package ru.samsung.itschool.threads;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text1);
        handler = new Handler() {   // создание хэндлера
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                text.setText(text.getText().toString() + msg.what);
                text.invalidate();
            }
        };
        AnotherThread t = new AnotherThread();//создание потока
        t.start();//запуск потока
    }

    class AnotherThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(1000); //Приостанавливает поток на 1 секунду
                } catch (InterruptedException e) {
                }
                handler.sendEmptyMessage(1);  // отправка сообщения хендлеру
            }
        }
    }
}