package com.takusemba.spotlightsample;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class TodoActivity extends AppCompatActivity {
    RecyclerView rvTodos;
    TodoAdapter todoAdapter;
    Button todoAddList;
    EditText et,et1;
    String str,str1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        rvTodos=(RecyclerView)findViewById(R.id.rvTodos);
        rvTodos.setLayoutManager(new LinearLayoutManager(this));
        final ArrayList<String> todoArrayList=new ArrayList<>();
        todoArrayList.add("Wish Kopal On Her BIRTHDAY!!!!!!!!");
        todoArrayList.add("Say HELLO! to Ritvik");
        todoArrayList.add("Send mail to HOD");
        todoArrayList.add("Ask Raghav for the notes");
        todoArrayList.add("Remind Ananya for the assignment");
        todoArrayList.add("Say HELLO! to Shreya didi");
        todoArrayList.add("Send mail to Navya");
        todoArrayList.add("Ask Raghav for the notes");
        todoArrayList.add("Remind Ananya for the assignment");


        final ArrayList<String> todoSend=new ArrayList<>();
        todoSend.add("HAPPY BIRTHDAY!!!!!!!! kopal");
        todoSend.add("Hi Ritvik!");
        todoSend.add("Sir please send the list of companies which will visit us this semester for the internship");
        todoSend.add("Raghav, please send me ADA notes");
        todoSend.add("Ananya get my OS assignment");
        todoSend.add("Hi Shreya didi.....");
        todoSend.add("Navya, check out this link 'www.taarangana.com' ");
        todoSend.add("Raghav, please send me ADA notes");
        todoSend.add("Ananya get my OS assignment");
        todoAdapter=new TodoAdapter(this,todoArrayList,todoSend);
        rvTodos.setAdapter(todoAdapter);
        todoAddList=(Button)findViewById(R.id.todoAddList1);
        Log.d("TODO", "onCreate: "+todoAddList.getId());
        todoAddList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("BTNCLICK", "onClick: ");
                final Dialog dialog = new Dialog(TodoActivity.this);
                dialog.setContentView(R.layout.dialog_todo);
                dialog.setTitle("TODO");
                dialog.getWindow().setLayout(700,400);
                dialog.show();

                Button button=(Button)dialog.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        et= (EditText)dialog.findViewById(R.id.etTodoHint);
                        str = et.getText().toString();
                        et1= (EditText)dialog.findViewById(R.id.etTodoDescription);
                        str1 = et1.getText().toString();
                        todoArrayList.add(str);
                        todoSend.add(str1);
                        todoAdapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });


            }
        });


    }
}
