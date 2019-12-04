package com.example.olivinetask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    String[] name,pass, email;
    int[] images;

    public MyAdapter(Context context, String[] name, String[] pass, String[] email, int[] images) {
        this.context = context;
        this.name = name;
        this.pass = pass;
        this.email = email;
        this.images = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);

        View view=layoutInflater.inflate(R.layout.showing_recycler_view_ui,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageShow.setImageResource(images[position]);
        holder.nameTV.setText(name[position]);
        holder.emailTV.setText(email[position]);
        holder.passTV.setText(pass[position]);

    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageShow;
        TextView nameTV,passTV,emailTV;



        public MyViewHolder(@NonNull View itemView) {

            super(itemView);



            imageShow=itemView.findViewById(R.id.imageShow);
            nameTV=itemView.findViewById(R.id.nameTV);
            passTV=itemView.findViewById(R.id.passTV);
            emailTV=itemView.findViewById(R.id.emailTV);


        }
    }





}
