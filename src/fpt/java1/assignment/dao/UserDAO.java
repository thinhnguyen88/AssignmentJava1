/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.java1.assignment.dao;

import fpt.java1.assignment.jdbc.DBUtil;
import fpt.java1.assignment.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Thinh Nguyen
 */
public class UserDAO {
    private static User objUser;

    public static void insertUser(User objUser) {
        Connection con;
        PreparedStatement pstm;
        try {
            con = DBUtil.openConnection();
            pstm = con.prepareStatement("insert into T_User values (?,?,?,?,?)");
            pstm.setString(1, objUser.getId());
            pstm.setString(2, objUser.getName());
            pstm.setString(3, objUser.getUsername());
            pstm.setString(4, objUser.getPassword());
            pstm.setBoolean(5, objUser.getStatus());
            pstm.execute();
            System.out.println("Insert User " + objUser.getName() + " Success !!!");
        } catch (SQLException e) {
            System.out.println("Loi insert DB : " + e.getMessage());
        }
    }
    
    public static void deleteUser(User objUser) {
        Connection con;
        PreparedStatement pstm;
        try {
            con = DBUtil.openConnection();
            pstm = con.prepareStatement("delete from T_User where id = ?");
            pstm.setString(1, objUser.getId());
            pstm.execute();
            System.out.println("Delete User voi id = " + objUser.getId()+ " Success !!!");
        } catch (SQLException e) {
            System.out.println("Loi DB : " + e.getMessage());
        }
    }

    public static ArrayList<User> showAllUser() {
        ArrayList<User> listUser = new ArrayList<>();
        Connection con;
        PreparedStatement pstm;
        ResultSet rs;
        try {
            con = DBUtil.openConnection();
            pstm = con.prepareStatement("Select * from T_User");
            rs = pstm.executeQuery();

            while (rs.next()) {
                objUser = new User();
                objUser.setId(rs.getString(1));
                objUser.setName(rs.getString(2));
                objUser.setUsername(rs.getString(3));
                objUser.setPassword(rs.getString(4));
                objUser.setStatus(true);
                listUser.add(objUser);
            }
        } catch (SQLException e) {
            System.out.println("Loi insert DB : " + e.getMessage());
        }
        return listUser;
    }

    public static boolean checkExistUser(String id) {
        boolean flag = false;
        Connection con = DBUtil.openConnection();
        PreparedStatement pstm;
        ResultSet rs;
        try {
            pstm = con.prepareStatement("select * from T_User where id = ?");
            pstm.setString(1, id);
            rs = pstm.executeQuery();
            while(rs.next()) {
                flag = true;
            }
        } catch (SQLException e) {
        }
        return flag;
    }
    
    public static void update1User(User objUserNew) {
        Connection con = DBUtil.openConnection();
        PreparedStatement pstm;
        try {
            pstm = con.prepareStatement("update T_USER set name = ? , username = ? , password = ? where id = ?");
            pstm.setString(1, objUserNew.getName());
            pstm.setString(2, objUserNew.getUsername());
            pstm.setString(3, objUserNew.getPassword());
            pstm.setString(4, objUserNew.getId());
            int i = pstm.executeUpdate();
            if(i==1) {
                System.out.println("Ban da update thanh cong User voi id = " + objUserNew.getId() );
            }
        } catch (SQLException e) {
        }
    }
    
}