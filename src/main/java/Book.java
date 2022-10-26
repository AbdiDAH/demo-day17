public class Book {
    private int numberOfPages;
    private String title;
    private String author;
    private String date;

    public Book() {
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Book(int numberOfPages, String title, String author, String date) {
        this.numberOfPages = numberOfPages;
        this.title = title;
        this.author = author;
        this.date = date;




    }
}
