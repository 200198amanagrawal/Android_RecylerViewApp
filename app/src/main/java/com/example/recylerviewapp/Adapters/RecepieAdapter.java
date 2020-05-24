package com.example.recylerviewapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recylerviewapp.Model.RecepiesModel;
import com.example.recylerviewapp.R;

import java.util.ArrayList;

public class RecepieAdapter extends RecyclerView.Adapter<RecepieAdapter.viewholder> {

    ArrayList<RecepiesModel> list;
    Context context;

    public RecepieAdapter(ArrayList<RecepiesModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sample_rec_layout,parent,false);
        return new viewholder(view);//gettig the layout of recyler_layout and then returning it viewholder is the class that is taken below
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        //this will take position of the arraylist
        RecepiesModel recepiesModel=list.get(position);
        holder.imageView.setImageResource(recepiesModel.getPic());
        holder.textView.setText(recepiesModel.getText());

    }

    @Override
    public int getItemCount() {
        return list.size();//this function is just used for showing the no of contents inside recyvlerview
    }

    public class viewholder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.Recycler_image);
            textView=itemView.findViewById(R.id.Recycler_text);
        }
    }
}
