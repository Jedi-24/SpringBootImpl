package com.jedi.springclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.jedi.springclient.models.Employee;
import com.jedi.springclient.retrofit.EmployeeApi;
import com.jedi.springclient.retrofit.RetrofitService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeForm extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    TextInputEditText mEmpName, mEmpLoc, mEmpBranch;
    MaterialButton mbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();

        RetrofitService retrofitService = new RetrofitService();
        EmployeeApi employeeApi = retrofitService.getRetrofit().create(EmployeeApi.class);

        mbtn.setOnClickListener(v -> {
            String name = String.valueOf(mEmpName.getText());
            String loc = String.valueOf(mEmpLoc.getText());
            String branch = String.valueOf(mEmpBranch.getText());

            Employee employee = new Employee();
            employee.setName(name);
            employee.setLocation(loc);
            employee.setBranch(branch);

            employeeApi.save(employee) // to initiate a POST request to the API.
                    .enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            Log.d(TAG, "onResponse: hereee");
                            Toast.makeText(EmployeeForm.this, "Saved Successfully..", Toast.LENGTH_SHORT).show();
                        }
                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(EmployeeForm.this, "Failed..", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "onFailure: " + t.getMessage());
                        }
                    }); // running on a background thread to prevent lag in application work flow;
        });
    }

    private void initializeComponents() {
        mEmpName = findViewById(R.id.user_name);
        mEmpLoc = findViewById(R.id.user_loc);
        mEmpBranch = findViewById(R.id.user_branch);
        mbtn = findViewById(R.id.save_emp_btn);
    }
}