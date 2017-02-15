/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.java1.assignment.controller;

import fpt.java1.assignment.model.User;
import java.util.Scanner;

/**
 *
 * @author Thinh Nguyen
 */
public class Controller {

    public static void input() {
        System.out.println("-------------------------------------------------");
        System.out.println("|********* Chuong trinh quan ly User ***********|");
        System.out.println("-------------------------------------------------");
        System.out.println("| 1. Them moi User                              |");
        System.out.println("| 2. Hien thi danh sach User                    |");
        System.out.println("| 3. Sua thong tin User                         |");
        System.out.println("| 4. Xoa User                                   |");
        System.out.println("| 5. Thoat                                      |");
        System.out.println("-------------------------------------------------");
        System.out.print("| Chon :  ");
    }

    public static User addUser() {
        User objUser = new User();
        System.out.println("-------------------------------------------------");
        System.out.println("|**************** Them moi User *****************|");
        System.out.println("-------------------------------------------------");
        System.out.print("Nhap User ID : ");
        objUser.setId(new Scanner(System.in).nextInt());
        System.out.print("Nhap Ten User : ");
        objUser.setName(new Scanner(System.in).nextLine());
        System.out.print("Nhap username : ");
        objUser.setUsername(new Scanner(System.in).nextLine());
        System.out.print("Nhap password : ");
        objUser.setPassword(new Scanner(System.in).nextLine());
        objUser.setStatus(true);
        return objUser;
    }
    
    public static void showAll() {
        System.out.println("----cho nay se show het danh sach user ra ------");
    }
    
    public static User changeUser() {
        User objUser = new User();
        System.out.println("-------------------------------------------------");
        System.out.println("|************** Sua thong tin User **************|");
        System.out.println("-------------------------------------------------");
        System.out.print("Nhap User ID : ");
        objUser.setId(new Scanner(System.in).nextInt());
        System.out.print("Nhap Ten User : ");
        objUser.setName(new Scanner(System.in).nextLine());
        System.out.print("Nhap username : ");
        objUser.setUsername(new Scanner(System.in).nextLine());
        System.out.print("Nhap password : ");
        objUser.setPassword(new Scanner(System.in).nextLine());
        objUser.setStatus(true);
        return objUser;
    }
    
    public static int deleteUser() {
        System.out.println("-------------------------------------------------");
        System.out.println("|************** Sua thong tin User **************|");
        System.out.println("-------------------------------------------------");
        System.out.print("Nhap User ID can xoa : ");
        int temp = new Scanner(System.in).nextInt();
        return temp;
    }
    
    public static void exit() {
        System.out.println("--- Tam biet ! Cam on ban da su dung chuong trinh ---");
        System.exit(0);
    }

    public static void start(int temp) {
        User objUser;
        switch (temp) {
            case 1:
                objUser = addUser();
                System.out.println(objUser);
                break;
            case 2:
                showAll();
                break;
            case 3:
                changeUser();
                break;
            case 4:
                deleteUser();
                break;
            case 5:
                exit();
                break;
            default:
                System.out.println("Dong nay khong bao gio in ra dau =))");
                break;
        }
    }
}
