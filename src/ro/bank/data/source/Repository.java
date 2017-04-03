package ro.bank.data.source;


import ro.bank.logic.Account;

import java.util.List;

public interface Repository {
    void saveData(List<Account> accounts);

    List<Account> loadData();

}
