package com.example.recylerviewapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
//        switch (position)
//        {
//            case 0:
//                holder.imageView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(context, "Image1 clicked", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                holder.textView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(context, "Text 1 clicked", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                break;
//            case 1:
//                holder.imageView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(context, "Image2 clicked", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                holder.textView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(context, "Text 2 clicked", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                break;
//                default:
//                    break;
//        }this was just without RecyclerViewClickListner

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
