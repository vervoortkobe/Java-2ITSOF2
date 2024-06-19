package bank;

public class ThreadWithdraw extends Thread {
    private Account account;
    private String name;
    private int withdrawal;

    public ThreadWithdraw(Account account, String name, int withdrawal) {
        this.account = account;
        this.name = name;
        this.withdrawal = withdrawal;
    }

    @Override
    public void run() {
        // Perform the withdrawal operation
        account.Withdraw(name, withdrawal);
    }
}