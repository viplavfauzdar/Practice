package com.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams1 {

    static Double avg(){
        int[] x = {1,2,3,4,5,6,7,8,9,10};
        return IntStream.of(x).average().getAsDouble();
    }

    static List<String> caseChange(){
        String[] s = {"viplav","fauzdar","dingo","singh"};
        return Arrays.asList(s).stream().map(s1 -> s1.toUpperCase()).toList();
    }

    static int even(){
        int[] x = {1,2,3,4,5,6,7,8,9,10};
        return IntStream.of(x).filter(x1 -> (x1 % 2 == 0)).sum();
    } 

    static int odd(){
        int[] x = {1,2,3,4,5,6,7,8,9,10};
        return IntStream.of(x).filter(x1 -> (x1 % 2 != 0)).sum();
    }
    
    static List dupes(){
        int[] x = {1,2,2,4,1,6,6,8,2,10};
        return IntStream.of(x).distinct().boxed().toList();
    } 

    static long count(String s){
        String[] s1 = {"viplav","fauzdar","dingo","fauz"};
        return Arrays.asList(s1).stream().filter(s11 -> s11.startsWith(s)).count();
    }

    static long count1(String s){
        String[] s1 = {"viplav","fauzdar","dingo","fauz"};
        return Stream.of(s1).filter(s11 -> s11.startsWith(s)).count();
    }

    static List<String> sort(){
        String[] s = {"viplav","fauzdar","dingo","singh"};
        return Arrays.asList(s).stream().sorted().toList();
    }

    static List<String> sort1(){
        String[] s = {"viplav","fauzdar","dingo","singh"};
        return Arrays.asList(s).stream().sorted(Comparator.reverseOrder()).toList();
    }
    
    static void p(Object obj){
        System.out.println(obj);
    }

    static int min(){
        int[] x = {1,2,2,4,1,6,6,8,2,10};
        return IntStream.of(x).min().getAsInt();
    } 

    static int max(){
        int[] x = {1,2,2,4,1,6,6,8,2,10};
        return IntStream.of(x).max().getAsInt();
    } 

    static int secondSmallest(){
        int[] x = {1,22,11,43,5,76,8,9,21};
        return IntStream.of(x).sorted().boxed().toList().get(1);
    } 

    static int secondLargest(){
        int[] x = {1,22,11,43,5,76,8,9,21,87};
        List<Integer> l = IntStream.of(x).sorted().boxed().toList();
        return l.get(l.size()-2);
    } 

    public static void main(String...args){
        p(avg());
        p(caseChange());
        p(even());
        p(odd());
        p(dupes());
        p(count("f"));
        p(count1("v"));
        p(sort());
        p(sort1());
        p(min());
        p(max());
        p(secondSmallest());
        p(secondLargest());
    }
}
