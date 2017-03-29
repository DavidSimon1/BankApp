package ro.bank;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankView extends JFrame implements ActionListener {

    private JPanel panel = new JPanel();
    private JMenuBar menu = new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenu accountMenu = new JMenu("Account");
    private JMenuItem save = new JMenuItem("Save Data");


    public BankView() {
        super("BankApp");
        setSize(610, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        menu.setBounds(0, 0, 610, 20);

        menu.add(fileMenu);
        menu.add(accountMenu);
        fileMenu.add(save);

        this.add(menu);
        this.add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BankView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == save) {
            System.out.println("Am apasat save");
        }
        /*
        in meniul file : save data, load data
        in meniul account : wiew accounts, create account , remove account, deposit money, retire money;
        in meniul persons : view persons, add person, remove person, edit person;
        todo

         */


    }
}
