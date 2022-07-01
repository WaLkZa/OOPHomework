package org.example.model.impl;

import org.example.constant.Constant;

public abstract class Animal {

    private String name;
    private int age;

    protected Animal(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException(Constant.NEGATIVE_AGE);
        }

        this.age = age;
    }

    public void increaseAge() {
        this.setAge(this.getAge() + 1);
    }

    @Override
    public String toString(){
        return this.name;
    }
}