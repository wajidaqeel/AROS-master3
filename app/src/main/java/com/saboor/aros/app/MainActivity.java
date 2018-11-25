package com.saboor.aros.app;

import android.support.v7.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;


import com.saboor.aros.R;
import com.saboor.aros.app.models.Chef;
import com.saboor.aros.app.models.Order;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    public static ArrayList<Chef> mChefs = new ArrayList<>();
    public static int chefNo = 0;
    public static RecyclerViewAdapterOrdersOfCook adapter2 = null;
    ActionBar actionBar;
    TextView mChefNo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffff8800")));

        mChefNo = findViewById(R.id.chefno);

        //getActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.cardview_dark_background)));
        ExtractChefsFromDb();
        ExtractOrdersOfChefsFromDb();


        /*if(findViewById(R.id.list_of_items) != null)
        {
            if(savedInstanceState != null)
            {
                return;
            }
            BlankFragmentNotDone blankFragment = new BlankFragmentNotDone();
            Bundle bundle = new Bundle();
            bundle.putString("test","abc");
            blankFragment.setArguments(bundle);
            // We can set arguments here
            getSupportFragmentManager().beginTransaction().add(blankFragment,null).commit();
            //getSupportFragmentManager().beginTransaction().replace(R.id.list_of_items,blankFragment).commit();
        }*/
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
        mChefs.add(new Chef("Chef 13"));
        mChefs.add(new Chef("Chef 14"));
        mChefs.add(new Chef("Chef 15"));


        initRecyclerView();
    }

    private void ExtractOrdersOfChefsFromDb()
    {
        mChefs.get(0).addOrder(new Order("Ready","Burger"));
        mChefs.get(0).addOrder(new Order("Ready","Fries"));
        mChefs.get(0).addOrder(new Order("Cooking","Rice"));
        mChefs.get(0).addOrder(new Order("Cooking","Chicken Maslaa"));
        mChefs.get(0).addOrder(new Order("Cooking","Egg Fried Rice"));
        mChefs.get(0).addOrder(new Order("Cooking","Chinese Rice"));
        mChefs.get(0).addOrder(new Order("Cooking","0"));
        mChefs.get(0).addOrder(new Order("Cooking","1"));
        mChefs.get(0).addOrder(new Order("Cooking","2"));
        mChefs.get(0).addOrder(new Order("Cooking","3"));
        mChefs.get(0).addOrder(new Order("Cooking","8"));
        mChefs.get(0).addOrder(new Order("Waiting","Pasta"));
        mChefs.get(0).addOrder(new Order("Waiting","Mutton handi"));

        mChefs.get(1).addOrder(new Order("Cooking","Zinger"));
        mChefs.get(1).addOrder(new Order("Cooking","Fries"));
        mChefs.get(2).addOrder(new Order("Cooking","Biryani"));
        mChefs.get(2).addOrder(new Order("Waiting","Egg"));
        mChefs.get(3).addOrder(new Order("Cooking","Pizza"));
        mChefs.get(4).addOrder(new Order("Cooking","Rice"));
        mChefs.get(5).addOrder(new Order("Cooking","Chicken Maslaa"));
        mChefs.get(6).addOrder(new Order("Cooking","Egg Fried Rice"));
        mChefs.get(6).addOrder(new Order("Cooking","Chinese Rice"));

        mChefNo.setText("Orders of chef " + (chefNo + 1));
        initRecyclerView2(chefNo);
    }

    private void initRecyclerView()
    {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapterCook adapter = new RecyclerViewAdapterCook(this, mChefs);
        recyclerView.setAdapter(adapter);
    }

    private void initRecyclerView2(int chefNo)
    {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        final RecyclerView recyclerView = findViewById(R.id.recyclerview2);
        recyclerView.setLayoutManager(layoutManager);

        adapter2 = new RecyclerViewAdapterOrdersOfCook(this, mChefs.get(chefNo).getOrder());

        //final RecyclerViewAdapterOrdersOfCook adapter = new RecyclerViewAdapterOrdersOfCook(this, mChefs.get(chefNo).getOrder());
        recyclerView.setAdapter(adapter2);
    }
}
