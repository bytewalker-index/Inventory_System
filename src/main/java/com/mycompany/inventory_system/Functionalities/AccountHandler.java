/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventory_system.Functionalities;

import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;
/**
 *
 * @author admin
 */
public class AccountHandler {
    public static HashMap<String, String> accounts = new HashMap<String, String>();
    public static HashMap<String, HashMap<String, Item>> account_items = new HashMap<String, HashMap<String, Item>>();
    public static HashMap<String, Item> items;
    public static String username;
    public static String password;
    
    public static String db_path; //file location
    public static String file_name = "/data.txt";
    
    
    public static void InitFileLocation() {
         AccountHandler.db_path = System.getProperty("user.dir") + file_name;
    }
    
    public static void SaveFile() {
        try {
        File file = new File(db_path);
        if(file.exists()) file.delete();
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(String.valueOf(accounts.size()).getBytes());
        stream.write('\n');
        for(Map.Entry<String, String> entry : accounts.entrySet()) {
            stream.write(entry.getKey().getBytes());
            stream.write('\n');
             stream.write(entry.getValue().getBytes());
            stream.write('\n');
           int item_count = account_items.get(entry.getKey() + entry.getValue()).size();
           stream.write(String.valueOf(item_count).getBytes());
            stream.write('\n');
           for(Map.Entry<String, Item> entry_items : account_items.get(entry.getKey() + entry.getValue()).entrySet()) {
            stream.write(entry_items.getKey().getBytes());
            stream.write('\n');
            stream.write(String.valueOf(entry_items.getValue().quantity).getBytes());
            stream.write('\n');
           }
        }
        stream.write('\n');
        stream.close();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    
    public static boolean ReadFile() {
        accounts.clear();
        account_items.clear();
        try {
        InputStreamReader stream = new InputStreamReader(new FileInputStream(db_path));
        BufferedReader reader = new BufferedReader(stream);
        int size = Integer.parseInt(reader.readLine());
//        System.out.println(size);
        int i = 0;
        for(i = 0; i < size; i++) {
            String key = reader.readLine();
            String value = reader.readLine();
           // System.out.println("key " + key);
           //  System.out.println("value " + value);
            accounts.put(key, value);
            account_items.put(key+value, new HashMap<String, Item>());
            HashMap<String, Item> map_item = account_items.get(key+value);
             int item_size = Integer.parseInt(reader.readLine());
             for(int j = 0; j < item_size; j++) {
                 String item_name = reader.readLine();
                 int item_quantity = Integer.parseInt(reader.readLine());
                 Item item = new Item();
                 item.name = item_name;
                 item.quantity = item_quantity;
                 map_item.put(item_name, item);
             }
        }
        
        reader.close();
        stream.close();
        } catch(Exception e) {
          return false;
        }
        return true;
    }
}
