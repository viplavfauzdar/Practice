package com.company;

import java.util.*;

public class TestMacys2 {

    public static void main(String[] args){
        //findDupes();
        int[] a = {2,3,1};//{1, 1, 4};//{1,2,3};
        int[] b = {1,3,2};//{1, 2, 3};//{2,1,3};
        System.out.println(areSimilar(a,b));

        List fruits = new ArrayList();
        Collections.addAll(fruits, "Apples", "Oranges", "Banana");
        fruits.forEach(System.out::println);

    }

    static void findDupes(){
        int[] n = {1,5,1,10,6,5};
        Set<Integer> s = new HashSet<>();
        for(int i: n){
            System.out.printf("%d - %s, ", i, s.add(i));
        }
    }

    static void findAddr(){
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);

        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(2);
        l2.add(3);

        for(Integer i1: l1){
            for(Integer i2: l2){
                if(i1 == i2){
                    System.out.println("same address!");
                }
            }
        }

    }

    static boolean areSimilar(int[] a, int[] b) {
        int c=0;
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i]){
                c = b[i];
                b[i] = b[i+1];
                b[i+1] = c;
                break;
            }
        }
        System.out.println(Arrays.toString(b));
        if(Arrays.equals(a,b)) {
            return true;
        }else {
            return false;
        }
    }
}
