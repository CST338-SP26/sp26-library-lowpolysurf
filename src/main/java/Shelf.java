import Utilities.Code;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Shelf{

    //data
    protected int SHELF_NUMBER_;
    protected String SUBJECT_;
    private int totalBooks;

    protected HashMap<Book, Integer> books;

    //constructor
    public Shelf() {
    }
    public Shelf(int SHELF_NUMBER_, String SUBJECT_) {
        this.SHELF_NUMBER_ = SHELF_NUMBER_;
        this.SUBJECT_ = SUBJECT_;
        this.totalBooks = 0;
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

    public HashMap<Book, Integer> getBooks() {
        return books;
    }

    public void setBooks(HashMap<Book, Integer> books) {
        this.books = books;
        this.totalBooks = 0;
        for (Map.Entry<Book, Integer> entry : this.books.entrySet()) {
            this.totalBooks++;
        }
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
            System.out.println(book.getTitle() + " added to shelf " + this.toString());
            totalBooks++;
            return Code.SUCCESS;
        }else if(book.getSubject().equals(this.SUBJECT_)){
            this.books.put(book, 1);
            System.out.println(book.getTitle() + " added to shelf " + this.toString());
            totalBooks++;
            return Code.SUCCESS;
        }
        return Code.SHELF_SUBJECT_MISMATCH_ERROR;
    }

    public Code removeBook(Book book){
        if(this.books.containsKey(book) && this.books.get(book) > 0){
            int tempCount = this.books.get(book) -1;
            this.books.put(book, tempCount);
            System.out.println(book.getTitle() + " successfully removed from shelf " + this.SUBJECT_);
            totalBooks--;
            return Code.SUCCESS;
        }
        if(!this.books.containsKey(book)){
            System.out.println(book.getTitle() + " is not on shelf " + this.SUBJECT_);
        }else{
            System.out.println("No copies of" + book.getTitle() + " remain on shelf " + this.SUBJECT_);
        }
        return Code.BOOK_NOT_IN_INVENTORY_ERROR;
    }

    public String listBooks(){
        StringBuilder out = new StringBuilder();
        out.append(totalBooks).append(" books on shelf: ").append(this.toString()).append("\n");
        for (Map.Entry<Book, Integer> entry : this.books.entrySet()) {
            out.append(entry.getKey().toString()).append(" ").append(entry.getValue()).append("\n");
        }
        return out.toString();
    }
}