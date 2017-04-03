package ro.bank.logic;

import ro.bank.model.Person;

public class SpendingAccount extends Account {
    private static final double COMMISSION = 0.1;

    public SpendingAccount(Person person) {
        super(person);
    }

    @Override
    public boolean retireMoney(double sum) {
        boolean sufficient;
        if (sum > sold) {
            sufficient = false;
        } else {
            sufficient = true;
            sold = sold - sum - COMMISSION * sum;
        }
        return sufficient;
    }

    @Override
    public boolean depositMoney(double sum) {
        sold = sold + sum;
        return true;
    }
}
