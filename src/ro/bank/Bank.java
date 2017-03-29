package ro.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank implements BankProc {

    private List<Account> accounts = new ArrayList<>();

    public List<Account> getAccount() {
        return accounts;
    }

    public void setAccount(List<Account> accounts) {
        this.accounts = accounts;
    }


}


