/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventory_system.Functionalities;

import javax.swing.*;
import java.util.*;
/**
 *
 * @author paul
 */
public class CheckUserlogin {
    /*
    String user;
    String password;
    
    public String checkUser(String user, String password){       
        
        this.user = user;
        this.password = password;
        
        if (user.equals("root") && password.equals("admin")){
            return "correct";
        }else{
            return "incorrect";
        }
        
    }
*/
     //0 - success
    //non-zero - failed
    public static int Login(String username, String password) {
        AccountHandler.ReadFile();
        if(username.equals("")) {
            JOptionPane.showMessageDialog(null,"empty username");
            return 1;
        }
        if(password.equals("")) {
            JOptionPane.showMessageDialog(null,"empty password");
            return 1;
        }
        if(AccountHandler.accounts.containsKey(username) && AccountHandler.accounts.get(username).equals(password)) {
          AccountHandler.username = username;
          AccountHandler.password = password;
          AccountHandler.items = AccountHandler.account_items.get(username + password);
          LogRecorder.records = LogRecorder.account_records.get(username + password);
          return 0;
        }
         JOptionPane.showMessageDialog(null,"account does not exist, Maybe you should register first. ");
            return 1;
    } 
    
    
    public static int SignUp(String username, String password) {
        if(!AccountHandler.accounts.containsKey(username)) {
          AccountHandler.username = username;
          AccountHandler.password = password;
          AccountHandler.accounts.put(username, password);
          AccountHandler.account_items.put(username + password, new HashMap<String, Item>());
          AccountHandler.items = AccountHandler.account_items.get(username + password);
          
          LogRecorder.account_records.put(username + password, new ArrayList<String>());
          LogRecorder.records = LogRecorder.account_records.get(username + password);
          
          AccountHandler.SaveFile();
          return 0;
        }
         JOptionPane.showMessageDialog(null, "username already exist.");
         return 1;
    }
    
    
    public static void LogOut() {
        AccountHandler.username = null;
        AccountHandler.password = null;
       // AccountHandler.items = null;
    }
}
