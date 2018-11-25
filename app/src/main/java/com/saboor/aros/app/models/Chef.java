package com.saboor.aros.app.models;

import java.util.ArrayList;

public class Chef
{
    private String mName;
    private ArrayList<Order> mOrder;

    public Chef(String name)
    {
        mName = name;
        mOrder = new ArrayList<>();
    }

    public String getName()
    {
        return mName;
    }

    public void setName(String name)
    {
        mName = name;
    }

    public ArrayList<Order> getOrder()
    {
        return mOrder;
    }

    public void setOrder(ArrayList<Order> order)
    {
        mOrder = order;
    }

    public void addOrder(Order order)
    {
        mOrder.add(order);
    }
}
