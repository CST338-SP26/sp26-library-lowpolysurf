import Utilities.Code;

import java.util.ArrayList;
import java.util.Objects;

public class Reader{

    //data
    private int CARD_NUMBER_;
    private String NAME_;
    private String PHONE_;
    private int BOOK_COUNT_;
    private int BOOK_START_ = 4;
    private ArrayList<Book> books;

    //constructor
    public Reader(int CARD_NUMBER_, String NAME_, String PHONE_) {
        this.CARD_NUMBER_ = CARD_NUMBER_;
        this.NAME_ = NAME_;
        this.PHONE_ = PHONE_;
        this.BOOK_COUNT_ = 0;
        this.books = new ArrayList<>();
    }

    //methods
    public int getCardNumber() {
        return CARD_NUMBER_;
    }

    public void setCardNumber(int CARD_NUMBER_) {
        this.CARD_NUMBER_ = CARD_NUMBER_;
    }

    public String getName() {
        return NAME_;
    }

    public void setName(String NAME_) {
        this.NAME_ = NAME_;
    }

    public String getPhone() {
        return PHONE_;
    }

    public void setPhone(String PHONE_) {
        this.PHONE_ = PHONE_;
    }

    public int getBookCount() {
        return BOOK_COUNT_;
    }

    public void setBookCount(int BOOK_COUNT_) {
        this.BOOK_COUNT_ = BOOK_COUNT_;
    }

    public int getBookStart() {
        return BOOK_START_;
    }

    public void setBookStart(int BOOK_START_) {
        this.BOOK_START_ = BOOK_START_;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public Code addBook(Book add){
        if(!books.contains(add)){
            books.add(add);
            BOOK_COUNT_++;
            return Code.SUCCESS;
        }
        return Code.BOOK_ALREADY_CHECKED_OUT_ERROR;
    }

    public Code removeBook(Book remove){
        if(books.contains(remove)){
            books.remove(remove);
            BOOK_COUNT_--;
            return Code.SUCCESS;
        }
        return Code.READER_DOESNT_HAVE_BOOK_ERROR;
    }

    public boolean hasBook(Book has){
        return books.contains(has);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return CARD_NUMBER_ == reader.CARD_NUMBER_ && BOOK_COUNT_ == reader.BOOK_COUNT_ && BOOK_START_ == reader.BOOK_START_ && Objects.equals(NAME_, reader.NAME_) && Objects.equals(PHONE_, reader.PHONE_);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CARD_NUMBER_, NAME_, PHONE_, BOOK_COUNT_, BOOK_START_);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(books.getFirst().toString());
        for(int i =1; i < books.size(); i++){
            out.append(", ").append(books.get(i).toString());
        }
        return NAME_ + " (#" + CARD_NUMBER_ + ") has checked out {" + out + "}";
    }
}