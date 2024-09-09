package com.test.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Post> {

    private  Context context;
    private  List<Post>  postList;

    public CustomAdapter(Context context, List<Post> postList) {
        super(context, 0, postList);
        this.context = context;
        this.postList = postList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        Post currentPost = postList.get(position);

        TextView titleTextView = convertView.findViewById(R.id.item_title);
        TextView contentTextView = convertView.findViewById(R.id.item_content);

        titleTextView.setText(currentPost.getTitle());
        contentTextView.setText(currentPost.getContent());

        return convertView;
    }
}