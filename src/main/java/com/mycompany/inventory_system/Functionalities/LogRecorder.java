/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventory_system.Functionalities;

import java.time.LocalDateTime;
import java.util.*;
/**
 *
 * @author admin
 */
public class LogRecorder {
    public static ArrayList<String> records;
    public static HashMap<String, ArrayList<String>> account_records = new HashMap<String, ArrayList<String>>();
    public static final int MAX_RECORD = 50;
    
    public static void Record(String s) {
       if(records.size() >= MAX_RECORD)
        records.remove(0);
        LocalDateTime currentDateTime = LocalDateTime.now();
        StringBuffer buffer = new StringBuffer();
        
        int hour = currentDateTime.getHour();
        boolean am = false;
         if(hour > 12) {
            am = false;
            hour -= 12;
         } else
             am = true;
         buffer.append(" * ");
         buffer.append(String.valueOf(hour));
         buffer.append(":");
         buffer.append(String.valueOf(currentDateTime.getMinute()));
         buffer.append(am ? " AM" : " PM");
         buffer.append("  ");
         buffer.append(String.valueOf(currentDateTime.getMonth().getValue()));
         buffer.append("/");
         buffer.append(String.valueOf(currentDateTime.getDayOfMonth()));
         buffer.append("/");
         buffer.append(String.valueOf(currentDateTime.getYear()));
         buffer.append("  ");
         buffer.append(s);
        records.add(buffer.toString());
    }
}
