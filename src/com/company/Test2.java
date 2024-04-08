package com.company;

import javax.xml.bind.Element;
import java.lang.annotation.*;
import java.util.Scanner;

public class Test2 {

    public String hello(String x){
       return  x;
    }

    public void hello(){
        System.out.println("hello");
    }

    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface MyAnno{
        int value();
    }



    @MyAnno(value = 10)
    private int some;

    public void say(){
        System.out.println(some);
    }

    public static void main(String[] args){
        new Test2().say();

        Test3<String> t = new Test3<>();
        t.setT("Viplav");
        System.out.println(t.getT());

        Scanner sc = new Scanner(System.in);



    }
}

class Test3<T>{

    private T t;

    public void setT(T t){
        this.t = t;
    }

    public T getT(){
        return t;
    }

}

interface vehicle{
    void engine();
    void brakes();
    default void blah(){

    }
}

abstract class car implements vehicle{
    public void engine(){
        //engine has cylinders
    }

    abstract void v6();
}

class civic extends car {
    public void v6(){
        //implement v6
    }
    public void brakes(){
        //implements brakes
    }

    static class x{

    }

    Runnable t = new Runnable() {
        @Override
        public void run() {

        }
    };

    Thread thread = new Thread(){
        public void run(){
            System.out.println("Thread Running");
        }
    };

  //thread.start();

}

interface infc{
    void do1();
}

/*
static class sync{



}*/
