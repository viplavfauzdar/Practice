package com.java8;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeetCode {

    public void rotate(int[] nums, int k) {
        //[1,2,3,4,5,6,7], k=3
        //[5,6,7,1,2,3,4]
        /*int len = nums.length;
        int[] nums2 = new int[nums.length];
        for(int i=0;i<k;i++){
            nums2 = new int[nums.length];
            nums2[0] = nums[len-1];
            for(int j=0;j<len-1;j++){
                nums2[j+1] = nums[j];
            }
            //System.out.println(Arrays.toString(nums2));
            //System.out.println(Arrays.toString(nums));
            nums = nums2;
            //System.out.println(Arrays.toString(nums));
        }
        //return nums;
        System.out.println(Arrays.toString(nums2));*/

        //just last k and append to front sub array - works but LeetCode doesn't like it
        int len = nums.length;
        int[] nums2 = new int[len];
        int j=0;
        for(int i=len-k;i<len;i++){
            nums2[j] = nums[i];
            j++;
        }
        for(int i=0;i<len-k;i++){
            nums2[j] = nums[i];
            j++;
        }
        nums = nums2;
        System.out.println(Arrays.toString(nums));

    }


    /*public boolean containsDuplicate(int[] nums) {

        *//*Set<Integer> set = new HashSet<>();

        Integer[] n = new Integer[];
        set.toArray(n);
        n[0].intValue();

        List<Integer> list = new ArrayList<>();
        list.toArray()*//*

    }*/

    public int singleNumber(int[] nums) {
        int uniqueVal = 0;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(Integer.valueOf(n))) {
                set.remove(n);
            }
        }
        Integer[] n = new Integer[1];
        set.toArray(n);
        return n[0].intValue();
    }

    //[1,2,2,1]
    //[2,2]
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        List<Integer> list3 = new ArrayList();
        Stream.of(nums1)
                .collect(Collectors.toList());
        System.out.println(list1 + "," + list2);

        Iterator iterator1 = list1.iterator();


        //doesnt work because iterator cunsumes
        //the list
        //iterators are not suitable for nested loops
        while(iterator1.hasNext()){
            Integer n1 = (Integer)iterator1.next();
            System.out.println("n1->"+n1);
            Iterator iterator2 = list2.iterator();
            while(iterator2.hasNext()){
                Integer n2 = (Integer)iterator2.next();
                System.out.println("n2->"+n2);
                if(n1.intValue() == n2.intValue()){
                    list3.add(n1);
                    list1.remove(n1);
                    list2.remove(n2);
                    System.out.println("----" + list1);
                }
            }
        }

        /*for(Integer n1: list1){ -- thorws concurrent mod
            for(Integer n2: list2){
                if(n1 == n2){
                    list3.add(n1);
                    list1.remove(n1);
                    list2.remove(n2);
                }
            }
        }*/
        return list3.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        //assuming non -ve
        int l1 = nums1.length;
        int l2 = nums2.length;
        int l3 = 0;
        if(l1<l2)
            l3 = l1;
        else
            l3 = l2;
        int[] n3 = new int[l3];
        int i = 0;
        for(int n1: nums1){
            for(int n2: nums2){
                if(n1 == n2){
                    n3[i] = n1;
                    n1 = -1;
                    n2 = -1;
                    i++;
                }
            }
        }
        return n3;
    }

    public static int[] intersect3(int[] nums1, int[] nums2) {
        //assuming non -ve
        List<Integer> list = new ArrayList();

        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i] == nums2[j]){
                    list.add(nums1[i]);
                    nums1[i] = -1;
                    nums2[j] = -1;
                }
                //System.out.println(Arrays.toString(nums1));
                //System.out.println(Arrays.toString(nums2));
            }
        }

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(list);

        //remove -1
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer n = iterator.next();
            if(n == -1) iterator.remove();
        }
        System.out.println(list);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    //Input: nums1 = [1,2,2,1], nums2 = [2,2]
    //Output: [2,2]
    //Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    //Output: [4,9]
    static int[] intersect4(int[] nums1, int[] nums2){
        Set<Integer> set = new HashSet<>();
        for(int n1: nums1){
            for(int n2: nums2){
                if(n1 == n2){
                    set.add(n2);
                }
            }
        }
        return null;
    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        String num = "";
        for(int i=0;i<len;i++){
            num = num + digits[i];
        }
        System.out.println(num);
        num = "" + (Long.valueOf(num)+1);
        System.out.println(num);
        int[] num2 = new int[num.length()];
        for(int i=0;i<num.length();i++){
            num2[i] = Integer.parseInt(num.substring(i,i+1));
        }
        return num2;
    }

    public static int[] plusOne2(int[] digits) {
        int last = digits[digits.length-1];
        if(last<9){
            digits[digits.length-1] = digits[digits.length-1]+1;
        }else if(digits.length==1) {

        }else{
            List<Integer> list = Arrays.stream(digits).boxed().collect(Collectors.toList());
            list.add(1);
            list.add(0);
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
        return digits;
    }

    public static int[] plusOne3(int[] digits) {
        int carry = 1;
        for (int i = digits.length-1; i>= 0; i--) {
            digits[i] += carry;
            if (digits[i] <= 9) // early return
                return digits;
            digits[i] = 0;
        }
        int[] ret = new int[digits.length+1];
        ret[0] = 1;
        return ret;
    }

    //Input: [1,2,3]
    //Output: [1,2,4]
    //Explanation: The array represents the integer 123.
    //9,8,7,6,5,4,3,2,1,0
    //does goofy calculation for
    //{7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6}
    static int[] plusOne4(int[] digits){
        System.out.println(Arrays.toString(digits));
        int l = digits.length;
        BigDecimal num=new BigDecimal(0.0);
        BigDecimal pow = new BigDecimal(10);
        for(int i=0;i<l;i++){
            num = num.add(new BigDecimal(digits[i]).multiply(pow.pow(l-(i+1))));// * (pow.pow(l-(i+1)))));
            //System.out.println(pow.pow(l-(i+1)));
        }

        num = num.add(BigDecimal.valueOf(1));
        System.out.println(num);
        String numS = String.valueOf(num);
        int[] newDigits = new int[numS.length()];
        //System.out.println(numS.split(""));
        String[] dS = numS.split("");
        for(int i=0;i<dS.length;i++){
            newDigits[i] = Integer.parseInt(dS[i]);
        }
        System.out.println(Arrays.toString(newDigits));
        return newDigits;
    }


    //orginal from way back
    public static void reverseString(char[] s) {
        for(int i=0;i<s.length/2;i++){
            char c = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = c;
        }
        System.out.println(s);
    }

    public static int reverse(int x) {
        if(x > Integer.MAX_VALUE) return 0;
        int sign = 0;
        if(x < 0){
            sign = -1;
            x = -1*x;
        }else{
            sign = 1;
        }
        String s = Integer.valueOf(x).toString();
        String[] ss = s.split("");
        System.out.println(Arrays.toString(ss));
        s = "";
        for(int i=ss.length-1;i>=0;i--){
            s += ss[i];
        }
        System.out.println(s);
        return sign*Integer.parseInt(s);
    }

    public static int reverse2(int x) {
        if(x == 0 || x == Integer.MIN_VALUE){
            return 0;
        }

        long res = 0;

        while(x != 0){
            int digit = x % 10;
            x /= 10;

            res = res*10 + digit;

            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
                return 0;
            }
        }

        return (int) res;
    }

    public static int firstUniqChar(String s) {
        if(s.length()==1) return 0;
        if(s == null || s.length() == 0) return -1;
        String orig = s, s1 = s;
        s1 = s1.replaceAll(""+s.charAt(0),"");
        if(s1.length()==0) return -1;
        for(int i=0;i<s.length();i++){
            int count=0;
            for(int j=0;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)){
                    count++;
                    if(count>1){
                        s = s.replaceAll(""+s.charAt(i),"");
                        break;
                    }
                }
            }
            if(s.length()==0) return -1;
        }
        log(orig);
        log(s);
        return orig.indexOf(s.charAt(0));

    }

    static void log(String s){
        System.out.println(s);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //[4,5,1,9] delete 5 [4,1,9]
    public static void deleteNode(ListNode node) {

    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        // Loop's ending condition is i * i <= num instead of i <= sqrt(num)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String ... args){
       /* int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
        //System.out.println(Arrays.toString(intersect3(nums1, nums2)));
        System.out.println(Arrays.toString(plusOne3(new int[]{1,9,9})));
        //System.out.println(Arrays.toString("100".split("")));
        int x = 1;
        x += 1;
        System.out.println(x);*/
        //reverseString(new char[]{'h','e','l','l','o'});
        Scanner in = new Scanner(System.in);
        System.out.println("Input:");
        //System.out.println(reverse2(in.nextInt()));//9646324351);
        //System.out.println(firstUniqChar("acaadcad"));//in.next()));//loveleetcode
        System.out.println(isPrime(2));
        //int[] a = {1,2,2,1}, b = {2,2};
        //int[] a = {4,9,5}, b = {9,4,9,8,4};
        /*int[] a = {61,24,20,58,95,53,17,32,45,85,70,20,83,62,35,89,5,95,12,86,58,77,30,64,46,13,5,92,67,40,20,38,31,18,89,85,7,30,67,34,62,35,47,98,3,41,53,26,66,40,54,44,57,46,70,60,4,63,82,42,65,59,17,98,29,72,1,96,82,66,98,6,92,31,43,81,88,60,10,55,66,82,0,79,11,81},
        b = {5,25,4,39,57,49,93,79,7,8,49,89,2,7,73,88,45,15,34,92,84,38,85,34,16,6,99,0,2,36,68,52,73,50,77,44,61,48};
        intersect3(a, b);*/
        plusOne4(new int[]{7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6});
    }
}
