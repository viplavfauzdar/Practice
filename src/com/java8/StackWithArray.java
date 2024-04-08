package com.java8;

import java.util.Arrays;

public class StackWithArray {

    int first;
    int last;
    int[] arr;
    int count;

    StackWithArray(int max){
        first = 0;
        last = 0;
        count = 0;
        arr = new int[max];
    }

    void push(int n){
        arr[count] = n;
        count++;
    }

    int pop(){
        int n = arr[count-1];
        arr[count-1] = -1;
        count--;
        return n;
    }

    public static void main(String[] args){
        StackWithArray stackWithArray = new StackWithArray(10);
        for(int i=1;i<=10;i++){
            stackWithArray.push(i);
        }
        System.out.println(stackWithArray.count);
        System.out.println(stackWithArray.pop());
        System.out.println(stackWithArray.pop());
        System.out.println(stackWithArray.pop());
        System.out.println(stackWithArray.count);
        System.out.println(Arrays.toString(stackWithArray.arr));
        stackWithArray.push(11);
        System.out.println(Arrays.toString(stackWithArray.arr));
    }
}
