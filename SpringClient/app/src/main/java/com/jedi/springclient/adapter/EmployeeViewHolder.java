package com.jedi.springclient.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jedi.springclient.R;

// inner class to Adapter...
public class EmployeeViewHolder extends RecyclerView.ViewHolder {

    TextView name,loc,branch;

    public EmployeeViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.employeeListItem_name);
        loc = itemView.findViewById(R.id.employeeListItem_location);
        branch = itemView.findViewById(R.id.employeeListItem_branch);
    }
}
