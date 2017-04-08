package ro.bank.view;

import ro.bank.data.source.FileRepository;
import ro.bank.data.source.Repository;
import ro.bank.logic.Account;
import ro.bank.logic.Bank;
import ro.bank.logic.BankProc;
import ro.bank.model.Person;

import javax.swing.*;
import java.awt.*;
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
    private JTable table;

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

        accountMenu.add(viewAccounts);
        viewAccounts.addActionListener(this);
        accountMenu.add(createAccount);
        accountMenu.add(removeAccount);
        removeAccount.addActionListener(this);
        accountMenu.add(depositMoney);
        accountMenu.add(retireMoney);

        personMenu.add(viewPersons);
        personMenu.add(addPerson);
        personMenu.add(removePerson);
        personMenu.add(editPerson);

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

        if (e.getSource() == load) {
            System.out.println("Am apasat load");
            accounts = fileRepository.loadData();
            ((Bank) bank).setAccount(accounts);
        }
        if (e.getSource() == save) {
            accounts = ((Bank) bank).getAccount();
            System.out.println("Am apasat save");
            if (accounts != null) {
                fileRepository.saveData(accounts);
            }

        }
        if (e.getSource() == viewAccounts) {
            String[] columnNames = {"id", "sold", "owner", "age", "gender"};
            accounts = ((Bank) bank).getAccount();
            Object[][] objects = new Object[accounts.size()][columnNames.length];
            for (int i = 0; i < accounts.size(); i++) {
                Account current = accounts.get(i);
                Person person = current.getPerson();
                for (int j = 0; j < columnNames.length; j++) {
                    if (j == 0) {
                        objects[i][j] = current.getId();
                    }
                    if (j == 1) {
                        objects[i][j] = current.getSold();
                    }
                    if (j == 2) {
                        objects[i][j] = person.getName();
                    }
                    if (j == 3) {
                        objects[i][j] = person.getAge();
                    }
                    if (j == 4) {
                        //// TODO: 4/8/2017
                        //afisare male/female pt boolean
                        objects[i][j] = person.getGender();
                    }
                }
            }

            JTable table = new JTable(objects, columnNames);
            panel.removeAll();
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(50, 50, 500, 300);
            panel.add(scrollPane);
            repaint();

        }
        if (e.getSource() == removeAccount) {
            String input = JOptionPane.showInputDialog(panel, "Enter the id of the account to delete");
            if (input != null && !input.isEmpty()) {
                bank.removeAccount(Integer.parseInt(input));
            }

        }
    }
}
