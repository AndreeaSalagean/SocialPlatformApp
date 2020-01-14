package com.example.mysocialplatformapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mysocialplatformapp.announcementDetails.AnnouncementDetailActivity;
import com.example.mysocialplatformapp.R;
import com.example.mysocialplatformapp.model.Announcement;

import java.util.List;

public class MyAdapter extends ArrayAdapter<Announcement> {

    public MyAdapter(Context context, List<Announcement> objects) {
        super(context, 0, objects);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Nullable
    @Override
    public Announcement getItem(int position) {
        Intent intent = new Intent(this.getContext(), AnnouncementDetailActivity.class);
        return super.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public void insert(@Nullable Announcement object, int index) {
        super.insert(object, index);
    }

    @Override
    public void remove(@Nullable Announcement object) {
        super.remove(object);
    }

    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)
                getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View myViewRow = (convertView == null) ?
                inflater.inflate(R.layout.announcement_item, parent, false) : convertView;

        TextView title = myViewRow.findViewById(R.id.title);
        ImageView image = myViewRow.findViewById(R.id.image);
        TextView location = myViewRow.findViewById(R.id.location);
        TextView date = myViewRow.findViewById(R.id.date);

        title.setText(getItem(position).getTitle());
        location.setText(getItem(position).getLocation());
        date.setText(getItem(position).getLocalDateTime().toString());
        image.setImageResource(getItem(position).getPhoto());
        return myViewRow;
    }
}