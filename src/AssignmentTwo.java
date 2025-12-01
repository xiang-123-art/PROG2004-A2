import java.util.Random;

public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo a2 = new AssignmentTwo();
        System.out.println("======== Part3 – Queue ========");
        a2.partThree();
        System.out.println("\n======== Part4A – Ride History ========");
        a2.partFourA();
        System.out.println("\n======== Part4B – Sort History ========");
        a2.partFourB();
        System.out.println("\n======== Part5 – Run One Cycle ========");
        a2.partFive();
        System.out.println("\n======== Part6 – Export File ========");
        a2.partSix();
        System.out.println("\n======== Part7 – Import File ========");
        a2.partSeven();
    }


    /* Utility method: quickly create a Visitor */
    private Visitor makeVisitor(int idx) {
        String[] types = {"Gold", "Silver", "Bronze"};
        Random r = new Random();
        return new Visitor("V" + idx, "Visitor" + idx, 10 + idx,
                types[r.nextInt(types.length)], 1.2 + idx * 0.1);
    }

    public void partThree() {
        Ride ride = new Ride("RollerCoaster", 2);
        for (int i = 1; i <= 5; i++) ride.addVisitorToQueue(makeVisitor(i));
        ride.printQueue();
        ride.removeVisitorFromQueue();
        ride.printQueue();
    }

    public void partFourA() {
        Ride ride = new Ride("WaterRide", 4);
        for (int i = 1; i <= 5; i++) ride.addVisitorToHistory(makeVisitor(i));
        System.out.println("Is V3 in history? " +
                ride.checkVisitorFromHistory(new Visitor("V3", "Visitor3", 13, "Gold", 1.5)));
        System.out.println("Total in history: " + ride.numberOfVisitors());
        ride.printRideHistory();
    }

    public void partFourB() {
        Ride ride = new Ride("DropTower", 4);
        for (int i = 5; i >= 1; i--) ride.addVisitorToHistory(makeVisitor(i));
        System.out.println("---- Before sort ----");
        ride.printRideHistory();
        ride.sortHistoryByNameThenAge();
        System.out.println("---- After sort ----");
        ride.printRideHistory();
    }

    public void partFive() {
        Ride ride = new Ride("SkyFlyer", 3);
        Employee op = new Employee("E1", "Operator", 30, "EMP001", 25.5);
        ride.setOperator(op);
        for (int i = 1; i <= 10; i++) ride.addVisitorToQueue(makeVisitor(i));
        ride.printQueue();
        ride.runOneCycle();
        ride.printQueue();
        ride.printRideHistory();
    }

    public void partSix() {
        Ride ride = new Ride("ExportTest", 2);
        for (int i = 1; i <= 5; i++) ride.addVisitorToHistory(makeVisitor(i));
        ride.exportRideHistory("ride_history.csv");
    }

    public void partSeven() {
        Ride ride = new Ride("ImportTest", 2);
        ride.importRideHistory("ride_history.csv");
        System.out.println("Total after import: " + ride.numberOfVisitors());
        ride.printRideHistory();
    }
}