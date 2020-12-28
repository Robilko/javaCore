package lesson5.Animals;

import lesson5.Animals.Animal;

public class Bird extends Animal {
    static int id;

    public Bird() {
        name = "The bird-" + (++id);
        runLimit = (5 + 2) - (int)(Math.random() * 4);
        jumpLimit = (0.2f + 0.8f) - (float)Math.random();
    }

    @Override
    public String swim(float a) {
        return (name + " can't swim");
    }
}
