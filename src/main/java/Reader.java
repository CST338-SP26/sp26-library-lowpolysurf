import Utilities.Code;

import java.util.ArrayList;
import java.util.Objects;

public class Reader{

    //data
    private int cardNumber;
    private String name;
    private String phone;
    private int bookCount;
    private int bookStart = 4;
    private ArrayList<Book> books;

    //constructor
    public Reader(int cardNumber, String name, String phone) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.phone = phone;
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
        return cardNumber == reader.cardNumber && bookCount == reader.bookCount && bookStart == reader.bookStart && Objects.equals(name, reader.name) && Objects.equals(phone, reader.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, name, phone, bookCount, bookStart);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(books.getFirst().toString());
        for(int i =1; i < books.size(); i++){
            out.append(", ").append(books.get(i).toString());
        }
        return name + " (#" + cardNumber + ") has checked out {" + out + "}";
    }
}