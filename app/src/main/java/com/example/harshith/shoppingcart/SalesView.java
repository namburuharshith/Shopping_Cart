package com.example.harshith.shoppingcart;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class SalesView extends RecyclerView.ViewHolder {

    TextView user;
    TextView model;
    TextView quantity;
    TextView inovoice;

    public SalesView(View itemView) {
        super(itemView);
        user = itemView.findViewById(R.id.user);
        quantity = itemView.findViewById(R.id.qty);
        model = itemView.findViewById(R.id.mod);
        inovoice = itemView.findViewById(R.id.invoice);
    }
}
