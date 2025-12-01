import java.util.Comparator;
public class VisitorNameAgeComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        int c = v1.getName().compareToIgnoreCase(v2.getName());
        if (c != 0) return c;
        return Integer.compare(v1.getAge(), v2.getAge());
    }
}