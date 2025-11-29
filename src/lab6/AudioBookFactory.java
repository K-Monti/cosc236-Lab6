package lab6;

public class AudioBookFactory extends BookFactory {

    @Override
    public Book createBook(String title) {
        return new AudioBook(title);
    }
}
