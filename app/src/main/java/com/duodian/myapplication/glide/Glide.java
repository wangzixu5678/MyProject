package com.duodian.myapplication.glide;

import android.graphics.Bitmap;
import android.widget.ImageView;

import java.util.concurrent.ConcurrentHashMap;

public class Glide {



    public static class Builder{


        private ConcurrentHashMap<String, Bitmap> bitmapPool;

        private ImageView imageView;

        public Builder with(ImageView imageView){
            this.imageView = imageView;
            return this;
        }





    }

}
