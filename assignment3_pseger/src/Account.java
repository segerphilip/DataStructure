import java.util.Random;

/**
 * Created by philip on 2/15/16.
 */
public abstract class Account {
    private int accountNum;
    private double accountBal;

    public Account(int accountNum, double accountBal) {
        this.accountNum = accountNum;
        this.accountBal = accountBal;
    }

    final public void deposit(double amount) {
        accountBal = amount;
    }

    public double getAccountBal() {
        return accountBal;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountBal(double val) {
        accountBal = val;
    }

    public static int generateAccountNumber() {
        Random rand = new Random();
        int number = 10000 + rand.nextInt(89999);
        return number;
    }

    public String toString() {
        return "Account: " + accountNum + "\nBalance: " +
                accountBal;
    }

    public abstract void makeWithdrawl(double sum);

//    testing for account
    public static void main(String[] args) {
        int test = generateAccountNumber();
        System.out.println(test);

        Account ts1 = new Account(generateAccountNumber(), 0) {
            @Override
            public void makeWithdrawl(double sum) {
                System.out.println("test");
            }
        };
    }
}
