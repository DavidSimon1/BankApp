package ro.bank.logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bank implements BankProc {

    private List<Account> accounts = new ArrayList<>();

    @Override
    public void createAccount(Account account) {
        if (account != null) {
            accounts.add(account);
        }
    }

    @Override
    public void removeAccount(int id) {
        Iterator<Account> iterator = accounts.iterator();
        while (iterator.hasNext()) {
            Account current = iterator.next();
            if (id == current.getId()) {
                iterator.remove();
            }
        }
    }

    @Override
    public void depositMoney(int id, double sum) {
        for (int i = 0; i < accounts.size(); i++) {
            Account current = accounts.get(i);
            if (id == current.getId()) {
                current.depositMoney(sum);
            }
        }
    }

    @Override
    public void retireMoney(int id, double sum) {
        for (int i = 0; i < accounts.size(); i++) {
            Account current = accounts.get(i);
            if (id == current.getId()) {
                current.retireMoney(sum);
            }
        }
    }

    public List<Account> getAccount() {
        return accounts;
    }

    public void setAccount(List<Account> accounts) {
        this.accounts = accounts;
    }
}


