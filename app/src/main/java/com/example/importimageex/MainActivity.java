package com.example.importimageex;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView imgGallery;
    Bitmap bitmap = null;

    Button btnGallery;
    int SELECT_PICTURE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgGallery = findViewById(R.id.image);
    }

    public void upload(View view) {
        loadImagesFromGallery();
    }

    public void save(View view) {
        Image image = new Image();
        image.setImage(ImageBitmapString.getStringFromBitmap(bitmap));
        DatabaseProviderImg.getDbConnection(getApplicationContext()).imageDao().insert(image);
    }

    public void get(View view) {
        startActivity(new Intent(MainActivity.this, ImageRecycler.class));
    }

    private void loadImagesFromGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_OK)
        {
            if (requestCode == SELECT_PICTURE)
            {
                Uri selectedImageUri = data.getData();

                if (null != selectedImageUri)
                {
                    imgGallery.setImageURI(selectedImageUri);

                    try
                    {
                        bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri);
                        imgGallery.setImageBitmap(bitmap);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}