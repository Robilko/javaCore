package lesson5.Animals;

import lesson5.Animals.Animal;

public class Bird extends Animal {
    static int id;
    protected float runLimit = 5;
    protected float jumpLimit = 0.2f;

    public Bird() {
        super.name = "The bird-" + (++id);
        super.runLimit = (runLimit + 2) - (int)(Math.random() * 4);
        super.jumpLimit = (jumpLimit + 0.8f) - (float)Math.random();
    }

    @Override
    public void swim(float a) {
        System.out.println(name + " can't swim");
    }
}
