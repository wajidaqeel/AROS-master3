package com.saboor.aros.app.models;

import com.saboor.aros.app.MainActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.MissingFormatArgumentException;

public class Chef implements Serializable
{
    private String mName;
    private String id;
    private ArrayList<Order> mOrder;
    private String specialty;
    private ArrayList<OrderDetailsDb> ChefQueue;

    public Chef(String mName, String id, ArrayList<Order> mOrder, String specialty, ArrayList<OrderDetailsDb> chefQueue, boolean isPresent) {
        this.mName = mName;
        this.id = id;
        this.mOrder = mOrder;
        this.specialty = specialty;
        ChefQueue = chefQueue;
        this.isPresent = isPresent;
    }

    public Chef(String mName, String id, String specialty, boolean isPresent) {
        this.mName = mName;
        this.id = id;
        this.specialty = specialty;
        this.isPresent = isPresent;
    }

    public int returnCookingTime(){
        int total = 0;
        for(OrderDetailsDb dish:ChefQueue){

            if (dish.getStatus() == MainActivity.COOKING)
                total += MainActivity.getDishCookingTime(dish.getDishname());
        }

        return total;
    }

    public int returnWaitingTime(){
        int total = 0;
        for(OrderDetailsDb dish:ChefQueue){

            if (dish.getStatus() == MainActivity.WAITING)
                total += MainActivity.getDishCookingTime(dish.getDishname());
        }

        return total;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
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

    public void addDish(OrderDetailsDb dish){
        ChefQueue.add(dish);
    }

}
