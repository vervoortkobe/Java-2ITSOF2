package bank;

public class ThreadDeposit extends Thread {
    private Account account;
    private String name;
    private int deposit;

    public ThreadDeposit(Account account, String name, int deposit) {
        this.account = account;
        this.name = name;
        this.deposit = deposit;
    }

    @Override
    public void run() {
        // Perform the withdrawal operation
        account.Desposit(name, deposit);
    }
}
