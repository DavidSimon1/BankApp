package ro.bank.view;

import ro.bank.data.source.FileRepository;
import ro.bank.data.source.Repository;
import ro.bank.logic.Account;
import ro.bank.logic.Bank;
import ro.bank.logic.BankProc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BankView extends JFrame implements ActionListener {

    private JPanel panel = new JPanel();
    private JMenuBar menu = new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenu accountMenu = new JMenu("Account");
    private JMenu personMenu = new JMenu("Person");

    private JMenuItem save = new JMenuItem("Save Data");
    private JMenuItem load = new JMenuItem("Load Data");
    private JMenuItem viewAccounts = new JMenuItem("View Accounts");
    private JMenuItem createAccount = new JMenuItem("Create Account");
    private JMenuItem removeAccount = new JMenuItem("Remove Account");
    private JMenuItem depositMoney = new JMenuItem("Deposit money");
    private JMenuItem retireMoney = new JMenuItem("Retire Money");
    private JMenuItem viewPersons = new JMenuItem("View Persons");
    private JMenuItem addPerson = new JMenuItem("Add Person");
    private JMenuItem removePerson = new JMenuItem("Remove Person");
    private JMenuItem editPerson = new JMenuItem("Edit Person");

    private BankProc bank = new Bank();
    private Repository fileRepository = new FileRepository();

    public BankView() {
        super("BankApp");
        setSize(610, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        menu.setBounds(0, 0, 610, 20);

        menu.add(fileMenu);
        menu.add(accountMenu);
        menu.add(personMenu);

        fileMenu.add(save);
        fileMenu.add(load);
        save.addActionListener(this);
        load.addActionListener(this);

        accountMenu.add("View Accounts");
        accountMenu.add("Create Account");
        accountMenu.add("Remove Account");
        accountMenu.add("Deposit Money");
        accountMenu.add("Retire Money");

        personMenu.add("View Persons");
        personMenu.add("Add person");
        personMenu.add("Remove person");
        personMenu.add("Edit person");

        this.add(menu);
        this.add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {

        new BankView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<Account> accounts = null;

        /*Date date = new Date();
        System.out.println(new Timestamp(date.getTime()));
        */

        if (e.getSource() == load) {
            System.out.println("Am apasat load");
            accounts = fileRepository.loadData();
        }
        if (e.getSource() == save) {
            System.out.println("Am apasat save");
            if (accounts != null) {
                fileRepository.saveData(accounts);
            }

        }
        if (accounts != null) {
            for (int x = 0; x < accounts.size(); x++) {
                Account current = accounts.get(x);
                System.out.println("id: " + current.getId());
            }
        }
    }
}
