package com.example.harshith.shoppingcart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SalesActivity extends AppCompatActivity {

    RecyclerView recy;
    RecyclerView.LayoutManager layoutManager1;
    SalesAdapter badapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();


        Api api = retrofit.create(Api.class);


        recy = findViewById(R.id.rec);

        Call<List<Sales>> call = api.getRecords();
        call.enqueue(new Callback<List<Sales>>() {

            @Override
            public void onResponse(Call<List<Sales>> call, Response<List<Sales>> response) {

                Log.i("Suess","4");
                List<Sales> s = response.body();
                layoutManager1=new LinearLayoutManager(getApplicationContext());
                recy.setLayoutManager(layoutManager1);
                badapter2=new SalesAdapter(s,getApplicationContext());
                badapter2.notifyDataSetChanged();
                recy.setAdapter(badapter2);

           }

            @Override
            public void onFailure(Call<List<Sales>> call, Throwable t) {

                Log.i("cces","5");
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
