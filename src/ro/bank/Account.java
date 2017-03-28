package ro.bank;

public class Account {
   private Person person = new Person();
    // Un cont are o persoana
    public void setPerson (Person person) {
        this.person = person;
    }
    public Person getPerson (){
        return person;
    }

}

