package com.takusemba.spotlightsample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hp on 7/10/2017.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventViewHolder>{
    public static final String TAG="CALENDES";

    Context context;
    ArrayList<TodoAdd> todoAddArrayList;

    public EventsAdapter(Context context, ArrayList<TodoAdd> todoAddArrayList) {
        this.context = context;
        this.todoAddArrayList = todoAddArrayList;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=li.inflate(R.layout.event_item_display,parent,false);
        return new EventViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        TodoAdd todoAdd=todoAddArrayList.get(position);
        holder.tvTitleEvent.setText(todoAdd.getTitle());
        holder.tvDescriptionEvent.setText(todoAdd.getDescription());

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: "+todoAddArrayList.size());
        return todoAddArrayList.size();
    }

    class EventViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitleEvent,tvDescriptionEvent;
        public EventViewHolder(View itemView) {
            super(itemView);
            tvTitleEvent=(TextView)itemView.findViewById(R.id.tvTitleEvent);
            tvDescriptionEvent=(TextView)itemView.findViewById(R.id.tvDescriptionEvent);
        }
    }
}

