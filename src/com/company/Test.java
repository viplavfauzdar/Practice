package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args){
        /*checkPrime(1);
        checkPrime(1,2);
        checkPrime(1,2,3,4,5);*/
        //int n = 9;
        //int ar[] = {10, 20, 20, 10, 10, 30, 50, 10, 20};

        /*int n = 15;
        int ar[] = {6, 5, 2, 3, 5, 2, 2, 1, 1, 5, 1, 3, 3, 3, 5};

        sockMerchant(n,ar);*/

        //valleys(8,"UDDDUDUUUDDDUDUU");



       /* int year = 1905;
        System.out.println(cent(year));
        year = 1900;
        System.out.println(cent(year));
        year = 1899;
        System.out.println(cent(year));*/

        //System.out.println(checkPalindrome("aabbaa"));

        /*int[] inputArray = {3, 6, -2, -5, 7, 3};
        System.out.println(adjacentElementsProduct(inputArray)+"");*/

        /*int[] statues = {6, 2, 3, 8};
        System.out.println(makeArrayConsecutive2(statues)+"");*/

        /*int[] seq = {1, 2, 3, 4, 3, 6};//{1, 2, 3, 4, 5, 3, 5, 6};
        System.out.println(almostIncreasingSequence(seq));*/

       /* int[][] matrix = {{0, 1, 1, 2},
                        {0, 5, 0, 0},
                        {2, 0, 3, 3}};
                *//*{{1, 1, 1, 0},
                            {0, 5, 0, 1},
                            {2, 1, 3, 10}};*//*
        System.out.println(matrixElementsSum(matrix));*/

        /*String[] inputArray = {"a",
                "abc",
                "cbd",
                "zzzzzz",
                "a",
                "abcdef",
                "asasa",
                "aaaaaa"};
        //{"aba", "aa", "ad", "vcd", "aba"};
        allLongestStrings(inputArray);*/

        //System.out.println(commonCharacterCount("aabcc","adcaa"));
        //System.out.println(isLucky(123456));
        /*int[] a ={-1, 150, 190, 170, -1, -1, 160, 180};
        System.out.println(Arrays.toString(sortByHeight(a)));*/

        //System.out.println(reverseInParentheses("foo(bar(baz))blim"));//(vip)foo(bar)baz(blim)"));//foo(bar)baz(blim)"));
        String[] p = {"a"};//bc","ded"};
        System.out.println(Arrays.toString(addBorder(p)));

        //Integer.p
    }

    static String[] addBorder(String[] picture) {
        String[] p1 = new String[picture.length+2];
        System.out.println(picture[0]);//.length);
        String bdr = "";
        for(int i=0;i<picture[0].length();i++){
            bdr = bdr + "*";
        }
        bdr = "*" + bdr + "*";

        p1[0] = bdr;
        for(int j=0;j<picture.length;j++)
            p1[j+1] = "*" + picture[j] + "*";

        p1[p1.length-1]=bdr;
        return p1;
    }


    static String reverseInParentheses(String inputString) {
        /*System.out.println(Arrays.toString(inputString.split("([(,)])+")));
        int k=0;
        String o1="";
        for(int i=0;i<inputString.length();i++){
            if(inputString.charAt(i)=='('){
                String o=inputString.substring(k,i);
                k=i;
                o = o.replace("(","").replace(")","");
                System.out.printf("( %d - %s%n",i,o);
                o1 = o1 + o;
            }
            if(inputString.charAt(i)==')'){
                String o=inputString.substring(k,i);
                k=i;
                o = o.replace("(","").replace(")","");
                String rev="";
                for(int m=o.length()-1;m>=0;m--){
                    rev = rev + o.charAt(m);
                }
                System.out.printf(") %d - %s%n",i,rev);
                o1 = o1 + rev;
            }
        }
        o1 = o1 + inputString.substring(k).replace("(","").replace(")","");
        return o1;*/

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < inputString.length(); i++){

            if(inputString.charAt(i) != ')'){

                stack.push(inputString.charAt(i));

            } else{

                System.out.println("S1-" + stack);

                List<Character> tmp = new ArrayList<>();//temp list to store chars inside a pair of '()';
                while(stack.peek() != '('){
                    tmp.add(stack.pop());
                }
                stack.pop();//get rid of the '(';


                for(int j = 0 ; j < tmp.size(); j++){

                    stack.push(tmp.get(j));//push the reversed characters back to the stack;

                }

                System.out.println("S2-" + stack);

            }

        }

        System.out.println("S3-" + stack);

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    static int[] sortByHeight(int[] a) {
        //-1 is tree
        //remember tree positions
        int[] tpos = new int[a.length];
        for(int i=0;i<a.length;i++){
            if(a[i]==-1){
                tpos[i] = -1;
            }else{
                tpos[i] = -2;
            }
        }
        System.out.println(Arrays.toString(tpos));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        for(int i=0;i<a.length;i++){
            if(a[i]!=-1){
                for(int j=0;j<tpos.length;j++){
                    if(tpos[j]==-2){
                        tpos[j] = a[i];
                        break;
                    }
                }
            }
        }
        return tpos;
    }

    static boolean isLucky(int n) {
        String s = String.valueOf(n);
        String s1 = s.substring(0,s.length()/2);
        String s2 = s.substring(s.length()/2);
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int sum1=0, sum2=0;
        for(int i=0;i<c1.length;i++){
            sum1 = sum1 + Integer.parseInt(String.valueOf(c1[i]));
        }
        for(int i=0;i<c2.length;i++){
            sum2 = sum2 + Integer.parseInt(String.valueOf(c2[i]));
        }
        System.out.printf("%s, %s%n",s1,s2);
        System.out.printf("%s, %s%n",sum1,sum2);
        if(sum1 == sum2)
            return true;
        else
            return false;
    }


    static int commonCharacterCount(String s1, String s2) {
        int count=0;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for(int i=0;i<c1.length;i++){
            for(int j=0;j<c2.length;j++){
                if(c2[j] == c1[i] && c1[i]!=1){
                    c2[j] = '1';
                    count++;
                    break;
                }
            }
        }
        System.out.println(c2);
        return count;
    }

    static String[] allLongestStrings(String[] inputArray) {
        int[] l = new int[inputArray.length];
        for(int i=0;i<inputArray.length;i++){
            l[i] = inputArray[i].length();
        }
        Arrays.sort(l);
        System.out.println(Arrays.toString(l));
        System.out.println(l.length);
        int ll= l[l.length-1];
        List<String> longest = new ArrayList<>();
        for(int i=0;i<inputArray.length;i++){
            if(inputArray[i].length()==ll)
                longest.add(inputArray[i]);
        }
        System.out.println(Arrays.asList(longest));
        String[] longest1 = new String[longest.size()];
        longest1 = longest.toArray(longest1);
        System.out.println(Arrays.toString(longest1));
        return longest1;
    }

    static int matrixElementsSum(int[][] matrix) {
        int l1 = matrix.length;
        int l2 = matrix[0].length;
        System.out.println(matrix.length);
        int cost = 0;
        List<Integer> js = new ArrayList<>();
        for(int i=0;i<l1;i++){
            for(int j=0;j<l2;j++){
                if(matrix[i][j]==0){
                    //ghost 0,3
                    //block below rooms
                    js.add(j);
                }else{
                    //add up 1st row <> 0
                    if(i==0) {
                        cost = cost + matrix[i][j];
                    }else{
                        if (!js.contains(j)){
                            System.out.printf("%d, %d%n", i, j);
                            cost = cost + matrix[i][j];
                        }
                    }
                }
            }
        }
        System.out.println(js);
        return cost;
    }

    static int cent(int year){
        if((year % 100) > 0)
            return (year/100 + 1);
        else
            return (year/100);
    }

    static int adjacentElementsProduct(int[] inputArray) {
        List<Integer> l = new ArrayList<Integer>();
        for(int i=0;i<inputArray.length-1;i++) {
            int product = inputArray[i] * inputArray[i + 1];
            l.add(product);
        }
        Collections.sort(l);
        return l.get(l.size()-1).intValue();
    }

    static int shapeArea(int n) {
        return (int)(Math.pow(n,2) + Math.pow(n-1,2));
    }

    static int makeArrayConsecutive2(int[] statues) {
        List<Integer> l = new ArrayList<>();
        for(int i=0;i<statues.length;i++){
            l.add(statues[i]);
        }
        Collections.sort(l);
        int count=0;
        for(int i=1;i<l.size();i++){
            count = count + (l.get(i) - l.get(i-1) - 1);
        }
        return count;
    }

    static boolean almostIncreasingSequence(int[] sequence) {
        int count=0;
        List<Integer> list = Arrays.stream(sequence).boxed().collect(Collectors.toList());
        System.out.println(list);
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i) > list.get(i+1) || list.get(i) == list.get(i+1)){
                list.remove(i);
                count++;
            }
        }
        System.out.println(list);
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i) > list.get(i+1) || list.get(i) == list.get(i+1)){
                list.remove(i);
                count++;
            }
        }
        System.out.println(list);
        if(count<=1)
            return true;
        else
            return false;
    }



    static boolean checkPalindrome(String inputString) {
        char c[] = inputString.toCharArray();
        boolean pal = false;
        for(int i=0;i<c.length/2;i++){
            if(c[i] == c[c.length-i-1]){
                pal = true;
            }else{
                pal = false;
            }
        }
        return pal;
    }

    static void checkPrime(int ... N){
        for(int n: N) {
            boolean prime = true;
            if (n < 2) prime = false;
            for (int i = 2; i < n; i++) {
                if ((n % i) == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime)
                System.out.printf("%d is a prime%n", n);
            else
                System.out.printf("%d is not a prime%n", n);

        }
    }

    static int sockMerchant(int n, int[] ar) {
        int pairs=0;

        /*List<Integer> arL = new ArrayList<Integer>();
        for(int i=0;i<ar.length;i++){
            arL.add(ar[i]);
        }

        System.out.println(arL.toString());
        for(int i=0;i<arL.size();i++){
            for(int j=1;j<arL.size();j++){
                System.out.printf("%d, %d%n", i, j);
                if(arL.get(j).equals(arL.get(i))){
                    arL.remove(j);
                    pairs++;
                    System.out.println("pairs found :" + pairs);
                    break;
                }
            }
            arL.remove(0);
            System.out.println(arL.toString());
        }*/

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(ar[i] != -1) {
                    if (ar[j] == ar[i]) {
                        ar[i] = -1;
                        pairs++;
                        break;
                    }
                }
            }
        }

        System.out.println(pairs);
        return pairs;
    }

    /*8
    UDDDUDUU*/
    static void valleys(int n, String s){
        int stepCount=0, valleysClimbed=0;

        char[] steps  = s.toCharArray();
        for(char step: steps){
            if(step == 'U') stepCount++;
            if(step == 'D') stepCount--;
            if(stepCount == 0  && step == 'U') valleysClimbed++;
        }

       /* int stepCount=0;
        for(int i=0;i<s.length();i++) {
            String step = s.substring(i, i + 1);
            System.out.println(step);
            if(step.equals("U")) stepCount++;
            if(step.equals("D")) stepCount--;
            if(stepCount == 0 && step.equals("U")) valleysClimbed++;
        }*/
        System.out.println(valleysClimbed);
    }
}
