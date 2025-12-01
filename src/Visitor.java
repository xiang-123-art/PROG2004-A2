public class Visitor extends Person {
    private String membershipType;
    private double height;   // 米

    public Visitor() {}
    public Visitor(String id, String name, int age, String membershipType, double height) {
        super(id, name, age);
        this.membershipType = membershipType;
        this.height = height;
    }
    public String getMembershipType() { return membershipType; }
    public void   setMembershipType(String t) { this.membershipType=t; }
    public double getHeight() { return height; }
    public void   setHeight(double h) { this.height=h; }

    @Override
    public String toString() {
        return "Visitor["+getId()+","+getName()+","+getAge()+","+membershipType+","+height+"]";
    }
    
}