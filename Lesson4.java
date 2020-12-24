package lesson4;


//Домашка Java. Уровень 1. Урок 4
//1 Создать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;
//2 Конструктор класса должен заполнять эти поля при создании объекта;
//3 Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
//4 Вывести при помощи методов из пункта 3 ФИО и должность.
//5 Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
//6* Создать метод, повышающий зарплату всем сотрудникам старше 35 лет на 10000;
//7** При создании экземпляра класса Сотрудник присваивать ему уникальный порядковый номер.

public class Lesson4 {
    public static void main(String[] args) {
        //4 Вывести при помощи методов из пункта 3 ФИО и должность.
        System.out.println("Задание 4: ");
        Employee employee1 = new Employee("Иванов Иван Иванович", "слесарь", "+7(926)-111-11-11", 15000, 40);
        System.out.println("ФИО: " + employee1.getFullName() + ", должность: " + employee1.getPosition());
        System.out.println();

        //5 Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        Employee[] employees = new Employee[] {
                new Employee("Типун Владимир Владимирович", "Генеральный директор", "+7(901)-111-11-11", 150000, 68),
                new Employee("Ведмедев Дмитрий Анатольевич", "Заместитель директора", "+7(902)-222-22-22", 120000, 55),
                new Employee("Шимустин Михаил Владимирович", "Главный бухгалтер", "+7(903)-333-33-33", 110000, 54),
                new Employee("Песец Любовь Эдуардовна", "Юрист", "+7(904)-444-44-44", 50000, 33),
                new Employee("Ванальный Алексей Анатольевич", "Специалист по работе с общественностью", "+7(905)-555-55-55", 0, 44)
        };

        System.out.println("Задание 5: ");

        for (Employee employee : employees) {
            if (employee.getAge() > 40) System.out.println("ФИО: " + employee.getFullName() + ", должность: " + employee.getPosition() + ", тел.: " + employee.getPhoneNumber() + ", зарплата: " + employee.getSalary() + ", возраст: " + employee.getAge());
        }

        System.out.println();

        //Проверка результата работы метода в задании 6
        salaryIncrease(employees);
        System.out.println("Задание 6: ");
        System.out.println("После повышения зарплаты всем кто старше 35:");
        for (Employee employee : employees) {
            System.out.println("ФИО: " + employee.getFullName() + ", должность: " + employee.getPosition() + ", тел.: " + employee.getPhoneNumber() + ", зарплата: " + employee.getSalary() + ", возраст: " + employee.getAge());
        }

        //7** При создании экземпляра класса Сотрудник присваивать ему уникальный порядковый номер.
        System.out.println("Задание 7: ");
        for (Employee employee : employees) {
            System.out.println("ФИО: " + employee.getFullName() + ", id: " + employee.getId());
        }
    }

    //6* Создать метод, повышающий зарплату всем сотрудникам старше 35 лет на 10000;
    public static void salaryIncrease(Employee[] arr) {
        for (Employee employee : arr){
            if (employee.getAge() > 35) employee.salary = employee.getSalary() + 10000;
        }
    }
}
