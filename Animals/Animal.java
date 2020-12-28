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

    public String run(float a) {
        if (runLimit == 0) return (name + " can't run.");
        else if (a > runLimit) return (name + " didn't run the distance.");
        else return (name + " ran the distance!");
    }

    public String swim(float a) {
        if (swimLimit == 0) return (name + " can't swim.");
        else if (a > swimLimit) return (name + " didn't swim the distance.");
        else return (name + " swam the distance!");
    }

    public String jump(float a) {
        if (jumpLimit == 0) return (name + " can't jump.");
        else if (a > jumpLimit) return (name + " didn't jump the barrier.");
        else return (name + " jumped over the barrier!");
    }

    public String info() {
        return (name + " can run - " + runLimit + " meters, can swim - " + swimLimit + " meters & can jump - " + jumpLimit + " meters. \nIt's results are:");
    }

}
