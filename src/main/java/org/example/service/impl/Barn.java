package org.example.service.impl;

import org.example.constant.Constant;
import org.example.model.impl.Animal;
import org.example.model.impl.Chicken;
import org.example.model.impl.Egg;
import org.example.service.Barnable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Barn implements Barnable {

    private List<Chicken> chickens;
    private List<Egg> eggs;
    private StringBuilder output;

    public Barn(List<Chicken> chickens) {
        this.chickens = chickens;
        this.eggs = new ArrayList<>();
        this.output = new StringBuilder();
    }

    public void generateWeek(String weekType) {
        increaseAges();
        hatchingEggs();
        removeHatchedEggs();
        layingEggs(weekType);
        killChickens();
    }

    private void increaseAges() {
        chickens.forEach(Animal::increaseAge);
        eggs.forEach(Animal::increaseAge);
    }

    private void hatchingEggs() {
        for (Egg egg : eggs) {
            if (egg.getAge() == Constant.EGG_HATCHING_AGE) {
                chickens.add(new Chicken(egg.getName(), 0));
            }
        }
    }

    private void removeHatchedEggs() {
        eggs = eggs.stream()
                .filter(Egg::isHatched)
                .collect(Collectors.toList());
    }

    private void layingEggs(String weekType) {
        for (Chicken chicken : chickens) {
            eggs.addAll(chicken.layingEggs(weekType));
        }
    }

    private void killChickens() {
        chickens = chickens.stream()
                .filter(Chicken::isAlive)
                .collect(Collectors.toList());
    }

    @Override
    public String toString(){
        Collections.sort(chickens);
        chickens.forEach(c -> output.append(c).append(System.lineSeparator()));
        output.append(String.format("Eggs: %d", eggs.size()));
        return output.toString();
    }
}