package ru.samsung.itschool.runnable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String str="";
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1= (TextView) findViewById(R.id.text1);
        Thread thread=new Thread(new AnotherRunnable());
        thread.start();
    }

    class AnotherRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try{
                    Thread.sleep(1000); //Приостанавливает поток на 1 секунду
                } catch(InterruptedException e){}
                str = str + "3";
            }
        }
    }

    public void refresh(View view) {
        text1.setText(str);
    }
}
