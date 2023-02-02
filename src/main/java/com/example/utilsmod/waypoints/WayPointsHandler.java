package com.example.utilsmod.waypoints;


import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class WayPointsHandler {
    protected static ArrayList<ArrayList<Integer>> coords = new ArrayList<ArrayList<Integer>>();
    protected static List<String> titles = new ArrayList<>();
    public static HashMap<String,ArrayList<Integer>> map = new HashMap<>();
    public static Gson gs = new Gson();

    public static void Add(ArrayList<Integer> coord,String title) throws IOException {
        coords.add(coord);
        titles.add(title);
        map.put(title,coord);
        AddToFile(map);
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
        writer.write(json);
//        System.out.println('a');
//        for(int o = 0; o <  coords.size();o++){
//            for(int i = 0; i <  coords.size();i++){
//                String scoords = coords.get(o).toString();
//                writer.write(scoords + titles.get(o) +"\n");
//                System.out.println(scoords);
//            }
//        }


        writer.close();
    }

    public static void ReadFile() throws FileNotFoundException {
        File file = new File("Desktop/coords.json");
        Scanner sc = new Scanner(file);

        String info = "";
        while (sc.hasNextLine()){
            info = info.concat(sc.nextLine() + "\n");
        }
    }

    public static class CoordsName{
        String title;
        public CoordsName(String title){
            this.title = title;
        }
        public static class Coords{
            ArrayList<Integer> coords = new ArrayList<Integer>();
            public Coords(ArrayList<Integer> coords){
                this.coords = coords;
            }
        }
    }
}
