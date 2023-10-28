package com.movie;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Scanner scanner = new Scanner(System.in);
        Service service = new Service();
        service.init();
        service.initHall();
        while(true){
            int chioce;
            service.menu();
            chioce=scanner.nextInt();
            switch(chioce){

                case 1:
                {
                    Integer index = service.adminLogin();
                    if(index!=-1){
                        adminLabel:
                        while(true){
                            service.adminMenu();
                            chioce=scanner.nextInt();
                            switch(chioce){

                                case 1:
                                    service.adminUpdatePwd();
                                    break;
                                case 2:
                                    service.adminResetUserPwd();
                                    break;
                                case 3:
                                    service.adminShowAllUser();
                                    break;
                                case 4:
                                    service.adminDeleteUser();
                                    break;
                                case 5:
                                    service.adminQueryUser();
                                    break;
                                case 0:
                                    System.out.println("谢谢使用！");
                                    break adminLabel;
                                default:
                                    System.out.println("输入有误，请重新输入！");
                                    break;
                            }
                        }
                    }
                }
                break;
                case 2:
                {
                    Integer index = service.mangerLogin();
                    if(index!=-1){
                        goodsLabel:
                        while(true){
                            service.managerMenu();
                            chioce=scanner.nextInt();
                            switch(chioce){

                                case 1:
                                    service.showMovie();
                                    break;
                                case 2:
                                    service.addMovie();
                                    break;
                                case 3:
                                    service.updateMovie();
                                    break;
                                case 4:
                                    service.deleteMovie();
                                    break;
                                case 5:
                                    service.queryMovie();
                                    break;
                                case 6:
                                    service.addHome();
                                    break;
                                case 7:
                                    service.updateHome();
                                    break;
                                case 8:
                                    service.deleteHome();
                                    break;
                                case 9:
                                    service.showHome();
                                    break;
                                case 0:
                                    System.out.println("谢谢使用！");
                                    break goodsLabel;
                                default:
                                    System.out.println("输入有误，请重新输入！");
                                    break;
                            }
                        }
                    }
                }
                break;
                case 3:
                {
                    int index=service.headLogin();
                    if(index!=-1){
                        adminLabel:
                        while(true){
                            service.headMenu();
                            chioce=scanner.nextInt();
                            switch(chioce){

                                case 1:
                                    service.showHomeMovie();
                                    break;
                                case 2:
                                    service.showAllHome();
                                    break;
                                case 3:
                                    service.showHomeBy();
                                    break;
                                case 4:
                                    service.ticketSale();
                                    break;
                                case 0:
                                    System.out.println("谢谢使用！");
                                    break adminLabel;
                                default:
                                    System.out.println("输入有误，请重新输入！");
                                    break;
                            }
                        }
                    }
                }
                break;
                case 4:
                {
                    int index=service.userLogin();
                    if(index!=-1){
                        label4:
                        while(true){
                            service.userMenu();
                            chioce=scanner.nextInt();
                            switch(chioce){

                                case 1:
                                    service.userUpdatePwd();
                                    break;
                                case 2:
                                    service.userGetPwd();
                                    break;
                                case 3:
                                    service.showAllHome();
                                    break;
                                case 4:
                                    service.showHomeBy();
                                    break;
                                case 5:
                                    service.ticketSale();
                                    break;
                                case 6:
                                    service.userGetTicket(index);
                                    break;
                                case 7:
                                    service.userSeeTicketHistory(index);
                                    break;
                                case 0:
                                    System.out.println("谢谢使用！");
                                    break label4;
                                default:
                                    System.out.println("输入有误，请重新输入！");
                                    break;
                            }
                        }
                    }
                }
                break;
                case 5:
                    service.userRegister();
                    break;
                case 0:
                    System.out.println("谢谢使用！");
                    System.exit(0);
                default:
                    System.out.println("输入有误，请重新输入！");
                    break;
            }
        }

    }


}
