package com.example.nina.mytodolist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by nina on 9/1/16.
 */
public class TodoListViewHolder extends RecyclerView.ViewHolder {

    TextView todoText;
    CheckBox doneCheckbox;

    public TodoListViewHolder(@NonNull View itemView) {
        super(itemView);

        todoText = (TextView) itemView.findViewById(R.id.main_list_item_text);
        doneCheckbox = (CheckBox) itemView.findViewById(R.id.main_list_item_check);
    }

}
