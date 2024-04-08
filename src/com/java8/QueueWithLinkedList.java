package com.java8;

public class QueueWithLinkedList {

    QueueNode front, rear;

    @Override
    public String toString() {
        return "QueueWithLinkedList{" +
                "front=" + front +
                ", rear=" + rear +
                '}';
    }

    static class QueueNode{
        int data;
        QueueNode next;
        QueueNode(){}
        QueueNode(int data){
            this.data = data;
        }
        QueueNode(int data, QueueNode next){
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "QueueNode{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    void enQueue(int data){
        QueueNode node = new QueueNode(data);

        //empty queue
        if(rear == null){
            front = rear = node;
        }else{
            rear.next = node;
            rear = node;
        }
    }

    QueueNode deQueue(){

        if(front==null) return null;
        QueueNode node = front;
        front = front.next;
        //if queue becomes empty
        if(front==null) rear = null;
        return node;
    }

    int size(){
        int size=0;
        QueueNode node = front;
        while(node.next!=null) {
            node = node.next;
            size++;
        }
        return size;
    }

    public static void main(String ... args){
        QueueWithLinkedList queueWithLinkedList = new QueueWithLinkedList();
        for(int i=1;i<=10;i++)
            queueWithLinkedList.enQueue(i);
        System.out.println(queueWithLinkedList.size());
        System.out.println(queueWithLinkedList.deQueue().data);
        System.out.println(queueWithLinkedList.deQueue().data);
        System.out.println(queueWithLinkedList.size());
    }
}
