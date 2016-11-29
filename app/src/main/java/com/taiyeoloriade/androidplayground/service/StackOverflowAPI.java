package com.taiyeoloriade.androidplayground.service;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.taiyeoloriade.androidplayground.activity.MainActivity;
import com.taiyeoloriade.androidplayground.model.Question;
import com.taiyeoloriade.androidplayground.model.StackOverflowQuestions;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by OLORIAKE KEHINDE on 11/10/2016.
 */

public interface StackOverflowAPI  {

    @GET("/2.2/questions?order=desc&sort=creation&site=stackoverflow")
    Call<StackOverflowQuestions> loadQuestions(@Query("tagged") String tags);


        }