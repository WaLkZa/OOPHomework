package org.example.model.impl;

import org.example.constant.Constant;
import org.example.model.Flyable;
import org.example.enumeration.Week;

import java.util.ArrayList;
import java.util.List;

public class Chicken extends Animal implements Flyable, Comparable<Chicken> {
    private static int id = 1;

    public Chicken(String name, int age) {
        super(name + id, age);
        id++;
    }

    public List<Egg> layingEggs(String weekType) {
        List<Egg> eggs = new ArrayList<>();

        if (super.getAge() >= Constant.CHICKEN_START_LAYING_AGE
                && super.getAge() <= Constant.CHICKEN_END_LAYING_AGE) {

            int eggCount = Week.valueOf(weekType.toUpperCase()).eggCount;
            addEggs(eggs, eggCount);
        }

        return eggs;
    }

    public boolean isAlive() {
        return super.getAge() < Constant.CHICKEN_DEAD_AGE;
    }

    private void addEggs(List<Egg> eggs, int eggCount) {
        for (int i = 0; i < eggCount; i++) {
            String eggName = this.getName() + "/Chicken";
            eggs.add(new Egg(eggName));
        }
    }

    @Override
    public int compareTo(Chicken o) {
        return super.getName().compareTo(o.getName());
    }
}