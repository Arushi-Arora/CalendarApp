package com.takusemba.spotlightsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import java.util.ArrayList;
import static com.takusemba.spotlightsample.MainActivity.db;

/**
 * Created by hp on 7/10/2017.
 */

public class EventsDisplay extends AppCompatActivity {
    RecyclerView rvEventsList;
    EventsAdapter eventsAdapter;
    public static final String TAG="CALENS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_display);
        rvEventsList=(RecyclerView)findViewById(R.id.rvEventsList);
        rvEventsList.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<TodoAdd> todoAddArrayList=db.getTodos();
        for(int i=0;i<todoAddArrayList.size();i++){
            Log.d(TAG, "onCreate: "+todoAddArrayList.get(i).getTitle());
        }
        eventsAdapter=new EventsAdapter(this,todoAddArrayList);
        rvEventsList.setAdapter(eventsAdapter);
    }
}
