package com.gourmetGo.utils;

public class OrderStatus {
    //Created, but adding items
    public final static String UNCOMPLETED = "Uncompleted";
    //Waiting for a courier to accept
    public final static String PENDING = "Pending";
    //In preparation
    public final static String PREPARING = "Preparing";
    //Delivering to the customer
    public final static String TRANSIT = "Transit";
    //Order delivered
    public final static String DELIVERED = "Delivered";
}
