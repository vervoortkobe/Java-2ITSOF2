package bank;

public class Main {
    public static void main(String[] args) {
        Account account = new Account("BE1234567890");

        //account.withdrawn("Sofia", 20);
        ThreadWithdraw t1 = new ThreadWithdraw(account, "Sofia", 20);
        //account.withdrawn("Jeroen", 40);
        ThreadWithdraw t2 = new ThreadWithdraw(account, "Jeroen", 40);
        //account.withdrawn("Rupta", 35);
        ThreadWithdraw t3 = new ThreadWithdraw(account, "Rupta", 35);
        //account.withdrawn("Bruno", 80);
        ThreadWithdraw t4 = new ThreadWithdraw(account, "Bruno", 80);
        //account.withdrawn("Kesha", 40);
        ThreadWithdraw t5 = new ThreadWithdraw(account, "Kesha", 40);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        while(t1.isAlive() || t2.isAlive() || t3.isAlive() || t4.isAlive() || t5.isAlive()) {
            System.out.println("Threads running...");
        }

        //er moet nog 35 euro op de rekening staan
        System.out.println("Het eindresultaat op de rekening is: " + account.getTotal());
    }
}
