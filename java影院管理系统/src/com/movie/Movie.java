package com.movie;

public class Movie {

//    片名、导演、主演、剧情简介、时长（片长时间）。

    private String name;
    private String director;
    private String star;
    private String info;
    private double time;//分钟

    public Movie(String name, String director, String star, String info, double time) {
        this.name = name;
        this.director = director;
        this.star = star;
        this.info = info;
        this.time = time;
    }

    public Movie() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", star='" + star + '\'' +
                ", info='" + info + '\'' +
                ", time=" + time +
                '}';
    }

    public void show(){

        System.out.print("片名："+name);
        System.out.print("  导演："+director);
        System.out.print("  主演："+star);
        System.out.print("  剧情简介："+info);
        System.out.println("  时长(分钟)："+time);

    }
}
