package com.java8;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.List;

public class LinkedList {

    ListNode listNode1 = null;
    ListNode listNode2 = null;
    ListNode listNode3 = null;
    ListNode listNode4 = null;

    //4->5->1->9
    void createList(){
        listNode4 = new ListNode(9, null);
        listNode3 = new ListNode(1,listNode4);
        listNode2 = new ListNode(5,listNode3);
        listNode1 = new ListNode(4, listNode2);
    }

    void deleteNode2(){
        listNode2.val = listNode2.next.val;
        listNode2.next = listNode2.next.next;
    }

    void delete2ndNodeFromEnd(){
        ListNode temp = new ListNode();
        temp.next = listNode1;
        int size=1;
        while (temp.next!=null){
            temp = temp.next;
            size++;
        }
        System.out.println(size + ", " + temp);
        ListNode temp1 = new ListNode();
        temp1.next = listNode1;
        for(int i=0;i<size-2;i++){
            temp1 = temp1.next;
        }
        System.out.println(temp1);
        temp1.val = temp1.next.val;
        temp1.next = null;
    }

    //4->5->1->9
    //5-4-1-9
    //5-1-4-9
    //5-1-9-4
    void reverse(ListNode head){
        ListNode curr = head;
        ListNode nxt = null;
        for(int i=0;i<2;i++){
            //ListNode copy = curr;
            //curr = copy.next;
            //nxt = copy;
            nxt = curr.next;
            curr = nxt.next;
        }
    }

    static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "listNode1=" + listNode1 +
                ", listNode2=" + listNode2 +
                ", listNode3=" + listNode3 +
                ", listNode4=" + listNode4 +
                '}';
    }

    static int factorial(int n){
        if(n == 0) return 1;
        return n * factorial(n-1);
    }

    static ListNode newNode(int data){
        return new ListNode(data);
    }

    //O(1) time & space
    static ListNode insertNode(ListNode head, int data){
        if(head == null)
            return newNode(data);
        else
            head.next = insertNode(head.next,data);
        return head;
    }

    static void insertNodeIterative(ListNode head, int data){
        if(head==null) {
            head = newNode(data);
            return;
        }
        while(head.next!=null){
            head = head.next;
        }
        head.next = newNode(data);
    }

    static void traverse(ListNode head){
        while(head!=null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    static void traverseRecursive(ListNode head){
        if(head!=null){
            System.out.print(head.val + " ");
            traverseRecursive(head.next);
        }
    }

    static ListNode deleteNthNode(ListNode head, int n){
        ListNode node = head;
        for(int i=1;i<n;i++){
            node = node.next;
        }
        node.val = node.next.val;
        node.next = node.next.next;
        return head;
    }

    static ListNode deleteNthNodeRecursive(ListNode head, int n){
        if(n==1){
            head.next = head.next.next;
        }else{
            head.next = deleteNthNode(head.next, n-1);
        }
        return head;
    }

    static ListNode deleteNthNodeFromEnd(ListNode head, int n){
        ListNode first = head;
        ListNode second = first;
        int i=1;
        while(i<n){
            second = second.next;
            i++;
        }
        System.out.println(second);
        while(second.next!=null){
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        log(first);
        return first;
    }

    static int size(ListNode head){
        int size=0;
        while(head!=null){
            head = head.next;
            size++;
        }
        return size;
    }

    static void deleteNthNodeFromEnd2(ListNode head, int n){
        int k = size(head) - n;
        for(int i=1;i<k;i++){
            head = head.next;
        }
        System.out.println(head);
        head.next = head.next.next;
        System.out.println(head);
        //return head;
    }

    /*static ListNode swapFirst2(ListNode head){
        ListNode curr = head;
        ListNode nxt = head.next;
        head = head.next;
        prev = curr;
        curr = head;
        log(head);
        return curr;
    }*/

    public static void main(String ... args){
       /* LinkedList leetCodeLinkedList = new LinkedList();
        leetCodeLinkedList.createList();
        System.out.println(leetCodeLinkedList.listNode1);

        leetCodeLinkedList.deleteNode2();
        System.out.println(leetCodeLinkedList.listNode1);

        leetCodeLinkedList.createList();
        leetCodeLinkedList.delete2ndNodeFromEnd();
        System.out.println(leetCodeLinkedList.listNode1);

        leetCodeLinkedList.createList();
        leetCodeLinkedList.reverseList(leetCodeLinkedList.listNode1);
        System.out.println(leetCodeLinkedList.listNode1);

        System.out.println(factorial(5));*/

       int[] arr = {4,5,1,9,7};
       ListNode head = null;
       for(int i=0; i<arr.length;i++){
           head = insertNode(head, arr[i]);
       }
       System.out.println(head);

       traverse(head);
        System.out.println("");
       traverseRecursive(head);
       //System.out.println(deleteNthNode(head,3));
       //System.out.println(deleteNthNodeRecursive(head, 2));
        System.out.println("");
        deleteNthNodeFromEnd2(head, 2);
        System.out.println(head);
        System.out.println("size: "+size(head));
        log(reverseList(head));
        //log(swapFirst(head));

        ListNode head2=newNode(1);
        for(int i=2;i<10;i++) insertNodeIterative(head2, i);
        log(head2);
    }

    static void log(ListNode head){
        System.out.println(head);
    }

    static class ListNode {
        int val;
        ListNode next;
        public ListNode(){};

        public ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}
