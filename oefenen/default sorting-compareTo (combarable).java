package exam;

public class Book implements Comparable<Book> {

    private String title;
    private String author;
    private int releaseYear;

    public Book(String title, String author, int releaseYear) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", releaseYear=" + releaseYear + "]";
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }
}










private static void defaultSorting(List<Book> books) {
        Collections.sort(books);
        for (Book book : books) {
            System.out.println(book);
        }