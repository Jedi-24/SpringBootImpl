package com.jedi.springclient.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jedi.springclient.R;
import com.jedi.springclient.models.Employee;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<EmployeeViewHolder> {

    List<Employee> employeeList = new ArrayList<>();

    public MyRecyclerViewAdapter(List<Employee> employeeList){
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.list_employee_item,parent,false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee employee = employeeList.get(position);

        holder.name.setText(employee.getName());
        holder.loc.setText(employee.getLocation());
        holder.branch.setText(employee.getBranch());
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }
}
