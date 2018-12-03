package com.saboor.aros.app.models;

import java.util.Comparator;

public class OrderComparator implements Comparator<OrderDetailsDb> {

    @Override
    public int compare(OrderDetailsDb o1, OrderDetailsDb o2) {
        return (new Integer(o2.getPriority())).compareTo((new Integer(o1.getPriority())));
    }
}
