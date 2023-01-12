package com.jedi.springclient.retrofit;

import com.jedi.springclient.models.Employee;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EmployeeApi {

    @GET("/employee/getAll")
    Call<List<Employee>> getAllEmployees();

    @POST("/employee/save")
    Call<ResponseBody> save(@Body Employee employee);
}
