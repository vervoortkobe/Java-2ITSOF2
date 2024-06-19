package be.ap.wk7;

import be.ap.wk7.starwars.dao.StormTrooperDAO;
import be.ap.wk7.starwars.troopers.Rank;
import be.ap.wk7.starwars.troopers.StormTrooper;
import be.ap.wk7.starwars.util.HibernateUtil;
import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {

        StormTrooperDAO dao = new StormTrooperDAO();

        StormTrooper trooper = new StormTrooper("Test", Rank.TROOPER);
        dao.createNew(trooper);

        System.out.println(dao.getAll());

    }

}
