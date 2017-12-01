import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {

        int result = 0;

        if (o1.getTitle().equals(o2.getTitle())){
            result = o1.getYear() - o2.getYear();
        }
        else{
            result = o1.getTitle().compareTo(o2.getTitle());
        }

        return result;
    }
}
