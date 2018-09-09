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

public class PhoneAdapter extends RecyclerView.Adapter<PhoneView> {

   private List<Phone> phone;
   ViewClickListener mlistener;

   private Context context;

   public PhoneAdapter(List<Phone> phone,Context context,ViewClickListener mlistener){
       this.mlistener = mlistener ;
       this.context = context;
       this.phone = phone;
   }

    @Override
    public PhoneView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.phones,parent,false);
        PhoneView p = new PhoneView(view,mlistener);
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
                mlistener.onClick(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return phone.size();
    }
}
