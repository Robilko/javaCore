package lesson4;

//1 Создать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;
public class Employee {
    String fullName;
    String position;
    String phoneNumber;
    int salary;
    int age;
    static int countId = 1;
    int id;


    //2 Конструктор класса должен заполнять эти поля при создании объекта;
    public Employee(String fullName, String position, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
        id = countId++;
    }

    //3 Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public int getId() {return id;}

}

