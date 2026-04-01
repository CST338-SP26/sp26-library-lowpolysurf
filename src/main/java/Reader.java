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
        this.books = new ArrayList<>();
    }

    //methods
    public Code addBook(Book add){
        if(!books.contains(add)){
            books.add(add);
            return Code.SUCCESS;
        }
        return Code.BOOK_ALREADY_CHECKED_OUT_ERROR;
    }

    public Code removeBook(Book remove){
        if(books.contains(remove)){
            books.remove(remove);
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