package com.movie;

import java.util.Arrays;

public class Order {

    private String id;//订单编号
    private String userId;//用户编号
    private String homeId;//场次编号
    private String date;//购买时间
    private int x;
    private int y;

    private boolean flag;



    public Order(String id, String userId, String homeId, String date, int x, int y, boolean flag) {
        this.id = id;
        this.userId = userId;
        this.homeId = homeId;
        this.date = date;
        this.x = x;
        this.y = y;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", homeId='" + homeId + '\'' +
                ", date='" + date + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", flag=" + flag +
                '}';
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHomeId() {
        return homeId;
    }

    public void setHomeId(String homeId) {
        this.homeId = homeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void show(){

        System.out.print("  订单编号："+id);
        System.out.print("  用户编号："+userId);
        System.out.print("  场次编号："+homeId);
        System.out.print("  购买时间："+date);
        System.out.print("  座位：("+x+","+y+")");
        if(flag)
            System.out.println("  已取票：");
        else
            System.out.println("  未取票：");

    }

}
