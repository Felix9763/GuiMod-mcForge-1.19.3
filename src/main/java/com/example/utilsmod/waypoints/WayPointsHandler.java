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
    public static String json;
    public static Gson gs = new Gson();

    public static void Add(ArrayList<Integer> coord,String title){
        coords.add(coord);
        titles.add(title);
        Mainmap.put(title,coord);
        ConvertToJson(Mainmap);
        try {SaveToFile(json);} catch (IOException e) {throw new RuntimeException(e);}
    }

    public void Remove(String rTitle){
        for(int i =0;i<titles.size();i++){
            if(rTitle == titles.get(i)){
                titles.remove(i);
                coords.remove(i);
            }
        }
    }

    private static void ConvertToJson(HashMap<String,ArrayList<Integer>> map){
        System.out.println("scoords");
        json = gs.toJson(map);
    }


    public static void SaveToFile(String json) throws IOException {
        File file = new File("C:\\Users\\psrek\\Desktop\\coords.json");
        FileWriter writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }
    public static void ReadFile() throws FileNotFoundException {
        File file = new File("C:\\Users\\psrek\\Desktop\\coords.json");
        Scanner sc = new Scanner(file);
        info = "";
        while (sc.hasNextLine()) {
            info = info.concat(sc.nextLine());
            System.out.println(info);
        }
       Type maptype = new TypeToken<HashMap<String,ArrayList<Integer>>>(){}.getType();

        HashMap<String,ArrayList<Integer>> map = gs.fromJson(info, maptype);
        Mainmap = map;




    }
}