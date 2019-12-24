package ru.nc.compareCollections;

import ru.nc.myList.ILinkedList;
import ru.nc.myList.MyLinkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class TestClassMyLinkedList {

    public static void main(String[] args) {
        Map<String, Long> allTime=new HashMap<>();
        ILinkedList<Integer> myList = new MyLinkedList<>();

        Random random = new Random();

        int z = random.nextInt(1000);
        long startTimeAddmyList = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            myList.add(z);
        }

        long endTimeAddMyList = System.nanoTime() - startTimeAddmyList;
        allTime.put("myListAdd", endTimeAddMyList);
        long startTimeInsertMyList = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            myList.add(40, z);
        }
        long endTimeInsertArray = System.nanoTime() - startTimeInsertMyList;
        allTime.put("MyListInsert", endTimeInsertArray);
        long startTimeDeleteMyList = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            myList.remove(40);
        }
        long endTimeDeleteMyList = System.nanoTime() - startTimeDeleteMyList;
        allTime.put("MyListDelete", endTimeDeleteMyList);
        Map<String, Long> allData = new TreeMap<String, Long>(allTime);

        for (Map.Entry<String, Long> element : allData.entrySet()){
            String key = element.getKey();
            Long value = element.getValue();
                System.out.print(key + " : " + value+ " | ");
        }
    }
}
