
public class Book{

    //data
    private String ISBN;
    private String TITLE;
    private String SUBJECT;
    private int PAGE_COUNT;
    private String AUTHOR;
    private LocalDate DUE_DATE;

    //constructors
    public Book() {
    }
    public Book(String ISBN, String TITLE, String SUBJECT, int PAGE_COUNT, String AUTHOR, LocalDate DUE_DATE){
        this.ISBN = ISBN;
        this.TITLE = TITLE;
        this.SUBJECT = SUBJECT;
        this.PAGE_COUNT = PAGE_COUNT;
        this.AUTHOR = AUTHOR;
        this.DUE_DATE = DUE_DATE;
    }

    //methods
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Book book = (Book) object;
        return PAGE_COUNT == book.PAGE_COUNT && java.util.Objects.equals(ISBN, book.ISBN) && java.util.Objects.equals(TITLE, book.TITLE) && java.util.Objects.equals(SUBJECT, book.SUBJECT) && java.util.Objects.equals(AUTHOR, book.AUTHOR);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), ISBN, TITLE, SUBJECT, PAGE_COUNT, AUTHOR);
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return TITLE;
    }

    public void setTitle(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getSubject() {
        return SUBJECT;
    }

    public void setSubject(String SUBJECT) {
        this.SUBJECT = SUBJECT;
    }

    public int getPageCount() {
        return PAGE_COUNT;
    }

    public void setPageCount(int PAGE_COUNT) {
        this.PAGE_COUNT = PAGE_COUNT;
    }

    public String getAuthor() {
        return AUTHOR;
    }

    public void setAuthor(String AUTHOR) {
        this.AUTHOR = AUTHOR;
    }

    public LocalDate getDueDate() {
        return DUE_DATE;
    }

    public void setDueDate(LocalDate DUE_DATE) {
        this.DUE_DATE = DUE_DATE;
    }

    //toString

    @java.lang.Override
    public java.lang.String toString() {
        return TITLE + " by " + AUTHOR + " ISBN: " + ISBN;
    }
}