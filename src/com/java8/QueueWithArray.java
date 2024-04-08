package com.java8;

public class QueueWithArray {

    /**
     * QueueWithArray using array
     */
    int maxSIze;
    int front;
    int rear;
    int size;
    int[] arr;

    QueueWithArray(int maxSize){
        this.maxSIze = maxSize;
        this.front = 0;
        this.rear = 0;
        this.size=0;
        arr = new int[maxSize];
    }

    void push(int n){
        arr[this.rear] = n;
        this.rear++;
        this.size++;
    }

    int pop(){
        int n = arr[front];
        this.front++;
        this.size--;
        return n;
    }

    int size(){
        return size;
    }

    public static void main(String...args){
        QueueWithArray queue = new QueueWithArray(10);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.size());
        System.out.println(queue.pop());
        System.out.println(queue.size());

    }
}
