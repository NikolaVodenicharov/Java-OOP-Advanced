import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book>{
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors){
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    public void setAuthors(String... authors) {
        this.authors = Arrays.asList(authors);
    }

    @Override
    public int compareTo(Book other) {
        int result = 0;

        if (this.title.equals(other.title)){
            result = this.year - other.year;
        }
        else{
            result = this.title.compareTo(other.title);
        }

        return result;
    }
}
