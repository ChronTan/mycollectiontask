package ru.nc.myList;

public class MainClass {
    public static void main(String[] args) {


        MyLinkedList list = new MyLinkedList<Double>();
        list.add(70);
        list.add(305);
        list.add(699);
        list.add(459);
        list.add(723);

        System.out.println(list.toString());
        list.remove(2);
        System.out.println(list.toString());
        list.add(2, 53);
        System.out.println(list.toString());
        System.out.println(list.set(2, 19));
        System.out.println(list.toString());
        list.clear();
        System.out.println(list.toString());
        list.add(215);
        System.out.println(list.toString());

    }
}
