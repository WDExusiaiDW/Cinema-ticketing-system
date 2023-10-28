package com.movie;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Service {

    List<Person> personList=new ArrayList<>();
    List<User> userList=new ArrayList<>();

    List<Movie> movieList=new ArrayList<>();

    List<Hall> hallList=new ArrayList<>();
    List<Home> homeList=new ArrayList<>();

    List<Order> orderList=new ArrayList<>();
    Scanner scanner=new Scanner(System.in);

    public void menu(){

        System.out.println("--------------------------------------");
        System.out.println("          影院管理系统");
        System.out.println("           1.管理员");
        System.out.println("           2.经理");
        System.out.println("           3.前台");
        System.out.println("           4.用户");
        System.out.println("           5.用户注册");
        System.out.println("           0.退出登录");
        System.out.println("--------------------------------------");
        System.out.println("请输入你的选择：");

    }

    //初始化
    public void init(){
        personList.add(new Person("admin","ynuinfo#777",1));
        personList.add(new Person("manger","ynuinfo#777",2));
        personList.add(new Person("head","ynuinfo#777",3));
        userList.add(new User("1","user001","User#1234",1,"2023-9-29 11:00:00",0,0,"18323610114","123@qq.com",0));
        userList.add(new User("2","user002","User#1234",2,"2023-9-29 11:00:00",0,0,"18323610111","133@qq.com",0));
        userList.add(new User("3","user003","User#1234",3,"2023-9-29 11:00:00",0,0,"18323610112","153@qq.com",0));

        movieList.add(new Movie("西游记","张三","李四","西天取经",150));
        movieList.add(new Movie("复仇者联盟","张三","李四","复仇",200));
        movieList.add(new Movie("夏洛特烦恼","沈腾","沈腾","烦恼",170));
    }
    //管理员登录
    public int adminLogin(){

        System.out.println("请输入登录的管理员用户名：");
        String name=scanner.next();
        System.out.println("请输入登录的管理员密码：");
        String pwd=scanner.next();

        for (int i=0;i<personList.size();i++){
            if(personList.get(i).getUsername().equals(name)
                    &&personList.get(i).getPassword().equals(pwd)
                    &&personList.get(i).getRole()==1){
                System.out.println("登录成功！");
                return i;
            }
        }

        System.out.println("用户名或者密码错误，登录失败！");
        return -1;

    }
    public int mangerLogin(){

        System.out.println("请输入登录的经理用户名：");
        String name=scanner.next();
        System.out.println("请输入登录的经理密码：");
        String pwd=scanner.next();

        for (int i=0;i<personList.size();i++){
            if(personList.get(i).getUsername().equals(name)
                    &&personList.get(i).getPassword().equals(pwd)
                    &&personList.get(i).getRole()==2){
                System.out.println("登录成功！");
                return i;
            }
        }

        System.out.println("用户名或者密码错误，登录失败！");
        return -1;

    }
    public int headLogin(){

        System.out.println("请输入登录的前台用户名：");
        String name=scanner.next();
        System.out.println("请输入登录的前台密码：");
        String pwd=scanner.next();

        for (int i=0;i<personList.size();i++){
            if(personList.get(i).getUsername().equals(name)
                    &&personList.get(i).getPassword().equals(pwd)
                    &&personList.get(i).getRole()==3){
                System.out.println("登录成功！");
                return i;
            }
        }

        System.out.println("用户名或者密码错误，登录失败！");
        return -1;

    }
    //管理员功能
    public void adminMenu(){

        System.out.println("--------------------------------------");
        System.out.println("               管理员");
        System.out.println("           1.修改自身密码");
        System.out.println("           2.重置普通用户密码");
        System.out.println("           3.列出所有用户信息");
        System.out.println("           4.删除用户信息");
        System.out.println("           5.查询用户信息");
        System.out.println("           0.退出登录");
        System.out.println("--------------------------------------");
        System.out.println("请输入你的选择：");

    }
    //管理员修改密码
    public void adminUpdatePwd(){

        System.out.println("请输入修改的管理员用户名：");
        String name=scanner.next();
        System.out.println("请输入修改的管理员原密码：");
        String pwd=scanner.next();

        for (int i=0;i<personList.size();i++){
            if(personList.get(i).getUsername().equals(name)
                    &&personList.get(i).getPassword().equals(pwd)
                    &&personList.get(i).getRole()==1){

                System.out.println("请输入新的管理员密码：");
                String password=scanner.next();
                personList.get(i).setPassword(password);
                System.out.println("修改管理员密码成功！");
                return;
            }
        }

        System.out.println("用户名或者密码错误，修改管理员密码失败！");

    }
    //重置普通用户密码
    public void adminResetUserPwd(){
        System.out.println("请输入重置密码的用户用户名：");
        String name=scanner.next();
        boolean flag=false;
        for(int i=0;i<userList.size();i++){
            if(name.equals(userList.get(i).getName())){
                flag=true;
                userList.get(i).setPwd("123456");
                System.out.println("密码重置为：123456");
                break;
            }
        }
        if(!flag){
            System.out.println("用户信息不存在，重置密码失败！");
        }
    }
    //列出所有用户信息
    public void adminShowAllUser(){
        if(userList.size()==0){
            System.out.println("没有用户信息！");
            return;
        }
        for(int i=0;i<userList.size();i++) {
            userList.get(i).show();
        }
    }
    //删除用户信息
    public void adminDeleteUser(){
        System.out.println("请输入删除的用户名：");
        String name=scanner.next();
        boolean flag=false;
        for(int i=0;i<userList.size();i++){
            if(name.equals(userList.get(i).getName())){
                flag=true;

                System.out.println("是否确认删除(y/n):");
                String ch=scanner.next();
                if("y".equals(ch)){
                    userList.remove(i);
                    System.out.println("删除用户信息成功！");
                }else {
                    System.out.println("取消删除！");
                }
                break;
            }
        }
        if(!flag){
            System.out.println("用户信息不存在，删除失败！");
        }
    }
    //查询用户信息
    public void adminQueryUser(){

        System.out.println("a.根据用户ID查询");
        System.out.println("b.根据用户姓名查询");
        System.out.println("请输入你的选择：");
        String ch=scanner.next();
        if("a".equals(ch)){
            System.out.println("请输入查询的用户ID：");
            String id=scanner.next();
            boolean flag=false;
            for(int i=0;i<userList.size();i++){
                if(id.equals(userList.get(i).getId())){
                    flag=true;
                    userList.get(i).show();
                }
            }
            if(!flag){
                System.out.println("用户信息不存在，查询失败！");
            }
        } else if ("b".equals(ch)) {
            System.out.println("请输入查询的用户名：");
            String name=scanner.next();
            boolean flag=false;
            for(int i=0;i<userList.size();i++){
                if(name.equals(userList.get(i).getName())){
                    flag=true;
                    userList.get(i).show();
                }
            }
            if(!flag){
                System.out.println("用户信息不存在，查询失败！");
            }
        }else {
            System.out.println("输入有误，查询失败！");
        }

    }




    //经理
    //影片管理
    public void managerMenu(){

        System.out.println("--------------------------------------");
        System.out.println("               影片管理");
        System.out.println("           1.列出所有正在上映影片的信息");
        System.out.println("           2.添加影片的信息");
        System.out.println("           3.修改电影的信息");
        System.out.println("           4.删除影片的信息");
        System.out.println("           5.查询影片的信息");
        System.out.println("             排片管理");
        System.out.println("           6.增加场次");
        System.out.println("           7.修改场次");
        System.out.println("           8.删除场次");
        System.out.println("           9.列出所有场次");
        System.out.println("           0.退出登录");
        System.out.println("--------------------------------------");
        System.out.println("请输入你的选择：");

    }
    //列出所有正在上映影片的信息
    public void showMovie(){

        if(movieList.size()==0){
            System.out.println("没有电影信息！");
        }
        for (Movie movie:movieList){
            movie.show();
        }

    }
    //添加影片的信息
    public void addMovie(){
        //    片名、导演、主演、剧情简介、时长（片长时间）。

        String name;
        String director;
        String star;
        String info;
        double time;//分钟
        System.out.println("请输入添加的片名：");
        name=scanner.next();
        for(int i=0;i< movieList.size();i++){
            if(name.equals(movieList.get(i).getName())){
                System.out.println("存在该电影信息，添加失败！");
                return;
            }
        }
        System.out.println("请输入添加的导演：");
        director=scanner.next();
        System.out.println("请输入添加的主演：");
        star=scanner.next();
        System.out.println("请输入添加的剧情简介：");
        info=scanner.next();
        System.out.println("请输入添加的时长(分钟)：");
        time=scanner.nextDouble();
        Movie movie = new Movie(name, director, star, info, time);
        movieList.add(movie);
        System.out.println("添加电影信息成功！");

    }
    //修改电影的信息
    public void updateMovie(){
        String name;
        String director;
        String star;
        String info;
        double time;//分钟
        System.out.println("请输入修改的片名：");
        name=scanner.next();
        boolean flag=false;
        for(int i=0;i< movieList.size();i++){
            if(name.equals(movieList.get(i).getName())){
                flag=true;
                System.out.println("请输入修改后的导演：");
                director=scanner.next();
                System.out.println("请输入修改后的主演：");
                star=scanner.next();
                System.out.println("请输入修改后的剧情简介：");
                info=scanner.next();
                System.out.println("请输入修改后的时长(分钟)：");
                time=scanner.nextDouble();
                movieList.get(i).setDirector(director);
                movieList.get(i).setStar(star);
                movieList.get(i).setInfo(info);
                movieList.get(i).setTime(time);
                System.out.println("修改电影信息成功！");

                break;
            }
        }

        if(!flag){
            System.out.println("修改的信息不存在！");
        }

    }
    //删除影片的信息
    public void deleteMovie(){
        String name;

        System.out.println("请输入删除的片名：");
        name=scanner.next();
        boolean flag=false;
        for(int i=0;i< movieList.size();i++){
            if(name.equals(movieList.get(i).getName())){
                flag=true;

                System.out.println("是否确认删除(y/n):");
                String ch=scanner.next();
                if("y".equals(ch)){
                    movieList.remove(i);
                    System.out.println("删除电影信息成功！");
                }else {
                    System.out.println("取消删除！");
                }

                break;
            }
        }

        if(!flag){
            System.out.println("删除的信息不存在！");
        }

    }
    //查询影片的信息
    public void queryMovie(){

        System.out.println("a.根据影片名称单独查询");
        System.out.println("b.根据导演单独查询");
        System.out.println("c.根据主演单独查询");
        System.out.println("d.根据影片名称、导演、主演组合查询");
        System.out.println("请输入你的选择：");
        String ch=scanner.next();
        if("a".equals(ch)){
            System.out.println("请输入查询的影片名称：");
            String name=scanner.next();
            boolean flag=false;
            for(int i=0;i<movieList.size();i++){
                if(name.equals(movieList.get(i).getName())){
                    flag=true;
                    movieList.get(i).show();
                }
            }
            if(!flag){
                System.out.println("电影信息不存在，查询失败！");
            }
        } else if ("b".equals(ch)) {
            System.out.println("请输入查询的影片导演：");
            String director=scanner.next();
            boolean flag=false;
            for(int i=0;i<movieList.size();i++){
                if(director.equals(movieList.get(i).getDirector())){
                    flag=true;
                    movieList.get(i).show();
                }
            }
            if(!flag){
                System.out.println("电影信息不存在，查询失败！");
            }
        }else if ("c".equals(ch)) {
            System.out.println("请输入查询的影片主演：");
            String star=scanner.next();
            boolean flag=false;
            for(int i=0;i<movieList.size();i++){
                if(star.equals(movieList.get(i).getStar())){
                    flag=true;
                    movieList.get(i).show();
                }
            }
            if(!flag){
                System.out.println("电影信息不存在，查询失败！");
            }
        }else if ("d".equals(ch)) {
            System.out.println("请输入查询的影片名称：");
            String name=scanner.next();
            System.out.println("请输入查询的影片导演：");
            String director=scanner.next();
            System.out.println("请输入查询的影片主演：");
            String star=scanner.next();

            boolean flag=false;
            for(int i=0;i<movieList.size();i++){
                if(star.equals(movieList.get(i).getStar())
                &&director.equals(movieList.get(i).getDirector())
                        &&name.equals(movieList.get(i).getName())
                ){
                    flag=true;
                    movieList.get(i).show();
                }
            }
            if(!flag){
                System.out.println("电影信息不存在，查询失败！");
            }
        }else {
            System.out.println("输入有误，查询失败！");
        }

    }




    //排片管理
    //初始化放映厅信息
    public void initHall(){
//        放映厅 5 个。每个放
//        映厅的座位数为 7 排，每排 12 人
        String seat[][]=new String[7][12];
        for (int i=0;i<7;i++){
            for (int j=0;j<12;j++){
                seat[i][j]="O";
            }
        }

       hallList.add(new Hall("放映厅1", seat));
        hallList.add(new Hall("放映厅2", seat));
        hallList.add(new Hall("放映厅3", seat));
        hallList.add(new Hall("放映厅4", seat));
        hallList.add(new Hall("放映厅5", seat));

    }
    //增加场次
    public static boolean validateTimeFormat(String timeStr) {
        String regex = "([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";
        return timeStr.matches(regex);
    }
    public void addHome(){

        System.out.println("请输入添加场次编号：");
        String id=scanner.next();
        for (int i=0;i<homeList.size();i++){
            if(id.equals(homeList.get(i).getId())){
                System.out.println("存在该编号，添加场次失败！");
                return;
            }
        }


        System.out.println("请输入你选择的放映厅编号：");
        String hallId=scanner.next();
        int flag=-1;
        for (int i=0;i<hallList.size();i++){
            if(hallId.equals(hallList.get(i).getId())){
                flag=i;
                break;
            }
        }
        if(flag==-1){
            System.out.println("不存在该放映厅，添加场次失败！");
            return;
        }

        System.out.println("请输入你选择的放映的电影名称：");
        String movieName=scanner.next();
        int movieFlag=-1;
        for (int i=0;i<movieList.size();i++){
            if(movieName.equals(movieList.get(i).getName())){
                movieFlag=i;
                break;
            }
        }
        if(movieFlag==-1){
            System.out.println("不存在该电影信息，添加场次失败！");
            return;
        }

        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate = currentDate.plusDays(7);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String time = futureDate.format(formatter);
        System.out.println("当前预约时间段日期为："+time);
        System.out.print("请输入时间（格式为HH:mm:ss）：");
        String inputTime = scanner.next();

        boolean isValid = validateTimeFormat(inputTime);
        if (isValid) {
            LocalTime tempTime = LocalTime.parse(inputTime, DateTimeFormatter.ofPattern("HH:mm:ss"));
            time=time+" "+inputTime;
        } else {
            System.out.println("时间格式不合法,增加场次失败！");
            return;
        }

        for (Home home:homeList){
            if(time.equals(home.getDate())
            &&hallId.equals(home.getHall().getId())
            &&home.getState()==1){
                System.out.println("该预约时间段日期已经预约，预约失败！");
                return;
            }
        }

        System.out.println("请输入价格：");
        double price=scanner.nextDouble();

        Home home = new Home(id,hallList.get(flag), movieName, price, time,1);
        homeList.add(home);
        System.out.println("添加场次成功！");

    }
    //修改场次
    public void updateHome(){
        System.out.println("请输入你修改的场次编号：");
        String id=scanner.next();

        boolean flag=false;
        for(int i=0;i<homeList.size();i++){
            if(id.equals(homeList.get(i).getId())){
                flag=true;

                System.out.println("是否空场(y/n):");
                String ch=scanner.next();
                if("y".equals(ch)){
                    homeList.get(i).setMovieName("");
                    homeList.get(i).setState(0);
                    homeList.get(i).setPrice(0);
                    System.out.println("修改场次信息成功！");
                    return;
                }

                System.out.println("请输入修改的放映的电影名称：");
                String movieName=scanner.next();
                int movieFlag=-1;
                for (int j=0;j<movieList.size();j++){
                    if(movieName.equals(movieList.get(j).getName())){
                        movieFlag=j;
                        break;
                    }
                }
                if(movieFlag==-1){
                    System.out.println("不存在该电影信息，修改场次失败！");
                    return;
                }

                LocalDate currentDate = LocalDate.now();
                LocalDate futureDate = currentDate.plusDays(7);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String time = futureDate.format(formatter);
                System.out.println("当前预约时间段日期为："+time);
                System.out.print("请输入修改场次的时间（格式为HH:mm:ss）：");
                String inputTime = scanner.next();

                boolean isValid = validateTimeFormat(inputTime);
                if (isValid) {
                    LocalTime tempTime = LocalTime.parse(inputTime, DateTimeFormatter.ofPattern("HH:mm:ss"));
                    time=time+" "+inputTime;
                } else {
                    System.out.println("时间格式不合法,修改场次失败！");
                    return;
                }

                System.out.println("请输入价格：");
                double price=scanner.nextDouble();

                homeList.get(i).setMovieName(movieName);
                homeList.get(i).setPrice(price);
                homeList.get(i).setDate(time);

                System.out.println("修改场次信息成功！");
            }
        }
        if(!flag){
            System.out.println("不存在该场次信息，修改失败！");
        }




    }
    //删除场次
    public void deleteHome(){
        System.out.println("请输入你删除的场次编号：");
        String id=scanner.next();

        boolean flag=false;
        for(int i=0;i<homeList.size();i++){
            if(id==homeList.get(i).getId()){
                flag=true;
                System.out.println("是否确认删除(y/n):");
                String ch=scanner.next();
                if("y".equals(ch)){
                    homeList.remove(i);
                    System.out.println("删除场次成功！");
                }else {
                    System.out.println("取消删除！");
                }
            }
        }
        if(!flag){
            System.out.println("不存在该场次信息，删除失败！");
        }




    }
    //列出所有场次
    public void showHome(){
        if(homeList.size()==0){
            System.out.println("没有场次信息！");
            return;
        }

        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime futureDateTime = currentDateTime.plusDays(7);


        for (Home home:homeList){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime givenDateTime = LocalDateTime.parse(home.getDate(), formatter);
            if (givenDateTime.isBefore(futureDateTime)) {
                home.show();
            }
//            home.show();

        }
    }



    //前台
    public void headMenu(){

        System.out.println("--------------------------------------");
        System.out.println("               前台页面");
        System.out.println("           1.列出所有正在上映影片的信息");
        System.out.println("           2.列出所有正在上映影片的信息");
        System.out.println("           3.列出所有正在上映影片的信息");
        System.out.println("           4.售票");
        System.out.println("           0.退出登录");
        System.out.println("--------------------------------------");
        System.out.println("请输入你的选择：");

    }
    //列出所有正在上映影片的信息
    public void showHomeMovie(){
        if(homeList.size()==0){
            System.out.println("没有上映影片信息！");
            return;
        }

        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime futureDateTime = currentDateTime.plusDays(7);

        for (Home home:homeList){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime givenDateTime = LocalDateTime.parse(home.getDate(), formatter);
            if (givenDateTime.isBefore(futureDateTime)) {
                for(Movie movie:movieList){
                    if(home.getMovieName().equals(movie.getName())){
                        movie.show();
                    }
                }
            }

        }
    }
    //列出所有正在上映影片的信息
    public void showAllHome(){
        if(homeList.size()==0){
            System.out.println("没有场次信息！");
            return;
        }

        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime futureDateTime = currentDateTime.plusDays(7);

        for (Home home:homeList){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime givenDateTime = LocalDateTime.parse(home.getDate(), formatter);
            if (givenDateTime.isBefore(futureDateTime)) {
                home.show();
            }

        }
    }
    //列出所有正在上映影片的信息
    public void showHomeBy(){
        if(homeList.size()==0){
            System.out.println("没有场次信息！");
            return;
        }

        System.out.println("请输入你查询的电影名称：");
        String name=scanner.next();
        System.out.println("请输入你查询的场次编号：");
        String id=scanner.next();

        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime futureDateTime = currentDateTime.plusDays(7);

        int temp=0;
        for (Home home:homeList){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime givenDateTime = LocalDateTime.parse(home.getDate(), formatter);
            if (givenDateTime.isBefore(futureDateTime)
            &&name.equals(home.getMovieName())
            &&id.equals(home.getId())) {
                temp++;
                home.show();
            }

        }

        if(temp==0){
            System.out.println("没有电影放映信息");
        }
    }
    //售票
    public void ticketSale(){
        int index = userLogin();
        if(index!=-1){
            System.out.println("请输入你购买的场次编号：");
            String id=scanner.next();
            System.out.println("请输入你购买的电影名称：");
            String name=scanner.next();

            for (int i=0;i<homeList.size();i++){
                if (name.equals(homeList.get(i).getMovieName()) &&id.equals(homeList.get(i).getId())) {
                    System.out.println("位置信息如下：");
                    homeList.get(i).show();
                    System.out.println("请输入购买的位置坐标x：");
                    int x=scanner.nextInt();
                    if(x<0||x>6){
                        System.out.println("输入有误，购买失败！");
                        return;
                    }
                    System.out.println("请输入购买的位置坐标y：");
                    int y=scanner.nextInt();
                    if(x<0||x>11){
                        System.out.println("输入有误，购买失败！");
                        return;
                    }

                    if(homeList.get(i).getHall().getSeat()[x][y].equals("X")){
                        System.out.println("该座位已经购买，购买失败！");
                        return;
                    }


                    UUID uuid = UUID.randomUUID();
                    String randomCode = uuid.toString();

                    Order order = new Order();
                    order.setId(randomCode);
                    order.setUserId(userList.get(index).getId());
                    order.setHomeId(id);
                    Date currentTime = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String currentTimeString = dateFormat.format(currentTime);
                    order.setDate(currentTimeString);
                    order.setX(x);
                    order.setY(y);
                    order.setFlag(false);

                    //判断两分钟内是否付款
                    long startTime = System.currentTimeMillis();

                    int temp=0;
                    if(userList.get(index).getLevel()==1){
                        System.out.println("您为金牌用户：88 折，是否确认付款(y/n):");
                        String ch=scanner.next();
                        if("y".equals(ch)){
                            temp=1;
                        }else {
                            System.out.println("取消付款，购票失败！");
                            return;
                        }
                    } else if (userList.get(index).getLevel()==2) {
                        System.out.println("您为银牌用户：95 折，是否确认付款(y/n):");
                        String ch=scanner.next();
                        if("y".equals(ch)){
                            temp=2;
                        }else {
                            System.out.println("取消付款，购票失败！");
                            return;
                        }
                    }else if (userList.get(index).getLevel()==3) {
                        System.out.println("您为铜牌用户：不打折，是否确认付款(y/n):");
                        String ch=scanner.next();
                        if("y".equals(ch)){
                            temp=3;
                        }else {
                            System.out.println("取消付款，购票失败！");
                            return;
                        }
                    }

                    long endTime = System.currentTimeMillis();
                    long elapsedTime = endTime - startTime;

                    if (elapsedTime > 2 * 60 * 1000) { // 2分钟，以毫秒为单位
                        System.out.println("付款时间超过两分钟，购票失败。");
                        return; // 结束函数运行
                    }

                    String[][] seat = homeList.get(i).getHall().getSeat();
                    seat[x][y]="X";

                    homeList.get(i).getHall().setSeat(seat);

                    if(temp==1){
                        userList.get(index).setMoney(userList.get(index).getMoney()+homeList.get(i).getPrice()*0.88);
                        userList.get(index).setNumber(userList.get(index).getNumber()+1);

                    } else if (temp==2) {
                        userList.get(index).setMoney(userList.get(index).getMoney()+homeList.get(i).getPrice()*0.95);
                        userList.get(index).setNumber(userList.get(index).getNumber()+1);

                    } else if (temp==3) {
                        userList.get(index).setMoney(userList.get(index).getMoney()+homeList.get(i).getPrice());
                        userList.get(index).setNumber(userList.get(index).getNumber()+1);

                    }


                    orderList.add(order);
                    System.out.println("购买成功！");
                    return;

                }

            }

            System.out.println("购买失败！");
        }

    }



    //用户
    public void userMenu(){

        System.out.println("--------------------------------------");
        System.out.println("               用户页面");
        System.out.println("           1.修改自身密码");
        System.out.println("           2.忘记密码");
        System.out.println("           3.查看所有电影放映信息");
        System.out.println("           4.查看指定电影放映信息");
        System.out.println("           5.购票");
        System.out.println("           6.取票");
        System.out.println("           7.查看购票历史");
        System.out.println("           0.退出登录");
        System.out.println("--------------------------------------");
        System.out.println("请输入你的选择：");

    }

    //用户登录
//    public int userLogin(){
//
//        System.out.println("请输入登录的用户名：");
//        String name=scanner.next();
//        System.out.println("请输入登录的密码：");
//        String pwd=scanner.next();
//
//        for (int i=0;i<userList.size();i++){
//            if(userList.get(i).getName().equals(name)&&userList.get(i).getPwd().equals(pwd)&&userList.get(i).getErrorNumber()<5){
//                System.out.println("登录成功！");
//                return i;
//            }
//        }
//        System.out.println("用户名或者密码错误或被锁定，登录失败！");
//        return -1;
//    }
    public int userLogin() {
        System.out.println("请输入登录的用户名：");
        String name = scanner.next();
        System.out.println("请输入登录的密码：");
        String pwd = scanner.next();

        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getName().equals(name) && user.getPwd().equals(pwd) && user.getErrorNumber() < 5) {
                System.out.println("登录成功！");
                // 重置用户的错误次数为0
                user.setErrorNumber(0);
                return i;
            } else if (user.getName().equals(name) && user.getPwd().equals(pwd) && user.getErrorNumber() >= 5) {
                System.out.println("用户已被锁定，登录失败！");
                return -1;
            }
        }

        System.out.println("用户名或者密码错误，登录失败！");

        // 在登录失败时将错误次数加一
        for (User user : userList) {
            if (user.getName().equals(name)) {
                user.setErrorNumber(user.getErrorNumber() + 1);
                break; // 找到用户后立即跳出循环
            }
        }

        return -1;
    }

    //用户注册
    public static boolean isValidUsername(String username) {
        // 检查用户名长度是否不少于 5 个字符
        if (username.length() < 5) {
            return false;
        }
        // 用户名可以包含字母、数字、下划线等字符，根据需要自定义正则表达式
        String usernameRegex = "^[a-zA-Z0-9_]+$";
        Pattern pattern = Pattern.compile(usernameRegex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }
    public static boolean isValidPassword(String password) {
        // 检查密码长度是否大于 8 个字符
        if (password.length() <= 8) {
            return false;
        }
        // 密码必须包含大小写字母、数字和标点符号中的至少一种
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).+$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    public void userRegister(){

        //    用户信息包括：用户 ID、用户名、用户级别（金牌用户、银牌用户、铜牌用户）、
//    用户注册时间、用户累计消费总金额、用户累计消费次数、用户手机号、用户邮箱；
        String id;
        String name;
        String pwd;//密码
        Integer level;//用户级别（1.金牌用户、2.银牌用户、3.铜牌用户）
        String date;
        double money;
        int number;
        String phone;
        String email;
        int errorNumber;//登录错误次数 5次锁定

        System.out.println("请输入注册的用户ID：");
        id=scanner.next();
        for (int i=0;i<userList.size();i++){
            if(id.equals(userList.get(i).getId())){
                System.out.println("存在该用户信息注册失败！");
                return;
            }
        }
        System.out.println("请输入注册的用户名：");
        name=scanner.next();
        if (!isValidUsername(name)) {
            System.out.println("用户名无效,注册失败");
            return;
        }
        for (int i=0;i<userList.size();i++){
            if(name.equals(userList.get(i).getName())){
                System.out.println("存在该用户信息注册失败！");
                return;
            }
        }

        System.out.println("请输入注册的密码：");
        pwd=scanner.next();
        if (!isValidPassword(pwd)) {
            System.out.println("密码无效,注册失败！");
            return;
        }
        System.out.println("请输入注册的用户级别（1.金牌用户、2.银牌用户、3.铜牌用户）：");
        level=scanner.nextInt();
        if(level<1||level>3){
            System.out.println("输入有误，注册失败！");
            return;
        }
        Date currentTime = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = dateFormat.format(currentTime);
        money=0;
        number=0;

        System.out.println("请输入注册的手机号码：");
        phone=scanner.next();
        System.out.println("请输入注册的邮箱：");
        email=scanner.next();
        errorNumber=0;
        User user = new User(id, name, pwd, level, date, money, number, phone, email, errorNumber);
        userList.add(user);

        System.out.println("注册成功！");

    }

    //用户修改自身密码
    public void userUpdatePwd(){
        System.out.println("请输入用户名：");
        String name=scanner.next();
        System.out.println("请输入旧密码：");
        String pwd=scanner.next();

        for (int i=0;i<userList.size();i++){
            if(userList.get(i).getName().equals(name)&&userList.get(i).getPwd().equals(pwd)){

                System.out.println("请输入修改后的密码：");
                String pass=scanner.next();
                userList.get(i).setPwd(pass);
                System.out.println("修改密码成功！");
                return;
            }
        }
        System.out.println("用户名或者密码错误，修改失败！");
    }
    //用户找回密码
    public void userGetPwd(){
        System.out.println("请输入找回的用户名：");
        String name=scanner.next();
        System.out.println("请输入找回的邮箱：");
        String email=scanner.next();

        for (int i=0;i<userList.size();i++){
            if(userList.get(i).getName().equals(name)&&userList.get(i).getEmail().equals(email)){

                System.out.println("密码为："+userList.get(i).getPwd());
                return;
            }
        }
        System.out.println("不存在该信息，找回失败！");
    }

    //取票
    public void userGetTicket(int index){
        int temp=0;
        System.out.println("您的所有购票信息如下：");
        for (int i=0;i< orderList.size();i++){
            if(userList.get(index).getId().equals(orderList.get(i).getUserId())){
                temp++;
                orderList.get(i).show();
            }
        }
        if(temp==0){
            System.out.println("您还没有购票信息，取票失败！");
            return;
        }
        System.out.println("请输入你取票的编号：");
        String id=scanner.next();
        for (int i=0;i< orderList.size();i++){
            if(userList.get(index).getId().equals(orderList.get(i).getUserId())
            &&id.equals(orderList.get(i).getId())){
                if(orderList.get(i).isFlag()){
                    System.out.println("已经取票，取票失败");
                    return;
                }
                System.out.println("取票成功，信息如下：");
                orderList.get(i).setFlag(true);
                orderList.get(i).show();
                return;
            }
        }

        System.out.println("取票信息不存在，取票失败！");
    }
    //查看购票历史
    public void userSeeTicketHistory(int index){
        int temp=0;
        System.out.println("您的所有购票信息如下：");
        for (int i=0;i< orderList.size();i++){
            if(userList.get(index).getId().equals(orderList.get(i).getUserId())){
                temp++;
                orderList.get(i).show();
            }
        }
        if(temp==0){
            System.out.println("您还没有购票信息，查看购票历史失败！");
            return;
        }
    }

}
