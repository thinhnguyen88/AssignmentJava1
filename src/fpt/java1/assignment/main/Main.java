/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.java1.assignment.main;

import static fpt.java1.assignment.controller.Controller.input;
import static fpt.java1.assignment.controller.Controller.start;
import java.util.Scanner;

/**
 *
 * @author Thinh Nguyen
 */
public class Main {

    private static int temp;

    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
            try {
                input();
                temp = new Scanner(System.in).nextInt();
                if (temp > 0 && temp < 6) {
                    flag = false;
                } else {
                    System.out.println(" Loi : !!! Ban hay nhap gia tri tu 1-5 !!!");
                }
            } catch (Exception e) {
                System.out.println(" Loi : !!! Ban hay nhap gia tri so !!!");
            }
        }
        start(temp);
    }
}
