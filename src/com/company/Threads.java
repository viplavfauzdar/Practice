package com.company;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

final public class Threads extends Error{

    void blah() {

        Thread thread = new Thread() {
            public void run() {
                System.out.println("Thread Running");
            }
        };
        thread.start();



        Runnable r = new Runnable() {
            @Override
            public void run() {

            }
        };
        r.run();

    }

    final void c() throws Exception{
        Set<String> s = new HashSet<>();
        Queue<String> q = new PriorityQueue<>();

    }

    synchronized void blh(){

    }

    /*void d(){
        synchronized (int x>1){

        }
    }*/



}

class A{

    private A(){}

    private static A a = null;

    public static A getInst(){
        if(a==null) a = new A();
        return a;
    }


}
