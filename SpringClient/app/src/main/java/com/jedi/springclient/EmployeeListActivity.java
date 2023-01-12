package com.jedi.springclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jedi.springclient.adapter.MyRecyclerViewAdapter;
import com.jedi.springclient.models.Employee;
import com.jedi.springclient.retrofit.EmployeeApi;
import com.jedi.springclient.retrofit.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeListActivity extends AppCompatActivity {

    private static final String TAG = "EmployeeListActivity";
    private RecyclerView mEmpRecyclerView;
    MyRecyclerViewAdapter myRecyclerViewAdapter;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        mEmpRecyclerView = findViewById(R.id.employee_RV);
        mEmpRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        fab = findViewById(R.id.add_emp);

//        loadDataFromServer();
        myRecyclerViewAdapter = new MyRecyclerViewAdapter(new ArrayList<>());
        mEmpRecyclerView.setAdapter(myRecyclerViewAdapter);

        fab.setOnClickListener(v -> startActivity(new Intent(this, EmployeeForm.class)));
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadDataFromServer();
    }

    private void loadDataFromServer() {
        RetrofitService retrofitService = new RetrofitService();
        EmployeeApi employeeApi = retrofitService.getRetrofit().create(EmployeeApi.class);

        employeeApi.getAllEmployees()
                .enqueue(new Callback<List<Employee>>() {
                    @Override
                    public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                        populateRecyclerView(response.body());
                        Log.d(TAG, "onResponse: " + response.body());
                    }
                    @Override
                    public void onFailure(Call<List<Employee>> call, Throwable t) {
                    }
                });
    }

    private void populateRecyclerView(List<Employee> employeeList) {
        myRecyclerViewAdapter = new MyRecyclerViewAdapter(employeeList);
        mEmpRecyclerView.setAdapter(myRecyclerViewAdapter);
    }
}