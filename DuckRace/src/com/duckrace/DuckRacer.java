package com.duckrace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class DuckRacer {
    private final int id;
    private String name;
    private final Collection<Reward> rewards = new ArrayList<>();

    public DuckRacer(int id, String name){
        this.id = id;
        setName(name);
    }

    //business-action methods
    public void win(Reward reward){
        rewards.add(reward);
    }

    //accessor methods
    public int getId() {    //id does not change, so its read-only aka getter only
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Reward> getRewards() { //getter only, so client does have ability to

        //this method returns a snapshot of collection. must be re-called for new update
        //return List.copyOf(rewards);

        //Method to call snapshot collection WITHOUT re-calling for new update
       return Collections.unmodifiableCollection(rewards);
    }

    //derived property
    public int getWins(){
        return rewards.size();
    }


    @Override
    public String toString() {
        return String.format("%s: [id=%s, name=%s, wins=%s, reward=%s]\n",
                getClass().getSimpleName(), getId(), getName(), getWins(), getRewards());
    }
}