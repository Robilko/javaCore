package lesson5.Animals;

import lesson5.Animals.Animal;

public class Dog extends Animal {
    static int id;

    public Dog() {
        name = "The dog-" + (++id);
        runLimit = (500 + 100) - (int)(Math.random()*200);
        swimLimit = (10 + 5) - (int)(Math.random()*10);
        jumpLimit = (0.5f + 1) - (float) Math.random();
    }
}
