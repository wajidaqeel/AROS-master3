/** This File is used as an adapter to show the chefs,
 * after head chef wants to transfer some order in waiting state from one chef to some other chef
**/

package com.saboor.aros.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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

public class RecyclerViewAdapterCookList extends RecyclerView.Adapter<RecyclerViewAdapterCookList.ViewHolder>
{
    ArrayList<Chef> mChefs = new ArrayList<>();
    Context mContext;
    int itemNo;
    int chefNo;
    CooksListActivity activity;

    public RecyclerViewAdapterCookList(Context context, ArrayList<Chef> chefs, int itemNo, int chefNo, CooksListActivity activity)
    {
        this.mChefs = chefs;
        this.itemNo = itemNo;
        this.chefNo = chefNo;
        this.activity = activity;
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
        boolean flag=false;

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                MainActivity.mChefs.get(position).getChefQueue().
                        add(MainActivity.mChefs.get(chefNo).getChefQueue().get(itemNo));
                //((MainActivity)mContext).reinitializeCookAdapter();/////////////

                MainActivity.mChefs.get(chefNo).getChefQueue().remove(itemNo);

                MainActivity.adapter.notifyDataSetChanged();
                Toast.makeText(mContext, mChefs.get(position).getName() + " has been assigned the dish", Toast.LENGTH_SHORT).show();
                // MainActivity.selected = true;
                // MainActivity.mChefs = mChefs;

                //Intent inte = new Intent();
                activity.setResult(Activity.RESULT_OK);/*, inte);*/
                activity.finish();
            }
        });

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                MainActivity.mChefs.get(position).getChefQueue().
                        add(MainActivity.mChefs.get(chefNo).getChefQueue().get(itemNo));


                MainActivity.mChefs.get(chefNo).getChefQueue().remove(itemNo);
                MainActivity.adapter.notifyDataSetChanged();
                Toast.makeText(mContext, mChefs.get(position).getName() + " has been assigned the dish", Toast.LENGTH_SHORT).show();

               // ((MainActivity)mContext).reinitializeCookAdapter();/////////////
                // MainActivity.selected = true;
                // MainActivity.mChefs = mChefs;

                activity.setResult(Activity.RESULT_OK);
                activity.finish();
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