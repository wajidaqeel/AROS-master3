package com.saboor.aros.app;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saboor.aros.R;
import com.saboor.aros.app.models.Order;

import java.util.List;


public class RecyclerViewAdapterOrdersOfCook extends RecyclerView.Adapter<OrderViewHolder>
{
    Context mContext;
    List<Order> mData;
    Dialog myDialog;

    public RecyclerViewAdapterOrdersOfCook(Context context, List<Order> data)
    {
        mContext = context;
        mData = data;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.layout_orders_of_cook,parent,false);
        final OrderViewHolder vHolder = new OrderViewHolder(v);

        vHolder.order_row.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.i("testing","!23");
                /*mContext.startActivity(new Intent(mContext, OthersFypDetailActivity.class).
                        putExtra("project",mData.get(vHolder.getAdapterPosition())));*/
            }
        });

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position)
    {

        holder.order_name.setText(mData.get(position).getItemName());
        holder.order_status.setText(mData.get(position).getStatus());
        String status=mData.get(position).getStatus();
        if(status.equals("Cooking"))
        {
            holder.itemView.setBackgroundColor(Color.parseColor("#ffeee0"));
            holder.button.setVisibility(View.INVISIBLE);

        }
        else if(status.equals("Waiting"))
        {
            holder.itemView.setBackgroundColor(Color.parseColor("#ff6961"));
            holder.button.setVisibility(View.INVISIBLE);

        }
        else if(status.equals("Ready"))
        {
            holder.itemView.setBackgroundColor(Color.parseColor("#98fb98"));
            holder.button.setVisibility(View.VISIBLE);
        }


        // new ImageDownload(holder.project_image,mContext).execute(mData.get(position).getProjectImage());
    }

    @Override
    public int getItemCount()
    {
        if(mData!=null)
        {
            return mData.size();
        }
        else
        {
            return 0;
        }
    }
}
