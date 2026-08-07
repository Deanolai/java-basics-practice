public class Manager extends Employee implements Payable{
    private double positionAllowance;

    public Manager(int employeeId, String name, double baseSalary, double positionAllowance) {
        super(employeeId, name, baseSalary);
        this.positionAllowance = positionAllowance;
    }

    @Override
    public String getRole() {
        return "Manager";
    }

    @Override
    public double calculateSalary(){
        return positionAllowance + baseSalary;
    }
}
