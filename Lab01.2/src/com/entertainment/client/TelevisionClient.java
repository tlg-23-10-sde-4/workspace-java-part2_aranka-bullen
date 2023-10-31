package com.entertainment.client;

import com.entertainment.Television;

class TelevisionClient {
    public static void main(String[] args) {
        Television tv = new Television("RCA", 30);
        System.out.println(tv);
        System.out.println();

        Television tv2 = new Television();
        System.out.println(tv2);
        tv2.changeChannel(25);
        System.out.println(tv2);


        Television tv3 = new Television("RCA", 30);
        System.out.println(tv==tv3);
        System.out.println(tv.equals(tv3));
    }
}