package com.example.utilsmod.waypoints;


import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class WayPointsHandler {
    protected static ArrayList<ArrayList<Integer>> coords = new ArrayList<ArrayList<Integer>>();
    protected static List<String> titles = new ArrayList<>();
    public static HashMap<String,ArrayList<Integer>> Mainmap = new HashMap<>();
    public static String info = "";
    public static Gson gs = new Gson();

    public static void Add(ArrayList<Integer> coord,String title) throws IOException {
        coords.add(coord);
        titles.add(title);
        Mainmap.put(title,coord);
        AddToFile(Mainmap);
    }

    public void Remove(String rTitle){
        for(int i =0;i<titles.size();i++){
            if(rTitle == titles.get(i)){
                titles.remove(i);
                coords.remove(i);
            }
        }
    }

    private static void AddToFile(HashMap<String,ArrayList<Integer>> map) throws IOException {
        System.out.println("scoords");
        String json = gs.toJson(map);

        File file = new File("C:\\Users\\psrek\\Desktop\\coords.json");
        FileWriter writer = new FileWriter("C:\\Users\\psrek\\Desktop\\coords.json");
        writer.write(info + json);
        writer.close();
    }

    public static void ReadFile() throws FileNotFoundException {
        File file = new File("C:\\Users\\psrek\\Desktop\\coords.json");
        Scanner sc = new Scanner(file);
        info = "";
        while (sc.hasNextLine()) {
            info = info.concat(sc.nextLine() + "\n");
            System.out.println(info);
        }
//        TypeToken<HashMap<String,ArrayList<Integer>>> maptype = new TypeToken<HashMap<String,ArrayList<Integer>>>(){};
//
//        HashMap<String,ArrayList<Integer>> map = gs.fromJson(info, (Type) maptype);
//        Mainmap = map;



    }
}
