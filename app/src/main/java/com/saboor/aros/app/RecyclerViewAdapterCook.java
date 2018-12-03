package com.saboor.aros.app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.saboor.aros.R;
import com.saboor.aros.app.models.Chef;

import java.util.ArrayList;

public class RecyclerViewAdapterCook extends RecyclerView.Adapter<RecyclerViewAdapterCook.ViewHolder>
{
    private ArrayList<Chef> mChefs = new ArrayList<>();
    private Context mContext;
    public static ArrayList<RecyclerViewAdapterOrdersOfCook> adapters = new ArrayList<>();

    public RecyclerViewAdapterCook(Context context, ArrayList<Chef> chefs)
    {
        this.mChefs = chefs;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_cooks_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position)
    {
        holder.name.setText(mChefs.get(position).getName());

        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        final RecyclerView recyclerView = holder.mRecyclerView;
        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapterOrdersOfCook adapter2 = new RecyclerViewAdapterOrdersOfCook(mContext, mChefs.get(position).getChefQueue(),position);
        adapters.add(adapter2);
        recyclerView.setAdapter(adapters.get(adapters.size()-1));

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(mContext, MainActivity.class);
                MainActivity.chefNo = position;
                holder.itemView.setBackgroundColor(Color.parseColor("#228B22"));

                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                mContext.startActivity(i);

                Toast.makeText(mContext, mChefs.get(position).getName(), Toast.LENGTH_SHORT).show();

            }
        });

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(mContext, MainActivity.class);
                MainActivity.chefNo = position;
                holder.itemView.setBackgroundColor(Color.parseColor("#228B22"));

                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                mContext.startActivity(i);

                Toast.makeText(mContext, mChefs.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        if(!mChefs.get(position).isPresent()){
            holder.name.setVisibility(View.GONE);
            holder.imageView.setVisibility(View.GONE);
            holder.mRecyclerView.setVisibility(View.GONE);
        }
        else{
            holder.name.setVisibility(View.VISIBLE);
            holder.imageView.setVisibility(View.VISIBLE);
            holder.mRecyclerView.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount()
    {
        return mChefs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name;
        ImageView imageView;
        RecyclerView mRecyclerView;

        public ViewHolder(View itemView)
        {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            imageView=itemView.findViewById(R.id.imageView);
            mRecyclerView=itemView.findViewById(R.id.recyclerview5);
        }
    }
}