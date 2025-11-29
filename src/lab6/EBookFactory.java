package lab6;

public class EBookFactory extends BookFactory {

    @Override
    public Book createBook(String name) {
        return new EBook(name);
    }
}
