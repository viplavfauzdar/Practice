package com.java8;

import java.util.List;

public class MyGenerics {

    public static void main(String ... args){

        Add<Integer> add = new Add<>();
        add.doAdd(1);
        Add<Double> add1 = new Add<>();
        add1.doAdd(1.0);
    }
}

class Add<T>{

    public T doAdd(T t){
        return (t);
    }

   /* public T doAdd1(List<T> t){
        T t2 = null;
        for(T t1: t){
            t2 = t2 + t1;
        }
    }*/
}
