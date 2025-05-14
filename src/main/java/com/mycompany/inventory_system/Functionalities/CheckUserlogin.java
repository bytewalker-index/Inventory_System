/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventory_system.Functionalities;

/**
 *
 * @author paul
 */
public class CheckUserlogin {
    
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
}
