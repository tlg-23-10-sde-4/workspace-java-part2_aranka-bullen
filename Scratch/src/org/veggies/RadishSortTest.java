package org.veggies;

import java.util.ArrayList;
import java.util.List;


class RadishSortTest {
    public static void main(String[] args) {

        List<Radish> radishes = new ArrayList<>();

        radishes.add(new Radish("red", 2.1, 1.0, 0));
        radishes.add(new Radish("black", 1.0, 0.0, 3));
        radishes.add(new Radish("red", 2.5, 4.2, 0));
        radishes.add(new Radish("pink", 0.7, 3.2, 2));

        //sorts by original order
        System.out.println("sort by original order");
        dump(radishes);
        System.out.println();

        //sorts by natural order
        System.out.println("sort by natural order");
        radishes.sort(null);  // passing null means to do natural order
        dump(radishes);
        System.out.println();

        System.out.println("color, via RadishColorComparator");
        radishes.sort(new RadishColorComparator());
        dump(radishes);
        System.out.println();


        System.out.println("color, via RadishGuysOnTopComparator");
        radishes.sort(new RadishGuysOnTopComparator());
        dump(radishes);
        System.out.println();
    }
    private static void dump(List<Radish>radishes){
        for(Radish radish : radishes){
            System.out.println(radish);
        }
    }
}