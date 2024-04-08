package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Streams {

    @Test
    public void test1(){

        int m = IntStream.range(1,10)
                .peek(System.out::println)
                .max().getAsInt();
        assertEquals(9, m);
    }

    @Test
    public void test2(){
        int sum = IntStream.range(1,5)
                .map(n -> n+1)
                .peek(System.out::println)
                .reduce(Integer::sum).getAsInt();
        assertEquals(14,sum);
    }

    @Test
    public void test3(){
        String[] name = {"viplav", "fauzdar"};
        String ss = Stream.of(name)
                .map(s -> s.toUpperCase())
                .peek(System.out::println)
                .collect(Collectors.joining(","));
        assertEquals("VIPLAV,FAUZDAR", ss);
    }

    @Test
    public void test4(){
        int sum = IntStream.range(1,10)
                .parallel()
                .map(n->n+1)
                .peek(System.out::println)
                .sum();
        assertEquals(54,sum);
    }

    @Test
    public void test5(){
        Integer[] nn = {1,2,3,4,5};
        List l = Stream.of(nn)
                .filter(n -> n>2)
                .peek(System.out::println)
                .collect(Collectors.toList())
                ;
        assertEquals(l, Arrays.asList(3,4,5));
    }
}
