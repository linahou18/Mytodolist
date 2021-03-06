package com.example.nina.mytodolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.nina.mytodolist.models.Todo;

import java.util.List;

/**
 * Created by nina on 8/28/16.
 */
public class TodoListConverter {
    private Context context;
    private List<Todo> data;


    public TodoListConverter(Context context, List<Todo> data) {
        this.context = context;
        this.data = data;
    }

    public View getView(int position) {

        Todo todo = data.get(position);

        View view = LayoutInflater.from(context).inflate(R.layout.main_list_item, null);
        ((TextView) view.findViewById(R.id.main_list_item_text)).setText(todo.text);
        return view;
    }
}
