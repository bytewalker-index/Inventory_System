/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventory_system.Functionalities;

/**
 *
 * @author admin
 */
public class DateChecker {
    //date format checker
  public static void CheckDate(String date) {
     String[] tokens = null;
     if(date.contains("//"))
      tokens = date.split("//");
     else if(date.contains("/"))
      tokens = date.split("/");
     else if(date.contains("-"))
      tokens = date.split("-");
     else
       throw new RuntimeException("date format should be [mm/dd/yy], [mm//dd//yy], [mm-dd-yy]");
      if(tokens.length != 3)
         throw new RuntimeException("date format should be [mm/dd/yy], [mm//dd//yy], [mm-dd-yy]");
      for(int i = 0; i < tokens.length; i++) {
          try {
          int aa = Integer.parseInt(tokens[i]);
          if(aa < 0)
              throw new RuntimeException("date format should be [mm/dd/yy], [mm//dd//yy], [mm-dd-yy]");
          } catch(Exception e) {
              throw new RuntimeException("date format should be [mm/dd/yy], [mm//dd//yy], [mm-dd-yy]");
          }
      }
  }
}
