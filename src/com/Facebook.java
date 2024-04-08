package com;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class Facebook {

    static boolean areTheyEqual(int[] array_a, int[] array_b) {
        // Write your code here
        for(int i=0;i<array_a.length;i++){
            for(int j=0;j<array_b.length;j++){
                if(array_a[i] == array_b[j]) {
                    int temp = array_b[j];
                    array_b[j] = array_b[i];
                    array_b[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array_b));
        if(Arrays.toString(array_a).equals(Arrays.toString(array_b)))
            return true;
        return false;
    }

    int[] countSubarrays(int[] arr) {
        // Write your code here
        int[] arr1 = new int[arr.length];
        for(int i=0;i<arr.length-1;i++){
            int count=1;
            for(int j=0;j<arr.length;j++){
                if(arr[i] < arr[j]){
                    break;
                }else if(i!=j){
                    count++;
                }
            }
            arr1[i] = count;
        }
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]==0) arr1[i] = 1;
        }
        return arr1;
    }

    //greedy algo - [4, 2, 1, 3]
    static int getTotalTime(int[] arr) {
        // Write your code here
        int sum=0, n=0;
        Arrays.sort(arr);
        while(arr.length>1) {
            n = arr[arr.length - 1] + arr[arr.length - 2];
            System.out.println(n);
            arr = Arrays.copyOf(arr, arr.length - 1);
            arr[arr.length - 1] = n;
            System.out.println(Arrays.toString(arr));
            sum = sum + n;
        }
        return sum;
    }

    static int penalty(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length-1]+arr[arr.length-2] ;
    }

    public static void main(String...args){
        System.out.println(getTotalTime(new int[]{4,2,1,3}));
        //System.out.println((areTheyEqual(new int[]{1,2,3,4}, new int[]{1,4,3,2})));
        ///System.out.println((areTheyEqual(new int[]{1,2,3,4}, new int[]{1,4,3,3})));

        //keyPress();
        /*try {
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_RIGHT);
            robot.keyRelease(KeyEvent.VK_RIGHT);
        }catch(Exception e){
            e.printStackTrace();
        }*/
    }

    static void keyPress(){
        try {
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_RIGHT);
            robot.keyRelease(KeyEvent.VK_RIGHT);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
