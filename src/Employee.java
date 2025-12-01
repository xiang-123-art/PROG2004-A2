public class Employee extends Person {
    private String employeeNo;
    private double hourlyRate;

    public Employee() {}
    public Employee(String id, String name, int age, String employeeNo, double hourlyRate) {
        super(id, name, age);
        this.employeeNo = employeeNo;
        this.hourlyRate = hourlyRate;
    }
    public String getEmployeeNo() { return employeeNo; }
    public void   setEmployeeNo(String no) { this.employeeNo=no; }
    public double getHourlyRate() { return hourlyRate; }
    public void   setHourlyRate(double rate) { this.hourlyRate=rate; }

    @Override
    public String toString() {
        return "Employee["+getId()+","+getName()+","+getAge()+","+employeeNo+","+hourlyRate+"]";
    }
    
}