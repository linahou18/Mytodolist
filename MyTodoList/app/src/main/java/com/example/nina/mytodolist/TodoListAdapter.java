package com.example.nina.mytodolist;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.nina.mytodolist.models.Todo;
import com.example.nina.mytodolist.utils.ModelUtils;
import com.example.nina.mytodolist.utils.UIUtils;

import java.util.List;

/**
 * Created by nina on 8/28/16.
 */
public class TodoListAdapter extends RecyclerView.Adapter {

    private static final String TODOS = "todos";

    private MainActivity activity;
    private List<Todo> data;

    public TodoListAdapter(@NonNull MainActivity activity, List<Todo> data) {
        this.activity = activity;
        this.data = data;
    }
//    @Override
//    public View getView(final int position, View convertView, ViewGroup parent) {

//        ViewHolder vh;

//        if (convertView == null) {
            //Log.d("linatodo:", "new view" + position );
           // convertView = activity.getLayoutInflater().inflate(R.layout.main_list_item, parent, false);
            //vh = new ViewHolder();
            //vh.todoText = (TextView) convertView.findViewById(R.id.main_list_item_text);
            //vh.doneCheckbox = (CheckBox) convertView.findViewById(R.id.main_list_item_check);
            //convertView.setTag(vh);
//        } else {
//            vh = (ViewHolder) convertView.getTag();
//        }

//        final Todo todo = (Todo) getItem(position);
//        vh.todoText.setText(todo.text);
//        vh.doneCheckbox.setChecked(todo.done);
//        UIUtils.setTextViewStrikeThrough(vh.todoText, todo.done);
//
//        vh.doneCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                activity.updateTodo(position, isChecked);
//            }
//        });


//        convertView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(activity, TodoEditActivity.class);
//                intent.putExtra(TodoEditActivity.KEY_TODO, todo);
//                activity.startActivityForResult(intent, MainActivity.REQ_CODE_TODO_EDIT);
//            }
//        });
//
//        return convertView;
//    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                                  .inflate(R.layout.main_list_item, parent, false);
        return new TodoListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final Todo todo = data.get(position);
//        ((TodoListViewHolder) holder).todoText.setText(todo.text);
//        ((TodoListViewHolder) holder).doneCheckbox.setChecked(todo.done);
//        UIUtils.setTextViewStrikeThrough(((TodoListViewHolder) holder).todoText, todo.done);

        ((TodoListViewHolder) holder).doneCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                todo.done = isChecked;
                UIUtils.setTextViewStrikeThrough(((TodoListViewHolder) holder).todoText, todo.done);
                ModelUtils.save(activity, TODOS, data);
            }
        });

        ((TodoListViewHolder)holder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, TodoEditActivity.class);
                intent.putExtra(TodoEditActivity.KEY_TODO, todo);
                activity.startActivityForResult(intent, MainActivity.REQ_CODE_TODO_EDIT);
            }
        });
        ((TodoListViewHolder) holder).todoText.setText(todo.text);
        ((TodoListViewHolder) holder).doneCheckbox.setChecked(todo.done);
        UIUtils.setTextViewStrikeThrough(((TodoListViewHolder) holder).todoText, todo.done);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
