package ro.bank;

public class Person {

    private String name;
    private int age;
    private boolean gender;

    //true = male;
    //false = female;
    public Person(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public boolean getGender() {
        return gender;

    }
}

