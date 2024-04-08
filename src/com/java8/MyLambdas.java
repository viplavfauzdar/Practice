package com.java8;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyLambdas {

    public static void main(String...args){

        Lamda1 l = new Lamda1() {
            @Override
            public void sayhello() {
                System.out.println("Annonymous class!");
            }
        };
        l.sayhello();

        /*Thread t = new Thread(){
            void run(){
                System.out.println("I am a thread");
            }
        };
        t.start();*/

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("annonymous class in runnable");
            }
        };
        r.run();

        Runnable r1 = () -> System.out.println("I am lambda thread");
        r1.run();

        Lamda1 l1 = () -> System.out.println("Hello L1");
        l1.sayhello();
        Lamda1.log();
        l1.logd();

        Lambda2 l2 = str -> System.out.println(str);
        l2.sathello("Hello L2");

        Lambda2 l3 = (System.out::println);
        l3.sathello("Hello L3");

        Comparator<Integer> c = (x,y) -> {
            if(x>y)
                return x;
            else
                return y;
        };
        System.out.println(c.compare(1,2));

        System.out.println("Prime: "+isPrime(5));

        System.out.println("---------- java.util.function ------------");

        Function<Integer, Integer> function = x -> x + 1;
        function = function.andThen(x -> x + 2);
        function = function.compose(x -> x * 5);
        System.out.println("Function: " + function.apply(5));
        System.out.println(Function.identity());

        Predicate<Integer> predicate = x -> x==5;
        P.r(predicate.test(5)+","+predicate.test(6));
        predicate = predicate.and(x -> x==6);
        P.r(""+predicate.and(x -> x==6).test(6));

    }

    static boolean isPrime(long x) {
        return java.math.BigInteger.valueOf(x).isProbablePrime(1);
    }
    
}



interface P{
    static void r(String s){
        System.out.println(s);
    }
}

@FunctionalInterface
interface Lamda1{

    public void sayhello();
    default void logd(){
        System.out.println("I am lambda1 from default");
    }
    static void log(){
        System.out.println("I am lambda1 from static");
    }
}

@FunctionalInterface
interface Lambda2{
    public void sathello(String str);
}
