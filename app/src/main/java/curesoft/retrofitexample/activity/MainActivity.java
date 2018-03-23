package curesoft.retrofitexample.activity;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import curesoft.retrofitexample.R;
import curesoft.retrofitexample.adapter.MoviesAdapter;
import curesoft.retrofitexample.model.MovieResponse;
import curesoft.retrofitexample.model.Result;
import curesoft.retrofitexample.rest.ApiClient;
import curesoft.retrofitexample.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    RecyclerView rv=null;
    private static final String API_KEY = "61fd4055b22838b78b6455488f9f3009";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         rv= (RecyclerView) findViewById(R.id.recycle);
        rv.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService = ApiClient.getApiClient().create(ApiInterface.class);
        Call<MovieResponse> call = apiService.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                // int code=response.code();

                List<Result> movie = response.body().getResults();
                rv.setAdapter(new MoviesAdapter(getApplicationContext(),movie));

            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
            }
        });


    }
}
