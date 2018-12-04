package com.saboor.aros.app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.saboor.aros.R;
import com.saboor.aros.app.RecyclerViewAdapterCook;
import com.saboor.aros.app.models.AttendanceDb;
import com.saboor.aros.app.models.Chef;
import com.saboor.aros.app.models.OrderDetailsDb;

import java.util.ArrayList;

public class AttendanceActivity extends AppCompatActivity
{
    ActionBar actionBar;
    public static ArrayList<Chef> mChefs = new ArrayList<>();
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance2);

        //setContentView(R.layout.activity_main);
        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffff8800")));
        actionBar.setTitle(Html.fromHtml("<font color='#ffffff'>AROS </font>"));

        //getActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.cardview_dark_background)));
        //ExtractChefsFromDb();
        mChefs = (ArrayList<Chef>) getIntent().getExtras().get("chefs");
        initRecyclerView();
    }

    private void ExtractChefsFromDb()
    {
        mChefs.clear();
        mChefs.add(new Chef("Chef 1"));
        mChefs.add(new Chef("Chef 2"));
        mChefs.add(new Chef("Chef 3"));
        mChefs.add(new Chef("Chef 4"));
        mChefs.add(new Chef("Chef 5"));
        mChefs.add(new Chef("Chef 6"));
        mChefs.add(new Chef("Chef 7"));
        mChefs.add(new Chef("Chef 8"));
        mChefs.add(new Chef("Chef 9"));
        mChefs.add(new Chef("Chef 10"));
        mChefs.add(new Chef("Chef 11"));
        mChefs.add(new Chef("Chef 12"));

        initRecyclerView();
    }

    private void initRecyclerView()
    {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView = findViewById(R.id.attendance_rv);
        recyclerView.setLayoutManager(layoutManager);

        com.saboor.aros.app.RecyclerViewAdapterAttendanceList adapter = new com.saboor.aros.app.RecyclerViewAdapterAttendanceList(this, mChefs);
        recyclerView.setAdapter(adapter);


    }

    public void doneClick(View view){

        ArrayList<Chef> chefs = ((RecyclerViewAdapterAttendanceList)recyclerView.getAdapter()).getmChefs();

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        ProgressDialog progressDialog = new ProgressDialog(AttendanceActivity.this);
        progressDialog.setMessage("Uploading Attendance");
        progressDialog.show();

        for (Chef chef:chefs){
            if(!chef.isPresent()){
                for(OrderDetailsDb dish:chef.getChefQueue()){
                    MainActivity.orderDetails.add(dish);
                }
                chef.setChefQueue(new ArrayList<OrderDetailsDb>());
            }

            DatabaseReference myRef = database.getReference("Attendance/" + chef.getId());
            myRef.setValue(new AttendanceDb(chef.getId(), chef.isPresent()));
        }

        progressDialog.dismiss();

        Intent intent = new Intent();
        this.setResult(RESULT_OK, intent);
        finish();
    }
}
