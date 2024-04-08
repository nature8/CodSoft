import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

class ATM extends JFrame implements ActionListener {
    private JLabel balanceLabel;
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;

        setTitle("ATM Machine");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK); // Set background color to black

        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.setBackground(Color.BLACK); // Set panel background color to black

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(this);
        depositButton.setBackground(Color.BLACK); // Set button background color to black
        depositButton.setForeground(Color.WHITE); // Set text color to white
        panel.add(depositButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(this);
        withdrawButton.setBackground(Color.BLACK); // Set button background color to black
        withdrawButton.setForeground(Color.WHITE); // Set text color to white
        panel.add(withdrawButton);

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.addActionListener(this);
        checkBalanceButton.setBackground(Color.BLACK); // Set button background color to black
        checkBalanceButton.setForeground(Color.WHITE); // Set text color to white
        panel.add(checkBalanceButton);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(this);
        closeButton.setBackground(Color.BLACK); // Set button background color to black
        closeButton.setForeground(Color.WHITE); // Set text color to white
        panel.add(closeButton);

        balanceLabel = new JLabel("Current Balance: " + account.getBalance());
        balanceLabel.setForeground(Color.WHITE); // Set text color to white
        panel.add(balanceLabel);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Deposit")) {
            String amountStr = JOptionPane.showInputDialog(this, "Enter amount to deposit:");
            if (amountStr == null || amountStr.isEmpty()) {
                return;
            }
            double amount = Double.parseDouble(amountStr);
            account.deposit(amount);
            JOptionPane.showMessageDialog(this, "Deposit successful");
        } else if (e.getActionCommand().equals("Withdraw")) {
            String amountStr = JOptionPane.showInputDialog(this, "Enter amount to withdraw:");
            if (amountStr == null || amountStr.isEmpty()) {
                return;
            }
            double amount = Double.parseDouble(amountStr);
            if (account.withdraw(amount)) {
                JOptionPane.showMessageDialog(this, "Withdrawal successful");
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient balance");
            }
        } else if (e.getActionCommand().equals("Check Balance")) {
            JOptionPane.showMessageDialog(this, "Current Balance: " + account.getBalance());
        } else if (e.getActionCommand().equals("Close")) {
            dispose();
        }

        balanceLabel.setText("Current Balance: " + account.getBalance());
    }
}

public class MainBank {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);
        ATM atm = new ATM(account);
        atm.setVisible(true);
    }
}
