package com.example.recylerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.recylerviewapp.Adapters.RecepieAdapter;
import com.example.recylerviewapp.Classes.RecyclerItemClickListener;
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
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,recyclerView,new RecyclerItemClickListener.OnItemClickListener(){

            @Override
            public void onItemClick(View view, int position) {
                switch (position)
                {
                    case 0:
                        Intent intent=new Intent(MainActivity.this,ScrollingActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "Card 2", Toast.LENGTH_SHORT).show();
                        break;
                        default:
                            break;
                }

            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

    }
}
