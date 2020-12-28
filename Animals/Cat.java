package lesson5.Animals;

import lesson5.Animals.Animal;

public class Cat extends Animal {
    static int id;

    public Cat() {
        name = "The cat-" + (++id);
        runLimit = (200 + 20) - (int)(Math.random() * 40);
        jumpLimit = (2 + 1) - (float) (Math.random() * 2);
    }

    @Override
    public String swim(float a) {
        return (name + " can't swim");
    }
}
