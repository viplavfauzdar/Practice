package com.java8;
import java.util.*;

public class MyCollections {

    public static void main(String ... args){

        List fruits = new ArrayList();
        Collections.addAll(fruits, "Apples", "Oranges", "Banana");
        fruits.forEach(System.out::println);

        Collections.sort(fruits);
        System.out.println("Sorted according to natural ordering:");
        fruits.forEach(System.out::println);

        Collections.sort(fruits, Comparator.reverseOrder());
        System.out.println("Sorted according to reverse of natural ordering:");
        fruits.forEach(System.out::println);

        /*Deque deque = new De
        deque.addFirst("Apples");
        deque.add("Oranges");
        deque.addLast("Bananas");

        Queue queue = Collections.asLifoQueue(deque);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());*/


    }

}
