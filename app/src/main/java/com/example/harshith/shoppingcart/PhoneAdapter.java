package com.example.harshith.shoppingcart;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneView>  {

   private List<Phone> phone;

   private Context context;

   public PhoneAdapter(List<Phone> phone,Context context){
       this.context = context;
       this.phone = phone;
   }

    @Override
    public PhoneView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.phones,parent,false);
        PhoneView p = new PhoneView(view);
        return p;
   }

    @Override
    public void onBindViewHolder(PhoneView holder, int position) {

        Glide.with(context).load(Uri.parse(phone.get(position).getImage())).into(holder.getImage());
        final String ph = phone.get(position).getModel();
        holder.getTxt().setText(phone.get(position).getModel());
        holder.getTxt1().setText(phone.get(position).getManufacturer());
        holder.getTxt2().setText("Rs "+phone.get(position).getPrice());
        Log.i("Sucess","1");
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                Log.i("cess","3");
                View view = LayoutInflater.from(context).inflate(R.layout.dialog,null);
                builder.setView(view);

                final EditText editText = view.findViewById(R.id.username);

                final EditText editText1 = view.findViewById(R.id.quantity);


                builder.setTitle("Info :");

                Log.i("Suc","4");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

                        Api api = retrofit.create(Api.class);

                        Call<Sales> call = api.getBuy(ph,editText.getText().toString(),editText1.getText().toString());
                        call.enqueue(new Callback<Sales>() {

                            @Override
                            public void onResponse(Call<Sales> call, Response<Sales> response) {
                                Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<Sales> call, Throwable t) {
                                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        });
                        Log.i("Sucess","5");

                    }
                });

                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("Sucess","6");
                        Toast.makeText(context, "cancelled", Toast.LENGTH_SHORT).show();
                        // Do nothing
                        dialog.dismiss();
                    }
                });
                Log.i("ss","7");
                AlertDialog alertDialog=builder.create();
                try {
                    alertDialog.show();
                } catch (Exception e) {
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return phone.size();
    }
}
