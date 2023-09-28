package com.example.importimageex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder>
{
 List arrList;
 Context context;
public ImageAdapter(Context context, List arrList)
{
    this.arrList = arrList;
    this.context = context;
}

    @NonNull
    @Override
    public ImageAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.img_row, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.MyViewHolder holder, int position) {
        Image images = (Image) arrList.get(position);
        holder.imgGallery.setImageBitmap(ImageBitmapString.getBitmapFromString(images.getImage()));
        images.setImage(images.getImage());
    }

    @Override
    public int getItemCount() {
        return arrList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imgGallery;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgGallery = itemView.findViewById(R.id.image);
        }
    }
}
