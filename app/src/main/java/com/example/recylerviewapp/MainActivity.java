package com.example.recylerviewapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.CheckBox;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recylerviewapp.Adapters.RecepieAdapter;
import com.example.recylerviewapp.Model.RecepiesModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    RecyclerView recyclerView;
    public boolean is_in_action_mode=false;
    TextView counter_text_view;
    RecepieAdapter recepieAdapter;
    Adapter adapter;
    Toolbar  toolbar;
    ArrayList<RecepiesModel> selection_list=new ArrayList<>();
    ArrayList<RecepiesModel> arrayList=new ArrayList<>();
    int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        toolbar=findViewById(R.id.toolbar_Selected);
        setSupportActionBar(toolbar);
        counter_text_view=findViewById(R.id.counter_text);
        counter_text_view.setVisibility(View.GONE);
        arrayList.add(new RecepiesModel(R.drawable.food1,"Burger"));
        arrayList.add(new RecepiesModel(R.drawable.food2,"Pizza"));
        arrayList.add(new RecepiesModel(R.drawable.food3,"Pasta"));
        arrayList.add(new RecepiesModel(R.drawable.food4,"Tacos"));
        arrayList.add(new RecepiesModel(R.drawable.food5,"Tortilas"));
        arrayList.add(new RecepiesModel(R.drawable.food6,"Something Wierd"));
        arrayList.add(new RecepiesModel(R.drawable.food7,"Donno"));
        recepieAdapter=new RecepieAdapter(arrayList,this);
        recyclerView.setAdapter(recepieAdapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,recyclerView,new RecyclerItemClickListener.OnItemClickListener(){
//
//            @Override
//            public void onItemClick(View view, int position) {
//                switch (position)
//                {
//                    case 0:
//                        Intent intent=new Intent(MainActivity.this,ScrollingActivity.class);
//                        startActivity(intent);
//                        break;
//                    case 1:
//                        Toast.makeText(MainActivity.this, "Card 2", Toast.LENGTH_SHORT).show();
//                        break;
//                        default:
//                            break;
//                }
//
//            }
//
//            @Override
//            public void onLongItemClick(View view, int position) {
//                switch (position)
//                {
//                    case 0:
//                        Toast.makeText(MainActivity.this, "Card1 long press", Toast.LENGTH_SHORT).show();
//                        break;
//                    default:
//                        break;
//                }
//            }
//        }));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_scrolling,menu);
        MenuItem searchItem=menu.findItem(R.id.search_view);
        SearchView searchView= (SearchView) searchItem.getActionView();

//        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recepieAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onLongClick(View v) {
        toolbar.getMenu().clear();
        toolbar.inflateMenu(R.menu.menu_action_mode);
        counter_text_view.setVisibility(View.VISIBLE);
        is_in_action_mode=true;
        recepieAdapter.notifyDataSetChanged();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return true;
    }
    public void prepareSelection(View view,int position)
    {
        if(((CheckBox)view).isChecked())
        {
            selection_list.add(arrayList.get(position));
            counter++;
            updateTextView(counter);
        }
        else {
            selection_list.remove(arrayList.get(position));
            counter--;
            updateTextView(counter);
        }
    }

    private void updateTextView(int counter) {
        if(counter>0)
        {
            counter_text_view.setText(counter+" items selected");
        }
        else {
            counter_text_view.setText(0+" items selected");
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.item_delete)
        {
            //RecepieAdapter recepieAdapter= (RecepieAdapter) adapter;
            recepieAdapter.updateAapter(selection_list);
            clearActionMode();
        }
        else if(item.getItemId()==android.R.id.home)
        {
            clearActionMode();
            recepieAdapter.notifyDataSetChanged();
        }
        return true;
    }
    public void clearActionMode()
    {
        is_in_action_mode=false;
        toolbar.getMenu().clear();
        toolbar.inflateMenu(R.menu.menu_scrolling);
        counter_text_view.setText(") items selected");
        counter_text_view.setVisibility(View.GONE);
        counter=0;
        selection_list.clear();
    }

    @Override
    public void onBackPressed() {
        if(is_in_action_mode)
        {
            clearActionMode();
            recepieAdapter.notifyDataSetChanged();
        }
        super.onBackPressed();
    }
}
