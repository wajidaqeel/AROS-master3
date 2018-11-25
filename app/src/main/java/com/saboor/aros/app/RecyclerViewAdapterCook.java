package com.saboor.aros.app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
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

    public RecyclerViewAdapterCook(Context context, ArrayList<Chef> chefs)
    {
        this.mChefs = chefs;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_cooks, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position)
    {
        holder.name.setText(mChefs.get(position).getName());
        boolean flag=false;

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(mContext, MainActivity.class);
                MainActivity.chefNo = position;
                holder.itemView.setBackgroundColor(Color.parseColor("#228B22"));
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
                mContext.startActivity(i);

                Toast.makeText(mContext, mChefs.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
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

        public ViewHolder(View itemView)
        {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            imageView=itemView.findViewById(R.id.imageView);
        }
    }
}