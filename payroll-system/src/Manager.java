public class Manager extends Employee{
    private double positionAllowance;

    public Manager(int employeeId, String name, double baseSalary, double positionAllowance) {
        super(employeeId, name, baseSalary);
        this.positionAllowance = positionAllowance;
    }

    @Override
    public String getRole() {
        return "Manager";
    }

    public double getPositionAllowance() {
        return positionAllowance;
    }
}
