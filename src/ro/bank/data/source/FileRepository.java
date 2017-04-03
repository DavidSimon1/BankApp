package ro.bank.data.source;


import ro.bank.logic.Account;

import java.io.*;
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

        }


        try {
            writer = new FileWriter(input);
            bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("");
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

    public List<Account> loadData() {
        return null;
    }
}
