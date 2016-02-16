/**
 * Created by philip on 2/15/16.
 */
public class SavingsAccount extends Account {
    private int savingsNum;
    private double savingsBal;
    private final double interestRate = .05;

    public SavingsAccount (int checkingNum, double checkingBal) {
        super(checkingNum, checkingBal);
        savingsNum = getAccountNum();
        savingsBal = getAccountBal();
    }

    public void makeWithdrawl(double sum) {
        System.out.println("This is a savings account, you are not allowed to withdraw.");
    }

    public void computeInterest() {
        double interest = Math.pow(1 + interestRate/12, 12);
        savingsBal = savingsBal * interest;
        setAccountBal(savingsBal);
    }

    public String toString() {
        return super.toString() + "\nInterest rate: " + interestRate;
    }

    public static void main(String[] args) {
        SavingsAccount test = new SavingsAccount(50505, 50);
        System.out.println(test);
        test.makeWithdrawl(60.00);
        System.out.println(test);
        test.computeInterest();
        System.out.println(test);
    }
}
