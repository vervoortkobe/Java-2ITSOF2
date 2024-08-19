package main;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book book1, Book book2) {
        // Compare by releaseYear in descending order
        int yearComparison = Integer.compare(book2.getReleaseYear(), book1.getReleaseYear());
        if (yearComparison != 0) {
            return yearComparison;
        }

        // If releaseYear is the same, compare by author in reverse alphabetical order
        return book2.getAuthor().compareTo(book1.getAuthor());
    }
}
