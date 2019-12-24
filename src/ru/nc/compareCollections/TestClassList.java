package ru.nc.compareCollections;

import java.util.*;

public class TestClassList {

    public static void main(String[] args) {

        Map<String, Long> allTime=new HashMap<>();
        List<Integer> arrList=new ArrayList<>();
        List<Integer> arrLinkedList=new LinkedList<>();
        Random random=new Random();

        int z=random.nextInt(1000);
        long startTimeAddArray = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrList.add(z);
        }
        long endTimeAddArray = System.nanoTime() - startTimeAddArray;
        allTime.put("ArrayListAdd", endTimeAddArray);
        long startTimeAddLinked = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrLinkedList.add(z);
        }
        long endTimeAddLinked = System.nanoTime() - startTimeAddLinked;
        allTime.put("LinkedListAdd", endTimeAddLinked);

        long startTimeInsertArray = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrList.add(40,z);
        }
        long endTimeInsertArray = System.nanoTime() - startTimeInsertArray;
        allTime.put("ArrayListInsert", endTimeInsertArray);
        long startTimeInsertLinked = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrLinkedList.add(10,z);
        }
        long endTimeInsertLinked = System.nanoTime() - startTimeInsertLinked;
        allTime.put("LinkedListInsert", endTimeInsertLinked);

        long startTimeDeleteArray = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrList.remove(40);
        }
        long endTimeDeleteArray = System.nanoTime() - startTimeDeleteArray;
        allTime.put("ArrayListDelete", endTimeDeleteArray);
        long startTimeDeleteLinked = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrLinkedList.remove(50);
        }
        long endTimeDeleteLinked = System.nanoTime() - startTimeDeleteLinked;
        allTime.put("LinkedListDelete", endTimeDeleteLinked);
        Map<String, Long> allData = new TreeMap<String, Long>(allTime);


        long mas[]=new long[2];
        int k=0;
        for (Map.Entry<String, Long> element : allData.entrySet()){
            String key = element.getKey();
            Long value = element.getValue();
            if(key.endsWith("Add")){
                System.out.print(key + " : " + value+ " | ");
                mas[k]=value;
                k++;
            }
        }
        if(mas[0]<mas[1]){
            System.out.println("ArrayList better");
            k=0;
        }else{
            System.out.println("ILinkedList better");
            k=0;
        }
        for (Map.Entry<String, Long> element : allData.entrySet()){
            String key = element.getKey();
            Long value = element.getValue();
            if(key.endsWith("Insert")){
                System.out.print(key + " : " + value+ " | ");
                mas[k]=value;
                k++;
            }
        }
        if(mas[0]<mas[1]){
            System.out.println("ArrayList better");
            k=0;
        }else{
            System.out.println("ILinkedList better");
            k=0;
        }
        for (Map.Entry<String, Long> element : allData.entrySet()){
            String key = element.getKey();
            Long value = element.getValue();
            if(key.endsWith("Delete")){
                System.out.print(key + " : " + value+ " | ");
                mas[k]=value;
                k++;
            }
        }
        if(mas[0]<mas[1]){
            System.out.println("ArrayList better");
            k=0;
        }else{
            System.out.println("ILinkedList better");
            k=0;
        }
        System.out.println("");
    }
}


