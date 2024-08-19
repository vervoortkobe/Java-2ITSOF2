import java.util.Comparator;

public class BookAuthorComparator implements Comparator<Book> {

    @Override
    public int compare(Book book1, Book book2) {
        // Compare by author
        int authorComparison = book1.getAuthor().compareTo(book2.getAuthor());
        if (authorComparison != 0) {
            return authorComparison;
        }

        // If authors are the same, compare by releaseYear
        int yearComparison = Integer.compare(book1.getReleaseYear(), book2.getReleaseYear());
        if (yearComparison != 0) {
            return yearComparison;
        }

        // If both author and releaseYear are the same, compare by title
        return book1.getTitle().compareTo(book2.getTitle());
    }
}







    private static void customSorting(List<Book> books) {
        // Sort using the custom comparator
        Collections.sort(books, new BookAuthorComparator());
        for (Book book : books) {
            System.out.println(book);
        }