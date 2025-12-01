import java.util.Queue;
public interface RideInterface {
    boolean addVisitorToQueue(Visitor v);
    boolean removeVisitorFromQueue();
    void    printQueue();
    boolean addVisitorToHistory(Visitor v);
    boolean checkVisitorFromHistory(Visitor v);
    int     numberOfVisitors();
    void    printRideHistory();
    void    runOneCycle();
}