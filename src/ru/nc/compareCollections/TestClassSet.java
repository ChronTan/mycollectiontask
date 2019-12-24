package ru.nc.compareCollections;

import java.util.*;

public class TestClassSet {

    public static void main(String[] args) {
        Map<String, Long> allTime=new HashMap<>();

        HashSet<Integer> hashSet = new HashSet<>();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        Random random=new Random();
        int z=random.nextInt(1000);

        long startTimeAddHashSet = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            hashSet.add(z);
        }
        long endTimeAddHashSet = System.nanoTime() - startTimeAddHashSet;
        allTime.put("HashSetAdd", endTimeAddHashSet);

        long startTimeAddLinkedhashSet = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedHashSet.add(z);
        }
        long endTimeAddLinkedHashSet = System.nanoTime() - startTimeAddLinkedhashSet;
        allTime.put("LinkedHashSetAdd", endTimeAddLinkedHashSet);

        long startTimeAddTreeSet = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            treeSet.add(z);
        }
        long endTimeAddTreeSet = System.nanoTime() - startTimeAddTreeSet;
        allTime.put("TreeSetAdd", endTimeAddTreeSet);

        long startTimeInsertHashSet = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            hashSet.add(z);
        }
        long endTimeInsertHashSet = System.nanoTime() - startTimeInsertHashSet;
        allTime.put("HashSetInsert", endTimeInsertHashSet);

        long startTimeInsertLinkedHashSet = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedHashSet.add(z);
        }
        long endTimeInsertLinkedHashSet = System.nanoTime() - startTimeInsertLinkedHashSet;
        allTime.put("LinkedHashSetInsert", endTimeInsertLinkedHashSet);

        long startTimeInsertTreeSet = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            treeSet.add(z);
        }
        long endTimeInsertTreeSet = System.nanoTime() - startTimeInsertTreeSet;
        allTime.put("TreeSetInsert", endTimeInsertTreeSet);

        long startTimeDeletHashSet = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            hashSet.remove(40);
        }
        long endTimeDeleteHashSet = System.nanoTime() - startTimeDeletHashSet;
        allTime.put("ArrayListDelete", endTimeDeleteHashSet);

        long startTimeDeleteLinkedhashSet = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedHashSet.remove(50);
        }
        long endTimeDeleteLinkedHashSet = System.nanoTime() - startTimeDeleteLinkedhashSet;
        allTime.put("LinkedHashSetDelete", endTimeDeleteLinkedHashSet);

        long startTimeDeleteTreeSet = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedHashSet.remove(50);
        }
        long endTimeDeleteTreeSet = System.nanoTime() - startTimeDeleteTreeSet;
        allTime.put("TreeSetDelete", endTimeDeleteTreeSet);
        Map<String, Long> allData = new TreeMap<String, Long>(allTime);


        long mas[]=new long[3];
        TestClassSet testClassSet = new TestClassSet();
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
        System.out.println(testClassSet.index(mas));
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
        System.out.println(testClassSet.index(mas));
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
        System.out.println(testClassSet.index(mas));
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
                return "HashSet better";
            case 1:
                return "LinkedHashSet better";
            case 2:
                return "TreeSet better";
            default:
                return "None";
        }
    }
}


