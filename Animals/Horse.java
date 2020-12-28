package lesson5.Animals;

import lesson5.Animals.Animal;

public class Horse extends Animal {
    static int id;

    public Horse() {
        name = "The horse-" + (++id);
        runLimit = (1500 + 200) - (int)(Math.random() * 400);
        swimLimit = (100 + 20) - (int)(Math.random() * 40);
        jumpLimit = (3 + 1) - (float) (Math.random() * 2);
    }
}
