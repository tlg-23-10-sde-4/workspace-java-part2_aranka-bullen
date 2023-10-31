package com.entertainment.client;

import com.entertainment.Television;

import java.util.HashSet;
import java.util.Set;

class TelevisionClient {
    public static void main(String[] args) {
        Television tv = new Television("RCA", 30);

        Television tv2 = new Television();
        tv2.changeChannel(25);
        System.out.println(tv2);


        Television tv3 = new Television("RCA", 30);
        System.out.println("tv == tv3 " + (tv==tv3));
        System.out.println("tv.equals(tv3)" + tv.equals(tv3));


        System.out.println(tv.hashCode());  //745160567
        System.out.println(tv3.hashCode());   //610984013
        System.out.println();

        Set<Television> tvs = new HashSet<>();
        tvs.add(tv);
        tvs.add(tv3);
        System.out.println("the size if the set is: " + tvs.size());
    }
}