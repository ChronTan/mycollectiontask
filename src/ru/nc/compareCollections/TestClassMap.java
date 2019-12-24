package ru.nc.compareCollections;

import java.util.*;

public class TestClassMap {

    static final int SIZE=10000;

    public static void main(String[] args) {
        Map<String, Long> allTime=new HashMap<>();

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        Random random=new Random();
        int z=random.nextInt(1000);

        long startTimeAddHashMap = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            hashMap.put(i,z);
        }
        long endTimeAddHashMap = System.nanoTime() - startTimeAddHashMap;
        allTime.put("HashMapAdd", endTimeAddHashMap);
        long startTimeAddLinkedHashMap = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            linkedHashMap.put(i,z);
        }
        long endTimeAddLinkedHashMap = System.nanoTime() - startTimeAddLinkedHashMap;
        allTime.put("LinkedHashMapAdd", endTimeAddLinkedHashMap);
        long startTimeAddTreeMap = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            treeMap.put(i,z);
        }
        long endTimeAddTreeSet = System.nanoTime() - startTimeAddTreeMap;
        allTime.put("TreeMapAdd", endTimeAddTreeSet);

        long startTimeInsertHashMap = System.nanoTime();
        for (int i = hashMap.size(); i < SIZE*2; i++) {
            hashMap.put(i,z);
        }
        long endTimeInsertHashMap = System.nanoTime() - startTimeInsertHashMap;
        allTime.put("HashMapInsert", endTimeInsertHashMap);
        long startTimeInsertLinkedHashMap = System.nanoTime();
        for (int i = linkedHashMap.size(); i < SIZE*2; i++) {
            linkedHashMap.put(i,z);
        }
        long endTimeInsertLinkedHashMap = System.nanoTime() - startTimeInsertLinkedHashMap;
        allTime.put("LinkedHashMapInsert", endTimeInsertLinkedHashMap);
        long startTimeInsertTreeMap = System.nanoTime();
        for (int i = treeMap.size(); i < SIZE*2; i++) {
            treeMap.put(i,z);
        }
        long endTimeInsertTreeMap = System.nanoTime() - startTimeInsertTreeMap;
        allTime.put("TreeMapInsert", endTimeInsertTreeMap);

        long startTimeDeleteHashMap = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            hashMap.remove(60,z);
        }
        long endTimeDeleteHashMap = System.nanoTime() - startTimeDeleteHashMap;
        allTime.put("HashMapDelete", endTimeDeleteHashMap);
        long startTimeDeleteLinkedHashMap = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            linkedHashMap.remove(60,z);
        }
        long endTimeDeleteLinkedHashMap = System.nanoTime() - startTimeDeleteLinkedHashMap;
        allTime.put("LinkedHashMapDelete", endTimeDeleteLinkedHashMap);
        long startTimeDeleteTreeMap = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            treeMap.remove(60,z);
        }
        long endTimeDeleteTreeMap = System.nanoTime() - startTimeDeleteTreeMap;
        allTime.put("TreeMapDelete", endTimeDeleteTreeMap);
        Map<String, Long> allData = new TreeMap<String, Long>(allTime);


        long mas[]=new long[3];
        TestClassMap testClassMap = new TestClassMap();
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
        System.out.println(testClassMap.index(mas));
        k=0;

        for (Map.Entry<String, Long> element : allData.entrySet()){
            String key = element.getKey();
            Long value = element.getValue();
            if(key.endsWith("Insert")){
                System.out.print(key + " : " + value+ " | ");
                mas[k]=value;
                k++;
            }
        }
        System.out.println(testClassMap.index(mas));
        k=0;
        for (Map.Entry<String, Long> element : allData.entrySet()){
            String key = element.getKey();
            Long value = element.getValue();
            if(key.endsWith("Delete")){
                System.out.print(key + " : " + value+ " | ");
                mas[k]=value;
                k++;
            }
        }
        System.out.println(testClassMap.index(mas));
        k=0;
        System.out.println("");
    }

    public String index(long mas[]){
        long min=10000000;
        int k=0;
        for(int i=0;i< mas.length;i++){
            if(mas[i]<min){
                min=mas[i];
                k=i;
            }
        }
        switch (k){
            case 0:
                return "HashMap better";
            case 1:
                return "LinkedHashMap better";
            case 2:
                return "TreeMap better";
            default:
                return "None";
        }
    }
}

