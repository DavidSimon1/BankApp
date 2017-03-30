package ro.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank implements BankProc {

    private List<Account> accounts = new ArrayList<>();

    @Override
    public void createAcount(Account account) {
        if (account != null) {
            accounts.add(account);
        }
    }

    @Override
    public void removeAccount(int id) {
        //sterg contu cu idu respectiv din lista - caut/sterg

    }

    @Override
    public void depositMoney(int id, double sum) {
        //caut contul si apelez depositmoney.
//
    }

    @Override
    public void retireMoney(int id, double sum) {
        for (int i = 0; i < accounts.size(); i++) {
            Account curent = accounts.get(i);
            if (id == curent.getId()) {
                curent.retireMoney(sum);
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


