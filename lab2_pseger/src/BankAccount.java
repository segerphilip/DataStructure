/**
 * Created by Eliza and Philip on 2/5/16.
 */

import java.util.Random;

public class BankAccount {
    private String accountHolder;
    private static String accountNumber;
    private static double rate;
    private double balance;

    public BankAccount(String name) {
        this.accountHolder = name;
        this.balance = 0;
        this.rate = 1.5;
        this.accountNumber = generateAccountNumber();
    }

    public String toString() {
        return "Bank Account Holder Name: " + accountHolder +
                "\nAccount #: ****" + accountNumber.substring(4) + "\nBalance: " + (balance == -1 ? "??????" : "$" + balance) +
                "\nCurrent Interest Rate: " + rate;
    }

    public double getBalance() {
        return balance;
    }

    public double getRate() {
        return rate;
    }

    public void makeDeposit(double sum) {
        balance += sum;
    }

    public void makeWithdrawl(double sum) {
        if (balance < sum) {
            balance = -1.0;
            return;
        }
        balance -= sum;
    }

    public void accrueInterest() {
        balance = balance + (balance * (rate/(100*12)));
        balance = Math.round(balance*100.0)/100.0;
    }

    public String generateAccountNumber() {
        String number = "";
        Random rand = new Random();
        for (int i=0; i < 7; i++) {
            number += "" + rand.nextInt(9);
        }
        return number;
    }

    public static void main(String[] args) {
        BankAccount bob = new BankAccount("bob");
        bob.makeDeposit(5000000);
        bob.makeWithdrawl(.02);
        bob.accrueInterest();
        System.out.println(bob);

        BankAccount mary = new BankAccount("mary");
        mary.makeDeposit(1000000);
        mary.makeWithdrawl(.01);
        mary.accrueInterest();
        System.out.println(mary);

        BankAccount paul = new BankAccount("paul");
        paul.makeDeposit(5);
        paul.makeWithdrawl(10);
        System.out.println(paul);
    }

}
