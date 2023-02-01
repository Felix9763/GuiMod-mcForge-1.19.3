package com.example.utilsmod.waypoints;

import java.util.ArrayList;
import java.util.List;

public class WayPointsHandler {
    protected static ArrayList<ArrayList<Integer>> coords = new ArrayList<ArrayList<Integer>>();
    protected static List<String> titles = new ArrayList<>();

    public static void Add(ArrayList<Integer> coord,String title){
        coords.add(coord);
        titles.add(title);
    }

    public void Remove(String rTitle){
        for(int i =0;i<titles.size();i++){
            if(rTitle == titles.get(i)){
                titles.remove(i);
                coords.remove(i);
            }
        }
    }
}
