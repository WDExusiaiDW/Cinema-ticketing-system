package com.movie;


import java.util.Date;

public class Home {

    private String id;
    private Hall hall;//放映厅
    private String movieName;//播放电影名称
    private double price;//价格
    private String date;//时间段
    private Integer state;//1.占场 0.空场


    public Home(String id, Hall hall, String movieName, double price, String date, Integer state) {
        this.id = id;
        this.hall = hall;
        this.movieName = movieName;
        this.price = price;
        this.date = date;
        this.state = state;
    }


    public Home() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Home{" +
                "id=" + id +
                ", hall=" + hall +
                ", movieName='" + movieName + '\'' +
                ", price=" + price +
                ", date='" + date + '\'' +
                ", state=" + state +
                '}';
    }

    public void show(){

        System.out.print("场次编号："+id);
        System.out.print("  播放电影名称："+movieName);
        System.out.print("  价格："+price);
        System.out.print("  时间段："+date);
        System.out.print("  状态(1.占场 0.空场)："+state);
        System.out.println("  放映厅："+hall.getId());
        System.out.println("  0 1 2 3 4 5 6 7 8 9 10 11");
        for(int i=0;i<7;i++) {
            System.out.print(i+" ");
            for (int j=0;j<12;j++){
                System.out.print(hall.getSeat()[i][j]+" ");

            }
            System.out.println();
        }
        System.out.println();
    }


}
