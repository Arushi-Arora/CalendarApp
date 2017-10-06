package com.takusemba.spotlightsample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hp on 7/10/2017.
 */

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {


    Context context;
    ArrayList<String> todoArrayList;
    ArrayList<String> todoSend;

    public TodoAdapter(Context context, ArrayList<String> todoArrayList,ArrayList<String> todoSend) {
        this.context = context;
        this.todoArrayList = todoArrayList;
        this.todoSend=todoSend;
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=li.inflate(R.layout.list_item_todo,parent,false);
        return new TodoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final TodoViewHolder holder, final int position) {
        String todoAdd=todoArrayList.get(position);
        holder.tvTodo.setText(todoAdd);
        holder.btnTodo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("SEND", "onClick: "+todoSend.size());
                String data=todoSend.get(position);
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT,data);
                context.startActivity(Intent.createChooser(i,"Send Using"));
                holder.btnTodo.setText("SENT");

            }
        });
    }

    @Override
    public int getItemCount() {
        return todoArrayList.size();
    }

    class TodoViewHolder extends RecyclerView.ViewHolder {
        TextView tvTodo;
        Button btnTodo;
        public TodoViewHolder(View itemView) {
            super(itemView);
            tvTodo=(TextView)itemView.findViewById(R.id.tvTodo);
            btnTodo=(Button) itemView.findViewById(R.id.btnTodo);
        }
    }
}
