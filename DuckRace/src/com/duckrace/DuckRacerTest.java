package com.duckrace;

import java.util.Collection;
import java.util.Collections;

class DuckRacerTest {
    public static void main(String[] args) {
        DuckRacer racer = new DuckRacer(14, "Scott");
        System.out.println(racer);

        //make it win a few times
        racer.win(Reward.DEBIT_CARD);
        racer.win(Reward.PRIZES);
        racer.win(Reward.DEBIT_CARD);
        racer.win(Reward.DEBIT_CARD);

        //we can cheat below without actually winning. This is possible because the system is
        // diectly calling the rewards collection. Therefore, the rewards collection needs to
        // called as a read-only view to circumnavigate the "cheat".

//        Collection<Reward> rewards = racer.getRewards();
//        rewards.add(Reward.DEBIT_CARD);
//        rewards.add(Reward.DEBIT_CARD);
//        System.out.println(rewards);


        //to show thr read-only view to thhe underlying collection
        Collection<Reward> rewards = racer.getRewards(); //collection is called
        System.out.println(rewards);  //should see 4

        racer.win(Reward.DEBIT_CARD);
        racer.win(Reward.DEBIT_CARD);

        System.out.println(rewards);  //should see 6 without having to re-calling the collection






    }
}