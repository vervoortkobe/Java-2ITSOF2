package labo3.labo3_3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Book> marcDeBel = Arrays.<Book>asList(
                new Book("De monsters van Frankenzwein", "Mark de Bel",1996,true),
                new Book("De fautenkampioene", "Mark de Bel",1997,true),
                new Book("Kikker", "Mark de Bel",2003,true),
                new Book("Herfst", "Mark de Bel",2004,true),
                new Book("Kadodder", "Mark de Bel",2013,true));

        List<Book> jkRowling = Arrays.<Book>asList(
                new Book("Harry Potter and the Philosopher's Stone ", "JK Rowling",1997,true),
                new Book("Harry Potter and the Chamber of Secrets ", "JK Rowling",1998,true),
                new Book("Harry Potter and the Goblet of Fire", "JK Rowling",2000,true),
                new Book("Harry Potter and the Order of the Phoenix", "JK Rowling",2003,true),
                new Book("Harry Potter and the Deathly Hallows ", "JK Rowling",2007,true));


        List<Book> hermanBrusselmans = Arrays.<Book>asList(
                new Book("Zul je mij altijd graag zien?", "Herman Brusselmans",1997,true),
                new Book("De Kus in de Nacht ", "Herman Brusselmans",2002,true),
                new Book("Mijn haar is lang ", "Herman Brusselmans",2009,true),
                new Book("System.out.println(publisher)an drie tot zes ", "Herman Brusselmans",2011,true),
                new Book("Mogelijke memoires", "Herman Brusselmans",2013,true));


        TreeSet<Book> publisher = new TreeSet<Book>();
        publisher.addAll(marcDeBel);
        publisher.addAll(jkRowling);
        publisher.addAll(hermanBrusselmans);

        TreeSet<Book> publisherOnYear = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getYear().compareTo(b2.getYear());
            }
        });
        publisherOnYear.addAll(publisher);

        System.out.println("----------- Sorted by title ---------");
        publisher.forEach(book -> System.out.println(book));
        System.out.println("----------- Sorted by year ---------");
        publisherOnYear.forEach(book -> System.out.println(book));
    }
}
