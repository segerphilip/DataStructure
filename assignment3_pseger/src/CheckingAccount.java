/**
 * Created by philip on 2/15/16.
 */
public class CheckingAccount extends Account {
    private int checkingNum;
    private double checkingBal;
    private final double overdraftFee = 10.00;
    private final double minimumBal = 10.00;

    public CheckingAccount (int checkingNum, double checkingBal) {
        super(checkingNum, checkingBal);
        checkingNum = getAccountNum();
        checkingBal = getAccountBal();
    }

    public void makeWithdrawl(double sum) {
        if (checkingBal - sum <= minimumBal) {
            checkingBal -= sum;
            System.out.println("Account is overdrawn, fee of " + overdraftFee + " applied.");
            checkingBal -= overdraftFee;
            setAccountBal(checkingBal);
        }
        else {
            checkingBal -= sum;
            setAccountBal(checkingBal);
        }
    }

    public String toString() {
        return super.toString() + "\nMinimum balance: " + minimumBal;
    }

    public static void main(String[] args) {
        CheckingAccount test = new CheckingAccount(50505, 50);
        System.out.println(test);
        test.makeWithdrawl(60.00);
        System.out.println(test);
        test.deposit(5000.00);
        System.out.println(test);
    }
}