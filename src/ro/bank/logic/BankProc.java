package ro.bank.logic;

public interface BankProc {

    void createAccount(Account account);

    void removeAccount(int id);

    void depositMoney(int id, double sum);

    void retireMoney(int id, double sum);

    }




