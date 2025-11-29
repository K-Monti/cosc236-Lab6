package lab6;

public class PaperBookFactory extends BookFactory {

    @Override
    public Book createBook(String title) {
        return new PaperBook(title);
    }
}
