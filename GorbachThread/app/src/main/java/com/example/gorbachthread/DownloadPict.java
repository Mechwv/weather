package com.example.gorbachthread;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadPict extends AsyncTask {
    Bitmap bf;
    private InputStream is;
    ImageView im;

    @Override
    protected Object doInBackground(Object[] objects) {
        try {
            URL newUrl = new URL("https://s1.travelask.ru/system/images/files/001/334/723/full/24.jpg?1562755481");
            bf = (Bitmap)(BitmapFactory.decodeStream((InputStream)(newUrl.getContent())));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bf;
    }
    public Bitmap getIm(){
        return this.bf;
    }
}
