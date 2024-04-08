package com.java8;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyStreams {


    public static void main(String...args){
        streams1();
    }

    static void streams1(){

        //forEach

        int[] n = {1,2,3,4,5};
        Arrays.stream(n)
                .forEach(System.out::println);

        Stream.of(Arrays.asList(n))
                .forEach(System.out::println);

        List<Integer> nn = new ArrayList<>();
        nn.add(1);
        nn.add(2);
        nn.add(3);
        nn.add(4);

        Stream.of(nn).forEach(System.out::println);

        //doesnt work because of generic type T
        Stream.of(nn).forEach(n1 -> {
            int i=0;
            System.out.println(n1.get(i) + 1);
            i++;
        });

        nn.stream().forEach(System.out::println);

        nn.stream().forEach(n1 -> {
            System.out.println(n1 + 1);
        });

        //map

        List<Integer> nnn =  nn.stream()
                .map(n1 -> (n1+1))
                .collect(Collectors.toList());
        System.out.println("Map: " + nnn);

        //filter

        List<Integer> nnn1 =  nn.stream()
                .filter(n1 -> n1>2)
                .collect(Collectors.toList());
        System.out.println(nnn1);

        //findFirst - with Optional

        Optional<Integer> nnn2 =  nn.stream()
                .findFirst();
        System.out.println(nnn2.get());

        Integer nnn3 =  nn.stream()
                .findFirst()
                .orElse(null);
        System.out.println(nnn3);

        //toArray

        Integer[] n2 = nn.stream()
                .toArray(Integer[]::new);
        System.out.println(n2);

        //flatMap - flattens nested List

        List<List<Integer>> nnn4 = new ArrayList<List<Integer>>();
        nnn4.add(nn);
        nnn4.add(nn);

        nnn4.forEach(nn4 -> {
            nn4.forEach(nn5 ->{
                System.out.println(nn5);
            });
        });

        List<Integer> nnn5 = nnn4.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println("FlatMap: " + nnn5);

        //peek - intermediate (always lazy)
        //if not using collect at the end then intermediate operation

        nn.stream()
                .peek(n1 -> {
                    n1++;
                    System.out.println("Peeking: " + n1);
                })
                .peek(System.out::println)
                .collect(Collectors.toList());

        //count - terminal. filter - intermediate.
        // filter not evaluated till count is called and is therefore lazy

        long c = nn.stream()
                .filter(n1 -> n1>2)
                .count();
        System.out.println("Count: " + c);

        //short circuit infinite stream

        Stream.iterate(1, i -> i * 2)
                .skip(3)
                .limit(10)
                .peek(System.out::println)
                .collect(Collectors.toList());

        //Lazy evaluation

        nn.stream()
                .map(n1 -> (n1+1))
                .filter(n1 -> n1>2)
                .peek(System.out::println)
                .collect(Collectors.toList());

        //sorted

        nn.stream()
                .sorted(Comparator.reverseOrder())
                .peek(System.out::println)
                .collect(Collectors.toList());

        //min & max

        int x = nn.stream()
                .min(Integer::compare)
                .orElseThrow(NoSuchElementException::new);
        System.out.println("min: " + x);

        int x1 = nn.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(NoSuchElementException::new);
        System.out.println("max: " + x1);

        //distinct
        Integer[] nn1 = {1,2,3,4,3,5,2};
        Stream.of(nn1)
                .distinct()
                .peek(System.out::println)
                .collect(Collectors.toList());

        //Specialized streams - intStream, double, long
        Integer m = Stream.of(nn1)
                .mapToInt(Integer::intValue)
                .peek(System.out::println)
                .min()
                .getAsInt();
        System.out.println("Int stream min: " + m);

        System.out.println("Max: " + IntStream.range(1,10).max().getAsInt());

        System.out.println("Sum: " + IntStream.range(1,10).sum());

        System.out.println("Avg: " + IntStream.range(1,10).average().getAsDouble());

        //parallel

        System.out.println("Starting parallel stream");
        List s = Arrays.asList(nn1).parallelStream()
                .peek(nk -> System.out.println("peeking parallel: " + nk))
                .distinct()
                .collect(Collectors.toList());
        System.out.println("parallel: " + s.toString());

        //using logger
        Logger logger = Logger.getLogger(MyStreams.class.getName());
        String[] ss = {"viplav","fauzdar"};
                Stream.of(ss)
                .peek(logger::info)
                .collect(Collectors.toList());

        try {
            Files.lines(Paths.get("/Users/viplavfauzdar/Downloads/Practice/src/test/file.txt"))
                    .peek(System.out::println)
                    .collect(Collectors.toList());
        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
