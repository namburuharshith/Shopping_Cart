package com.example.harshith.shoppingcart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        final EditText txt1 = findViewById(R.id.manufacturer_input);
        final EditText txt2 = findViewById(R.id.model_input);
        final EditText txt3 = findViewById(R.id.min_price);
        final EditText txt4 = findViewById(R.id.max_price);
        Button button = findViewById(R.id.find);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                String manu = txt1.getText().toString();
                String model = txt2.getText().toString();
                String mip = txt3.getText().toString();
                String map = txt4.getText().toString();
                if(manu==""){
                    bundle.putString("manufacturer",null);
                }
                bundle.putString("manufacturer",manu);
                if(model==""){
                    bundle.putString("model",null);
                }
                bundle.putString("model",model);
                if(mip==""){
                    bundle.putString("minprice",null);
                }
                bundle.putString("minprice",mip);
                if(map==""){
                    bundle.putString("maxprice",null);
                }
                bundle.putString("maxprice",map);

                Intent intent = new Intent(SearchActivity.this,MainActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

}
