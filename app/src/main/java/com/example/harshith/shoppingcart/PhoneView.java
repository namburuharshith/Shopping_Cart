package com.example.harshith.shoppingcart;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PhoneView extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ViewClickListener mlistener;
    private TextView txt;
    private TextView txt1;
    private TextView txt2;
    private ImageView image;
    private CardView layout;

    public PhoneView(View view, ViewClickListener listener) {
        super(view);
        this.mlistener = listener;
        this.image = view.findViewById(R.id.image);
        this.txt = view.findViewById(R.id.model);
        this.txt1 = view.findViewById(R.id.manufacturer);
        this.txt2 = view.findViewById(R.id.price);
        this.layout = view.findViewById(R.id.cardview);
        view.setOnClickListener(this);
    }

    public TextView getTxt() {
        return txt;
    }

    public TextView getTxt1() {
        return txt1;
    }

    public TextView getTxt2() {
        return txt2;
    }

    public ImageView getImage() {
        return image;
    }

    public CardView getView(){ return layout;}

    @Override
    public void onClick(View v) {
        mlistener.onClick(v,getAdapterPosition());
    }
}
