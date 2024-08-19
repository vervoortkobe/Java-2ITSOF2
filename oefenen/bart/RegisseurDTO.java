package org.example.entity;

import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RegisseurDTO {

    // Method to find or create a Regisseur
    public static Regisseur findOrCreateRegisseur(String name, Session session) {
        // Check if Regisseur already exists
        name = name.trim();
        Regisseur existingRegisseur = session.createQuery(
                        "FROM Regisseur WHERE naam = :naam", Regisseur.class
                )
                .setParameter("naam", name)
                .uniqueResult();

        if (existingRegisseur == null) {
            // Create a new Regisseur if not found
            Regisseur newRegisseur = new Regisseur();
            newRegisseur.setNaam(name);
            session.save(newRegisseur);  // Save the new Regisseur
            return newRegisseur;
        }
        return existingRegisseur;
    }

    // Method to get all Regisseur entities
    public static List<Regisseur> getAllRegisseurs() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Regisseur", Regisseur.class).list();
        } catch (Exception e) {
            e.printStackTrace();  // Log any exceptions
            return null;          // Return null or handle as needed
        }
    }
}
