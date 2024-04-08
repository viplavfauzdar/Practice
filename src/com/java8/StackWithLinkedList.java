package com.java8;

public class StackWithLinkedList {

    int data;
    int count=0;

    static class Node{
        int data;
        Node next;
        Node(){}
        Node(int data){
            this.data = data;
        }
        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    static Node push(int n, Node node){
        if(node==null) {
            node = new Node(n);
        }else {
            node.next = new Node(n, node.next);
        }
        return node;
    }

    static Node pop(Node node){
        node.next = node.next.next;
        return node;
    }

    public static void main(String ... args){
        Node node = new Node(1);
        for(int i=2;i<=10;i++){
            node = push(i,node);
        }
        System.out.println(node);

        System.out.println(pop(node));
        System.out.println(pop(node));
        node = push(11,node);
        System.out.println(node);
        System.out.println(pop(node));

    }

}
