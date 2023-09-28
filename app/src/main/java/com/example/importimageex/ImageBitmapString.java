package com.example.importimageex;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.room.TypeConverter;

import java.io.ByteArrayOutputStream;

public class ImageBitmapString {
    @TypeConverter
    public static byte[] getStringFromBitmap(Bitmap bitmapPicture) {
        ByteArrayOutputStream byteArrayBitmapStream = new ByteArrayOutputStream();
        bitmapPicture.compress(Bitmap.CompressFormat.PNG, 0, byteArrayBitmapStream);
        byte[] bytes = byteArrayBitmapStream.toByteArray();
        return bytes;
    }

    @TypeConverter
    public static Bitmap getBitmapFromString(byte[] arrr) {
        return BitmapFactory.decodeByteArray(arrr, 0, arrr.length);
    }
}
