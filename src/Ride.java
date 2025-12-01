import java.util.*;
import java.io.*;

public class Ride implements RideInterface {
    private String rideName;
    private int maxRider;
    private Employee operator;
    private Queue<Visitor> waitingLine = new LinkedList<>();
    private LinkedList<Visitor> rideHistory = new LinkedList<>();
    private int numOfCycles = 0;

    public Ride() {}
    public Ride(String rideName, int maxRider) {
        this.rideName = rideName;
        this.maxRider = maxRider;
    }
    public String  getRideName() { return rideName; }
    public void    setRideName(String n) { this.rideName = n; }
    public int     getMaxRider() { return maxRider; }
    public void    setMaxRider(int m) { this.maxRider = m; }
    public Employee getOperator() { return operator; }
    public void     setOperator(Employee op) { this.operator = op; }

    /* ---------- Interface Methods ---------- */
    @Override
    public boolean addVisitorToQueue(Visitor v) {
        if (v == null) return false;
        waitingLine.offer(v);
        System.out.println("[OK] " + v.getName() + " added to queue.");
        return true;
    }
    @Override
    public boolean removeVisitorFromQueue() {
        Visitor v = waitingLine.poll();
        if (v == null) {
            System.out.println("[FAIL] Queue empty.");
            return false;
        }
        System.out.println("[OK] " + v.getName() + " removed from queue.");
        return true;
    }
    @Override
    public void printQueue() {
        if (waitingLine.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Current queue:");
        for (Visitor v : waitingLine) System.out.println("  " + v);
    }
    @Override
    public boolean addVisitorToHistory(Visitor v) {
        if (v == null) return false;
        rideHistory.add(v);
        return true;
    }
    @Override
    public boolean checkVisitorFromHistory(Visitor v) {
        return rideHistory.contains(v);
    }
    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }
    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("Ride history is empty.");
            return;
        }
        System.out.println("Ride history:");
        Iterator<Visitor> it = rideHistory.iterator();
        while (it.hasNext()) System.out.println("  " + it.next());
    }
    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("[FAIL] No operator assigned.");
            return;
        }
        if (waitingLine.isEmpty()) {
            System.out.println("[FAIL] No visitors in queue.");
            return;
        }
        int count = 0;
        while (!waitingLine.isEmpty() && count < maxRider) {
            Visitor v = waitingLine.poll();
            rideHistory.add(v);
            count++;
        }
        numOfCycles++;
        System.out.println("[OK] Cycle complete. Visitors boarded: " + count);
    }

    /* ---------- Sorting ---------- */
    public void sortHistoryByNameThenAge() {
        rideHistory.sort(new VisitorNameAgeComparator());
    }

    /* ---------- File I/O ---------- */
    public void exportRideHistory(String fileName) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            for (Visitor v : rideHistory) {
                pw.println(v.getId() + "," + v.getName() + "," + v.getAge() + ","
                        + v.getMembershipType() + "," + v.getHeight());
            }
            System.out.println("[OK] History exported to " + fileName);
        } catch (IOException e) {
            System.out.println("[FAIL] Export error: " + e.getMessage());
        }
    }
    public void importRideHistory(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                if (p.length != 5) continue;
                Visitor v = new Visitor(p[0], p[1], Integer.parseInt(p[2]), p[3], Double.parseDouble(p[4]));
                rideHistory.add(v);
            }
            System.out.println("[OK] History imported from " + fileName + ". Total: " + numberOfVisitors());
        } catch (IOException e) {
            System.out.println("[FAIL] Import error: " + e.getMessage());
        }
    }
}