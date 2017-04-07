package ro.bank.logic;

import ro.bank.model.Person;

public abstract class Account {
    private Person person;
    private int id;
    protected double sold;
    private static int nr = 0;

    public Account(Person person) {
        this.person = person;
        this.id = nr + 1;
        nr += 1;
    }

    public Account() {

    }

    public abstract boolean retireMoney(double sum);

    public abstract boolean depositMoney(double sum);


    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public double getSold() {
        return sold;
    }

    public void setSold(double sold) {
        this.sold = sold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

