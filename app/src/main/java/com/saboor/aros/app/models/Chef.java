package com.saboor.aros.app.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Chef implements Serializable
{
    private String mName;
    private String id;
    private ArrayList<Order> mOrder;

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    private boolean isPresent = false;

    public Chef(String name)
    {
        mName = name;
        mOrder = new ArrayList<>();
    }

    public void setId(String id) {
        this.id = id;
    }

    public Chef(String mName, String id, ArrayList<Order> mOrder) {
        this.mName = mName;
        this.id = id;
        this.mOrder = mOrder;
    }

    public String getId() {
        return id;
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
