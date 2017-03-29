package ro.bank;

public class Account {
    private Person person;

    // Un cont are o persoana
    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

}

