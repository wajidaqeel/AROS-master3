package com.saboor.aros.app;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.saboor.aros.R;
import com.saboor.aros.app.models.Chef;

import java.util.ArrayList;
import java.util.List;

public class CooksListActivity extends AppCompatActivity
{
    private ArrayList<Chef> mChefs = new ArrayList<>();
    public static int chefNo = 0;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cooks_list);
        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffff8800")));

        mChefs = MainActivity.mChefs;

        //mChefs = (ArrayList<Chef>) getIntent().getSerializableExtra("chefs_list");
        initRecyclerView();
    }

    private void initRecyclerView()
    {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView3);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapterCookList adapter = new RecyclerViewAdapterCookList(this, mChefs);
        recyclerView.setAdapter(adapter);
    }
}
