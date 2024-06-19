package bank;

public class Account {
    private String accountNr;
    private int total;

    public Account(String accountNr) {
        this.accountNr = accountNr;
        this.total = 100;
    }

    public void Withdraw(String name, int withdrawal) {
        if(total >= withdrawal) {
            System.out.println(name + " withdrew " + withdrawal);
            total -= withdrawal;
            System.out.println("Balance after withdrawal: " + total);
        } else {
            System.out.println(name + " can't withdraw " + withdrawal);
            System.out.println("Balance: " + total);
        }
        try { //1s timeout
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void Desposit(String name, int deposit) {
        System.out.println(name + " deposited " + deposit);
        total += deposit;
        System.out.println("Balance after deposit: " + total);
        try { //1s timeout
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getTotal() {
        return total;
    }
}
