package com.movie;

public class User {

//    用户信息包括：用户 ID、用户名、用户级别（金牌用户、银牌用户、铜牌用户）、
//    用户注册时间、用户累计消费总金额、用户累计消费次数、用户手机号、用户邮箱；
    private String id;
    private String name;
    private String pwd;//密码
    private Integer level;//用户级别（1.金牌用户、2.银牌用户、3.铜牌用户）
    private String date;
    private double money;
    private int number;
    private String phone;
    private String email;
    private int errorNumber;//登录错误次数 5次锁定

    public User(String id, String name, String pwd, Integer level, String date, double money, int number, String phone, String email, int errorNumber) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.level = level;
        this.date = date;
        this.money = money;
        this.number = number;
        this.phone = phone;
        this.email = email;
        this.errorNumber = errorNumber;
    }

    public User(String id, String name, Integer level, String date, double money, int number, String phone, String email, int errorNumber) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.date = date;
        this.money = money;
        this.number = number;
        this.phone = phone;
        this.email = email;
        this.errorNumber = errorNumber;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", level=" + level +
                ", date='" + date + '\'' +
                ", money=" + money +
                ", number=" + number +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", errorNumber=" + errorNumber +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getErrorNumber() {
        return errorNumber;
    }

    public void setErrorNumber(int errorNumber) {
        this.errorNumber = errorNumber;
    }

    public void show(){
        System.out.print("用户ID："+id);
        System.out.print("  用户名："+name);
        System.out.print("  用户级别(1.金牌用户、2.银牌用户、3.铜牌用户)："+level);
        System.out.print("  用户注册时间："+date);
        System.out.print("  用户累计消费金额："+money);
        System.out.print("  用户累计消费次数："+number);
        System.out.print("  用户手机号码："+phone);
        System.out.println("  用户邮箱："+email);
    }
}
