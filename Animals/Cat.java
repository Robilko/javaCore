package lesson5.Animals;

import lesson5.Animals.Animal;

public class Cat extends Animal {
    static int id;
    protected float runLimit = 200;
    protected float jumpLimit = 2;

    public Cat() {
        super.name = "The cat-" + (++id);
        super.runLimit = (runLimit + 20) - (int)(Math.random() * 40);
        super.jumpLimit = (jumpLimit + 1) - (float) (Math.random() * 2);
    }

    @Override
    public void swim(float a) {
        System.out.println(name + " can't swim");
    }
}
