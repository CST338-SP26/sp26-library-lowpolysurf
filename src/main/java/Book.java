import java.time.LocalDate;
import java.util.Objects;

public class Book{

    //data
    private String ISBN_;
    private String TITLE_;
    private String SUBJECT_;
    private int PAGE_COUNT_;
    private String AUTHOR_;
    private LocalDate DUE_DATE_;

    //constructors
    public Book() {
    }
    public Book(String ISBN, String TITLE, String SUBJECT, int PAGE_COUNT, String AUTHOR, LocalDate DUE_DATE){
        this.ISBN_ = ISBN;
        this.TITLE_ = TITLE;
        this.SUBJECT_ = SUBJECT;
        this.PAGE_COUNT_ = PAGE_COUNT;
        this.AUTHOR_ = AUTHOR;
        this.DUE_DATE_ = DUE_DATE;
    }

    //methods
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Book book = (Book) object;
        return PAGE_COUNT_ == book.PAGE_COUNT_ && java.util.Objects.equals(ISBN_, book.ISBN_) && java.util.Objects.equals(TITLE_, book.TITLE_) && java.util.Objects.equals(SUBJECT_, book.SUBJECT_) && java.util.Objects.equals(AUTHOR_, book.AUTHOR_);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), ISBN_, TITLE_, SUBJECT_, PAGE_COUNT_, AUTHOR_);
    }

    public String getISBN() {
        return ISBN_;
    }

    public void setISBN(String ISBN) {
        this.ISBN_ = ISBN;
    }

    public String getTitle() {
        return TITLE_;
    }

    public void setTitle(String TITLE) {
        this.TITLE_ = TITLE;
    }

    public String getSubject() {
        return SUBJECT_;
    }

    public void setSubject(String SUBJECT) {
        this.SUBJECT_ = SUBJECT;
    }

    public int getPageCount() {
        return PAGE_COUNT_;
    }

    public void setPageCount(int PAGE_COUNT) {
        this.PAGE_COUNT_ = PAGE_COUNT;
    }

    public String getAuthor() {
        return AUTHOR_;
    }

    public void setAuthor(String AUTHOR) {
        this.AUTHOR_ = AUTHOR;
    }

    public LocalDate getDueDate() {
        return DUE_DATE_;
    }

    public void setDueDate(LocalDate DUE_DATE) {
        this.DUE_DATE_ = DUE_DATE;
    }

    //toString

    @java.lang.Override
    public java.lang.String toString() {
        return TITLE_ + " by " + AUTHOR_ + " ISBN: " + ISBN_;
    }
}