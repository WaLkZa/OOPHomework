package org.example.model.impl;

import org.example.constant.Constant;
import org.example.model.Hatchable;

public class Egg extends Animal implements Hatchable {
    public Egg(String name) {
        super(name, 0);
    }

    public boolean isHatched() {
        return super.getAge() < Constant.EGG_HATCHING_AGE;
    }
}