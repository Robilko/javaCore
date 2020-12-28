package lesson5;


import lesson5.Animals.*;

// 1. Создать классы Собака, Лошадь, Птица и Кот с наследованием от класса Животное.
// 2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
// В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).
// 3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м., Лошадь 1500 м., Птица 5 м.,; прыжок: кот 2 м., собака 0.5 м.,
// Лошадь 3 м., Птица 0.2 м. ; плавание: кот и птица не умеет плавать, собака 10 м., лошадь 100 м.).
// 4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат. (Например, dog1.run(150); -> результат: 'Пёсик пробежал!')
// 5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.
public class Main {
    public static void main(String[] args) {
        //Задаем параметры длины дисттанций и барьера. Для тестирования меняем их
        float runDist = 300;
        float swimDist = 40;
        float jumpDist = 3;

        Animal[] array = {new Dog(), new Dog(), new Dog(), new Horse(), new Horse(), new Bird(), new Bird(), new Cat(), new Cat()};

        //Проверка результатов выполнения заданий
        System.out.println("All the animals must to run - " + runDist + " meters, swim - " + swimDist + " meters & jump - " + jumpDist + " meters.\n");
        for(Animal animal : array) {
            System.out.println(animal.info());
            System.out.println(animal.run(runDist));
            System.out.println(animal.swim(swimDist));
            System.out.println(animal.jump(jumpDist));
            System.out.println();
        }
    }
}
