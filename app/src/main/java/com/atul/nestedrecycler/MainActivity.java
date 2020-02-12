package com.atul.nestedrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView mainRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<HoriModel> horiModels = new ArrayList<>();
        horiModels.add(new HoriModel("BigClout", R.drawable.ic_launcher_foreground));
        horiModels.add(new HoriModel("Android", R.drawable.ic_android_black_24dp));
        horiModels.add(new HoriModel("BigClout", R.drawable.ic_launcher_foreground));
        horiModels.add(new HoriModel("Android", R.drawable.ic_android_black_24dp));
        horiModels.add(new HoriModel("BigClout", R.drawable.ic_launcher_foreground));
        horiModels.add(new HoriModel("Android", R.drawable.ic_android_black_24dp));
        horiModels.add(new HoriModel("BigClout", R.drawable.ic_launcher_foreground));
        horiModels.add(new HoriModel("Android", R.drawable.ic_android_black_24dp));
        mainRecycler = findViewById(R.id.recMain);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mainRecycler.setLayoutManager(linearLayoutManager);
        List<MainModel> mainModels = new ArrayList<>();
        mainModels.add(new MainModel(horiModels,0));
        mainModels.add(new MainModel(horiModels,0));
        mainModels.add(new MainModel(horiModels,0));
        mainModels.add(new MainModel(horiModels,0));
        mainModels.add(new MainModel(horiModels,0));


        MainAdapter mainAdapter = new MainAdapter(mainModels);
        mainRecycler.setAdapter(mainAdapter);
        mainAdapter.notifyDataSetChanged();
    }
}
