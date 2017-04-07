package ro.bank.data.source;


import ro.bank.logic.Account;
import ro.bank.logic.SavingAccount;
import ro.bank.logic.SpendingAccount;
import ro.bank.model.AccountType;
import ro.bank.model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileRepository implements Repository {
    private static final String FILE_NAME = "accounts.txt";

    public void saveData(List<Account> accounts) {
        File input = new File(FILE_NAME);
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;

        String accountData = "";
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            int id = account.getId();
            double sold = account.getSold();
            Person person = account.getPerson();
            String name = person.getName();
            int age = person.getAge();
            boolean gender = person.getGender();
            AccountType accountType = null;
            if (account instanceof SpendingAccount) {
                accountType = AccountType.SPENDING;
            } else if (account instanceof SavingAccount) {
                accountType = AccountType.SAVING;
            }

            String result = id + "|" + sold + "|" + name + "|" + age + "|" + gender + "|" + accountType + "\n";
            accountData = accountData + result;

        }
        try {
            writer = new FileWriter(input);
            bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(accountData);
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        FileRepository fileRepository = new FileRepository();
/* testare saveData()
        Person ion = new Person("Ion", 19, true);
        Account account1 = new SavingAccount(ion);
        account1.depositMoney(5100);


        Person ionel = new Person("Ionel", 24, true);
        Account account2 = new SpendingAccount(ionel);
        account2.depositMoney(5200);


        Person maria = new Person("Maria", 20, false);
        Account account3 = new SavingAccount(maria);
        account3.depositMoney(5300);

        List<Account> accountList = new ArrayList<>();
        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);
        fileRepository.saveData(accountList);
  */

        List<Account> accountList = fileRepository.loadData();
        for (int i = 0; i < accountList.size(); i++) {
            Account account = accountList.get(i);
            Person person = account.getPerson();
            System.out.println("id: " + account.getId() + " name: " + person.getName() + " age: " + person.getAge());
        }
    }

    public List<Account> loadData() {
        File input = new File(FILE_NAME);
        FileReader reader = null;
        BufferedReader bufferedReader = null;
        List<Account> accounts = new ArrayList<>();

        try {
            reader = new FileReader(input);
            bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();

            while (line != null) {
                String[] splitted = line.split("\\|");
                //3|5300.0|Maria|20|false|SAVING
                String name = splitted[2];
                int age = Integer.parseInt(splitted[3]);
                boolean gender = Boolean.parseBoolean(splitted[4]);
                int id = Integer.parseInt(splitted[0]);
                double sold = Double.parseDouble(splitted[1]);

                Person person = new Person(name, age, gender);

                String type = splitted[5];
                AccountType accountType = AccountType.valueOf(type);
                Account account;
                if (accountType == AccountType.SAVING) {
                    account = new SavingAccount(person);
                } else {
                    account = new SpendingAccount(person);
                }

                account.setId(id);
                account.setSold(sold);
                accounts.add(account);
                line = bufferedReader.readLine();
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return accounts;
    }
}
