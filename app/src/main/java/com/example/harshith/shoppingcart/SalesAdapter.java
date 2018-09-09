package com.example.harshith.shoppingcart;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class SalesAdapter extends RecyclerView.Adapter<SalesView>{


    private List<Sales> list;
    private Context cont;

    SalesAdapter(List<Sales> list,Context context){
        this.cont = context;
        this.list= list;
    }
    @Override
    public SalesView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(cont).inflate(R.layout.info,parent,false);
        SalesView v = new SalesView(view);
        return v;
    }

    @Override
    public void onBindViewHolder(SalesView holder, int position) {

        holder.inovoice.setText("Invoice Number :"+list.get(position).getInvoiceNumber());
        holder.model.setText("Model :"+list.get(position).getModel());
        holder.quantity.setText("Quantity :"+list.get(position).getQuantity());
        holder.user.setText("Name :"+list.get(position).getUsername());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
