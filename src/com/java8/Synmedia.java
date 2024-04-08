package com.java8;

import sun.rmi.server.InactiveGroupException;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class Synmedia {


    public static void main(String ... args){

        String S = "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
                "john.png, London, 2015-06-20 15:13:22\n" +
                "myFriends.png, Warsaw, 2013-09-05 14:07:13\n" +
                "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
                "pisatower.jpg, Paris, 2015-07-22 23:59:59\n" +
                "BOB.jpg, London, 2015-08-05 00:02:03\n" +
                "notredame.png, Paris, 2015-09-01 12:00:00\n" +
                "me.jpg, Warsaw, 2013-09-06 15:40:22\n" +
                "a.png, Warsaw, 2016-02-13 13:33:50\n" +
                "b.jpg, Warsaw, 2016-01-02 15:12:22\n" +
                "c.jpg, Warsaw, 2016-01-02 14:34:30\n" +
                "d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
                "e.png, Warsaw, 2016-01-02 09:49:09\n" +
                "f.png, Warsaw, 2016-01-02 10:55:32\n" +
                "g.jpg, Warsaw, 2016-02-29 22:13:11";

        System.out.println(solution1(S));
    }

    public static int solution(int N) {
        // write your code in Java SE 8

        int sign = 1;
        if(N<0){
            N = -1*N;
            sign = -1;
        }

        Integer integer = Integer.valueOf(N);
        String string = integer.toString();
        System.out.println(string);


        List<Integer> list = new ArrayList<>();
        Integer integer1 = new Integer("5" + string);
        System.out.println(integer1);

        list.add(sign * integer1);
        Integer integer2 = new Integer(string + "5");
        list.add(sign * integer2);
        System.out.println(list);

        for(int i=0;i<string.length()-1;i++){
            list.add(sign * new Integer(string.substring(0,i+1) + "5" + string.substring(i+1)));
        }
        System.out.println(list);
        return Collections.max(list).intValue();
    }

    public static String solution1(String S){

        List<String> list = Arrays.asList(S.split("\n"));
        //System.out.println(list);

        //get unique cities
        Set<String> cities = new HashSet<>();
        for(String s: list) {
            String[] pic = s.split(",");
            cities.add(pic[1]);
        }

        List<SortedMap<Date, String>> mapList = new ArrayList();
        SortedMap<Date, String> map = new TreeMap();

        for(String s: list){
            String[] pic = s.split(",");
            String file = pic[1] + pic[0].substring(pic[0].indexOf("."));

            try {
                //for(String city: cities) {
                    //if(file.contains(city)){
                        Date date1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(pic[2]);
                        map.put(date1, file);
                    //}
                    //mapList.add(map);
                //}

            }catch(Exception e){e.printStackTrace();}
        }
        //System.out.println(cities);
        //System.out.println(map);

        Set s = map.entrySet();
        Iterator i = s.iterator();
        String ret = "";
        int cnt = 1;
        while (i.hasNext()) {
            Map.Entry m = (Map.Entry)i.next();

            String key = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format((Date)m.getKey());
            String value = (String)m.getValue();

            //System.out.println("Key : " + key +
            //        "  value : " + value);

            ret = ret + value.substring(0,value.indexOf(".")) + cnt + value.substring(value.indexOf(".")) + "\n";
            cnt++;
        }

        return ret;
    }
}
