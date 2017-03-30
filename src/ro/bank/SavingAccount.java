package ro.bank;

public class SavingAccount extends Account {

    private final static double MIN_DEPOSIT = 5000;

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
        return false;
    }
    //// TODO: 3/30/2017 Daca suma este mai mica de 5000, n-o pot introduce
}

