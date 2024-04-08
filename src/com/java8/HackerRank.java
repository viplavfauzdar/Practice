package com.java8;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HackerRank {



    static void rotateArray2(){
        int a[] = {1,2,3,4,5};
        int r[] = {1,2};
        List<Integer> a1 = Arrays.stream(a).boxed().collect(Collectors.toList());
        List<Integer> r1 = Arrays.stream(r).boxed().collect(Collectors.toList());

        for(Integer x: r1) {
            List<Integer> b = new ArrayList<>();
            b.addAll(a1.subList(x, a1.size()));
            b.addAll(a1.subList(0, x));
            System.out.println(b.stream().mapToInt(Integer::intValue).toArray());
        }
    }

    static void rotateArray(){
        int x=3;
        int[] n = {1, 2, 3, 4, 5};
        //5 1 2 3 4
        int[] nn = new int[5];
        int j=0;
        for(int i=x;i<n.length;i++){
            nn[j] = n[i];
            j++;
        }
        for(int i=0;i<x;i++){
            nn[j] = n[i];
            j++;
        }
        System.out.println(Arrays.asList(nn));
    }

    static void camelCaseWords(String camel){
        int count=1; //there is at least one word
        for(int i=0;i<camel.length()-1;i++){
            System.out.println(camel.substring(i,i+1).matches("[A-Z]+"));
            if(camel.substring(i,i+1).matches("[A-Z]")){
                count++;
            }
        }


        System.out.printf("Words: %d", count);

        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(camel);

        System.out.println(camel.split("(?=\\p{Lu})").length);

        int cnt=1;
        for(char c: camel.toCharArray()){
            Character.isUpperCase(c);
            cnt++;
        }
        System.out.println(cnt);
    }

    static int simpleArraySum(int[] ar) {
        /*
         * Write your code here.
         */
        int sum=0;
        for(int a: ar){
            sum = sum + a;
        }
        return sum;
    }

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> list = new ArrayList<>();
        int as=0, bs=0;
        for(int i=0;i<3;i++) {
            if (a.get(i) > b.get(i)){
                as++;
            }else if (a.get(i) < b.get(i)){
                bs++;
            }
        }
        list.add(as);
        list.add(bs);
        return list;


    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int left=0,right=0;
        for(int i=0;i<arr.size()-1;i++){
            left = left + arr.get(i).get(i) + arr.get(i+1).get(i+1);
        }
        for(int i=arr.size()-1;i>0;i--){
            right = right + arr.get(i).get(i) + arr.get(i-1).get(i-1);
        }
        return Math.abs(left-right);
    }

    static void miniMaxSum(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(list);
        int min=0,max=0;
        for(int i=1;i<list.size();i++) min=min+list.get(i);
        Collections.sort(list, Comparator.reverseOrder());
        for(int i=1;i<list.size();i++) min=min+list.get(i);
        System.out.printf("%d %d", min, max);
    }

    static int birthdayCakeCandles(int[] ar) {
        int max = Arrays.stream(ar).max().getAsInt();
        int n=0;
        for(int a: ar){
            if(a == max) n++;
        }
        return n;
    }

    static String timeConversion(String s) {
        String hh=null;
        if(s.contains("PM")){
            int h = Integer.parseInt(s.substring(0,2));
            System.out.println(h);
            if(h < 12) h = h + 12;
            hh = h + s.substring(2);
            hh = hh.replace("PM","");
        }else{
            if(s.contains("12")) s = s.replace("12","00");
            hh = s.replace("AM","");
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ssa");
            Date d = dateFormat.parse("1:40:22PM");
            System.out.println(d);
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("HH:mm:ss");
            System.out.println(dateFormat1.format(d));
        }catch (Exception e){}
        return hh;
    }

    public static long substringCalculator(String s) {
        // Write your code here
        /*int l = s.length();
        System.out.println(l);
        int count=0;
        for(int i=0;i<l;i++){
            System.out.println(s.substring(i));
            count++;
        }
        for(int i=l;i>=0;i--){
            System.out.println(s.substring(0,i));
            count++;
        }
        for(int i=0;i<l;i++){
            try {
                System.out.println(s.substring(i, l - i));
            }catch(Exception e){}
            count++;
        }
        System.out.println(count);
        return count;*/

        //Set<String> result = new HashSet<String>(s.length());
        int count = 0;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                //result.add(s.substring(i, j));
                s.substring(i, j);
                count++;
            }
        }
        return count-2;//result.size();
    }

    public static void main(String ... args){

        /*rotateArray();
        camelCaseWords("saveChangesInTheEditor");
        rotateArray2();
        int[] ar = {1,2,3};
        System.out.println(simpleArraySum(ar));*/
        //System.out.println(timeConversion("12:40:22PM"));
        System.out.println(substringCalculator("kincenvizh"));

    }
}
