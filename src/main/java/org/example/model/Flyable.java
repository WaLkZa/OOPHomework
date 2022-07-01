package org.example.model;

import org.example.model.impl.Egg;

import java.util.List;

public interface Flyable {

    List<Egg> layingEggs(String week);
    boolean isAlive();
}
