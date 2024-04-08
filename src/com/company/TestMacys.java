package com.company;

import com.sun.tools.javac.util.Log;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.*;
import java.util.function.Function;
import java.util.stream.IntStream;

public class TestMacys {

    public static void main(String[] args){
        //System.out.println(reverseSentence("Man bites dog"));
        /*Animal animal = new Animal();
        animal.sayHello();*/
        /*Car[] c = new Car[2];
        c[0] = new Car();
        c[1] = new Car();
        c[0].say();

        LinkedList<String> lk = new LinkedList<>();
        lk.add("Viplav");
        lk.add("Fauzdar");

        int[] n = {1, 2, 3, 4, 5, 6, 7};//1, 3, 2, 1};
        List<Integer> ln = new ArrayList<>();
        for(int i: n){
            ln.add(i);
        }
        System.out.println(binSrch(ln, 5));//almostIncreasingSequence(n));*/

       /* AtomicInteger atomicInt = new AtomicInteger(0);


        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 1000)
                .forEach(i -> {
                    Runnable task = () ->
                            atomicInt.updateAndGet(n -> n + 2);
                    executor.submit(task);
                });


        stop(executor);

        System.out.println(atomicInt.get());    // => 2000
*/
        LinkedList<String> lk = new LinkedList<>();
        lk.add("Viplav");
        lk.add("Fauzdar");

        Set s = new TreeSet();
        Set s1 = new HashSet();
        Set s2 = new LinkedHashSet();

        /*List<String> list = new ArrayList<String>();
        Collections.binarySearch(list,"");
        Collections.min(list);*/
        Queue queue = new PriorityQueue();

        Deque<String> deque = new ArrayDeque<>();

        Math.ceil(2.04);
        Math.floor(2.04);


        ArrayList<ArrayList<Integer>> ll = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);

        ArrayList<Integer> l2 = new ArrayList<>();
        l1.add(3);
        l1.add(4);

        ll.add(l1);
        ll.add(l2);

        System.out.println(ll);






       Function<String, String> f = (String x) -> x.toUpperCase();
       System.out.println(f.apply("viplav"));

       //System.out.println((a1, a2) -> a1 > a2;);

        Stack<Integer> stack = new Stack();

        fizzBuzz();
        }

        static void fizzBuzz(){
            int[] arr = {3,5,9,15,2,4,6,7,20};
            for(int i=0;i<arr.length;i++){
                if(i % 3 == 0){
                    System.out.println("Fizz!");
                }else if(i % 5 ==0){
                    System.out.println("Buzz!");
                }
            }

        }

    static int binSrch(List<Integer> ln, int x) {
        int l = ln.size();
        int match = 0;
        if(x == ln.get(l/2)) match = l/2;
        if(x < ln.get(l/2)){
            ln = ln.subList(0,l/2);
            System.out.println("1: " + ln);
            binSrch(ln,x);
        }else{
            ln = ln.subList(l/2,l);
            System.out.println("2: " + ln);
            binSrch(ln,x);
        }
        return match;
    }



    static boolean almostIncreasingSequence(int[] sequence) {
        int count=0;
        //if(sequence[0]>sequence[1]) count++;
        for(int i=0;i<sequence.length;i++){
            if(i==sequence.length-1) break;
            if(sequence[i]>sequence[i+1]){
                count++;
            }
        }
        if(count<=1)
            return true;
        else
            return false;
    }


        static String reverseSentence(String sentence) {
        String[] str = sentence.split(" ");
        String sent1="";
        for(int i=str.length-1;i>=0;i--){
            sent1 = sent1 + " " + str[i];
        }
        return sent1.trim();
    }



}

class Car{
    void say(){
        System.out.println("Hello");
    }
}

abstract class Animal{
    abstract void sayHello();
}
