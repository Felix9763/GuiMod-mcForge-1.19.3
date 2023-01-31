package com.example.utilsmod.waypoints;

import java.util.ArrayList;
import java.util.List;

public class WayPointsHandler {
    public ArrayList<ArrayList<Integer>> coords = new ArrayList<ArrayList<Integer>>();
    public List<String> titles = new ArrayList<>();

    public void Add(ArrayList<Integer> coord,String title){
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
