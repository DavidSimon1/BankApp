package ro.bank;

public interface BankProc {

    void createAcount(Account account);

    void removeAccount(int id);

    void depositMoney(int id, double sum);

    void retireMoney(int id, double sum);

}


