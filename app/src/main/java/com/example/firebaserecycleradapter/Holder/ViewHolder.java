package com.example.firebaserecycleradapter.Holder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firebaserecycleradapter.R;
import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView textView_name , textView_lastname , textView_age;
    public ImageView imageView_row;



//
////    public void setDetails(Context context ,String Name ,String Age ,String Lastname ,String Post )
//    {
//
//        TextView textView_name , textView_lastname , textView_age ;
//        ImageView imageView_post;
//
//        textView_name = view.findViewById(R.id.row_name);
//        textView_lastname = view.findViewById(R.id.row_lastname);
//        textView_age = view.findViewById(R.id.row_age);
//        imageView_post = view.findViewById(R.id.row_image);
//
//
////        textView_name.setText(Name);
////        textView_lastname.setText(Lastname);
////        textView_age.setText(Age);
////
////        Picasso.get().load(Post).into(imageView_post);
//
//    }

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        textView_name = itemView.findViewById(R.id.row_name);
        textView_lastname = itemView.findViewById(R.id.row_lastname);
        textView_age = itemView.findViewById(R.id.row_age);

        imageView_row = itemView.findViewById(R.id.row_image);
    }
}
