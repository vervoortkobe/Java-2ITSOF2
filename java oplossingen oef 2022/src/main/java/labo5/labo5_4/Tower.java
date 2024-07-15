package labo5.labo5_4;

public class Tower {
    public void startTower(int disks)
    {
        doTower(disks, 'A', 'B', 'C');
    }

    private void doTower(int n, char start, char auxiliary, char end) {
        // De ring nummering is van klein naar groot
        // De ring met het kleinste cijfer is ook de kleinste ring
        // De ring met het grootste cijfer is het breedst
        if (n == 1) {
            System.out.println("Ring "+n+" moving from "+ start + " -> "+end);
        }
        else{
            doTower(n-1,start,end,auxiliary);
            System.out.println("Ring "+n+" moving from "+ start + " -> "+end);
            doTower(n-1, auxiliary, start , end);
        }
    }
}