package com.example.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Objects;

public class Listadapter extends ArrayAdapter<User> {
    public Listadapter(Context context, ArrayList<User> userArraylist) {
        super(context, R.layout.listview, userArraylist);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        User user = getItem(position);

        if (convertView ==null){
            convertView = LayoutInflater
                    .from(getContext())
                    .inflate(R.layout.listview, parent, false);
        }

        ImageView imageview = convertView.findViewById(R.id.profile_image);
        TextView name = convertView.findViewById(R.id.textView);
        TextView message = convertView.findViewById(R.id.textView2);
        TextView time = convertView.findViewById(R.id.textView3);

        imageview.setImageResource(user.imageid);
        name.setText(user.name);
        message.setText(user.lastmsg);
        time.setText(user.time);

        return convertView;
    }
}
