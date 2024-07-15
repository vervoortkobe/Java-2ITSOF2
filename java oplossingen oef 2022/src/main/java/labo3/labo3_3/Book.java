package labo3.labo3_3;

public class Book implements Comparable<Book> {
    private String title;
    private String writerName;
    private Integer year;
    private Boolean hardcover;

    public Book(String title, String writerName, Integer year, Boolean hardcover) {
        super();
        this.title = title;
        this.writerName = writerName;
        this.year = year;
        this.hardcover = hardcover;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getWriterName() {
        return writerName;
    }
    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public Boolean getHardcover() {
        return hardcover;
    }
    public void setHardcover(Boolean hardcover) {
        this.hardcover = hardcover;
    }


    @Override
    public int compareTo(Book book) {
        return title.compareTo(book.title);
    }



    @Override
    public String toString() {
        return "Book [title=" + title + ", writerName=" + writerName + ", year=" + year + ", hardcover=" + hardcover
                + "]";
    }


}
