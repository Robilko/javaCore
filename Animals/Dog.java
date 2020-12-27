package lesson5.Animals;

import lesson5.Animals.Animal;

public class Dog extends Animal {
    static int id;
    protected float runLimit = 500;
    protected float swimLimit = 10;
    protected float jumpLimit = 0.5f;

    public Dog() {
        super.name = "The dog-" + (++id);
        super.runLimit = (runLimit + 100) - (int)(Math.random()*200);
        super.swimLimit = (swimLimit + 5) - (int)(Math.random()*10);
        super.jumpLimit = (jumpLimit + 1) - (float) Math.random();
    }
}
