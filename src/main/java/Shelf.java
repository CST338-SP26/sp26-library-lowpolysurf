import Utilities.Code;

import java.util.HashMap;
import java.util.Objects;

public class Shelf{

    //data
    protected int SHELF_NUMBER_;
    protected String SUBJECT_;

    protected HashMap<Book, Integer> books;

    //constructor
    public Shelf() {
    }
    public Shelf(int SHELF_NUMBER_, String SUBJECT_) {
        this.SHELF_NUMBER_ = SHELF_NUMBER_;
        this.SUBJECT_ = SUBJECT_;
    }

    //methods
    public int getShelfNumber() {
        return SHELF_NUMBER_;
    }

    public void setShelfNumber(int SHELF_NUMBER_) {
        this.SHELF_NUMBER_ = SHELF_NUMBER_;
    }

    public String getSubject() {
        return SUBJECT_;
    }

    public void setSubject(String SUBJECT_) {
        this.SUBJECT_ = SUBJECT_;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Shelf shelf = (Shelf) o;
        return SHELF_NUMBER_ == shelf.SHELF_NUMBER_ && Objects.equals(SUBJECT_, shelf.SUBJECT_);
    }

    @Override
    public int hashCode() {
        return Objects.hash(SHELF_NUMBER_, SUBJECT_);
    }

    @Override
    public String toString() {
        return SHELF_NUMBER_ + " : " + SUBJECT_;
    }

    public int getBookCount(Book book){
        if(this.books.containsKey(book)){
            return this.books.get(book);
        }
        return 0;
    }

    public Code addBook(Book book){
        if(this.books.containsKey(book)){
            int tempCount = this.books.get(book) + 1;
            this.books.put(book, tempCount);
            System.out.println(book.toString() + " added to shelf " + this.toString());
            return Code.SUCCESS;
        }else if(book.getSubject().equals(this.SUBJECT_)){
            this.books.put(book, 1);
            System.out.println(book.toString() + " added to shelf " + this.toString());
            return Code.SUCCESS;
        }
        return Code.SHELF_SUBJECT_MISMATCH_ERROR;
    }
}