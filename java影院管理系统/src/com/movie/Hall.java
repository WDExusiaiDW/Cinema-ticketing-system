package com.movie;

import java.util.Arrays;

public class Hall {

    private String id;//放映厅编号
    private String seat[][];

    public Hall(String id, String[][] seat) {
        this.id = id;
        this.seat = seat;
    }

    public Hall() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[][] getSeat() {
        return seat;
    }

    public void setSeat(String[][] seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "id='" + id + '\'' +
                ", seat=" + Arrays.toString(seat) +
                '}';
    }
}
