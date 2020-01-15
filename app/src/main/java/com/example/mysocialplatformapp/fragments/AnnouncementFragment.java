package com.example.mysocialplatformapp.fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.mysocialplatformapp.R;
import com.example.mysocialplatformapp.adapter.MyAdapter;
import com.example.mysocialplatformapp.announcementDetails.AnnouncementDetailActivity;
import com.example.mysocialplatformapp.createNewAnnouncement.RequestActivity;
import com.example.mysocialplatformapp.model.Announcement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementFragment extends Fragment {

    private ListView listView;
    private MyAdapter listAdapter;
    private ImageButton addButton;
    private final List<Announcement> announcements = new ArrayList<>();
    private Intent intent;
    private Announcement announcement;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_service, parent, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        listView = view.findViewById(R.id.announcement_list);
        addButton = view.findViewById(R.id.add_button);
        addButton.setImageResource(R.drawable.ic_add);
        intent = new Intent(this.requireContext(), RequestActivity.class);
        announcement = (Announcement) getActivity().getIntent().getSerializableExtra("announcementCreated");

        addAnnouncements();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        listAdapter = new MyAdapter(this.requireContext(), announcements);
        listView.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();
        registerForContextMenu(listView);

        listView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentDetails = new Intent(parent.getContext(), AnnouncementDetailActivity.class);
                Announcement announcement = (Announcement) parent.getItemAtPosition(position);
                intentDetails.putExtra("announcement", announcement);
                startActivity(intentDetails);
            }
        });

        if (announcement != null) {
            listAdapter.insert(announcement, listAdapter.getCount());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void addAnnouncements() {
        for (int i = 0; i < 10; i++) {
            announcements.add(new Announcement("Emergency " + i, "Repair shop auto body shop durango repair service diagnostics repair download number: - Daily updated free icons and png images for your projects. All images use to free for personal projects. " + i,
                    "Cluj Napoca", LocalDateTime.now(), R.drawable.repair));
        }
    }
}
