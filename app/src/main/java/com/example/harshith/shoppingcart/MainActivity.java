package com.example.harshith.shoppingcart;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

     RecyclerView recyclerView;
     RecyclerView.LayoutManager layoutManager;
     RecyclerView.Adapter madapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.search_bar){
            search();
            return true;
        }else if(item.getItemId() == R.id.info){
            search1();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void search1(){
        Intent i = new Intent(MainActivity.this,SalesActivity.class);
        startActivity(i);

    }

    private void search() {
        Intent intent = new Intent(MainActivity.this,SearchActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = this.getIntent().getExtras();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        Api api = retrofit.create(Api.class);

        Call<List<Phone>> call=api.getPhones();

        layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(layoutManager);


        if (bundle != null) {

            String manufacturer = bundle.getString("manufacturer",null);
            String model = bundle.getString("model",null);
            String minp = bundle.getString("minprice",null);
            String maxp = bundle.getString("maxprice",null);

            if ((manufacturer == null) && (model == null) && (minp == null) && (maxp == null)){
                call = api.getPhones();
            } else {
                call = api.getPhones(model, manufacturer, minp, maxp);
            }

        }
        
            call.enqueue(new Callback<List<Phone>>() {
                @Override
                public void onResponse(Call<List<Phone>> call, Response<List<Phone>> response) {
                    Log.i("url",call.request().url().toString());
                    List<Phone> ph = response.body();
                    renderPhones(ph);
                }

                @Override
                public void onFailure(Call<List<Phone>> call, Throwable t) {

                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
    }

    public void renderPhones(List<Phone> ph){

       madapter=new PhoneAdapter(ph,getApplicationContext());
       madapter.notifyDataSetChanged();
        recyclerView.setAdapter(madapter);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


}
