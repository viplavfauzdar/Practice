package com.java8;

import java.util.*;

public class Sorting {

    //time O(NlogN) (when middle pivot), worst O(N^2) (when last/first pivot), space - O(1) if in place
    //good for arrays but not linked lists
    static void quickSort(int[] arr){
        int n = arr[arr.length-1];
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]<n) {
                left[i] = n;
                quickSort(left);
            }else {
                right[i] = n;
                quickSort(right);
            }
        }
    }

    /*
    Input: ["2", "1", "+", "3", "*"]
    Output: 9
    Explanation: ((2 + 1) * 3) = 9
     */

    static void rpn(){
        List<String> oprt = Arrays.asList("+", "-", "*", "/");
        List<String> oprt1 = new ArrayList<>();


        List<String> list = Arrays.asList("2", "1", "+", "3", "*");

        Queue<String> queue = new PriorityQueue<>();
        Stack<String> stack = new Stack<>();

        list.forEach(s->{
            if(!oprt.contains(s)){
               queue.add(s);
               stack.push(s);
            }else{
                oprt1.add(s);
            }
        });
        System.out.println(stack);
        System.out.println(oprt1);
        int x=0,y=0,r=0;
        for(int i=0;i<stack.size();i++){
            x = Integer.parseInt(stack.get(i));
            if(i==stack.size()-1) return;
            y = Integer.parseInt(stack.get(i+1));
            for(String o:oprt1){
                if(o.equals("+")){
                    r = x + y;
                }else if(o.equals("*")){
                    r = x * y;
                }
            }
        }
        System.out.println(r);

    }

    public static void main(String...args){
        int[] arr={3,5,1,2,6,5,8};
        //quickSort(arr);
        rpn();
    }
}
