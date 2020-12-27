package lesson5.Animals;

public class Animal {
    protected String name;
    static int id;
    protected float runLimit;
    protected float swimLimit;
    protected float jumpLimit;

    public Animal() {
        name = "The animal-" + (++id);
    }

    public void run(float a) {
        if (runLimit == 0) System.out.println(name + " can't run.");
        else if (a > runLimit) System.out.println(name + " didn't run the distance.");
        else System.out.println(name + " ran the distance!");
    }

    public void swim(float a) {
        if (swimLimit == 0) System.out.println(name + " can't swim.");
        else if (a > swimLimit) System.out.println(name + " didn't swim the distance.");
        else System.out.println(name + " swam the distance!");
    }

    public void jump(float a) {
        if (jumpLimit == 0) System.out.println(name + " can't jump.");
        else if (a > jumpLimit) System.out.println(name + " didn't jump the barrier.");
        else System.out.println(name + " jumped over the barrier!");
    }

    public void info() {
        System.out.println(name + " can run - " + runLimit + " meters, can swim - " + swimLimit + " meters & can jump - " + jumpLimit + " meters. \nIt's results are:");
    }

}
