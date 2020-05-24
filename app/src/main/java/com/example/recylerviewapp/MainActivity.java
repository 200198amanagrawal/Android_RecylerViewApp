package com.example.recylerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.example.recylerviewapp.Adapters.RecepieAdapter;
import com.example.recylerviewapp.Model.RecepiesModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        ArrayList<RecepiesModel> arrayList=new ArrayList<>();
        arrayList.add(new RecepiesModel(R.drawable.food1,"Burger"));
        arrayList.add(new RecepiesModel(R.drawable.food2,"Pizza"));
        arrayList.add(new RecepiesModel(R.drawable.food3,"Pasta"));
        arrayList.add(new RecepiesModel(R.drawable.food4,"Tacos"));
        arrayList.add(new RecepiesModel(R.drawable.food5,"Tortilas"));
        arrayList.add(new RecepiesModel(R.drawable.food6,"Something Wierd"));
        arrayList.add(new RecepiesModel(R.drawable.food7,"Donno"));
        RecepieAdapter recepieAdapter=new RecepieAdapter(arrayList,this);
        recyclerView.setAdapter(recepieAdapter);
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);
       //same is the case with horizontal too
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

    }
}
