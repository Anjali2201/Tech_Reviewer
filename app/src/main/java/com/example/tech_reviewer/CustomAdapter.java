package com.example.tech_reviewer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList gadget_id, gadget_name, gadget_desc, gadget_rating;

    CustomAdapter(Activity activity, Context context, ArrayList gadget_id, ArrayList gadget_name, ArrayList gadget_desc,
                  ArrayList gadget_rating){
        this.activity = activity;
        this.context = context;
        this.gadget_id = gadget_id;
        this.gadget_name = gadget_name;
        this.gadget_desc = gadget_desc;
        this.gadget_rating = gadget_rating;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.gadget_id_txt.setText(String.valueOf(gadget_id.get(position)));
        holder.gadget_name_txt.setText(String.valueOf(gadget_name.get(position)));
        holder.gadget_desc_txt.setText(String.valueOf(gadget_desc.get(position)));
        holder.gadget_rating_txt.setText(String.valueOf(gadget_rating.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(gadget_id.get(position)));
                intent.putExtra("title", String.valueOf(gadget_name.get(position)));
                intent.putExtra("author", String.valueOf(gadget_desc.get(position)));
                intent.putExtra("pages", String.valueOf(gadget_rating.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return gadget_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView gadget_id_txt, gadget_name_txt, gadget_desc_txt, gadget_rating_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            gadget_id_txt = itemView.findViewById(R.id.gadget_id_txt);
            gadget_name_txt = itemView.findViewById(R.id.gadget_name_txt);
            gadget_desc_txt = itemView.findViewById(R.id.gadget_desc_txt);
            gadget_rating_txt = itemView.findViewById(R.id.gadget_rating_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}
