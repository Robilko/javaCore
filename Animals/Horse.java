package lesson5.Animals;

import lesson5.Animals.Animal;

public class Horse extends Animal {
    static int id;
    protected float runLimit = 1500;
    protected float swimLimit = 100;
    protected float jumpLimit = 3;

    public Horse() {
        super.name = "The horse-" + (++id);
        super.runLimit = (runLimit + 200) - (int)(Math.random() * 400);
        super.swimLimit = (swimLimit + 20) - (int)(Math.random() * 40);
        super.jumpLimit = (jumpLimit + 1) - (float) (Math.random() * 2);
    }
}
