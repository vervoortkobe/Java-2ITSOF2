package org.example.entity;
import  org.example.utils.*;
import org.hibernate.Session;
import org.example.entity.*;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MovieDTO {
    public static List<Movie> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "SELECT DISTINCT m FROM Movie m LEFT JOIN FETCH m.regisseurs", Movie.class
            ).list();
        }
    }


    public static void Add(String line){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tran = null;
        try{
            tran = session.beginTransaction();
            Movie movie = ConvertToMovie(line, session);
            session.save(movie);

            tran.commit();
        }catch (Exception e){
            if (tran != null) tran.rollback();
        }
        finally {
            session.close();
        }
    }
    public static Movie ConvertToMovie(String line, Session session){
        String[] movieStr = line.split(";");

        int show_id = Integer.parseInt(movieStr[0]);
        String titel = movieStr[2];
        String land = movieStr[5];

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        LocalDate dateAdded = LocalDate.parse(movieStr[6].trim(), formatter);

        int outYear = Integer.parseInt(movieStr[7]);
        String description = movieStr[11];
        List<Regisseur> regisseurs = new ArrayList<>();
        for (String name : movieStr[4].split(",")){

           Regisseur regisseur = RegisseurDTO.findOrCreateRegisseur(name, session);
            regisseurs.add(regisseur);
        }
        return new Movie(show_id,titel,land,dateAdded,outYear,description,regisseurs);
    }
}
