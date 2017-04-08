package ro.bank.logic;

import ro.bank.model.Person;

public class SavingAccount extends Account {

    private final static double MIN_DEPOSIT = 5000;

    public SavingAccount(Person person) {
        super(person);
    }

    @Override
    public boolean retireMoney(double sum) {
        boolean sufficient;
        if (sum > sold) {
            sufficient = false;
        } else {
            sufficient = true;
            sold = sold - sum;
        }
        return sufficient;
    }

    @Override
    public boolean depositMoney(double sum) {
        boolean insufficient;
        if (sum < MIN_DEPOSIT) {
            insufficient = true;
        } else {
            insufficient = false;
            sold = sold + sum;
        }
        return insufficient;
    }
}



